package it.polimi.ingsw.Ziti.launcher.Messages;

public class CompletedRequestMessage extends MessageToClient{
   private String description;
   
   public CompletedRequestMessage(String description){
    this.description=description;
}
    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        
    }
}

