package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.Messages.Message;

import java.io.Serializable;

public abstract class MessageToClient extends Message {

    public abstract void handle(ClientMessageHandler clientMessageHandler);
    
}
