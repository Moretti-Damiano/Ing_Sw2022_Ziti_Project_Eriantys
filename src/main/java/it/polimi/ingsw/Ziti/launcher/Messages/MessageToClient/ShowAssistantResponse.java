package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.model.Assistant;


import java.util.List;

public class ShowAssistantResponse extends MessageToClient{
    private List<Assistant> assistants;

    public ShowAssistantResponse(List<Assistant> assistants){
        this.assistants=assistants;
    }

    public List<Assistant> getAssistants() {
        return assistants;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.ShowAssistantResponseHandle(this);
    }
}
