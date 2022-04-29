package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;

public class NumOfPLayersRequest  extends MessageToClient{
    
    public void handle(ClientMessageHandler clientMessageHandler){
        clientMessageHandler.NumOfPlayerRequestHandle(this);
    }
}
