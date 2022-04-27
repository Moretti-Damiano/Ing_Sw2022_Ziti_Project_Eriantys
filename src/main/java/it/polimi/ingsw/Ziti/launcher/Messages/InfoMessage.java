package it.polimi.ingsw.Ziti.launcher.Messages;

public class InfoMessage extends MessageToClient {
    String description;


    public InfoMessage(String description){
        this.description=description;

    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {

    }
}
