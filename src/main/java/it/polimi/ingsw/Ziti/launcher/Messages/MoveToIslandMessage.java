package it.polimi.ingsw.Ziti.launcher.Messages;

import it.polimi.ingsw.Ziti.launcher.model.Island;

public class MoveToIslandMessage extends Message{

    private int islandID;
    private String Colour;
    private Boolean correct=false;

    public MoveToIslandMessage(String sender,int islandID,String colour) {
        super(sender);
        this.islandID=islandID;
        this.Colour=colour;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
