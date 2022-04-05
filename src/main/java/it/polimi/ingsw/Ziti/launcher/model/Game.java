package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;

import java.util.ArrayList;

public class Game {
    ArrayList<Island> islands;
    ArrayList<Player> players;
    Mother mother;

    /**
     * Creates 12 islands,Mother and memorizes the players
     * @param p arraylist containing all the players
     */
    public Game(ArrayList<Player> p){
        islands = new ArrayList<Island>();
        for(int i=0;i<12;i++){
            islands.add(new Island(i));
        }
        mother = Mother.motherInstance();  //should be passed as parameter or created here?
        this.players = new ArrayList<Player>(p);    //copies p into players
    }


    public ArrayList<Island> getIslands() {
        return islands;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param i is the main island
     * @return next island to i
     * if i is the last island, returns the first island
     */
    public Island getNextIsland(Island i){
        int index = islands.indexOf(i);
        if(index == islands.size()-1){  //i is last element
            return islands.get(0);
        }
        else
            return islands.get(index+1);
    }

    /**
     * @param i is the main island
     * @return the previous island to i
     * if i is the first islands, return the last island
     */
    public Island getPrevIsland(Island i){
        int index = islands.indexOf(i);
        if(index == 0){         //i is first element
            return islands.get(islands.size()-1);
        }
        else
            return islands.get(index-1);
    }

    /**
     *Adds a students from player's board, choosen by colour, to the specified island
     */
    public void addStudent(Player player, Island island, Colour colour){
        island.addStudent(player.getBoard().leave(colour));
    }

}
