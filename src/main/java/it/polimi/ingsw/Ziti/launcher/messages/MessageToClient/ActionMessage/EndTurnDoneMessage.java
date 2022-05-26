package it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.ActionMessage;

import it.polimi.ingsw.Ziti.launcher.messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.model.*;

import java.util.ArrayList;

public class EndTurnDoneMessage extends ActionMessage {

    private ArrayList<Island> islands;
    private ArrayList<Board> boards;
    private ArrayList<CloudIsland> cloudIslands;
    private ArrayList<Player> players;

    public EndTurnDoneMessage(String description, ArrayList<Island> islands, ArrayList<Board> boards,
                              ArrayList<CloudIsland> cloudIslands) {
        super(description);
        this.islands = islands;
        this.boards = boards;
        this.cloudIslands = cloudIslands;
    }

    public ArrayList<Island> getIslands() {
        return islands;
    }

    public ArrayList<Board> getBoards() {
        return boards;
    }

    public ArrayList<CloudIsland> getCloudIslands() {
        return cloudIslands;
    }


    public ArrayList<Player> getPlayers() {
        return players;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.EndTurnDoneHandle(this);
    }
}
