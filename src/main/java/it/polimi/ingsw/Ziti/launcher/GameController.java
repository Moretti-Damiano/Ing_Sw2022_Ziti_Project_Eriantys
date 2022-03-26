package it.polimi.ingsw.Ziti.launcher;

import java.sql.Array;
import java.util.ArrayList;

public class GameController {
    ArrayList<Island> islands;
    ArrayList<Player> players;
    Mother mother;

    /**
     * Creates 12 islands,Mother and memorizes the players
     * @param p arraylist containing all the players
     */
    public GameController(ArrayList<Player> p){
        islands = new ArrayList<Island>();
        for(int i=0;i<12;i++){
            islands.add(new Island(i));
        }
        mother = new Mother();  //should be passed as parameter or created here?
        this.players = new ArrayList<Player>(p);    //copies p into players
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
     * @param island
     * @return the player with most influence on the island
     */
    public Player getControl(Island island){
        //work in progress...
    }

}
