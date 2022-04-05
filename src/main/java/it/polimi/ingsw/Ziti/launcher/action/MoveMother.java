package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.model.*;

public class MoveMother implements Action{
    private Game game;
    private int moves;

    public MoveMother(Game game, int moves){
        this.game = game;
        this.moves = moves;
    }

    @Override
    public Object execute() {

    }

    /**
     *
     * @param island
     * @return the player with most influence on island
     */
    public Player getControl(Island island){

    }

    /**
     * Merges two islands into one
     * @param  island1 is the 'main' island that will be updated
     * @param island2 will be deleted after the merge
     */
    public void merge(Island island1, Island island2){

    }

    /**
     * checks if island1 and island2 can be merged
     * @param island1
     * @param island2
     * @return true if the islands can be merged, else false
     */
    public boolean checkMerge(Island island1, Island island2){

    }
}
