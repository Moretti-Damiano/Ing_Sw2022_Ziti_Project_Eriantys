package it.polimi.ingsw.Ziti.launcher.Messages;

import java.io.Serializable;

public class ChoseAssistantMessage extends MessagetoServer {
    private int assistantId;
    private String sender;
    public ChoseAssistantMessage(String sender,int assistantId) {
        this.sender = sender;
        this.assistantId=assistantId;
    }

    public int getAssistantId() {
        return assistantId;
    }

    @Override
    public String getSender() {
        return sender;
    }

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.choseAssistantHandler(this);
    }
}
