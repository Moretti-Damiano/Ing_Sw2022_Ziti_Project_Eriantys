package it.polimi.ingsw.Ziti.launcher.messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.messages.ServerMessageHandler;

public class ChooseAssistantMessage extends MessagetoServer {
    private int assistantId;
    private String sender;
    public ChooseAssistantMessage( int assistantId) {
        super();
        this.assistantId=assistantId;
    }

    public int getAssistantId() {
        return assistantId;
    }

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.choseAssistantHandler(this);
    }
}
