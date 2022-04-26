package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.Message;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

public interface GameControllerObserver {
    void update(MessageToClient message, String nickName);
    void update(MessageToClient message);
}
