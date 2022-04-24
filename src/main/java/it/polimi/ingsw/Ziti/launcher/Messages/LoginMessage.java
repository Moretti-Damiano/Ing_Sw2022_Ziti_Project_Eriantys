package it.polimi.ingsw.Ziti.launcher.Messages;

public class LoginMessage extends Message {
    private String username;
    private Boolean correct=false;
    public LoginMessage(String sender,String username) {
        super(sender);
        this.username=username;
    }

    public void setCorrect(Boolean correct) {
        this.correct=correct;
    }

    public Boolean getCorrect() {
        return correct;
    }
}
