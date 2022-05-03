package it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.Messages.ServerMessageHandler;

public class CloudIslandMessage extends MessagetoServer {
    private int cloudId;
    private String sender;

    public CloudIslandMessage(int cloudId) {
        super();
        this.cloudId=cloudId;
    }


    public int getCloudId() {
        return cloudId;
    }

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.cloudIslandHandler(this);
    }
}
