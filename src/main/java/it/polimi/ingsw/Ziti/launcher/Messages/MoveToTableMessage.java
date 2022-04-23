package it.polimi.ingsw.Ziti.launcher.Messages;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;

public class MoveToTableMessage extends Message{
    Colour colour;
    Boolean correct=false;
    public MoveToTableMessage(String sender,Colour colour) {
        super(sender);
        this.colour=colour;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
