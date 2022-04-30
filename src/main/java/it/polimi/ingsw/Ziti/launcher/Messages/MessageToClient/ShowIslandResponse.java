package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.model.Island;

import java.util.ArrayList;

public class ShowIslandResponse extends MessageToClient{
    private ArrayList<Island> islands;

    public ShowIslandResponse(ArrayList<Island> islands){
        this.islands=islands;
    }

    public ArrayList<Island> getIslands(){
        return this.islands;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.ShowIslandsResponseHandle(this);
    }
}
