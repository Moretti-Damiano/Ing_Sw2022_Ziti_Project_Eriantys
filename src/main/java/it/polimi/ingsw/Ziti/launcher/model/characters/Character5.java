package it.polimi.ingsw.Ziti.launcher.model.characters;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.CharacterException;
import it.polimi.ingsw.Ziti.launcher.model.Player;
import it.polimi.ingsw.Ziti.launcher.model.Professor;

/*
Choose a colour of student: during the influence calculation this turn,that color adds no influence
 */

public class Character5 extends Character{

    private Colour colour;
    private Player profPlayer;
    private Professor professor;

    public Character5() {
        super();
        setId(5);
        setCost(3);
        setDescription("Choose a colour of student: during the influence calculation this turn,that color adds no influence");
        getUsePhase().add(PhaseType.MOTHER);
        setAvailable(true);
        setEndPhase(PhaseType.CLOUD);
    }

    /**
     * this method is used to set the colour for the character's effect
     * @param colour the chosen colour
     * @throws CharacterException if the colour is not valid
     */
    public void choose(String colour) throws CharacterException {
    checkInput(colour);
    this.colour=Colour.valueOfName(colour);
    }

    @Override
    public void startEffect()  {
        setUsed(true);
        profPlayer = getGame().checkProfessor(colour);
        if(profPlayer != null)
            professor = profPlayer.getBoard().removeProfessorByColour(colour);
    }

    @Override
    public void endEffect() {
        if(profPlayer!=null)
            profPlayer.getBoard().addProfessor(professor);

        setAvailable(true);
        setUsed(false);
    }

    private void checkInput(String colour) throws CharacterException{
        if(!Colour.checkStringToColour(colour)){
            throw new CharacterException();
        }
    }
}
