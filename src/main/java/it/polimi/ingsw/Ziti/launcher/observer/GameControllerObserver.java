package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.Message;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

/**
 * Interface used to implement the Observer-Observable pattern between Server and GameController.
 * This interface allows the Server to observe the GameController.
 * It contains the methods to send the message to the clients.
 */
public interface GameControllerObserver {

    public void sendToOnePlayer(MessageToClient message, String nickName);
    public void sendToAllPlayers(MessageToClient message);
    public void successfulLogin(MessageToClient message, String temporaryName,String newName);
    public void requestPlayerNumber(MessageToClient message, String nickName);

}
