package it.polimi.ingsw.Ziti.launcher.Messages;

import java.io.Serializable;

public class ErrorMessage implements  MessagetoClient, Serializable {

    private String description;
    private String sender;
    public ErrorMessage(String sender,String description) {
        this.sender = sender;
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public String getSender() {
        return sender;
    }

}
