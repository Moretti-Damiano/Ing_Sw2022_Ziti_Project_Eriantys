package it.polimi.ingsw.Ziti.launcher.TurnPhase;

import it.polimi.ingsw.Ziti.launcher.action.EndTurn;
import it.polimi.ingsw.Ziti.launcher.controller.TurnController;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;

/**
 * Abstract class used for implementing turnPhases via Strategy Pattern.
 * Every phase has to extend this class.
 */
public abstract class Phase {

    private final TurnController turncontroller;
    private final PhaseType phaseType;

    public Phase(TurnController turnController, PhaseType phaseType){
        this.turncontroller = turnController;
        this.phaseType = phaseType;
        updateGameMode(getPhaseType());
    }

    public PhaseType getPhaseType() {
        return phaseType;
    }


    public TurnController getTurncontroller(){
        return turncontroller;
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

    /**
     * Contains all the action to be done when the current phase is updated
     */
    public abstract void update();

    /**
     * Set the phase to the next one
     */
    public abstract void nextPhase();

    /**
     * This methods calls the onPhaseUpdate method of the set gameMode
     * @param phaseType the current phaseType
     */
    public void updateGameMode(PhaseType phaseType){
        getTurncontroller().getGameController().getGame().getGameMode().onPhaseUpdate(phaseType);
    }
}
