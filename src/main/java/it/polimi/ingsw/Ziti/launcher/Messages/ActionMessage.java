package it.polimi.ingsw.Ziti.launcher.Messages;

public class ActionMessage extends MessageToClient {

    String description;

    public ActionMessage(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {

    }
}
