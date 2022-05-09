package it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.CharacterMessage;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.MessagetoServer;
import it.polimi.ingsw.Ziti.launcher.Messages.ServerMessageHandler;

public class Character0Message extends MessagetoServer {

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.chooseCharacter0Handler(this);
    }
}
