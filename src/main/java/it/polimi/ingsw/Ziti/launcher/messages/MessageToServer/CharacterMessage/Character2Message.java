package it.polimi.ingsw.Ziti.launcher.messages.MessageToServer.CharacterMessage;

import it.polimi.ingsw.Ziti.launcher.messages.MessageToServer.MessagetoServer;
import it.polimi.ingsw.Ziti.launcher.messages.ServerMessageHandler;

public class Character2Message extends MessagetoServer {
    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.chooseCharacter2Handler(this);
    }
}
