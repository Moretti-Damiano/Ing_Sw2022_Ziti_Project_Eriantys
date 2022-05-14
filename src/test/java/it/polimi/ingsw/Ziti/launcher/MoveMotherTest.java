package it.polimi.ingsw.Ziti.launcher;

import it.polimi.ingsw.Ziti.launcher.action.MoveMother;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
    @BeforeEach
    //set up a game for 2 players
    public void setUp() throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Player> players = new ArrayList<>();
        for(int i = 0; i < 2; i ++){
            players.add(new Player("Giocatore"+ i));
        }
       // game = new Game(players); //creates a new game with 2 players
    }

    @ParameterizedTest
    @ValueSource(ints = {0,5,7,10})
    public void correctPosition(int pos) throws ActionException {
        Mother.motherInstance().setIsland(game.getIslands().get(pos));
        game.setAction(new MoveMother(game,4,true));
        game.doAction();
        assertEquals((pos + 4)%(game.getIslands().size()),game.getIslands().indexOf(Mother.motherInstance().getIsland()));
    }

    @Test
    public void InfluenceTest() throws ActionException {
        //for this test mother will move of 1 island
        Island start = Mother.motherInstance().getIsland();
        game.setAction(new MoveMother(game,1,true));
        Island destination = game.getNextIsland(start);

        destination.getStudents().clear();
        //adding 1 blue, 4 yellow and 6 red
        for(int i = 0; i < 4; i++){
            destination.addStudent(new Student(Colour.YELLOW));
            destination.addStudent(new Student(Colour.RED));
            destination.addStudent(new Student(Colour.RED));
        }
        destination.addStudent(new Student(Colour.RED));
        destination.addStudent(new Student(Colour.RED));
        destination.addStudent(new Student(Colour.BLUE));

        //player 1 will own blue and yellow professor, player2 the red professor
        Player p1 = game.getPlayers().get(0);
        Player p2 = game.getPlayers().get(1);
        p1.getBoard().addProfessor(game.getProfessorbyColour(Colour.BLUE));
        p1.getBoard().addProfessor(game.getProfessorbyColour(Colour.YELLOW));
        p2.getBoard().addProfessor(game.getProfessorbyColour(Colour.RED));

        game.doAction();
        assertEquals(p2,destination.getTowerPlayer());
    }

    @Test
    public void InfluenceWithTowerTest() throws ActionException {
        //for this test mother will move of 1 island
        Island start = Mother.motherInstance().getIsland();
        game.setAction(new MoveMother(game,1,true));
        Island destination = game.getNextIsland(start);

        destination.getStudents().clear();
        //adding 1 blue, 4 yellow and 6 red
        for(int i = 0; i < 4; i++){
            destination.addStudent(new Student(Colour.YELLOW));
            destination.addStudent(new Student(Colour.RED));
        }
        destination.addStudent(new Student(Colour.RED));
        destination.addStudent(new Student(Colour.RED));
        destination.addStudent(new Student(Colour.BLUE));



        //player 1 will own blue and yellow professor, player2 the red professor
        Player p1 = game.getPlayers().get(0);
        Player p2 = game.getPlayers().get(1);
        p1.getBoard().addProfessor(game.getProfessorbyColour(Colour.BLUE));
        p1.getBoard().addProfessor(game.getProfessorbyColour(Colour.YELLOW));
        p2.getBoard().addProfessor(game.getProfessorbyColour(Colour.RED));

        //adding p1 tower
        destination.getTowers().clear();
        destination.getTowers().add(new Tower(p1,p1.getBoard().getTower_colour()));
        destination.setTowerPlayer(p1);

        game.doAction();
        assertEquals(p1,destination.getTowerPlayer());
    }

    @Test
    public void mergeTest() throws ActionException {
        //for this test mother will move of 1 island
        game.setAction(new MoveMother(game,1,true));
        Island start = Mother.motherInstance().getIsland();
        Island destination = game.getNextIsland(start);

        Player p1 = game.getPlayers().get(0);
        Player p2 = game.getPlayers().get(1);

        //p1 will control starting island
        start.getStudents().clear();
        start.getTowers().clear();
        start.setTowerPlayer(p1);
        start.getTowers().add(new Tower(p1,p1.getBoard().getTower_colour()));

        //p2 initially control destination island
        destination.getStudents().clear();
        destination.getTowers().clear();
        destination.setTowerPlayer(p2);
        destination.getTowers().add(new Tower(p2,p2.getBoard().getTower_colour()));

        //giving p1 red professor
        p1.getBoard().addProfessor(game.getProfessorbyColour(Colour.RED));
        //giving p2 blue professor
        p2.getBoard().addProfessor(game.getProfessorbyColour(Colour.BLUE));

        //adding to destination 4 red students and 2 blue students
        for(int i = 0; i<4; i++) {
            destination.addStudent(new Student(Colour.RED));}
        for(int i = 0; i<2; i++){
            destination.addStudent(new Student(Colour.BLUE));}

        Island newPrevious = game.getPrevIsland(start);
        int previousSize = game.getIslands().size();
        game.doAction();

        assert(Mother.motherInstance().getIsland().equals(destination));
        assert(destination.getTowerPlayer().equals(p1));
        assert(game.getPrevIsland(destination).equals(newPrevious));
        assert(destination.getTowerPlayer().equals(p1));
        assert(previousSize == game.getIslands().size()+1);

    }

}
