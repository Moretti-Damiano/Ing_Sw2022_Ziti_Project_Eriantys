package it.polimi.ingsw.Ziti.launcher.controller;

import it.polimi.ingsw.Ziti.launcher.action.EndTurn;
import it.polimi.ingsw.Ziti.launcher.enumeration.Phase;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static it.polimi.ingsw.Ziti.launcher.enumeration.Phase.*;

/**
 * This class is used to set turns during a game
 */
public class TurnController {
    private GameController gameController;
    private Player currentPlayer;
    private Phase phase;
    private ArrayList<Player> players;
    private ArrayList<Player> orderPlayers;
    private int moveNumber;
    private int playersDone;
    private Map<Integer,Player> playerAssistants;

    public  TurnController(GameController gameController,ArrayList<Player> players){
        this.gameController = gameController;
        phase = Phase.PLANNING;
        this.players = players;
        orderPlayers = new ArrayList<>(players); //da rivedere poi con che ordine inziare
        playerAssistants = new HashMap<>();
        setCurrentPlayer(players.get(0));
        moveNumber = 0;
        playersDone = 0;
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
    public void updatePhase(){
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
    }

    public Phase getPhase() {
        return phase;
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    /**
     * Set the current player in game (model)
     * @param currentPlayer
     */
    private void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        gameController.getGame().setActivePlayer(currentPlayer);
    }

    /**
     * Used to set the real order of the next player
     * @param map is a map of each player-assistant chosen
     * @return the real order of players
     */
    private ArrayList<Player> putInOrder(Map<Integer,Player> map){
        Map<Integer,Player> orderMap = new TreeMap<>(map);
        ArrayList<Player> inOrder = new ArrayList<>();

        for(Map.Entry<Integer,Player> entry : orderMap.entrySet()){
            inOrder.add(entry.getValue());
        }
        map.clear();
        return inOrder;
    }

    /**
     *
     * @param player is the current player
     * @return next player
     */
    private Player nextPlayer(Player player){
        int position = players.indexOf(player);
        if(position == players.size()-1)
            return players.get(0);
        else
            return  players.get(position+1);
    }
}
