package it.polimi.ingsw.Ziti.launcher.Messages;

import it.polimi.ingsw.Ziti.launcher.model.*;
import it.polimi.ingsw.Ziti.launcher.model.Character;

import java.util.ArrayList;

public class EndTurnDoneMessage extends ActionMessage{

    private ArrayList<Island> islands;
    private ArrayList<Board> boards;
    private ArrayList<CloudIsland> cloudIslands;
    private ArrayList<Character> characters;
    private ArrayList<Player> players;

    public EndTurnDoneMessage(String description, ArrayList<Island> islands, ArrayList<Board> boards,
                              ArrayList<CloudIsland> cloudIslands, ArrayList<Character> characters, ArrayList<Player> players) {
        super(description);
        this.islands = islands;
        this.boards = boards;
        this.cloudIslands = cloudIslands;
        this.characters = characters;
        this.players = players;
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

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
