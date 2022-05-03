package it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.Messages.ServerMessageHandler;

import java.io.Serializable;

public class LoginMessage extends MessagetoServer implements Serializable {
    private String username;

    public LoginMessage(String username) {
        super();
        this.username=username;
    }

    public String getUsername(){return username;}
    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.loginHandler(this);
    }

}
