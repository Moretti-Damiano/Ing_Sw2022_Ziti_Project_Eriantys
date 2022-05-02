package it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.Messages.Message;
import it.polimi.ingsw.Ziti.launcher.Messages.ServerMessageHandler;

import java.io.Serializable;

public abstract class MessagetoServer extends Message implements Serializable {
    private String Sender;

    public void setSender(String sender) {
        Sender = sender;
    }

    public abstract String getSender();
    public abstract void handle(ServerMessageHandler serverMessageHandler);
}
