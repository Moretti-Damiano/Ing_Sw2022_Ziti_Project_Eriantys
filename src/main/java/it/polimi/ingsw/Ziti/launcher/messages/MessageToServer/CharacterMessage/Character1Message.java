package it.polimi.ingsw.Ziti.launcher.messages.MessageToServer.CharacterMessage;

import it.polimi.ingsw.Ziti.launcher.messages.MessageToServer.MessagetoServer;
import it.polimi.ingsw.Ziti.launcher.messages.ServerMessageHandler;

public class Character1Message extends MessagetoServer {
    private int islandId;

    public Character1Message(int islandId){
        this.islandId=islandId;
    }

    public int getIslandId(){
        return this.islandId;
    }
    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.chooseCharacter1Handler(this);
    }
}
