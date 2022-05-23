package it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.Messages.Message;
import it.polimi.ingsw.Ziti.launcher.Messages.ServerMessageHandler;

import java.io.Serializable;

/**
 * this class is used to send a message to the server
 */
public abstract class MessagetoServer extends Message implements Serializable {
    private String sender;

    public MessagetoServer(){
        sender = "";
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSender(){
        return sender;
    }

    /**
     * this method is used to manage the message
     * @param serverMessageHandler the message to handle
     */
    public abstract void handle(ServerMessageHandler serverMessageHandler);
}
