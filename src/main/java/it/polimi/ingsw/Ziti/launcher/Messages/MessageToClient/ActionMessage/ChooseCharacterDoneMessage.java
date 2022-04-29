package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;

public class ChooseCharacterDoneMessage extends ActionMessage{
    public ChooseCharacterDoneMessage(String description) {
        super(description);
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.ChooseCharacterDoneHandle(this);
    }
}
