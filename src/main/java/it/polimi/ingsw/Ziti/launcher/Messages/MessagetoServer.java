package it.polimi.ingsw.Ziti.launcher.Messages;

import java.io.Serializable;

public abstract class MessagetoServer extends Message{
    private String Sender;

    public void setSender(String sender) {
        Sender = sender;
    }

    public abstract String getSender();
    public abstract void handle(ServerMessageHandler serverMessageHandler);
}
