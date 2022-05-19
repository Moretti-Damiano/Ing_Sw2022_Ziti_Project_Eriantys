package it.polimi.ingsw.Ziti.launcher;

import it.polimi.ingsw.Ziti.launcher.action.MoveToIsland;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.*;
import it.polimi.ingsw.Ziti.launcher.model.Game.Game;
import it.polimi.ingsw.Ziti.launcher.model.Game.Game2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is used to test three scenarios:
 *      if there are no colours in the waiting room the action fails
 *      if there's not the chosen colour in the waiting room the action fails
 *      verify that the action is correctly done
 */
public class MoveToIslandTest {
    private Game game;

    // setUp create a game for 2 player
    @Test
    @BeforeEach
    public void setUp() throws IOException, ParserConfigurationException, SAXException {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Player" + 1));
        players.add(new Player("Player" + 2));

        game = new Game2(players);
        game.setActivePlayer(game.getPlayers().get(0));
    }

    //test a normal MoveToIsland action
    @Test
    public void MoveToIslandTest() throws ActionException{

        Student blueStudent = new Student(Colour.BLUE);
        Student greenStudent = new Student(Colour.GREEN);
        Student pinkStudent = new Student(Colour.PINK);
        Student redStudent = new Student(Colour.RED);
        Student yellowStudent = new Student(Colour.YELLOW);

        Player p0 = game.getPlayers().get(0);
        // the player now has 5 students: one for each colour
        p0.getBoard().addStudent(new Student(Colour.RED));
        p0.getBoard().addStudent(new Student(Colour.BLUE));
        p0.getBoard().addStudent(new Student(Colour.YELLOW));
        p0.getBoard().addStudent(new Student(Colour.GREEN));
        p0.getBoard().addStudent(new Student(Colour.PINK));

        int oldsize = p0.getBoard().getStudents_waiting().size();
        game.getIslands().get(1).getStudents().clear();
        game.setAction( new MoveToIsland(game, game.getIslands().get(1).getID(), Colour.BLUE.getName()));
        game.doAction();

        // verify colours in the chosen Island
        assertEquals(1,game.getIslands().get(1).getColour(Colour.BLUE ));
        assertEquals(0,game.getIslands().get(1).getColour(Colour.GREEN));
        assertEquals(0,game.getIslands().get(1).getColour(Colour.PINK));
        assertEquals(0,game.getIslands().get(1).getColour(Colour.RED));
        assertEquals(0,game.getIslands().get(1).getColour(Colour.YELLOW));
        // verify colours in the board
        assertFalse(p0.getBoard().checkpresence(blueStudent.getColour()));
        assertTrue(p0.getBoard().checkpresence(greenStudent.getColour()));
        assertTrue(p0.getBoard().checkpresence(pinkStudent.getColour()));
        assertTrue(p0.getBoard().checkpresence(redStudent.getColour()));
        assertTrue(p0.getBoard().checkpresence(yellowStudent.getColour()));
        // verify that the number of students waiting after the action is correct
        assertEquals(oldsize,p0.getBoard().getStudents_waiting().size());

    }

    // test if there isn't the chosenColour
    @Test
    public void NoColour() throws ActionException{
        Player p0 = game.getPlayers().get(0);
        p0.getBoard().getStudents_waiting().clear();
        // the player now has 5 students: 1 blue, 1 green, 1 red, 0 pink, 2 yellow
        p0.getBoard().addStudent(new Student(Colour.RED));
        p0.getBoard().addStudent(new Student(Colour.BLUE));
        p0.getBoard().addStudent(new Student(Colour.BLUE));
        p0.getBoard().addStudent(new Student(Colour.YELLOW));
        p0.getBoard().addStudent(new Student(Colour.YELLOW));
        p0.getBoard().addStudent(new Student(Colour.GREEN));
        p0.getBoard().addStudent(new Student(Colour.PINK));

        game.getIslands().get(0).getStudents().clear();
        game.setAction( new MoveToIsland(game, game.getIslands().get(0).getID(), Colour.PINK.getName()));
        game.doAction();

        // verify colours in the chosen Island
        assertEquals(1, game.getIslands().get(0).getStudents().size());
        // verify colours in the board
        assertFalse(p0.getBoard().checkpresence(Colour.PINK));
        assertTrue(p0.getBoard().checkpresence(Colour.GREEN));
        assertEquals(2,p0.getBoard().countStudentColor(Colour.BLUE));
        assertTrue(p0.getBoard().checkpresence(Colour.RED));
        assertEquals(2,p0.getBoard().countStudentColor(Colour.YELLOW));

    }

    // test the action if waiting_student is empty
    @Test
    public void EmptyWaitingRoom() throws ActionException{

        Player p0 = game.getPlayers().get(0);
        p0.getBoard().getStudents_waiting().clear();

        Student blueStudent = new Student(Colour.BLUE);
        Student greenStudent = new Student(Colour.GREEN);
        Student redStudent = new Student(Colour.RED);
        Student yellowStudent = new Student(Colour.YELLOW);
        Student pinkStudent = new Student(Colour.PINK);

        p0.getBoard().getStudents_waiting().add(new Student(Colour.BLUE));

        game.getIslands().get(2).getStudents().clear();
        game.setAction( new MoveToIsland(game, game.getIslands().get(2).getID(), "BLUE"));
        game.doAction();

        // verify colours is in the chosen Island
        assertEquals(1, game.getIslands().get(2).getStudents().size());
        // verify colours in the board
        assertTrue(p0.getBoard().getStudents_waiting().isEmpty());
    }


}

