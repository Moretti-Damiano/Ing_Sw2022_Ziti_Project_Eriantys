package it.polimi.ingsw.Ziti.launcher.controller;

import it.polimi.ingsw.Ziti.launcher.Messages.CharacterSummary;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.YourTurnNotification;
import it.polimi.ingsw.Ziti.launcher.TurnPhase.EndGamePhase;
import it.polimi.ingsw.Ziti.launcher.TurnPhase.Phase;
import it.polimi.ingsw.Ziti.launcher.TurnPhase.PlanningPhase;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.WinException;
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
        gameController.notifyNewActivePlayer(currentPlayer);
        this.gameController.getGame().setActivePlayer(currentPlayer);
        playersDone = 1;
    }

    public void setPhase(Phase phase){
        this.phase = phase;
    }

    public void updatePhase() throws WinException {
            checkWin();
            phase.update();
    }


    /**
     * Combines each player with the value of the assistant chosen
     * @return a map of player-assistant chosen
     */
    public Map<Integer,Player> getPlayerAssistants() {
        return playerAssistants;
    }

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

    public void  addPlayersDone(){playersDone++;}

    public void resetPlayersDone(){playersDone=1;}

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

    private void checkWin() throws WinException{
        checkWinTowers();
        checkWinIslands();
    }

    private void checkWinIslands() throws WinException {
        int towers;
        Player winner;

        if(gameController.getGame().getIslands().size() == 3){

            winner = gameController.getPlayers().get(0);
            towers = winner.getBoard().getTowerSize();

            for(Player p: gameController.getPlayers()){
                if(p.getBoard().getTowerSize() < towers){
                    winner = p;
                    towers = p.getBoard().getTowerSize();

                }
                if(p.getBoard().getTowerSize() == towers){
                    if(p.getBoard().getProfessors().size() > winner.getBoard().getProfessors().size()){
                        winner = p;
                    }
                }
            }
            throw new WinException(winner.GetName());
        }
    }

    private void checkWinTowers() throws WinException{
     if(getCurrentPlayer().getBoard().getTowerSize()==0){
         throw new WinException(getCurrentPlayer().GetName());
     }
    }
}
