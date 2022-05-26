package it.polimi.ingsw.Ziti.launcher.model;

import java.io.Serializable;

/**
 * This class represents the Mother Of Nature in the game.
 * */
public class Mother implements Serializable {
    private Island island;


    public void setIsland(Island island) {
        this.island = island;
    }

    public Island getIsland() {
        return island;
    }
}
