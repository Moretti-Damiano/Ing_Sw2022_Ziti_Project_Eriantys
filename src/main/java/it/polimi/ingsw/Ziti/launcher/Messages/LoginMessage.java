package it.polimi.ingsw.Ziti.launcher.Messages;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.Serializable;

public class LoginMessage extends MessagetoServer {
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

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.loginHandler(this);
    }
}
