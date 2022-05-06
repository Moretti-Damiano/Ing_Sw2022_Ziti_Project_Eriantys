package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.action.MoveMother;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.Game;
import it.polimi.ingsw.Ziti.launcher.model.Island;
import it.polimi.ingsw.Ziti.launcher.model.Mother;

public class Character1 extends Character{

    private int islandId;
    private Island motherIsland;
    private int motherIslandPosition;

    protected Character1(Game game) {
        super(game);
    }

    @Override
    public void choose() {

    }

    @Override
    public void startEffect() throws ActionException {
        int moves;
        int islandPosition = getGame().getIslands().indexOf(getGame().getIslandbyId(islandId));
        motherIsland = getGame().getIslandbyId(Mother.motherInstance().getIsland().getID());
        motherIslandPosition = getGame().getIslands().indexOf(Mother.motherInstance().getIsland());

        if(motherIslandPosition < islandPosition ){
            moves = islandPosition - motherIslandPosition;
        }
        else{
            moves = islandPosition + (getGame().getIslands().size() - motherIslandPosition);
        }
        getGame().setAction(new MoveMother(getGame(),moves));
        getGame().doAction();
    }

    @Override
    public void endEffect() {
        Mother.motherInstance().getIsland().removeMother();
        Mother.motherInstance().setIsland(motherIsland);
        Mother.motherInstance().getIsland().addMother();
    }
}
