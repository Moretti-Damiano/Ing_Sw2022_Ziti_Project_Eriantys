package it.polimi.ingsw.Ziti.launcher.messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.messages.ClientMessageHandler;

import java.io.Serializable;

public class NumOfPLayersRequest  extends MessageToClient implements Serializable {
    
    public void handle(ClientMessageHandler clientMessageHandler){
        clientMessageHandler.NumOfPlayerRequestHandle(this);
    }
}
