package it.polimi.ingsw.Ziti.launcher.Messages;

import it.polimi.ingsw.Ziti.launcher.model.CloudIsland;

import java.util.List;

public class showCloudsMessage extends MessageToClient{
    List<CloudIsland> cloudIslands;
    public showCloudsMessage(List <CloudIsland> clouds){
        this.cloudIslands=clouds;
    }

    public List<CloudIsland> getCloudIslands() {
        return cloudIslands;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.showCloudsHandle(this);
    }
}
