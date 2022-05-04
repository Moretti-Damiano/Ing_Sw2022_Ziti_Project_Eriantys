package it.polimi.ingsw.Ziti.launcher.controller;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.YourTurnNotification;
import it.polimi.ingsw.Ziti.launcher.TurnPhase.Phase;
import it.polimi.ingsw.Ziti.launcher.TurnPhase.PlanningPhase;
import it.polimi.ingsw.Ziti.launcher.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to set turns during a game
 */
public class TurnController {
    private GameController gameController;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private ArrayList<Player> orderPlayers;
    private int playersDone;
    private Map<Integer,Player> playerAssistants;

    private Phase phase;

    public  TurnController(GameController gameController,ArrayList<Player> players){
        this.gameController = gameController;
        setPhase(new PlanningPhase(this));
        this.players = players;
        orderPlayers = new ArrayList<>(players);
        playerAssistants = new HashMap<>();
        currentPlayer = players.get(0);
        this.gameController.getGame().setActivePlayer(currentPlayer);
        playersDone = 0;
    }

    public void setPhase(it.polimi.ingsw.Ziti.launcher.TurnPhase.Phase phase){
        this.phase = phase;
    }

    public void updatePhase(){
        phase.update();
    }


    /**
     * Combines each player with the value of the assistant chosen
     * @return a map of player-assistant chosen
     */
    public Map<Integer,Player> getPlayerAssistants() {
        return playerAssistants;
    }

    /**
     * Update phases of the game (declared in enum. Phase)
     */
  /*  public void OLDupdatePhase(){
        // Planning Phase
        if(phase.equals(PLANNING)){
            playersDone++;
            setCurrentPlayer(nextPlayer(currentPlayer));
            // Every player chose an assistant
            if(playersDone == players.size()){
                // Put in Order used to set the real order of the next player
                orderPlayers = putInOrder(playerAssistants);

                playersDone = 0;
                phase = next(phase);
                setCurrentPlayer(orderPlayers.get(0));
            }
        }
        else if(phase.equals(MOVEMENT)){
            moveNumber++;
            // Check if the player has already moved 3 students (ToTable or ToIsland)
            if(moveNumber == 3){
                moveNumber = 0;
                phase = next(phase);
            }
        }
        else if(phase.equals(MOTHER)){
            phase = next(phase);
        }
        else if(phase.equals(CLOUD)) {
            playersDone++;
            if (playersDone == players.size()) {
                gameController.getGame().setAction(new EndTurn(gameController.getGame()));
                // If every player completed his turn, Game controller calls EndTurn action
                try {
                    gameController.getGame().doAction();
                } catch (ActionException e) {
                    e.printStackTrace(); //non verrà mai chiamata perchè chiamo solo endturn
                }
                phase = next(phase); //rientro fase planning
                setCurrentPlayer(orderPlayers.get(0)); //first player for next round
            }
            else {
                setCurrentPlayer(orderPlayers.get(playersDone));
                phase = MOVEMENT;
            }
        }
    }*/


    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        gameController.getGame().setActivePlayer(currentPlayer);
        gameController.notifyNewActivePlayer(currentPlayer);
    }

    /**
     * set the currentPlayer in both turnController and game to the next one
     */
    public void setNextPlayer(){
        setCurrentPlayer(nextPlayer(this.currentPlayer));
        gameController.getGame().setActivePlayer(currentPlayer);
    }

    /**
     *
     * @param player is the current player
     * @return next player
     */
    private Player nextPlayer(Player player){
        int position = orderPlayers.indexOf(player);
        if(position == players.size()-1)
            return orderPlayers.get(0);
        else
            return  orderPlayers.get(position+1);
    }

    public int getPlayersDone() {
        return playersDone;
    }

    public GameController getGameController() {
        return gameController;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Player> getOrderPlayers() {
        return orderPlayers;
    }

    public void setOrderPlayers(ArrayList<Player> orderPlayers) {
        this.orderPlayers = orderPlayers;
    }

    public Phase getPhase() {
        return phase;
    }
}
