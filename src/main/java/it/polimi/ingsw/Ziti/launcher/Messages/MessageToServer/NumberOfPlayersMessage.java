package it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.Messages.ServerMessageHandler;

public class NumberOfPlayersMessage extends MessagetoServer{
    int numberOfPlayers;
    String sender;

    public NumberOfPlayersMessage(String sender, int numberofplayers){
        this.sender=sender;
        this.numberOfPlayers=numberofplayers;
    }

    public  String getSender(){
        return sender;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.numberOfPlayersHandler(this);
    }
}
