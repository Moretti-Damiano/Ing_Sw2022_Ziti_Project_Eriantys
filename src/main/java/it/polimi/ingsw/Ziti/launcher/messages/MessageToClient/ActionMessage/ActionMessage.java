package it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.ActionMessage;

import it.polimi.ingsw.Ziti.launcher.messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.MessageToClient;

/**
 * It's a message to Client used to notify the player that an action is done
 */
public abstract class ActionMessage extends MessageToClient {

    private String description;

    public ActionMessage(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /**
     * This method is used to avoid a big switch branch
     * @param clientMessageHandler is the class that really handle messages to client
     */
    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {

    }
}
