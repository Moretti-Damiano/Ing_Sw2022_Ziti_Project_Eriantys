package it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.Messages.ServerMessageHandler;

public class ConnectionMessage extends MessagetoServer{
    String Port;
    String Address;

    public ConnectionMessage(String port,String address){
        this.Port=port;
        this.Address=address;
    }
    @Override
    public String getSender() {
        return null;
    }

    public String getAddress() {
        return Address;
    }

    public String getPort() {
        return Port;
    }

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {

    }
}
