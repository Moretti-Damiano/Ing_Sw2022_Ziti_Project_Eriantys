package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.model.CloudIsland;

import java.util.ArrayList;
/**
 * This message has a list of Cloud Islands as a response to a Show Cloud request
 */
public class ShowCloudResponse  extends MessageToClient{
    private ArrayList<CloudIsland> clouds;

    public ShowCloudResponse(ArrayList<CloudIsland> clouds){
        this.clouds=clouds;
    }

    public ArrayList<CloudIsland> getClouds() {
        return clouds;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.ShowCloudsResponseHandle(this);
    }
}
