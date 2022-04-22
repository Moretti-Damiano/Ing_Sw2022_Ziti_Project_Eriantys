package it.polimi.ingsw.Ziti.launcher.networking;

import it.polimi.ingsw.Ziti.launcher.enumeration.MessageType;

public class Message {
    MessageType messageType;
    String sender;
    String body;

    public MessageType getMessageType() {
        return messageType;
    }

    public String getSender() {
        return sender;
    }

    public String getBody() {
        return body;
    }
}
