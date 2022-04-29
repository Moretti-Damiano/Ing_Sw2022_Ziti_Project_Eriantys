package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;

public class TurnError extends MessageToClient{
    String description;

    public TurnError(String descriuption){
        this.description=descriuption;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {

    }
}
