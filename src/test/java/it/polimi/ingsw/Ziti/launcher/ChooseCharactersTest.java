package it.polimi.ingsw.Ziti.launcher;
import it.polimi.ingsw.Ziti.launcher.action.*;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.exception.CharacterException;
import it.polimi.ingsw.Ziti.launcher.model.*;
import it.polimi.ingsw.Ziti.launcher.model.Characters.*;
import it.polimi.ingsw.Ziti.launcher.model.Game.Game;
import it.polimi.ingsw.Ziti.launcher.model.Game.Game2;
import it.polimi.ingsw.Ziti.launcher.model.GameMode.ExpertMode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ChooseCharactersTest {
    private Game game;
    Player player1;
    Player activeplayer;

    @Test
    @BeforeEach
    public void setUp() throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Player> players = new ArrayList<>();
        for(int i = 0; i < 2; i ++){
            players.add(new Player("Giocatore"+ i));
        }
        game = new Game2(players);//creates a new game with 2 players
        game.setGameMode(new ExpertMode(game));
        game.getGameMode().startmode();
        game.setActivePlayer(players.get(0));
        for(Player p : game.getPlayers()){
            for(int i=0;i<15;i++) {
                p.getBoard().getWallet().add(new Coin());
            }
            for(Colour c : Colour.values()){
                p.getBoard().addStudent(new Student(c));
                p.getBoard().addStudent(new Student(c));
             }
        }
        player1=game.getPlayers().get(1);
        activeplayer= game.getPlayers().get(0);
    }

    @Test
    public void testCharacter0() throws ActionException {
        player1.getBoard().addStudenttoColourRow(new Student(Colour.PINK));
        player1.getBoard().addStudenttoColourRow(new Student(Colour.BLUE));
       for(int i=0;i<4;i++) {
           player1.getBoard().addStudenttoColourRow(new Student(Colour.RED));
       }
        player1.getBoard().addProfessor(game.getProfessorbyColour(Colour.PINK));
        player1.getBoard().addProfessor(game.getProfessorbyColour(Colour.BLUE));
        player1.getBoard().addProfessor(game.getProfessorbyColour(Colour.RED));
        Character0 character=new Character0();
        character.setGame(game);
        game.setAction(new MoveToTable(game,"BLUE"));
        game.doAction();
        game.setAction(new MoveToTable(game,"PINK"));
        game.doAction();
        game.setAction(new MoveToTable(game,"RED"));
        game.doAction();
        character.startEffect();
        assertTrue(character.isUsed());
        character.endEffect();
        assertTrue(activeplayer.getBoard().hasProfessor(Colour.BLUE));
        assertTrue(activeplayer.getBoard().hasProfessor(Colour.PINK));
        assertFalse(activeplayer.getBoard().hasProfessor(Colour.RED));
        assertEquals(1,activeplayer.getBoard().getColorRowSize(Colour.BLUE));
        assertEquals(1,activeplayer.getBoard().getColorRowSize(Colour.PINK));
    }

    @Test
    public void testCharacter1() throws ActionException, CharacterException {
        activeplayer.getBoard().addProfessor(game.getProfessorbyColour(Colour.BLUE));
        game.setAction(new MoveToIsland(game,0,"BLUE"));
        game.doAction();
        Character1 character =new Character1();
        character.setGame(game);
        character.choose(0);
        character.startEffect();
        assertTrue(character.isUsed());
        character.endEffect();
        assertEquals(activeplayer,game.getIslands().get(0).getTowerPlayer());
        assertEquals(1,game.getIslands().get(0).getTowers().size());
        activeplayer.getBoard().addProfessor(game.getProfessorbyColour(Colour.YELLOW));
        game.setAction(new MoveToIsland(game,4,"YELLOW"));
        game.doAction();
        game.setAction(new MoveToIsland(game,5,"YELLOW"));
        game.doAction();
        character.choose(4);
        character.startEffect();
        character.endEffect();
        character.choose(5);
        character.startEffect();
        character.endEffect();
        assertEquals(2,game.getIslands().get(4).getTowers().size());
        assertEquals(activeplayer,game.getIslands().get(4).getTowerPlayer());

    }

    @Test
    public void testCharacter2() throws ActionException {
     game.setAction(new ChooseAssistant(game,activeplayer,0));
     game.doAction();
        Character2 character = new Character2();
        character.setGame(game);
        character.startEffect();
        assertTrue(character.isUsed());
        assertEquals(3,activeplayer.getAssChosen().getMovesMother());
        character.endEffect();
        assertEquals(1,activeplayer.getAssChosen().getMovesMother());
        game.setActivePlayer(player1);
        game.setAction(new ChooseAssistant(game,player1,9));
        game.doAction();
        character.startEffect();
        assertEquals(7,player1.getAssChosen().getMovesMother());
        character.endEffect();
        assertEquals(5,player1.getAssChosen().getMovesMother());
    }

    @Test
    public void testCharacter3() throws ActionException, CharacterException {
        for(Island s: game.getIslands()){
            if(s.getMother()){
                s.removeMother();
            }
        }
        game.getMother().setIsland(game.getIslandbyId(5));
        game.getIslands().get(5).addMother();
        activeplayer.getBoard().addProfessor(game.getProfessorbyColour(Colour.BLUE));
        game.setAction(new MoveToIsland(game,6,"BLUE"));
        game.doAction();
        game.setAction(new MoveToIsland(game,6,"BLUE"));
        game.doAction();
        Character1 character1 =new Character1();  //adds a tower on island 0
        character1.setGame(game);
        character1.choose(6);
        character1.startEffect();
        character1.endEffect();
        assertEquals(1,game.getIslands().get(6).getTowers().size());
        assertEquals(activeplayer,game.getIslands().get(6).getTowerPlayer());
       game.setActivePlayer(player1);
       game.setAction(new MoveToTable(game,"BLUE"));
       game.doAction();
       game.setAction(new MoveToTable(game,"BLUE"));
       game.doAction();
       game.setAction(new ChooseAssistant(game,player1,5));
       game.doAction();
       assertFalse(activeplayer.getBoard().hasProfessor(Colour.BLUE));
        assertTrue(player1.getBoard().hasProfessor(Colour.BLUE));
       Character3 character = new Character3();
       character.setGame(game);
       character.startEffect();
        assertNull(game.getIslands().get(6).getTowerPlayer());
       assertEquals(0,game.getIslands().get(6).getTowers().size());
       game.setAction(new MoveMother(game,1,true));
       game.doAction();
        character.endEffect();
       assertEquals(player1,game.getIslands().get(6).getTowerPlayer());
    }
    @Test
    public void Character4() throws CharacterException {
        for (int i = 0; i < 5; i++) {
            activeplayer.getBoard().addStudenttoColourRow(new Student(Colour.GREEN));
            player1.getBoard().addStudenttoColourRow(new Student(Colour.BLUE));
        }
        for(int i=0;i<2;i++){
            activeplayer.getBoard().addStudenttoColourRow(new Student(Colour.BLUE));
            player1.getBoard().addStudenttoColourRow(new Student(Colour.GREEN));
        }
        activeplayer.getBoard().addProfessor(game.getProfessorbyColour(Colour.GREEN));
        player1.getBoard().addProfessor(game.getProfessorbyColour(Colour.BLUE));
        Character4 character = new Character4();
        character.setGame(game);
        character.choose("GREEN");
        character.startEffect();
        character.endEffect();
        assertEquals(2,activeplayer.getBoard().getColorRowSize(Colour.GREEN));
        assertEquals(0,player1.getBoard().getColorRowSize(Colour.GREEN));
        assertTrue(activeplayer.getBoard().hasProfessor(Colour.GREEN));
        character.choose("BLUE");
        character.startEffect();
        character.endEffect();
        assertEquals(0,activeplayer.getBoard().getColorRowSize(Colour.BLUE));
        assertEquals(2,player1.getBoard().getColorRowSize(Colour.BLUE));
        assertTrue(player1.getBoard().hasProfessor(Colour.BLUE));
    }
    @Test
    public void Character5() throws ActionException, CharacterException {
        for(Island s: game.getIslands()){
            if(s.getMother()){
                s.removeMother();
            }
        }
        game.getMother().setIsland(game.getIslandbyId(7));
        game.getIslands().get(7).addMother();
        player1.getBoard().addProfessor(game.getProfessorbyColour(Colour.PINK));
        game.setAction(new MoveToIsland(game,8,"PINK"));
        game.doAction();
        assertNull(game.getIslands().get(8).getTowerPlayer());
        activeplayer.getBoard().addProfessor(game.getProfessorbyColour(Colour.YELLOW));
        game.setAction(new MoveToIsland(game,8,"YELLOW"));
        game.doAction();
        Character5 character = new Character5();
        character.setGame(game);
        character.choose("PINK");
        character.startEffect();
        game.setAction(new MoveMother(game,1,false));
        game.doAction();
        assertEquals(activeplayer,game.getIslands().get(8).getTowerPlayer());
        character.endEffect();
    }


}
