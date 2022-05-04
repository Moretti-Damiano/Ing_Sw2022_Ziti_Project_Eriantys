package it.polimi.ingsw.Ziti.launcher.TurnPhase;

import it.polimi.ingsw.Ziti.launcher.controller.TurnController;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;

public class MotherPhase extends Phase{
    public MotherPhase(TurnController turnController) {
        super(turnController, PhaseType.MOTHER);
    }

    @Override
    public void update() {
        nextPhase();
    }

    @Override
    public void nextPhase() {
        getTurncontroller().setPhase(new CloudPhase(getTurncontroller()));
    }
}
