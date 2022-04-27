package it.polimi.ingsw.Ziti.launcher.Messages;

public class NumberOfPlayersMessage extends MessagetoServer{
    int numberofplayers;
    String sender;

    public NumberOfPlayersMessage(String sender, int numberofplayers){
        this.sender=sender;
        this.numberofplayers=numberofplayers;
    }

    public  String getSender(){
        return sender;
    }

    public int getNumberOfPlayers() {
        return numberofplayers;
    }

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.numberOfPlayersHandler(this);
    }
}
