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

    protected Character5(Game game) {
        super(game);
        setCost(3);
        setUsePhase(PhaseType.MOTHER);
    }


    public void choose() {

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
    }
}
