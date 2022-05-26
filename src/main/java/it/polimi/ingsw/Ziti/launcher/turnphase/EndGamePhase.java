package it.polimi.ingsw.Ziti.launcher.turnphase;

import it.polimi.ingsw.Ziti.launcher.controller.TurnController;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;

/**
 * Final state of the game, only activates when a player win.
 * During this phase all the moves are blocked.
 */
public class EndGamePhase extends Phase{


    public EndGamePhase(TurnController turnController, PhaseType phaseType) {
        super(turnController, phaseType);
    }

    @Override
    public void update() {
        
    }

    @Override
    public void nextPhase() {

    }
}
