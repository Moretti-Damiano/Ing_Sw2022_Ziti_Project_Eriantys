package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;

public class LoginError extends MessageToClient{
    String description;
    
    public LoginError(String description){
        this.description=description;
    }
    
    public void setDescription(String description){
        this.description=description;
    }
    
    public void handle(ClientMessageHandler clientMessageHandler){}
}
