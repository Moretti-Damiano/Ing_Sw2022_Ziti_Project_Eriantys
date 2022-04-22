package it.polimi.ingsw.Ziti.launcher.Messages;
import java.io.Serializable;

public abstract class Message implements Serializable {

    private final String sender;

    public Message(String sender) {
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }
}
