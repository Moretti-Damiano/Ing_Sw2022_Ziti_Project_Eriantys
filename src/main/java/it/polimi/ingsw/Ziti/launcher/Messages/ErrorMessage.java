package it.polimi.ingsw.Ziti.launcher.Messages;

public class ErrorMessage extends Message{

    private String description;
    public ErrorMessage(String sender,String description) {
        super(sender);
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

}
