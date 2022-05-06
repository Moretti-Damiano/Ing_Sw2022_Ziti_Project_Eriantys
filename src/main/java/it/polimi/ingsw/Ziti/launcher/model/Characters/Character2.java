package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.Game;

/*Puoi muovere Madre Natura fino a 2 Isole addizionali rispetto a quanto indicato sulla carta Assistente che hai giocato.*/
public class Character2 extends Character{

    protected Character2(Game game) {
        super(game);
        setCost(1);
        setUsePhase(PhaseType.MOTHER);
    }


    public void choose() {

    }

    @Override
    public void startEffect(){
        getGame().getCurrentPlayer().getAssChosen().addMoves(2);
    }

    @Override
    public void endEffect() {
        getGame().getCurrentPlayer().getAssChosen().reduceMoves(2);
    }
}
