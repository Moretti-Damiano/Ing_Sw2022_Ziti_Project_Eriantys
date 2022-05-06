package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.Game;

public class Character2 extends Character{

    protected Character2(Game game) {
        super(game);
    }

    @Override
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
