package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.ErrorMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.MoveToIslandMessage;

/**
 * Observer interface with update method
 */
public interface Observer {

    void updateError(ErrorMessage message);
    void updateMoveToIsland(MoveToIslandMessage message);
}
