package it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.Messages.ServerMessageHandler;

public class CloudIslandMessage extends MessagetoServer {
    private int cloudId;
    private String sender;

    public CloudIslandMessage(String sender,int cloudId) {
        this.sender = sender;
        this.cloudId=cloudId;
    }

    @Override
    public String getSender() {
        return sender;
    }

    public int getCloudId() {
        return cloudId;
    }

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.cloudIslandHandler(this);
    }
}
