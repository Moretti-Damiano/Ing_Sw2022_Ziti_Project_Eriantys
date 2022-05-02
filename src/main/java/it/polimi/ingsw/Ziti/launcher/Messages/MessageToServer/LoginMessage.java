package it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.Messages.ServerMessageHandler;

import java.io.Serializable;

public class LoginMessage extends MessagetoServer implements Serializable {
    private String username;
    private String sender;

    public LoginMessage(String sender,String username) {
        this.sender = sender;
        this.username=username;
    }

    @Override
    public String getSender() {
        return sender;
    }

    public String getUsername(){return username;}

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.loginHandler(this);
    }

}
