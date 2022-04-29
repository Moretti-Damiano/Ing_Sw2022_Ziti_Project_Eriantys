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

public class TurnController {
    private GameController gameController;
    private Player currentPlayer;
    private Phase phase;
    private ArrayList<Player> players;
    private ArrayList<Player> orderPlayers;
    private ArrayList<Player> newOrderPlayer;
    private int moveNumber;
    private int playersDone;
    private Map<Integer,Player> playerAssistants;

    public  TurnController(GameController gameController,ArrayList<Player> players){
        this.gameController = gameController;
        phase = Phase.PLANNING;
        this.players = players;
        orderPlayers = new ArrayList<>(players); //da rivedere poi con che ordine inziare
        newOrderPlayer = new ArrayList<>();
        playerAssistants = new HashMap<>();
        setCurrentPlayer(players.get(0));
        moveNumber = 0;
        playersDone = 0;
    }

    public Map<Integer,Player> getPlayerAssistants() {
        return playerAssistants;
    }

    public void updatePhase(){

        if(phase.equals(PLANNING)){
            playersDone++;
            setCurrentPlayer(nextPlayer(currentPlayer));

            if(playersDone == players.size()){

                orderPlayers = putInOrder(playerAssistants);

                playersDone = 0;
                phase = next(phase);
                setCurrentPlayer(orderPlayers.get(0));
            }
        }
        else if(phase.equals(MOVEMENT)){
            moveNumber++;
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

    private void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        gameController.getGame().setActivePlayer(currentPlayer);
    }

    private ArrayList<Player> putInOrder(Map<Integer,Player> map){
        Map<Integer,Player> orderMap = new TreeMap<>(map);
        ArrayList<Player> inOrder = new ArrayList<>();

        for(Map.Entry<Integer,Player> entry : orderMap.entrySet()){
            inOrder.add(entry.getValue());
        }
        map.clear();
        return inOrder;
    }

    private Player nextPlayer(Player player){
        int position = players.indexOf(player);
        if(position == players.size()-1)
            return players.get(0);
        else
            return  players.get(position+1);
    }
}
