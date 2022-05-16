package it.polimi.ingsw.Ziti.launcher.TurnPhase;

import it.polimi.ingsw.Ziti.launcher.controller.TurnController;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;

public class MovementPhase extends Phase{

    private int moveNumber;
    private int numplayer;

    public MovementPhase(TurnController turnController) {
        super(turnController, PhaseType.MOVEMENT);
        moveNumber = 0;
        numplayer=turnController.getGameController().getGame().getCloudIslands().get(0).getSize();
    }

    @Override
    public void update() {
        updateGameMode(getPhaseType());
        
        moveNumber++;
            // Check if the player has already moved 3 students (ToTable or ToIsland)
            if (moveNumber == numplayer) {
                moveNumber = 0;
                nextPhase();
            }
        }
    @Override
    public void nextPhase() {
        getTurncontroller().setPhase(new MotherPhase(getTurncontroller()));
    }
}
