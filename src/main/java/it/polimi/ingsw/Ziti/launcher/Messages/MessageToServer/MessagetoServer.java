package it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.Messages.Message;
import it.polimi.ingsw.Ziti.launcher.Messages.ServerMessageHandler;

import java.io.Serializable;

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

    public abstract void handle(ServerMessageHandler serverMessageHandler);
}
