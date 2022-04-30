package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.model.Board;

import java.util.ArrayList;

public class ShowBoardsResponse  extends MessageToClient {
    private ArrayList<Board> boards;

    public ShowBoardsResponse(ArrayList<Board> boards){
        this.boards=boards;
    }

    public ArrayList<Board> getBoards() {
        return boards;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.ShowBoardsResponseHandle(this);
    }
}
