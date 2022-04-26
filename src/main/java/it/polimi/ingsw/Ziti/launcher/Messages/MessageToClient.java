package it.polimi.ingsw.Ziti.launcher.Messages;

import java.io.Serializable;

public abstract class MessageToClient extends Message{

    public abstract void handle(ClientMessageHandler clientMessageHandler);
    
}
