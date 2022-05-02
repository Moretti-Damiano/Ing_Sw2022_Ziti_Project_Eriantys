package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;

import java.io.Serializable;

public class NumOfPLayersRequest  extends MessageToClient implements Serializable {
    
    public void handle(ClientMessageHandler clientMessageHandler){
        clientMessageHandler.NumOfPlayerRequestHandle(this);
    }
}
