package it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.ActionMessage;

import it.polimi.ingsw.Ziti.launcher.messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.model.Board;

public class MoveToTableDoneMessage extends ActionMessage{
     private Board activeplayerboard;
     private String playername;

    public MoveToTableDoneMessage(String description, Board board , String name) {
        super(description);
        this.activeplayerboard=board;
        this.playername=name;
    }

    public Board getBoard(){
        return this.activeplayerboard;
    }

    public String getPlayername(){
        return this.playername;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.MoveToTableDoneHandle(this);
    }
}
