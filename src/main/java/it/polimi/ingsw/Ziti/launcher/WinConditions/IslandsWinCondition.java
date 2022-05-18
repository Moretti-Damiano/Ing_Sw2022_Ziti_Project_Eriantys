package it.polimi.ingsw.Ziti.launcher.WinConditions;

import it.polimi.ingsw.Ziti.launcher.controller.TurnController;
import it.polimi.ingsw.Ziti.launcher.exception.WinException;

/**
 * this class ends the game when only 3 islands are left in the game
 */
public class IslandsWinCondition extends WinCondition {

    public IslandsWinCondition(TurnController turnController) {
        super(turnController);
    }

    @Override
    public void check() throws WinException {
        if(getGame().getIslands().size() <= 3){
            chooseWinnerByTowers();
        }
    }
}
