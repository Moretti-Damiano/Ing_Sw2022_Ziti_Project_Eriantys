package it.polimi.ingsw.Ziti.launcher;

import it.polimi.ingsw.Ziti.launcher.action.ChooseAssistant;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.game.Game;
import it.polimi.ingsw.Ziti.launcher.model.game.Game3;
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
        game = new Game3(players); //creates a new game with 3 players
        game.setActivePlayer(game.getPlayers().get(2));
    }

    /**
     * Normal game situation, check if a player can choose an assistant and verify that after this action the assistant is the actual assistant of the player and that is signed as used
     * @throws ActionException
     */
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

    /**
     * Normal game situation, a player tries to choose an assistant that another player is already using
     * @throws ActionException if the player can't do this action
     */
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

        try{
            game.setAction(new ChooseAssistant(game,p3,assID1));
            game.doAction();
        }catch(ActionException e) {

            assertFalse(p3.getAssistants().get(2).isActual());
            assert (p3.getAssistants().get(2).isAssChose());
            assertNull(p3.getAssChosen());
        }
    }

    /**
     * Particular case : in a match of 3 player, during the 8th round, the third player can only choose the same assistant that is arleady in use by one of the other two player
     * This happens only in the case that the third player has already used all the other assistants
     * In this case the player has another possible chose (He can choose the assistant with ID=5)
     * @throws ActionException if the player can't choose that assistant
     */
    @Test
    public void EighthRoundThreePlayerChooseNotAllowed() throws ActionException{
        game.getPlayers().get(0).getAssistants().get(0).setActual(true);
        game.getPlayers().get(0).setAssChoosed(game.getPlayers().get(0).getAssistants().get(0));
        //manca il 5 e il 9
        game.getPlayers().get(0).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(8).setAssChose(true);

        game.getPlayers().get(1).getAssistants().get(9).setActual(true);
        game.getPlayers().get(1).setAssChoosed(game.getPlayers().get(1).getAssistants().get(9));
        //manca lo 0 l'8
        game.getPlayers().get(1).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(5).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(7).setAssChose(true);

        game.getPlayers().get(2).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(8).setAssChose(true);

        Player p3=game.getCurrentPlayer();
        int assId=9;
        try{
            game.setAction(new ChooseAssistant(game,p3,assId));
            game.doAction();
        }catch (ActionException e){
            assertFalse(p3.getAssistants().get(assId).isActual());
            assertFalse(p3.getAssistants().get(assId).isAssChose());
        }
    }

    /**
     * Particular case : in a match of 3 player, during the 9th round, the third player can only choose the same assistant that is arleady in use by one of the other two player
     * This happens only in the case that the third player has already used all the other assistants
     * @throws ActionException if the player can't choose that assistant
     */
    @Test
    public void NinethRoundThreePlayerChooseAllowed() throws ActionException{
        game.getPlayers().get(0).getAssistants().get(0).setActual(true);
        game.getPlayers().get(0).setAssChoosed(game.getPlayers().get(0).getAssistants().get(0));
        //manca il 5
        game.getPlayers().get(0).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(8).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(9).setAssChose(true);

        game.getPlayers().get(1).getAssistants().get(9).setActual(true);
        game.getPlayers().get(1).setAssChoosed(game.getPlayers().get(1).getAssistants().get(9));
        //manca  l'8
        game.getPlayers().get(1).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(0).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(5).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(7).setAssChose(true);

        game.getPlayers().get(2).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(5).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(8).setAssChose(true);

        Player p3=game.getCurrentPlayer();
        int assId=9;
        game.setAction(new ChooseAssistant(game,p3,assId));
        game.doAction();
        assert(p3.getAssistants().get(assId).isActual());
        assert(p3.getAssistants().get(assId).isAssChose());

    }
    /**
     * Particular case : in a match of 3 player, during the 9th round, the third player can only choose the same assistant that is arleady in use by one of the other two player
     * This happens only in the case that the third player has already used all the other assistants
     * In this case the player has another possible chose (He can choose the assistant with ID=5)
     * @throws ActionException if the player can't choose that assistant
     */
    @Test
    public void NinethRoundThreePlayerChooseNotAllowed() throws ActionException{
        game.getPlayers().get(0).getAssistants().get(0).setActual(true);
        game.getPlayers().get(0).setAssChoosed(game.getPlayers().get(0).getAssistants().get(0));
        //manca il 5
        game.getPlayers().get(0).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(8).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(9).setAssChose(true);

        game.getPlayers().get(1).getAssistants().get(9).setActual(true);
        game.getPlayers().get(1).setAssChoosed(game.getPlayers().get(1).getAssistants().get(9));
        //manca lo 0
        game.getPlayers().get(1).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(5).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(8).setAssChose(true);

        game.getPlayers().get(2).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(0).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(8).setAssChose(true);

        Player p3=game.getCurrentPlayer();
        int assId=9;
        try{
            game.setAction(new ChooseAssistant(game,p3,assId));
            game.doAction();
        }catch (ActionException e){
            assertFalse(p3.getAssistants().get(assId).isActual());
            assertFalse(p3.getAssistants().get(assId).isAssChose());
        }
    }
    /**
     * Particular case : in a match of 3 player, during the 10th round, the third player can only choose the same assistant that is arleady in use by one of the other two player
     * This happens only in the case that the third player has already used all the other assistants
     * @throws ActionException if the player can't choose that assistant
     */
    @Test
    public void TenthRoundThreePlayerChooseAllowed() throws ActionException{
        game.getPlayers().get(0).getAssistants().get(0).setActual(true);
        game.getPlayers().get(0).setAssChoosed(game.getPlayers().get(0).getAssistants().get(0));
        game.getPlayers().get(0).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(8).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(9).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(5).setAssChose(true);

        game.getPlayers().get(1).getAssistants().get(9).setActual(true);
        game.getPlayers().get(1).setAssChoosed(game.getPlayers().get(1).getAssistants().get(9));
        game.getPlayers().get(1).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(0).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(5).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(8).setAssChose(true);

        game.getPlayers().get(2).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(5).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(8).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(0).setAssChose(true);

        Player p3=game.getCurrentPlayer();
        int assId=9;
        game.setAction(new ChooseAssistant(game,p3,assId));
        game.doAction();
        assert(p3.getAssistants().get(assId).isActual());
        assert(p3.getAssistants().get(assId).isAssChose());

    }
    /**
     * Particular case : in a match of 3 player, during the 9th round, the third player can only choose the same assistant that is arleady in use by one of the other two player
     * This happens only in the case that the third player has already used all the other assistants
     * In this case the player has another possible chose (He can choose the assistant with ID=5)
     * @throws ActionException if the player can't choose that assistant
     */
    @Test
    public void TenthRoundThreePlayerChooseNotAllowed() throws ActionException{
        game.getPlayers().get(0).getAssistants().get(0).setActual(true);
        game.getPlayers().get(0).setAssChoosed(game.getPlayers().get(0).getAssistants().get(0));
        game.getPlayers().get(0).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(8).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(9).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(5).setAssChose(true);

        game.getPlayers().get(1).getAssistants().get(9).setActual(true);
        game.getPlayers().get(1).setAssChoosed(game.getPlayers().get(1).getAssistants().get(9));
        game.getPlayers().get(1).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(5).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(8).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(0).setAssChose(true);

        game.getPlayers().get(2).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(0).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(8).setAssChose(true);
        game.getPlayers().get(2).getAssistants().get(9).setAssChose(true);

        Player p3=game.getCurrentPlayer();
        int assId=9;
        try{
            game.setAction(new ChooseAssistant(game,p3,assId));
            game.doAction();
        }catch (ActionException e){
            assertFalse(p3.getAssistants().get(assId).isActual());
            assert(p3.getAssistants().get(assId).isAssChose());
        }
    }

    /**
     * Normal case, a player tries to chose an assistant that as already chose
     * @throws ActionException if he can't do this action
     */
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
        try{
            game.setAction(new ChooseAssistant(game,p3,assID));
            game.doAction();
        }catch(ActionException e){
            assertFalse(p3.getAssistants().get(0).isActual());
            assertNull(p3.getAssChosen());
        }

        int assID1= 1;

        try{
            game.setAction(new ChooseAssistant(game,p3,assID));
            game.doAction();
        }catch(ActionException e){
        assertFalse(p3.getAssistants().get(1).isActual());
        assertNull(p3.getAssChosen());

    }}

    /**
     * Particular case : in a match of 2 player, during the 10th round, the third player can only choose the same assistant that is arleady in use by one of the other two player
     * This happens only in the case that the third player has already used all the other assistants
     * @throws ActionException if the player can't choose that assistant
     */
    @Test
    public void TenthRoundTwoPlayerChooseAllowed() throws ActionException{
        game.getPlayers().get(0).getAssistants().get(0).setActual(true);
        game.getPlayers().get(0).setAssChoosed(game.getPlayers().get(0).getAssistants().get(0));
        game.getPlayers().get(0).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(8).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(9).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(5).setAssChose(true);

        game.getPlayers().get(1).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(9).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(5).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(8).setAssChose(true);


        Player p3=game.getPlayers().get(1);
        int assId=0;
        game.setAction(new ChooseAssistant(game,p3,assId));
        game.doAction();
        assert(p3.getAssistants().get(assId).isActual());
        assert(p3.getAssistants().get(assId).isAssChose());

    }
    /**
     * Particular case : in a match of 3 player, during the 9th round, the third player can only choose the same assistant that is arleady in use by one of the other two player
     * This happens only in the case that the third player has already used all the other assistants
     * In this case the player has another possible chose (He can choose the assistant with ID=5)
     * @throws ActionException if the player can't choose that assistant
     */
    @Test
    public void TenthRoundTwoPlayerChooseNotAllowed() throws ActionException{
        game.getPlayers().get(0).getAssistants().get(0).setActual(true);
        game.getPlayers().get(0).setAssChoosed(game.getPlayers().get(0).getAssistants().get(0));
        game.getPlayers().get(0).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(8).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(9).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(5).setAssChose(true);

        game.getPlayers().get(1).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(5).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(8).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(0).setAssChose(true);


        Player p2=game.getPlayers().get(1);
        int assId=0;
        try{
            game.setAction(new ChooseAssistant(game,p2,assId));
            game.doAction();
        }catch (ActionException e){
            assertFalse(p2.getAssistants().get(assId).isActual());
            assert(p2.getAssistants().get(assId).isAssChose());
        }
    }


    /**
     * Particular case : in a match of 3 player, during the 9th round, the third player can only choose the same assistant that is arleady in use by one of the other two player
     * This happens only in the case that the third player has already used all the other assistants
     * In this case the player has another possible chose (He can choose the assistant with ID=5)
     * @throws ActionException if the player can't choose that assistant
     */
    @Test
    public void NinethRoundTwoPlayerChooseNotAllowed() throws ActionException{
        game.getPlayers().get(0).getAssistants().get(0).setActual(true);
        game.getPlayers().get(0).setAssChoosed(game.getPlayers().get(0).getAssistants().get(0));
        game.getPlayers().get(0).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(8).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(9).setAssChose(true);

        game.getPlayers().get(1).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(5).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(8).setAssChose(true);

        Player p2=game.getPlayers().get(1);
        int assId=0;
        try{
            game.setAction(new ChooseAssistant(game,p2,assId));
            game.doAction();
        }catch (ActionException e){
            assertFalse(p2.getAssistants().get(assId).isActual());
            assertFalse(p2.getAssistants().get(assId).isAssChose());
        }
    }


    /**
     * Particular case : in a match of 2 player, during the 8th round
     * In this case the player has another possible chose
     * @throws ActionException if the player can't choose that assistant
     */
    @Test
    public void EighthRoundTwoPlayerChooseNotAllowed() throws ActionException{
        game.getPlayers().get(0).getAssistants().get(0).setActual(true);
        game.getPlayers().get(0).setAssChoosed(game.getPlayers().get(0).getAssistants().get(0));
        game.getPlayers().get(0).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(7).setAssChose(true);
        game.getPlayers().get(0).getAssistants().get(8).setAssChose(true);

        game.getPlayers().get(1).getAssistants().get(1).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(2).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(3).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(4).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(5).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(6).setAssChose(true);
        game.getPlayers().get(1).getAssistants().get(7).setAssChose(true);

        Player p2=game.getPlayers().get(1);
        int assId=0;
        try{
            game.setAction(new ChooseAssistant(game,p2,assId));
            game.doAction();
        }catch (ActionException e){
            assertFalse(p2.getAssistants().get(assId).isActual());
            assertFalse(p2.getAssistants().get(assId).isAssChose());
        }
    }

}
