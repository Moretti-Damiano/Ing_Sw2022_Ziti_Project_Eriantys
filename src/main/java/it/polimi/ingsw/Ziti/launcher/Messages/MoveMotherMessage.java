package it.polimi.ingsw.Ziti.launcher.Messages;

public class MoveMotherMessage extends Message{
    int moves;
    Boolean correct=false;
    public MoveMotherMessage(String sender,int moves) {
        super(sender);
        this.moves=moves;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
