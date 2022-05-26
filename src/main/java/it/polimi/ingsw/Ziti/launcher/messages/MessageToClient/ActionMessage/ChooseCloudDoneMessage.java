package it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.ActionMessage;

import it.polimi.ingsw.Ziti.launcher.messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.model.CloudIsland;

import java.util.ArrayList;

public class ChooseCloudDoneMessage extends ActionMessage{

    private ArrayList<CloudIsland> cloudIslands;

    public ChooseCloudDoneMessage(String description, ArrayList<CloudIsland> cloudIslands) {
        super(description);
        this.cloudIslands = new ArrayList<>(cloudIslands);
    }

    public ArrayList<CloudIsland> getCloudIslands() {
        return cloudIslands;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.ChooseCloudIslandDoneHandle(this);
    }
}
