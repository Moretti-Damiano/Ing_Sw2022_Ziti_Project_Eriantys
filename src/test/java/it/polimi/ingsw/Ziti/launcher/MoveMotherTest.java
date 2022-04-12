package it.polimi.ingsw.Ziti.launcher;

import it.polimi.ingsw.Ziti.launcher.action.MoveMother;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MoveMotherTest {
    private static Game game;
    @Test
    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Player> players = new ArrayList<>();
        for(int i = 0; i < 2; i ++){
            players.add(new Player("Giocatore"+ i));
        }
        game = new Game(players); //creates a new game with 2 players
    }

    @ParameterizedTest
    @ValueSource(ints = {0,5,7,10})
    public void correctPosition(int pos) throws ActionException {
        Mother.motherInstance().setIsland(game.getIslands().get(pos));
        game.setAction(new MoveMother(game,4));
        game.doAction();
        System.out.println("Length islands: " + game.getIslands().size());
        assertEquals((pos + 4)%(game.getIslands().size()),game.getIslands().indexOf(Mother.motherInstance().getIsland()));

    }
}
