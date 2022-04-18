package it.polimi.ingsw.Ziti.launcher;

import it.polimi.ingsw.Ziti.launcher.action.MoveToTable;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.model.Game;
import it.polimi.ingsw.Ziti.launcher.model.Player;
import it.polimi.ingsw.Ziti.launcher.model.Student;
import it.polimi.ingsw.Ziti.launcher.model.WalletController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

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
    public void moveToTableTest(){
        game.setAction(new MoveToTable(game,Colour.RED, new WalletController()));
   Player p0=game.getPlayers().get(0);
   Player p1=game.getPlayers().get(1);
   //game.setCurrentPlayer(p0)
        for(int i=0; i<6; i++){
         p0.getBoard().addStudenttoColourRow(new Student(Colour.RED));
         p0.getBoard().addStudenttoColourRow(new Student(Colour.PINK));
         p1.getBoard().addStudenttoColourRow(new Student(Colour.RED));
         p1.getBoard().addStudenttoColourRow(new Student(Colour.PINK));
        }
        p0.getBoard().addStudenttoColourRow(new Student(Colour.RED));


    }




}
