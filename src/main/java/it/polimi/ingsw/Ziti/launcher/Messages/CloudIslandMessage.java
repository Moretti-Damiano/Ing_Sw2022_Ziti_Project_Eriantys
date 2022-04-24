package it.polimi.ingsw.Ziti.launcher.Messages;

public class CloudIslandMessage extends Message{
    int cloudId;
    Boolean correct =false;
    public CloudIslandMessage(String sender,int cloudId) {
        super(sender);
        this.cloudId=cloudId;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public Boolean getCorrect() {
        return correct;
    }
}
