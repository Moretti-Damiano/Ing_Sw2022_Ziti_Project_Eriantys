package it.polimi.ingsw.Ziti.launcher;

import it.polimi.ingsw.Ziti.launcher.action.ChooseAssistant;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.Game;
import it.polimi.ingsw.Ziti.launcher.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import static org.junit.jupiter.api.Assertions.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class ChooseAssistantTest {
    private static Game game;

    @Test
    @BeforeEach
    //set up a game for 2 players
    public void setUp() throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Player> players = new ArrayList<>();
        for(int i = 0; i < 3; i ++){
            players.add(new Player("Player"+ i));
        }
        game = new Game(players); //creates a new game with 3 players
    }
    @Test
    public void assistantUsed () throws ActionException {
        game.getPlayers().get(0).getAssistants().get(0).setActual(true);
        game.getPlayers().get(0).setAssChoosed(game.getPlayers().get(0).getAssistants().get(0));

        game.getPlayers().get(0).getAssistants().get(0).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(1).setAssChoosed(game.getPlayers().get(1).getAssistants().get(2));
        game.getPlayers().get(1).getAssistants().get(2).setActual(true);
        game.getPlayers().get(1).getAssistants().get(0).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(0).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(2).setAssChose(true);

        Player p3=game.getPlayers().get(2);
        int assID=5;

        game.setAction(new ChooseAssistant(game,p3,assID));
        game.doAction();

        assert(p3.getAssistants().get(5).isActual());
        assert(p3.getAssistants().get(5).isAssChose());
        assertEquals(p3.getAssChosen(),p3.getAssistants().get(assID));


    }
    @Test
    public void assistantUsed2 () throws ActionException {
        game.getPlayers().get(0).getAssistants().get(0).setActual(true);
        game.getPlayers().get(0).setAssChoosed(game.getPlayers().get(0).getAssistants().get(0));

        game.getPlayers().get(0).getAssistants().get(0).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(1).setAssChoosed(game.getPlayers().get(1).getAssistants().get(2));
        game.getPlayers().get(1).getAssistants().get(2).setActual(true);
        game.getPlayers().get(1).getAssistants().get(0).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(0).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(2).setAssChose(true);

        Player p3=game.getPlayers().get(2);

        int assID1= 2;

        game.setAction(new ChooseAssistant(game,p3,assID1));
        game.doAction();

        assertFalse(p3.getAssistants().get(2).isActual());
        assert(p3.getAssistants().get(2).isAssChose());
        assertNull(p3.getAssChosen());

    }

    @Test
    public void assistantTaken () throws ActionException {
        game.getPlayers().get(0).getAssistants().get(0).setActual(true);
        game.getPlayers().get(0).setAssChoosed(game.getPlayers().get(0).getAssistants().get(0));

        game.getPlayers().get(0).getAssistants().get(0).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(1).setAssChoosed(game.getPlayers().get(1).getAssistants().get(2));
        game.getPlayers().get(1).getAssistants().get(2).setActual(true);
        game.getPlayers().get(1).getAssistants().get(0).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(0).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(2).setAssChose(true);

        Player p3=game.getPlayers().get(2);
        int assID= 0;

        game.setAction(new ChooseAssistant(game,p3,assID));
        game.doAction();

        assertFalse(p3.getAssistants().get(0).isActual());
        assertNull(p3.getAssChosen());

        int assID1= 1;

        game.setAction(new ChooseAssistant(game,p3,assID1));
        game.doAction();

        assertFalse(p3.getAssistants().get(1).isActual());
        assertNull(p3.getAssChosen());

    }


}
