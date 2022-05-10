package it.polimi.ingsw.Ziti.launcher.controller;
import it.polimi.ingsw.Ziti.launcher.Messages.CharacterSummary;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.ChooseCharacterDoneMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.CharacterMessage.*;
import it.polimi.ingsw.Ziti.launcher.TurnPhase.EndGamePhase;
import it.polimi.ingsw.Ziti.launcher.action.*;
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

/**
 * This class observes Game (the model) and the Server and is observed by the Server
 */

public class GameController extends GameControllerObservable implements ServerObserver, Observer {


    private Game game;
    private TurnController turnController;
    private ArrayList<Player> players;
    private int numberOfPlayers = 4; //game for n plauers

    public GameController(){
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
    public void loginHandler(LoginMessage message)  {
        System.out.println("Received login message");
        if(getPlayerByName(message.getUsername()) == null && players.size() < numberOfPlayers) {
            try {
                System.out.println("Adding player to list");
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
                notifyObserver(obs -> obs.sendToAllPlayers(new TurnNotification("it's " + game.getCurrentPlayer().GetName() + " turn and it's " + turnController.getPhase().getPhaseType().getAbbreviation() + " Phase")));

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
            notifyObserver(obs -> obs.sendToAllPlayers(new TurnNotification("it's " + game.getCurrentPlayer().GetName() + " turn and it's " + turnController.getPhase().getPhaseType().getAbbreviation() + " Phase")));

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
            notifyObserver(obs -> obs.sendToAllPlayers(new TurnNotification("it's " + game.getCurrentPlayer().GetName() + " turn and it's " + turnController.getPhase().getPhaseType().getAbbreviation() + " Phase")));

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
                notifyObserver(obs -> obs.sendToAllPlayers(new TurnNotification("it's " + game.getCurrentPlayer().GetName() + " turn and it's " + turnController.getPhase().getPhaseType().getAbbreviation() + " Phase")));

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
                notifyObserver(obs -> obs.sendToAllPlayers(new TurnNotification("it's " + game.getCurrentPlayer().GetName() + " turn and it's " + turnController.getPhase().getPhaseType().getAbbreviation() + " Phase")));

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
    public void showBoardsRequestHandler(ShowBoardsRequest message) {
        notifyObserver(obs -> obs.sendToOnePlayer( new ShowBoardsResponse(getGame().getBoards()), message.getSender()));
    }

    @Override
    public void showBoardRequestHandler(ShowBoardRequest message) {
        notifyObserver(obs -> obs.sendToOnePlayer(new ShowBoardResponse(getPlayerByName(message.getSender()).getBoard()), message.getSender()));
    }

    @Override
    public void showCharacterRequestHandler(ShowCharacterRequest message) {
        notifyObserver(obs -> obs.sendToOnePlayer(new ShowCharacterResponse(getCharacterSummary()), message.getSender()));

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
        if(checkActivePlayer(message.getSender())){
            game.setAction(new ChooseCharacter(game, Character0.getInstance()));
            try {
                //Character0.getInstance().choose();
                game.doAction();
                //notifyObserver(obs -> obs.sendToAllPlayers(new ChooseCharacterDoneMessage((message.getSender()) + " has chosen character 0")));
                //notifica di choosecharacterDone è fatta da game.doAction()!!!
            } catch (ActionException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("You can't choose this character"),message.getSender()));
            }

        }
    }

    @Override
    public void chooseCharacter1Handler(Character1Message message) {
        if(checkActivePlayer(message.getSender())){
            game.setAction(new ChooseCharacter(game,Character1.getInstance()));
            try {
                Character1.getInstance().choose(message.getIslandId());
                game.doAction();
                //notifyObserver(obs -> obs.sendToAllPlayers(new ChooseCharacterDoneMessage((message.getSender()) + " has chosen character 1")));
            } catch (ActionException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("You can't choose this character"),message.getSender()));
            }
            catch (CharacterException e){
                notifyObserver(obs-> obs.sendToOnePlayer(new InputError("You insert an invalid island"), message.getSender()));
            }
            }
        }


    @Override
    public void chooseCharacter2Handler(Character2Message message) {
        if(checkActivePlayer(message.getSender())){
            game.setAction(new ChooseCharacter(game, Character2.getInstance()));
            try {
                game.doAction();
                //Character2.getInstance().choose();
                //notifyObserver(obs -> obs.sendToAllPlayers(new ChooseCharacterDoneMessage((message.getSender()) + " has chosen character 2")));
            } catch (ActionException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("You can't choose this character"),message.getSender()));
            }
        }
    }

    @Override
    public void chooseCharacter3Handler(Character3Message message) {
        if(checkActivePlayer(message.getSender())){
            game.setAction(new ChooseCharacter(game, Character3.getInstance()));
            try {
                game.doAction();
                //Character3.getInstance().choose();
                //notifyObserver(obs -> obs.sendToAllPlayers(new ChooseCharacterDoneMessage((message.getSender()) + " has chosen character 3")));
            } catch (ActionException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("You can't choose this character"),message.getSender()));
            }
        }
    }

    @Override
    public void chooseCharacter4Handler(Character4Message message) {
        if(checkActivePlayer(message.getSender())){
            game.setAction(new ChooseCharacter(game, Character4.getInstance()));
            try {
                Character4.getInstance().choose(message.getColour());
                game.doAction();
                //notifyObserver(obs -> obs.sendToAllPlayers(new ChooseCharacterDoneMessage((message.getSender()) + " has chosen character 4")));
            } catch (ActionException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("You can't choose this character"),message.getSender()));
            }
            catch (CharacterException e){
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("You did not insert a valid colour"),message.getSender()));
            }
            }
        }


    @Override
    public void chooseCharacter5Handler(Character5Message message) {
        if(checkActivePlayer(message.getSender())){
            game.setAction(new ChooseCharacter(game,Character5.getInstance()));
            try {
                Character5.getInstance().choose(message.getColour());
                game.doAction();
                //notifyObserver(obs -> obs.sendToAllPlayers(new ChooseCharacterDoneMessage((message.getSender()) + " has chosen character 5")));
            }
            catch (ActionException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("You can't choose this character"),message.getSender()));
            }
            catch(CharacterException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("You did not insert a valid colour"),message.getSender()));
            }

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
        this.game = new Game(players);
        game.addObserver(this);
        this.turnController = new TurnController(this,players);
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
        notifyObserver(obs->obs.sendToAllPlayers(new WinMessage(winnerName)));
        notifyObserver(GameControllerObserver::disconnectAll);
        startNewGame();
    }

    public void endGameDisconnection(){
        notifyObserver(obs->obs.sendToAllPlayers(new ErrorMessage("Server","Game has ended because a player disconnected")));
        notifyObserver(GameControllerObserver::disconnectAll);
        startNewGame();
    }

    private void startNewGame(){
        System.out.println("Starting a new game");
        this.game = null;
        this.players = new ArrayList<>();
        this.turnController = null;
    }
}
