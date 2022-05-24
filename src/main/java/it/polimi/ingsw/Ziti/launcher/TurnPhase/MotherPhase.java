package it.polimi.ingsw.Ziti.launcher.TurnPhase;

import it.polimi.ingsw.Ziti.launcher.controller.TurnController;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;

/**
 * Phase where each player can move MotherNature, the number of moves will be check by the action.
 */
public class MotherPhase extends Phase{
    public MotherPhase(TurnController turnController) {
        super(turnController, PhaseType.MOTHER);
    }

    @Override
    public void update() {
        updateGameMode(getPhaseType());
        //standard case
        if(!getTurncontroller().getGameController().getGame().getSack().isEmpty()){
            
            nextPhase();
        }
        else{   //no more students in the sack
            //last player
            if (getTurncontroller().getPlayersDone() == getTurncontroller().getPlayers().size()){
                jumpToEndTurn();
            }
            else{
            getTurncontroller().addPlayersDone();
            getTurncontroller().setNextPlayer();
            getTurncontroller().setPhase(new MovementPhase(getTurncontroller()));
            }
        }
    }

    @Override
    public void nextPhase() {
        if(!getTurncontroller().getGameController().getGame().getSack().isEmpty())
            getTurncontroller().setPhase(new CloudPhase(getTurncontroller()));
        else
            getTurncontroller().setPhase(new PlanningPhase(getTurncontroller()));

    }
}
