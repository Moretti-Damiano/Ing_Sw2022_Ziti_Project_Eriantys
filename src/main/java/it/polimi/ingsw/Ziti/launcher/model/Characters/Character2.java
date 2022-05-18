package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;

/*You may move Mother Nature up to 2 additional islands than is indicated by the Assistant card you've played.*/
public class Character2 extends Character{

    public Character2() {
        super();
        setId(2);
        setCost(1);
        setDescription(" You may move Mother Nature up to 2 additional islands than is indicated by the Assistant card you've played ");
        getUsePhase().add(PhaseType.MOVEMENT);
        getUsePhase().add(PhaseType.MOTHER);
        setAvailable(true);
        setEndPhase(PhaseType.CLOUD);
    }



    public void choose() {
    }

    @Override
    public void startEffect(){
        setUsed(true);
        getGame().getCurrentPlayer().getAssChosen().addMoves(2);
    }

    @Override
    public void endEffect() {
        getGame().getCurrentPlayer().getAssChosen().reduceMoves(2);
        setAvailable(true);
        setUsed(false);
    }
}
