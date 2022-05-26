package it.polimi.ingsw.Ziti.launcher.messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.messages.ServerMessageHandler;

public class NumberOfPlayersMessage extends MessagetoServer{
    int numberOfPlayers;
    String sender;

    public NumberOfPlayersMessage(int numberofplayers){
        super();
        this.numberOfPlayers=numberofplayers;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.numberOfPlayersHandler(this);
    }
}
