package it.polimi.ingsw.Ziti.launcher.Messages;

public class InputError extends MessageToClient{
    String description;

    public InputError(String description){
        this.description=description;
    }

    public String getDescription(){
        return description;
    }
}
