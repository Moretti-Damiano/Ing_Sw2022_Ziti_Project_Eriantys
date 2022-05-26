package it.polimi.ingsw.Ziti.launcher.messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.model.Board;

import java.util.ArrayList;
/**
 * This message contains a list of board as a response to a Show Boards request
 */
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
