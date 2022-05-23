package it.polimi.ingsw.Ziti.launcher.TurnPhase;

import it.polimi.ingsw.Ziti.launcher.action.EndTurn;
import it.polimi.ingsw.Ziti.launcher.controller.TurnController;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;

public abstract class Phase {

    private TurnController turncontroller;
    private PhaseType phaseType;
    private int playersDone;
    private Character activeCharacter;
    //private int numplayer=turncontroller.getPlayers().size();

    public Phase(TurnController turnController, PhaseType phaseType){
        this.turncontroller = turnController;
        this.phaseType = phaseType;
        playersDone = 0;
        updateGameMode(getPhaseType());
    }

    public PhaseType getPhaseType() {
        return phaseType;
    }

    public TurnController getTurncontroller(){
        return turncontroller;
    }

    public int getPlayersDone() {
        return playersDone;
    }

    public void addPlayersDone() {
        this.playersDone ++;
    }

    public void resetPlayersDone(){
        this.playersDone = 0;
    }


    /**
     * Check if in the game there's an active character whose effect starts in this phase,
     * if it exists, the method starts the character effect if it hasn't started already
     */

    /**
     * Run the end_effect of the active character started in this phase
     */

    public void setActiveCharacter(Character activeCharacter) {
        this.activeCharacter = activeCharacter;
    }

    /**
     * This methods end the current turn, sets the new order of the players and set the phase to planning.
     */
    public void jumpToEndTurn(){
        getTurncontroller().getGameController().getGame().setAction(new EndTurn(getTurncontroller().getGameController().getGame()));
        try {
            getTurncontroller().getGameController().getGame().doAction();
            getTurncontroller().addTurnDone();
            getTurncontroller().resetPlayersDone();
            getTurncontroller().setCurrentPlayer(getTurncontroller().getOrderPlayers().get(0)); //first player for next round
            nextPhase(); //rientro fase planning
        } catch (ActionException e) {
            e.printStackTrace(); //non verrà mai chiamata perchè chiamo solo endturn
        }
    }

    public abstract void update();
    public abstract void nextPhase();

    public void updateGameMode(PhaseType phaseType){
        getTurncontroller().getGameController().getGame().getGameMode().onPhaseUpdate(phaseType);
    }
}
