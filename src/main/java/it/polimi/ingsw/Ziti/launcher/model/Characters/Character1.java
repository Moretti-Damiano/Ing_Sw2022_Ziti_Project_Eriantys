package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.action.MoveMother;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.Game;
import it.polimi.ingsw.Ziti.launcher.model.Island;
import it.polimi.ingsw.Ziti.launcher.model.Mother;

/*Scegli un'isola e calcola la maggioranza come se Madre Natura avesse terminato il suo movimento lì.
 In questo turno Madre Natura si muoverà come di consueto e nell'Isola dove terminarà il suo movimento la maggioranza verrà normalmente calcolata.*/

public class Character1 extends Character{

    private int islandId;
    private Island motherIsland;
    private int motherIslandPosition;

    protected Character1(Game game) {
        super(game);
        setCost(3);
        setUsePhase(PhaseType.MOTHER);
        setAvailable(true);
    }


    public void choose(int islandId) throws ActionException{
        checkInput();
        this.islandId=islandId;
        setAvailable(false);

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
        getGame().setAction(new MoveMother(getGame(),moves,true));
        getGame().doAction();
        endAction();
    }

    @Override
    public void endEffect() {
        increaseCost();
        setAvailable(true);
    }

    private void endAction(){
        Mother.motherInstance().getIsland().removeMother();
        Mother.motherInstance().setIsland(motherIsland);
        Mother.motherInstance().getIsland().addMother();
        Mother.motherInstance().getIsland().removeMother();
        Mother.motherInstance().setIsland(motherIsland);
        Mother.motherInstance().getIsland().addMother();

    }

    private void checkInput() throws ActionException{
        if(!checkId()){
            throw new ActionException();
        }
    }

    private boolean checkId(){
        for(Island i: getGame().getIslands()){
            if(i.getID() == islandId){
                return true;
            }
        }
        return false;
    }
}
