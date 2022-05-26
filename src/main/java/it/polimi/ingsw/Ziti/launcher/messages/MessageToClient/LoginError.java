package it.polimi.ingsw.Ziti.launcher.messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.messages.ClientMessageHandler;

/**
 * This message is a login error message to client
 */
public class LoginError extends MessageToClient{
    String description;
    
    public LoginError(String description){
        this.description=description;
    }
    
    public void setDescription(String description){
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public void handle(ClientMessageHandler clientMessageHandler){clientMessageHandler.LoginErrorHandle(this);}
}
