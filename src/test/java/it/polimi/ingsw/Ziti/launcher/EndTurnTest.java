package it.polimi.ingsw.Ziti.launcher;

import it.polimi.ingsw.Ziti.launcher.action.EndTurn;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.*;
import it.polimi.ingsw.Ziti.launcher.model.Game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import static org.junit.jupiter.api.Assertions.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class EndTurnTest {
    private Game game;

    // setUp create a game for 2 player
    @Test
    @BeforeEach
    public void setUp() throws IOException, ParserConfigurationException, SAXException {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Player" + 1));
        players.add(new Player("Player" + 2));

        //game = new Game(players);

    }
    // Player0 has used assistant 0 : checking if it's chosen and if others are not actual and not chosen
    @Test
    public  void EndTurnTestSingle() throws ActionException {
        Player p0 = game.getPlayers().get(0);
        // p0 chooses assistant 0
        p0.setAssChoosed(p0.getAssistants().get(0));
        p0.getAssistants().get(0).setAssChose(true);


        game.setAction(new EndTurn(game));
        game.doAction();

        // checking if the assistant chosen is really the one who's been chosen
        assertEquals(p0.getAssChosen(), p0.getAssistants().get(0));
        // checking if the assistant chosen is actual
        assertFalse(p0.getAssistants().get(0).isActual());
        // checking if the assistant chosen has been used
        assertTrue(p0.getAssistants().get(0).isAssChose());
        // checking if the others are not actual and not chosen
        for (int i = 1; i < p0.getAssistants().size(); i++) {
            assertFalse(p0.getAssistants().get(i).isActual());
            assertFalse(p0.getAssistants().get(i).isAssChose());
        }
    }
        // Player0 used assistants 2 and 3
        // Player1 used assistants 5 and 9
        @Test
        public  void EndTurnTestDouble() throws ActionException{
            Player p0 = game.getPlayers().get(0);
            Player p1 = game.getPlayers().get(1);
            // p0 chooses assistant 0
            p0.setAssChoosed(p0.getAssistants().get(2));
            p0.getAssistants().get(2).setAssChose(true);
            p0.getAssistants().get(3).setAssChose(true);
            p1.setAssChoosed(p1.getAssistants().get(5));
            p1.getAssistants().get(5).setAssChose(true);
            p1.getAssistants().get(9).setAssChose(true);

            game.setAction( new EndTurn(game));
            game.doAction();

            // checking if the assistant chosen is really the one who's been chosen
            assertEquals(p0.getAssChosen(),p0.getAssistants().get(2));
            assertEquals(p1.getAssChosen(),p1.getAssistants().get(5));
            // checking if the assistant chosen is actual
            assertFalse(p0.getAssistants().get(2).isActual());
            assertFalse(p1.getAssistants().get(5).isActual());
            // checking if the assistant chosen has been used
            assertTrue(p0.getAssistants().get(2).isAssChose());
            assertTrue(p0.getAssistants().get(3).isAssChose());
            assertTrue(p1.getAssistants().get(5).isAssChose());
            assertTrue(p1.getAssistants().get(9).isAssChose());

    }


}
