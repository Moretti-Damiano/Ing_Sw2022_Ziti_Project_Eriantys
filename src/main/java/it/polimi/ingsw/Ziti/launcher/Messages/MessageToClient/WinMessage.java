package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;

public class WinMessage extends MessageToClient{

    private String winner;

    public String getWinner(){return winner;}
    
    public WinMessage(String winner){
        this.winner = winner;
    }
    
    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.WinMessageHandle(this);
    }
}
