package it.polimi.ingsw.Ziti.launcher;

import it.polimi.ingsw.Ziti.launcher.action.ChooseCloud;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.CloudIsland;
import it.polimi.ingsw.Ziti.launcher.model.Game.Game;
import it.polimi.ingsw.Ziti.launcher.model.Game.Game2;
import it.polimi.ingsw.Ziti.launcher.model.Game.Game3;
import it.polimi.ingsw.Ziti.launcher.model.Player;
import it.polimi.ingsw.Ziti.launcher.model.Student;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ChooseCloudTest {

    private static Game game;
    @ParameterizedTest
    @ValueSource(ints = {2,3})
    public void CloudIslandTest(int numPlayers) throws ParserConfigurationException, IOException, SAXException, ActionException {

        //set up a game for n players
        ArrayList<Player> players = new ArrayList<>();
        for(int i = 0; i < numPlayers; i ++){
            players.add(new Player("Giocatore"+ i));
        }
        if(numPlayers==2){
            game = new Game2(players);
        }
        else
            game = new Game3(players);

        //removes all students from p1 board
        Player p1 = game.getPlayers().get(0);
        p1.getBoard().getStudents_waiting().clear();

        game.setActivePlayer(p1);
        game.setAction(new ChooseCloud(game,p1,0));
        CloudIsland cloud = game.getCloudIslands().get(0);
        ArrayList<Student> cloudStudents = new ArrayList<> (cloud.getStudents());

        game.doAction();

        //check if cloud 0 is not available
        assertFalse(cloud.isAvailable());
        //check if the same number of student has been transferred to p1.board
        assertEquals(cloud.getSize(),p1.getBoard().getStudents_waiting().size());
        //check if p1.board students waiting are the same as the cloud island
        assertEquals(cloudStudents,p1.getBoard().getStudents_waiting());

    }
}


