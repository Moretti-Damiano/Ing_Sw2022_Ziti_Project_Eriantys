package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.ErrorMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.MoveToIslandMessage;

public interface ViewObserver {

    void updateMoveToIslandMessage(MoveToIslandMessage message);
    void updateErrorMessage(ErrorMessage message);
}
