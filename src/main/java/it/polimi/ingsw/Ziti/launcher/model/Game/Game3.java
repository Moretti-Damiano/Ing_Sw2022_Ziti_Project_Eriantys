package it.polimi.ingsw.Ziti.launcher.model.Game;

import it.polimi.ingsw.Ziti.launcher.enumeration.TowerColour;
import it.polimi.ingsw.Ziti.launcher.model.Player;
import it.polimi.ingsw.Ziti.launcher.model.Tower;

import java.util.ArrayList;

public class Game3 extends Game {

    /**
     * Creates 12 islands,Mother and memorizes the players
     * @param p arraylist containing all the players
     */
    public Game3(ArrayList<Player> p) {
            super(p);
        }

        public void setPlayers(ArrayList<Player> p) {
        //set player towercolour
            int towerColour = 0;
            for (Player player : p) {
                player.getBoard().setTowerColour(TowerColour.valueOfAbbreviation(Integer.toString(towerColour)));
                towerColour++;
            }

            //add 7 random students on each player's board and 8 towers
            for (Player player : p) {
                for (int i = 0; i < 9; i++) {
                    player.getBoard().addStudent(getSack().extract());
                }
                for (int i = 0; i < 6; i++) {
                    player.getBoard().addTower(new Tower(player, player.getBoard().getTower_colour()));
                }
            }
        }
}

