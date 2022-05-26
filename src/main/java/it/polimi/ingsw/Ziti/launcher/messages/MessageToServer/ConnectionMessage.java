package it.polimi.ingsw.Ziti.launcher.messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.messages.ServerMessageHandler;

public class ConnectionMessage extends MessagetoServer{
    String Port;
    String Address;

    public ConnectionMessage(String port,String address){
        this.Port=port;
        this.Address=address;
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
