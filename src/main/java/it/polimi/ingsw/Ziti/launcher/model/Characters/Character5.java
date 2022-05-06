package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.Game;
import it.polimi.ingsw.Ziti.launcher.model.Player;
import it.polimi.ingsw.Ziti.launcher.model.Professor;

/*
Scegli un colore di Studente;in questo turno,durante il calcolo dell'influenza quel colore non fornisce influenza
 */

public class Character5 extends Character{

    private Colour colour;
    private Player profPlayer;
    private Professor professor;

    public Character5(Game game) {
        super(game);
        setCost(3);
        setUsePhase(PhaseType.MOTHER);
        setAvailable(true);
    }


    public void choose(String colour) throws ActionException {
    checkInput(colour);
    setAvailable(false);
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

    private void checkInput(String colour) throws ActionException{
        if(!Colour.checkStringToColour(colour)){
            throw new ActionException();
        }
    }
}
