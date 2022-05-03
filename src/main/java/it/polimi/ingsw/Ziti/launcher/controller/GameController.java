package it.polimi.ingsw.Ziti.launcher.controller;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.*;
import it.polimi.ingsw.Ziti.launcher.action.*;
import it.polimi.ingsw.Ziti.launcher.enumeration.Phase;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.*;
import it.polimi.ingsw.Ziti.launcher.model.Player;
import it.polimi.ingsw.Ziti.launcher.observer.GameControllerObservable;
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
        System.out.println("GameController - getSedner"+message.getSender());
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
                notifyObserver(obs -> obs.requestPlayerNumber(new NumOfPLayersRequest(),message.getUsername()));
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
            notifyObserver(obs -> obs.requestPlayerNumber(new NumOfPLayersRequest(),message.getSender()));
        }
        else {
            this.numberOfPlayers = message.getNumberOfPlayers();
            this.notifyObserver(obs -> obs.sendToOnePlayer(new CompletedRequestMessage("Number of players set to "+ message.getNumberOfPlayers() ),message.getSender()));
        }
    }

    @Override
    public void choseAssistantHandler(ChooseAssistantMessage message) {
        if(checkActivePlayer(message.getSender()) && turnController.getPhase().equals(Phase.PLANNING)){
            game.setAction(new ChooseAssistant(game, turnController.getCurrentPlayer(),message.getAssistantId()));
            try {
                game.doAction();
                turnController.getPlayerAssistants().put(turnController.getCurrentPlayer().getAssistants().get(message.getAssistantId()).getValue(),
                        turnController.getCurrentPlayer());

            } catch (ActionException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("Invalid input parameters"),message.getSender()));
            }
            turnController.updatePhase();
        }
        else{
            notifyObserver(obs -> obs.sendToOnePlayer(new TurnError("It's not your turn phase"),message.getSender()));
        }
    }

    @Override
    public void moveToIslandHandler(MoveToIslandMessage message) {
        if(checkActivePlayer(message.getSender()) && turnController.getPhase().equals(Phase.MOVEMENT)){
            game.setAction( new MoveToIsland(game,message.getIslandID(),message.getColour().toLowerCase(Locale.ROOT)));
            try {
            game.doAction();
            } catch (ActionException e) {
            notifyObserver(obs -> obs.sendToOnePlayer(new InputError("Invalid input parameters"),message.getSender()));
            }
            turnController.updatePhase();
        }
        else{
            notifyObserver(obs -> obs.sendToOnePlayer(new TurnError("It's not your turn phase"),message.getSender()));
        }
    }

    @Override
    public void moveToTableHandler(MoveToTableMessage message) {
        if(checkActivePlayer(message.getSender()) && turnController.getPhase().equals(Phase.MOVEMENT)){
            game.setAction(new MoveToTable(game,message.getColour().toLowerCase(Locale.ROOT)));
            try {
            game.doAction();
            } catch (ActionException e) {
            notifyObserver(obs -> obs.sendToOnePlayer(new InputError("Invalid input parameters"),message.getSender()));
            }
            turnController.updatePhase();
        }
        else{
           notifyObserver(obs -> obs.sendToOnePlayer(new TurnError("It's not your turn phase"),message.getSender()));
        }
    }

    @Override
    public void moveMotherHandler(MoveMotherMessage message) {
        if(checkActivePlayer(message.getSender()) && turnController.getPhase().equals(Phase.MOTHER)){
            game.setAction(new MoveMother(game,message.getMoves()));
            try {
                game.doAction();
            } catch (ActionException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("Invalid input parameters"),message.getSender()));
            }
            turnController.updatePhase();
        }
        else{
            notifyObserver(obs -> obs.sendToOnePlayer(new TurnError("It's not your turn phase"),message.getSender()));
        }
    }


    @Override
    public void cloudIslandHandler(CloudIslandMessage message) {
        if(checkActivePlayer(message.getSender()) && turnController.getPhase().equals(Phase.CLOUD)){
            game.setAction(new ChooseCloud(game,turnController.getCurrentPlayer(),message.getCloudId()));
            try {
                game.doAction();
            } catch (ActionException e) {
                notifyObserver(obs -> obs.sendToOnePlayer(new InputError("Invalid input parameters"),message.getSender()));
            }
            turnController.updatePhase();
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
        notifyObserver(obs -> obs.sendToOnePlayer(new ShowCharacterResponse(getGame().getCharacters()), message.getSender()));

    }

    @Override
    public void showCloudRequestHandler(ShowCloudRequest message) {
        notifyObserver(obs -> obs.sendToOnePlayer(new ShowCloudResponse(getGame().getCloudIslands()), message.getSender()));
    }

    @Override
    public void showIslandRequestHandler(ShowIslandRequest message) {
        notifyObserver(obs -> obs.sendToOnePlayer(new ShowIslandResponse(getGame().getIslands()), message.getSender()));
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
}
