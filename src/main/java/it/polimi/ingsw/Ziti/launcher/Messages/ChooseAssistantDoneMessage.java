package it.polimi.ingsw.Ziti.launcher.Messages;

import it.polimi.ingsw.Ziti.launcher.model.Assistant;

public class ChooseAssistantDoneMessage extends ActionMessage{
    private Assistant assistant;
    private String playername;

    public ChooseAssistantDoneMessage(String description, Assistant assistant, String playername) {
        super(description);
        this.assistant=assistant;
        this.playername=playername;
        }

    public Assistant getAssistant() {
        return assistant;
    }

    public String getPlayername() {
        return playername;
    }


}

