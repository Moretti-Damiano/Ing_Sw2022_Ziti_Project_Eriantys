package it.polimi.ingsw.Ziti.launcher.Messages;

public class TurnError extends MessageToClient{
    String description;

    public TurnError(String descriuption){
        this.description=descriuption;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {

    }
}
