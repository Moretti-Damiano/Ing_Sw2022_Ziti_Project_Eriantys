package it.polimi.ingsw.Ziti.launcher.controller;
import it.polimi.ingsw.Ziti.launcher.exception.EnabledCharactersException;
import it.polimi.ingsw.Ziti.launcher.model.GameMode.ExpertMode;
import it.polimi.ingsw.Ziti.launcher.model.GameMode.NormalMode;
import it.polimi.ingsw.Ziti.launcher.networking.server.MainSocketServer;
import it.polimi.ingsw.Ziti.launcher.Messages.CharacterSummary;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.CharacterMessage.*;
import it.polimi.ingsw.Ziti.launcher.TurnPhase.EndGamePhase;
import it.polimi.ingsw.Ziti.launcher.action.*;
import it.polimi.ingsw.Ziti.launcher.enumeration.ModeType;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.exception.CharacterException;
import it.polimi.ingsw.Ziti.launcher.exception.WinException;
import it.polimi.ingsw.Ziti.launcher.model.*;
import it.polimi.ingsw.Ziti.launcher.model.Characters.*;
import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;
import it.polimi.ingsw.Ziti.launcher.model.Player;
import it.polimi.ingsw.Ziti.launcher.observer.GameControllerObservable;
import it.polimi.ingsw.Ziti.launcher.observer.GameControllerObserver;
import it.polimi.ingsw.Ziti.launcher.observer.Observer;
import it.polimi.ingsw.Ziti.launcher.observer.ServerObserver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

/**
 * This class observes Game (the model) and the Server and is observed by the Server
 */

public class GameController extends GameControllerObservable implements ServerObserver, Observer {

    private Game game;
    private TurnController turnController;
    private ArrayList<Player> players;
    private int numberOfPlayers = 4;//game for n plauers
    private boolean mode;

    public GameController(MainSocketServer mainSocketServer){
        players = new ArrayList<>();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Game getGame() {
        return game;
    }

    /**
     * Return a player object by searching for his NickName
     * @param nickName the player requested
     * @return the player with the given nickname, returns null if it doesn't exist
     */
    private Player getPlayerByName(String nickName){
        for(Player p:players){
            if(p.GetName().equals(nickName)){
                return p;
            }
        }
        return null;
    }

    /**
     * @param player the player to check if is the active player
     * @return true if player is the active player, false otherwise
     */
    private boolean checkActivePlayer(String player){
        return turnController.getCurrentPlayer().equals(getPlayerByName(player));
    }

    @Override
    public void loginHandler(LoginMessage message){
        System.out.println("Received login message");
        if(getPlayerByName(message.getUsername()) == null && players.size() < numberOfPlayers) {
            try {
                players.add(new Player(message.getUsername()));

                notifyObserver(obs -> obs.successfulLogin(new CompletedRequestMessage("Login completed"),message.getSender(),message.getUsername()));
            } catch (ParserConfigurationException | IOException | SAXException e) {
                System.out.println("Error in creating parser");
            }

            if(players.size() == 1){
                System.out.println("Send request players number");
                notifyObserver(obs -> obs.sendToOnePlayer(new NumOfPLayersRequest(),message.getUsername()));
            }
        }
        else{
            notifyObserver(obs -> obs.sendToOnePlayer(new LoginError("Name already used, try again"), message.getSender()));
            return;
        }
        if(players.size() == numberOfPlayers){
            startGame();
        }
    }

    /**
     * This method is used to verify the number of players
     * @param message is a Message To Server
     */
    public void numberOfPlayerHandler(NumberOfPlayersMessage message){
        if(message.getNumberOfPlayers() < 2 || message.getNumberOfPlayers() > 4){
            notifyObserver(obs -> obs.sendToOnePlayer(new InputError("Invalid number of players"),message.getSender()));
            notifyObserver(obs -> obs.sendToOnePlayer(new NumOfPLayersRequest(),message.getSender()));
        }
        else {
            this.numberOfPlayers = message.getNumberOfPlayers();
            this.notifyObserver(obs -> obs.sendToOnePlayer(new CompletedRequestMessage("Number of players set to "+ message.getNumberOfPlayers() ),message.getSender()));
            this.notifyObserver(obs -> obs.sendToOnePlayer(new ModeRequest(), message.getSender()));
        }
    }

    public void modeHandler(ModeResponse message){
     if(!(message.getMode().toUpperCase(Locale.ROOT).equals("EXPERT") || message.getMode().toUpperCase(Locale.ROOT).equals("NORMAL"))){
         notifyObserver(obs -> obs.sendToOnePlayer(new InputError("invalid Game mode"), message.getSender()));
         notifyObserver(obs -> obs.sendToOnePlayer(new ModeRequest(), message.getSender()));
     }
     else{
         this.mode=message.getMode().toUpperCase(Locale.ROOT).equals("EXPERT");
     }
    }

    @Override
    public void choseAssistantHandler(ChooseAssistantMessage message) {
        if(checkActivePlayer(message.getSender()) && turnController.getPhase().getPhaseType().equals(PhaseType.PLANNING)){
            game.setAction(new ChooseAssistant(game, turnController.getCurrentPlayer(),message.getAssistantId()));
            try {
                game.doAction();
                turnController.getPlayerAssistants().put(turnController.getCurrentPlayer().getAssistants().get(message.getAssistantId()).getValue(),
                        turnController.getCurrentPlayer());
                turnController.updatePhase();
            } catch (ActionException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("Invalid input parameters"),message.getSender()));
            }
            catch (WinException e){
                turnController.setPhase(new EndGamePhase(turnController, PhaseType.ENDGAME));
                endGame(e.getNickname());
            }
        }
        else{
            notifyObserver(obs -> obs.sendToOnePlayer(new TurnError("It's not your turn phase"),message.getSender()));
        }
    }

    @Override
    public void moveToIslandHandler(MoveToIslandMessage message) {
        if(checkActivePlayer(message.getSender()) && turnController.getPhase().getPhaseType().equals(PhaseType.MOVEMENT)){
            game.setAction( new MoveToIsland(game,message.getIslandID(),message.getColour().toLowerCase(Locale.ROOT)));
            try {
            game.doAction();
            turnController.updatePhase();
            } catch (ActionException e) {
            notifyObserver(obs -> obs.sendToOnePlayer(new InputError("Invalid input parameters"),message.getSender()));
            }
            catch (WinException e){
                turnController.setPhase(new EndGamePhase(turnController, PhaseType.ENDGAME));
                endGame(e.getNickname());
            }

        }
        else{
            notifyObserver(obs -> obs.sendToOnePlayer(new TurnError("It's not your turn phase"),message.getSender()));
        }
    }

    @Override
    public void moveToTableHandler(MoveToTableMessage message) {
        if(checkActivePlayer(message.getSender()) && turnController.getPhase().getPhaseType().equals(PhaseType.MOVEMENT)){
            game.setAction(new MoveToTable(game,message.getColour().toLowerCase(Locale.ROOT)));
            try {
            game.doAction();
            turnController.updatePhase();

            } catch (ActionException e) {
            notifyObserver(obs -> obs.sendToOnePlayer(new InputError("Invalid input parameters"),message.getSender()));
            }
            catch (WinException e){
                turnController.setPhase(new EndGamePhase(turnController, PhaseType.ENDGAME));
                endGame(e.getNickname());
            }
        }
        else{
           notifyObserver(obs -> obs.sendToOnePlayer(new TurnError("It's not your turn phase"),message.getSender()));
        }
    }
    @Override
    public void moveMotherHandler(MoveMotherMessage message) {
        if(checkActivePlayer(message.getSender()) && turnController.getPhase().getPhaseType().equals(PhaseType.MOTHER)){
            game.setAction(new MoveMother(game,message.getMoves(),true));
            try {
                game.doAction();
                turnController.updatePhase();

            } catch (ActionException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("Invalid input parameters"),message.getSender()));
            } catch (WinException e){
                turnController.setPhase(new EndGamePhase(turnController, PhaseType.ENDGAME));
                endGame(e.getNickname());
            }
       }
        else{
            notifyObserver(obs -> obs.sendToOnePlayer(new TurnError("It's not your turn phase"),message.getSender()));
        }
    }


    @Override
    public void cloudIslandHandler(CloudIslandMessage message) {
        if(checkActivePlayer(message.getSender()) && turnController.getPhase().getPhaseType().equals(PhaseType.CLOUD)){
            game.setAction(new ChooseCloud(game,turnController.getCurrentPlayer(),message.getCloudId()));
            try {
                game.doAction();
                turnController.updatePhase();

            } catch (ActionException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("Invalid input parameters"),message.getSender()));
            }
            catch (WinException e){
                turnController.setPhase(new EndGamePhase(turnController, PhaseType.ENDGAME));
                endGame(e.getNickname());
            }
        }
        else{
            notifyObserver(obs -> obs.sendToOnePlayer(new TurnError("It's not your turn phase"),message.getSender()));
        }
    }
    @Override
    public void showAssistantRequestHandler(ShowAssistantRequest message){
        notifyObserver(obs -> obs.sendToOnePlayer(new ShowAssistantResponse(getPlayerByName(message.getSender()).getAssistants()), message.getSender()));
    }

    @Override
    public void showBoardsandIslandsRequestHandler(ShowBoardsandIslandsRequest message) {
        notifyObserver(obs -> obs.sendToOnePlayer(new ShowBoardsandIslandsResponse(game.getIslands(), game.getBoards(), message.getSender(), turnController.getPhase().getPhaseType()), message.getSender()));
    }

    @Override
    public void showBoardsRequestHandler(ShowBoardsRequest message) {
        notifyObserver(obs -> obs.sendToOnePlayer( new ShowBoardsResponse(getGame().getBoards()), message.getSender()));
    }

    @Override
    public void showBoardRequestHandler(ShowBoardRequest message) {
        notifyObserver(obs -> obs.sendToOnePlayer(new ShowBoardResponse(getPlayerByName(message.getSender()).getBoard()), message.getSender()));
    }

    @Override
    public void showCharacterRequestHandler(ShowCharacterRequest message) {
        if(game.getModeType()==ModeType.EXPERT) {
            notifyObserver(obs -> obs.sendToOnePlayer(new ShowCharacterResponse(getCharacterSummary()), message.getSender()));
        }
        else{
            notifyObserver(obs -> obs.sendToOnePlayer(new TurnError("characters are not available for this mode"), message.getSender()));
        }
    }

    @Override
    public void showCloudRequestHandler(ShowCloudRequest message) {
        notifyObserver(obs -> obs.sendToOnePlayer(new ShowCloudResponse(getGame().getCloudIslands()), message.getSender()));
    }

    @Override
    public void showIslandRequestHandler(ShowIslandRequest message) {
        notifyObserver(obs -> obs.sendToOnePlayer(new ShowIslandResponse(getGame().getIslands()), message.getSender()));
    }

    @Override
    public void chooseCharacter0Handler(Character0Message message) {
        Character0 character = (Character0) game.getGameMode().getCharacterbyId(0);
        if(checkActivePlayer(message.getSender())){
            try {
                game.doAction();
                //notifica di choosecharacterDone è fatta da game.doAction()!!!
                if(character.isPhase(turnController.getPhase().getPhaseType())){
                    character.startEffect();
                }
            } catch (ActionException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("You can't choose this character"),message.getSender()));
            } catch (EnabledCharactersException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("characters are not available for this mode"), message.getSender()));
            }
        }
        else{
            notifyObserver(obs -> obs.sendToOnePlayer(new TurnError("It's not your turn phase"),message.getSender()));
        }
    }

    @Override
    public void chooseCharacter1Handler(Character1Message message) {
        Character1 character = (Character1) game.getGameMode().getCharacterbyId(1);
        if(checkActivePlayer(message.getSender()) ){
            try {
                character.choose(message.getIslandId());
                game.getGameMode().enabledCharacters(character, turnController.getPhase());
            } catch (ActionException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("You can't choose this character"),message.getSender()));
            }
            catch (CharacterException e){
                notifyObserver(obs-> obs.sendToOnePlayer(new InputError("You insert an invalid island"), message.getSender()));
            } catch (EnabledCharactersException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("characters are not available for this mode"), message.getSender()));
            }
        }
        else{
                notifyObserver(obs -> obs.sendToOnePlayer(new TurnError("It's not your turn phase"),message.getSender()));
        }
    }


    @Override
    public void chooseCharacter2Handler(Character2Message message) {
        Character2 character = (Character2) game.getGameMode().getCharacterbyId(2);
        if(checkActivePlayer(message.getSender()) ){
            try{
            game.getGameMode().enabledCharacters(character, turnController.getPhase());
            } catch (ActionException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("You can't choose this character"),message.getSender()));
            }
            catch (EnabledCharactersException e){
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("characters are not available for this mode"), message.getSender()));
            }
        }
        else{
                notifyObserver(obs -> obs.sendToOnePlayer(new TurnError("It's not your turn phase"),message.getSender()));
        }
    }

    @Override
    public void chooseCharacter3Handler(Character3Message message) {
        Character3 character = (Character3) game.getGameMode().getCharacterbyId(3);
        if(checkActivePlayer(message.getSender())){
            try {
                game.getGameMode().enabledCharacters(character,turnController.getPhase());
            } catch (ActionException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("You can't choose this character"),message.getSender()));
            } catch (EnabledCharactersException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("characters are not available for this mode"), message.getSender()));
            }
        }
        else{
            notifyObserver(obs -> obs.sendToOnePlayer(new TurnError("It's not your turn phase"),message.getSender()));
        }
    }

    @Override
    public void chooseCharacter4Handler(Character4Message message) {
        Character4 character = (Character4) game.getGameMode().getCharacterbyId(4);

        if(checkActivePlayer(message.getSender())){
            try {
                character.choose(message.getColour());
                game.getGameMode().enabledCharacters(character,turnController.getPhase());
            } catch (ActionException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("You can't choose this character"),message.getSender()));
            } catch (EnabledCharactersException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("characters are not available for this mode"), message.getSender()));
            }
            catch (CharacterException e){
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("You did not insert a valid colour"),message.getSender()));
            }
        }
        else{
            notifyObserver(obs -> obs.sendToOnePlayer(new TurnError("It's not your turn phase"),message.getSender()));
        }
    }


    @Override
    public void chooseCharacter5Handler(Character5Message message) {
        Character5 character = (Character5) game.getGameMode().getCharacterbyId(5);
        if(checkActivePlayer(message.getSender()) && !Objects.requireNonNull(getPlayerByName(message.getSender())).hasUsedACharacter() && game.getModeType()==ModeType.EXPERT){
            game.setAction(new ChooseCharacter(game,character));
            try {
                character.choose(message.getColour());
                game.doAction();
                if(character.isPhase(turnController.getPhase().getPhaseType())){
                    character.startEffect();
                }
            }
            catch (ActionException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("You can't choose this character"),message.getSender()));
            }
            catch(CharacterException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("You did not insert a valid colour"),message.getSender()));
            }
        }
        else{
            if(game.getModeType()==ModeType.NORMAL)
                notifyObserver(obs->obs.sendToOnePlayer(new TurnError("characters are not available for this mode"), message.getSender()));
            if(!checkActivePlayer(message.getSender()))
                notifyObserver(obs -> obs.sendToOnePlayer(new TurnError("It's not your turn phase"),message.getSender()));
            if(checkActivePlayer(message.getSender()) && Objects.requireNonNull(getPlayerByName(message.getSender())).hasUsedACharacter())
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("You already chose a character in this turn"),message.getSender()));
        }
    }

    /**
     * receives al the updates from the game model
     * @param message the message sent by the model
     */
    public void update(MessageToClient message){
        notifyObserver(obs -> obs.sendToAllPlayers(message));
    }

    /**
     * Sets up a game (observed by GameController)
     * Creates TurnController
     */
    private void startGame(){
        System.out.println("Starting game for " + players.size() + " players");
        chooseGame(numberOfPlayers);
        chooseMode(mode);
        game.getGameMode().startmode();
        game.addObserver(this);
        this.turnController = new TurnController(this,players);

        notifyObserver(); //notifies the socketserver

        System.out.println("Game started!");
        notifyObserver(obs -> obs.sendToAllPlayers(new GameStartedMessage()));

    }

    public void notifyNewActivePlayer(Player currentPlayer) {
        notifyObserver(obs-> obs.sendToOnePlayer(new YourTurnNotification(),currentPlayer.GetName()));
    }

    private ArrayList<CharacterSummary> getCharacterSummary(){
        ArrayList<CharacterSummary> summary = new ArrayList<>();
        for(Character c: game.getCharacters()){
            summary.add(new CharacterSummary(c.getId(),c.getCost(),c.getDescription()));
        }
        return  summary;
    }

    public void endGame(String winnerName){
        System.out.println(winnerName + "won the game!!!");
        notifyObserver(obs->obs.sendToAllPlayers(new WinMessage(winnerName)));
        notifyObserver(GameControllerObserver::disconnectAll);
    }

    public void endGameDisconnection(){
        notifyObserver(obs->obs.sendToAllPlayers(new ErrorMessage("Server","Game has ended because a player disconnected")));
        notifyObserver(GameControllerObserver::disconnectAll);
    }


    private void chooseGame(int playerSize){
        if(playerSize==2){
            this.game=new Game2(players);}
        if(playerSize==3){
            this.game= new Game3(players);
        }
    }

    private void chooseMode(boolean mode){
        if(mode){
            game.setGameMode(new ExpertMode(game));
        }
        else{
           game.setGameMode(new NormalMode(game));
        }
    }

    public void sendTurnNotification() {
        notifyObserver(obs -> obs.sendToAllPlayers(new TurnNotification("it's " +
                game.getCurrentPlayer().GetName() + " turn and it's " +
                turnController.getPhase().getPhaseType().getAbbreviation() + " Phase")));
    }
}

