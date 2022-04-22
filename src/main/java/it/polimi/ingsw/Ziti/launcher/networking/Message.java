package it.polimi.ingsw.Ziti.launcher.networking;

import it.polimi.ingsw.Ziti.launcher.enumeration.MessageType;

public class Message {
    MessageType messageType;
    String sender;
    String body;
    public Message(MessageType mt,String sender,String body){
        this.messageType=mt;
        this.sender=sender;
        this.body=body;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getBody() {
        return body;
    }

    public String getSender() {
        return sender;
    }
}
