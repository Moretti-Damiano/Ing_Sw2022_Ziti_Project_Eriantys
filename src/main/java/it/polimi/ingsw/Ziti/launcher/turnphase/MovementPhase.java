package it.polimi.ingsw.Ziti.launcher.turnphase;

import it.polimi.ingsw.Ziti.launcher.controller.TurnController;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;

/**
 * Phase where each player can move his students to the dinign room or to the islands.
 * The number of moves is set by Game (depending on the numbers of players).
 */
public class MovementPhase extends Phase{

    private int moveNumber;
    private final int numPlayer;

    public MovementPhase(TurnController turnController) {
        super(turnController, PhaseType.MOVEMENT);
        moveNumber = 0;
        numPlayer=turnController.getGameController().getGame().getCloudIslands().get(0).getSize();
    }

    @Override
    public void update() {
        updateGameMode(getPhaseType());
        
        moveNumber++;
            // Check if the player has already moved 3 students (ToTable or ToIsland)
            if (moveNumber == numPlayer) {
                moveNumber = 0;
                nextPhase();
            }
        }
    @Override
    public void nextPhase() {
        getTurncontroller().setPhase(new MotherPhase(getTurncontroller()));
    }
}
