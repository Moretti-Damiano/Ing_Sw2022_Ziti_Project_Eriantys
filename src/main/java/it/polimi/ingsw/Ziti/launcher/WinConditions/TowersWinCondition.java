package it.polimi.ingsw.Ziti.launcher.WinConditions;

import it.polimi.ingsw.Ziti.launcher.controller.TurnController;
import it.polimi.ingsw.Ziti.launcher.exception.WinException;
import it.polimi.ingsw.Ziti.launcher.model.Player;

/**
 * This class ends the game when one of the players has placed all of its towers on the islands
 */
public class TowersWinCondition extends WinCondition{

    public TowersWinCondition(TurnController turnController) {
        super(turnController);
    }

    @Override
    public void check() throws WinException {
        for(Player player:getGame().getPlayers()){
            if (player.getBoard().getTowerSize() == 0)
                throw new WinException(player.GetName());
                break;
        }
    }
}
