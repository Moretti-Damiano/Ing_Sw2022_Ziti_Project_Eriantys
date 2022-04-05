package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.enumeration.TowerColour;

/**
*  This class represents Tower used in the game to symbolize the control of a Player in an Island.
* */
public class Tower {

    private TowerColour towerColour;
    private Player player;

    /**
     *
     * @return towerColour
     */
    public TowerColour getTowerColour(){
        return towerColour;
    }
}
