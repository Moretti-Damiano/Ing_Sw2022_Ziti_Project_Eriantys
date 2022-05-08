package it.polimi.ingsw.Ziti.launcher.TurnPhase;

import it.polimi.ingsw.Ziti.launcher.controller.TurnController;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;

public class MotherPhase extends Phase{
    public MotherPhase(TurnController turnController) {
        super(turnController, PhaseType.MOTHER);
    }

    @Override
    public void update() {
        endCharacter();
        nextPhase();
    }

    @Override
    public void nextPhase() {
        getTurncontroller().setPhase(new CloudPhase(getTurncontroller()));
    }

}
