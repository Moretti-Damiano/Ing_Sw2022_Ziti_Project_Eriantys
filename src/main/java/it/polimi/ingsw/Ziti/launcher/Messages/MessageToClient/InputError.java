package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;

/**
 * This message is an input error message to client
 */
public class InputError extends MessageToClient{
    String description;

    public InputError(String description){
        this.description=description;
    }

    public String getDescription(){
        return description;
    }


    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
             clientMessageHandler.inputErrorHandle(this);
    }
}
