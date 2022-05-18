package it.polimi.ingsw.Ziti.launcher.WinConditions;

import it.polimi.ingsw.Ziti.launcher.controller.TurnController;
import it.polimi.ingsw.Ziti.launcher.exception.WinException;

/**
 * This class ends the game if the players used all of their assistants cards
 */
public class AssistantsWinCondition extends WinCondition{

    public AssistantsWinCondition(TurnController turnController) {
        super(turnController);
    }

    @Override
    public void check() throws WinException {
        if(getTurnController().getTurnNumber() == 10)    //turnNumber is updated by CloudPhase at the end of the turn of the last player
            chooseWinnerByTowers();
    }
}
