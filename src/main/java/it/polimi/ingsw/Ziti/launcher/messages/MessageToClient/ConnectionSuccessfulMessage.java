package it.polimi.ingsw.Ziti.launcher.messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.messages.ClientMessageHandler;

/**
 * This message is used to notify that a connection has been established and game can start
 */
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
        clientMessageHandler.ConnectionSuccessfulHandle(this);
    }
}
