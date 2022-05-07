package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.Game;

/*You may move Mother Nature up to 2 additional islands than is indicated by the Assistant card you've played.*/
public class Character2 extends Character{

    public Character2(Game game) {
        super(game);
        setCost(1);
        setDescription(" You may move Mother Nature up to 2 additional islands than is indicated by the Assistant card you've played ");
        setUsePhase(PhaseType.MOTHER);
        setAvailable(true);
    }


    public void choose() {
        setAvailable(false);
    }

    @Override
    public void startEffect(){
        getGame().getCurrentPlayer().getAssChosen().addMoves(2);
    }

    @Override
    public void endEffect() {
        getGame().getCurrentPlayer().getAssChosen().reduceMoves(2);
        setAvailable(true);
        increaseCost();
    }
}
