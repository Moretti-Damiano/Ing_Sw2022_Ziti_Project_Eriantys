package it.polimi.ingsw.Ziti.launcher.TurnPhase;

import it.polimi.ingsw.Ziti.launcher.controller.TurnController;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;

/**
 * Phase where each player have to pick one of the cloudIslands.
 */
public class CloudPhase extends Phase{
    public CloudPhase(TurnController turnController) {
        super(turnController, PhaseType.CLOUD);
    }

    @Override
    public void update() {
        updateGameMode(getPhaseType());


        if (getTurncontroller().getPlayersDone() == getTurncontroller().getPlayers().size()) {
            jumpToEndTurn();
        }
        else {
            getTurncontroller().addPlayersDone();
            getTurncontroller().setNextPlayer();
            getTurncontroller().setPhase(new MovementPhase(getTurncontroller()));
        }
    }

    @Override
    public void nextPhase() {
        getTurncontroller().setPhase(new PlanningPhase(getTurncontroller()));
    }
}
