package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;

public class ConnectionSuccessfulMessage extends MessageToClient{
    Boolean Success;
    public ConnectionSuccessfulMessage(Boolean success){
        this.Success=success;
    }

    public Boolean getSuccess() {
        return Success;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {

    }
}
