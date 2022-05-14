package it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.Messages.ServerMessageHandler;

public class ModeResponse extends MessagetoServer{
    private String mode;

    public ModeResponse(String mode){
        super();
        this.mode=mode;
    }

    public String getMode() {
        return mode;
    }

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.modeHandler(this);
    }
}
