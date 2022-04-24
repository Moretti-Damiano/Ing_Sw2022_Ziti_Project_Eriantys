package it.polimi.ingsw.Ziti.launcher.Messages;

public interface MessagetoServer {
    public String getSender();
    public void handle(ServerMessageHandler serverMessageHandler);
}
