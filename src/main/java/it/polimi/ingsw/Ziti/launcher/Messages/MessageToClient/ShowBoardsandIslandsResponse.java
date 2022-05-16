package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.model.Board;
import it.polimi.ingsw.Ziti.launcher.model.Island;

import java.util.ArrayList;

public class ShowBoardsandIslandsResponse extends MessageToClient{
    private ArrayList<Island> islands;
    private ArrayList<Board> boards;
    private String requestplayer;
    private PhaseType phaseType;

    public ShowBoardsandIslandsResponse(ArrayList<Island> islands, ArrayList<Board> boards,String requestPlayer, PhaseType phaseType){
        this.boards=boards;
        this.islands=islands;
        this.requestplayer=requestPlayer;
        this.phaseType = phaseType;
    }

    public String getRequestplayer() {
        return requestplayer;
    }

    public ArrayList<Island> getIslands() {
        return islands;
    }

    public ArrayList<Board> getBoards() {
        return boards;
    }

    public PhaseType getPhaseType() {
        return phaseType;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.ShowBoardsandIslandsResponseHandle(this);
    }
}
