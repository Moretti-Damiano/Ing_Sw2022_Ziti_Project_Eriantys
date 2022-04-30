package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.model.Board;

public class ShowBoardResponse  extends MessageToClient{
    private Board board;

    public ShowBoardResponse(Board board){
        this.board=board;
    }

    public Board getBoard(){
        return this.board;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.ShowBoardResponseHandle(this);
    }
}
