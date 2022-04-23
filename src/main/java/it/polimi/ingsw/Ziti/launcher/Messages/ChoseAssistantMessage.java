package it.polimi.ingsw.Ziti.launcher.Messages;

public class ChoseAssistantMessage extends Message{
    int assistantId;
    Boolean correct=false;
    public ChoseAssistantMessage(String sender,int assistantId) {
        super(sender);
        this.assistantId=assistantId;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
