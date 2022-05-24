package it.polimi.ingsw.Ziti.launcher.model.Game;
import it.polimi.ingsw.Ziti.launcher.enumeration.TowerColour;
import it.polimi.ingsw.Ziti.launcher.model.Player;
import it.polimi.ingsw.Ziti.launcher.model.Tower;

import java.util.ArrayList;

/**
 * Class used to set up a game for 2 players
 */
public class Game2 extends Game {


    /**
     * Creates 12 islands,Mother and memorizes the players
     *
     * @param p arraylist containing all the players
     */
    public Game2(ArrayList<Player> p) {
        super(p);
    }

    /**
     * depending on the game number of players, this method initializes each player's board
     * adding students and towers of the automatically assigned colour
     *
     * @param p the arraylist containing all the players
     */
    public void setPlayers(ArrayList<Player> p) {
        //set player towercolour
        int towerColour = 0;
        for (Player player : p) {
            player.getBoard().setTowerColour(TowerColour.valueOfAbbreviation(Integer.toString(towerColour)));
            towerColour++;
        }

        //add 7 random students on each player's board and 8 towers
        for (Player player : p) {
            for (int i = 0; i < 7; i++) {
                player.getBoard().addStudent(getSack().extract());
                player.getBoard().addTower(new Tower(player, player.getBoard().getTower_colour()));
            }
            player.getBoard().addTower(new Tower(player, player.getBoard().getTower_colour())); //adds the 8th tower

        }

    }
}