package it.polimi.ingsw.Ziti.launcher.TurnPhase;

import it.polimi.ingsw.Ziti.launcher.action.EndTurn;
import it.polimi.ingsw.Ziti.launcher.controller.TurnController;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;

public class CloudPhase extends Phase{
    public CloudPhase(TurnController turnController) {
        super(turnController, PhaseType.CLOUD);
    }

    @Override
    public void update() {
        endCharacter();


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
