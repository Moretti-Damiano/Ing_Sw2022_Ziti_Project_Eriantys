package it.polimi.ingsw.Ziti.launcher.model.game;

import it.polimi.ingsw.Ziti.launcher.model.Player;

import java.util.ArrayList;

/**
 * Class used to create a new game depending on the number of players by using a Factory pattern.
 * This class also implements the Singleton Pattern.
 */
public class GameFactory {

    private static GameFactory instance;

    private GameFactory(){}

    public static GameFactory getInstance(){
        if(instance == null)
            instance = new GameFactory();
        return instance;
    }

    /**
     * Creates a new game per numOfPlayers players
     * @param numOfPlayers the number of players
     * @param players the arraylist of players
     * @return the game class
     */
    public Game getGame(int numOfPlayers, ArrayList<Player> players){
        if(numOfPlayers == 2)
            return new Game2(players);
        if(numOfPlayers == 3)
            return  new Game3(players);
        return null;
    }
}
