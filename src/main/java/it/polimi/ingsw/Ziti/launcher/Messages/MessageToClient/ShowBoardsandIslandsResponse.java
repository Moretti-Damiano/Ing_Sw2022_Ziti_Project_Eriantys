package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.model.Board;
import it.polimi.ingsw.Ziti.launcher.model.Island;

import java.util.ArrayList;
import java.util.Map;

public class ShowBoardsandIslandsResponse extends MessageToClient{
    private ArrayList<Island> islands;
    private ArrayList<Board> boards;
    private String requestplayer;
    private String activeplayer;
    private PhaseType phaseType;
    private Map<Integer,String> assistantMap;

    public ShowBoardsandIslandsResponse(ArrayList<Island> islands, ArrayList<Board> boards,
                                        String requestPlayer,String activeplayer, PhaseType phaseType,
                                        Map<Integer,String> assistantMap){
        this.boards=boards;
        this.islands=islands;
        this.requestplayer=requestPlayer;
        this.phaseType = phaseType;
        this.activeplayer=activeplayer;
        this.assistantMap=assistantMap;
    }

    public String getRequestplayer() {
        return requestplayer;
    }

    public String getActiveplayer(){ return activeplayer; }

    public ArrayList<Island> getIslands() {
        return islands;
    }

    public ArrayList<Board> getBoards() {
        return boards;
    }

    public PhaseType getPhaseType() {
        return phaseType;
    }

    public Map<Integer,String> getAssistantMap(){return assistantMap;}

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.ShowBoardsandIslandsResponseHandle(this);
    }
}
