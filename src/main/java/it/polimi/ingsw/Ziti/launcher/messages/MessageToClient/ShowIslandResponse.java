package it.polimi.ingsw.Ziti.launcher.messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.model.Island;

import java.util.ArrayList;
/**
 * This message has a list of  Islands as a response to a Show Island request
 */
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
