package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.Game;

/*You may move Mother Nature up to 2 additional islands than is indicated by the Assistant card you've played.*/
public class Character2 extends Character{
    private static Character2 instance;

    public static Character2 getInstance(){
        if (instance == null) instance = new Character2();
        return instance;
    }

    public Character2() {
        setId(2);
        setCost(1);
        setDescription(" You may move Mother Nature up to 2 additional islands than is indicated by the Assistant card you've played ");
        setUsePhase(PhaseType.MOTHER);
        setAvailable(true);
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
        setAvailable(true);
        increaseCost();
    }
}
