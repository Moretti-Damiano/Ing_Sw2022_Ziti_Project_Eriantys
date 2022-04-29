package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.model.Board;
import it.polimi.ingsw.Ziti.launcher.model.Island;

import java.util.ArrayList;

public class MoveToIslandDoneMessage extends ActionMessage{
    private ArrayList<Island> islands;
    private Board board;
    private String playername;

    public MoveToIslandDoneMessage(String description, ArrayList<Island> islands, Board board, String playername) {
        super(description);
        this.islands=new ArrayList<>(islands);
        this.board=board;
        this.playername=playername;

    }

    public Board getBoard(){
        return this.board;
    }

    public ArrayList<Island> getIslands(){
        return this.islands;
    }

    public String getPlayername(){
        return this.playername;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.MoveToIslandDoneHandle(this);
    }
}
