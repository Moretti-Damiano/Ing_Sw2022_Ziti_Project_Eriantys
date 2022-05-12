package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.model.Board;
import it.polimi.ingsw.Ziti.launcher.model.Island;

import java.util.ArrayList;

public class ShowBoardsandIslandsResponse extends MessageToClient{
    private ArrayList<Island> islands;
    private ArrayList<Board> boards;

    public ShowBoardsandIslandsResponse(ArrayList<Island> islands, ArrayList<Board> boards){
        this.boards=boards;
        this.islands=islands;
    }

    public ArrayList<Island> getIslands() {
        return islands;
    }

    public ArrayList<Board> getBoards() {
        return boards;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.ShowBoardsandIslandsResponseHandle(this);
    }
}
