package it.polimi.ingsw.Ziti.launcher.messages.MessageToServer.CharacterMessage;

import it.polimi.ingsw.Ziti.launcher.messages.MessageToServer.MessagetoServer;
import it.polimi.ingsw.Ziti.launcher.messages.ServerMessageHandler;

public class Character4Message extends MessagetoServer {
    private String colour;

    public Character4Message(String colour){
        this.colour=colour;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.chooseCharacter4Handler(this);
    }
}
