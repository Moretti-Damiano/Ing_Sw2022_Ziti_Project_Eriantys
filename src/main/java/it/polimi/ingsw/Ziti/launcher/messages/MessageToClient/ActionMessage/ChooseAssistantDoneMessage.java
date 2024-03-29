package it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.ActionMessage;

import it.polimi.ingsw.Ziti.launcher.messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.model.Assistant;

import java.util.ArrayList;
import java.util.List;

public class ChooseAssistantDoneMessage extends ActionMessage{
    private ArrayList<Assistant> assistants;
    private String playername;

    public ChooseAssistantDoneMessage(String description, List<Assistant> assistants, String playername) {
        super(description);
        this.assistants=new ArrayList<>(assistants);
        this.playername=playername;
        }

    public ArrayList<Assistant> getAssistants() {
        return assistants;
    }

    public String getPlayername() {
        return playername;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.ChooseAssistantDoneHandle(this);
    }
}

