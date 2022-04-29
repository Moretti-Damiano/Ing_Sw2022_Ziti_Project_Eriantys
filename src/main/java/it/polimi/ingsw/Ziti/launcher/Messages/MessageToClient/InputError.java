package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;

public class InputError extends MessageToClient{
    String description;

    public InputError(String description){
        this.description=description;
    }

    public String getDescription(){
        return description;
    }

    // da implementare i controlli
    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
             clientMessageHandler.inputErrorHandle(this);
    }
}
