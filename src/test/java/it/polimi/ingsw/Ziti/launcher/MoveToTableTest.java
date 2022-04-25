package it.polimi.ingsw.Ziti.launcher;

import it.polimi.ingsw.Ziti.launcher.action.MoveToTable;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveToTableTest {
    private static Game game;


    @Test
    @BeforeEach
    public void setUp() throws ParserConfigurationException, IOException,org.xml.sax.SAXException {
        ArrayList<Player> players= new ArrayList<>();
        for(int i=0; i<2; i++){
            players.add(new Player("Giocatore"+ i));
        }
        game=new Game(players);
    }

    @Test
    public void moveToTableTest() throws ActionException {
        ArrayList<Colour>colors= new ArrayList<>();
        colors.add(Colour.BLUE);
        colors.add(Colour.RED);
        colors.add(Colour.GREEN);
        colors.add(Colour.PINK);
        colors.add(Colour.YELLOW);
   Player p0=game.getPlayers().get(0);
   Player p1=game.getPlayers().get(1);
   game.setActivePlayer(p0);
        //each player has 6 red and 6 pink student in his board
        for(int i=0; i<6; i++){
         p0.getBoard().addStudenttoColourRow(new Student(Colour.RED));
         p0.getBoard().addStudenttoColourRow(new Student(Colour.PINK));
         p1.getBoard().addStudenttoColourRow(new Student(Colour.RED));
         p1.getBoard().addStudenttoColourRow(new Student(Colour.PINK));
        }
        //each player has a student for each colour in his 'dining room'
       for(Colour c : colors){
           p0.getBoard().addStudent(new Student(c));
           p1.getBoard().addStudent(new Student(c));
       }
       p1.getBoard().addProfessor(game.getProfessorbyColour(Colour.RED));
        game.setAction(new MoveToTable(game,Colour.RED));
        game.doAction();
       assertTrue(p0.getBoard().hasProfessor(Colour.RED));
       assertFalse(p1.getBoard().hasProfessor(Colour.RED));
       assertEquals(7,p0.getBoard().getColorRowSize(Colour.RED));
       for(int i=0;i<2;i++){
           p0.getBoard().addStudenttoColourRow(new Student(Colour.BLUE));
       }
       game.setAction(new MoveToTable(game,Colour.BLUE));
       game.doAction();
       assertTrue(p0.getBoard().hasProfessor(Colour.BLUE));
       assertEquals(1,p0.getBoard().getNumberofCoin());
       assertEquals(3,p0.getBoard().getColorRowSize(Colour.BLUE));
       p1.getBoard().addStudenttoColourRow(new Student(Colour.PINK));
       p1.getBoard().addStudenttoColourRow(new Student(Colour.PINK));
       p1.getBoard().addProfessor(new Professor(Colour.PINK));
        game.setAction(new MoveToTable(game,Colour.PINK));
        game.doAction();
        assertFalse(p0.getBoard().hasProfessor(Colour.PINK));
        assertEquals(7,p0.getBoard().getColorRowSize(Colour.PINK));







    }




}
