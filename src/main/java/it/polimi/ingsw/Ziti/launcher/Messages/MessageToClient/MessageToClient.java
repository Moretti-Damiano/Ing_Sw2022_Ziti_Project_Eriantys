package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.Messages.Message;

import java.io.Serializable;

/**
 * this class is used by server to send a message to a client
 */
public abstract class MessageToClient extends Message implements Serializable {

    /**
     * this method is used to manage the message
     * @param clientMessageHandler the message to handle
     */
    public abstract void handle(ClientMessageHandler clientMessageHandler);
    
}
