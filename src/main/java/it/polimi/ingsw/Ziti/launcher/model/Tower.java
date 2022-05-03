package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.enumeration.TowerColour;

import java.io.Serializable;

/**
*  This class represents Tower used in the game to symbolize the control of a Player in an Island.
* */
public class Tower implements Serializable {

    private TowerColour towerColour;
    private Player player;

    public Tower(Player player,TowerColour towerColour){
        this.player = player;
        this.towerColour = towerColour;
    }

    /**
     * @return towerColour
     */
    public TowerColour getTowerColour(){
        return towerColour;
    }
}
