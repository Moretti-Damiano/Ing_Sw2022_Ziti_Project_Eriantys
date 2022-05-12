package it.polimi.ingsw.Ziti.launcher.TurnPhase;

import it.polimi.ingsw.Ziti.launcher.controller.TurnController;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;

public class MovementPhase extends Phase{

    private int moveNumber;

    public MovementPhase(TurnController turnController) {
        super(turnController, PhaseType.MOVEMENT);
        moveNumber = 0;
    }

    @Override
    public void update() {
        endCharacter();
        moveNumber++;
            // Check if the player has already moved 3 students (ToTable or ToIsland)
            if (moveNumber == 3) {
                moveNumber = 0;
                nextPhase();
            } else {
                checkCharacter();
            }

    }
    @Override
    public void nextPhase() {
        getTurncontroller().setPhase(new MotherPhase(getTurncontroller()));
    }
}
