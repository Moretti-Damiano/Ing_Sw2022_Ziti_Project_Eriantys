package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.exception.CharacterException;
import it.polimi.ingsw.Ziti.launcher.model.Game;
import it.polimi.ingsw.Ziti.launcher.model.Player;
import it.polimi.ingsw.Ziti.launcher.model.Professor;

/*
Choose a colour of student: during the influence calculation this turn,that color adds no influence
 */

public class Character5 extends Character{

    private Colour colour;
    private Player profPlayer;
    private Professor professor;

    private static Character5 instance;

    public static Character5 getInstance(){
        if (instance == null) instance = new Character5();
        return instance;
    }

    public Character5() {
        setId(5);
        setCost(3);
        setDescription("Choose a colour of student: during the influence calculation this turn,that color adds no influence");
        setUsePhase(PhaseType.MOTHER);
        setAvailable(true);
    }


    public void choose(String colour) throws CharacterException {
    checkInput(colour);
    this.colour=Colour.valueOfName(colour);

    }

    @Override
    public void startEffect()  {
        //tolgo il prof di quel colore
        Player profPlayer = getGame().checkProfessor(colour);
        if(profPlayer != null)
            professor = profPlayer.getBoard().removeProfessorByColour(colour);
    }

    @Override
    public void endEffect() {
        //rimetto il professore
        if(profPlayer!=null)
            profPlayer.getBoard().addProfessor(professor);
        setAvailable(true);
        increaseCost();
    }

    private void checkInput(String colour) throws CharacterException{
        if(!Colour.checkStringToColour(colour)){
            throw new CharacterException();
        }
    }
}
