package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.action.MoveMother;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.exception.CharacterException;
import it.polimi.ingsw.Ziti.launcher.model.Game;
import it.polimi.ingsw.Ziti.launcher.model.Island;
import it.polimi.ingsw.Ziti.launcher.model.Mother;

/*Choose an island and resolve the island as if Mother Nature had ended her movement there.
Mother Nature will still move and the island where she ends her movement will also be resolved*/

public class Character1 extends Character{

    private int islandId;
    private Island motherIsland;
    private int motherIslandPosition;

    public Character1() {
        super();
        setId(1);
        setCost(3);
        setDescription(" Choose an island and resolve the island as if Mother Nature had ended her movement there." +
                " Mother Nature will still move and the island where she ends her movement will also be resolved ");
        getUsePhase().add(PhaseType.MOVEMENT);
        getUsePhase().add(PhaseType.MOTHER);
        setAvailable(true);
        setEndPhase(PhaseType.MOTHER);
    }


    public void choose(int islandId) throws CharacterException {
        checkInput(islandId);
        this.islandId=islandId;

    }

    @Override
    public void startEffect() throws ActionException {
        setUsed(true);
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

        getGame().setAction(new MoveMother(getGame(),moves,false));
        getGame().doAction();
        endAction();
    }

    @Override
    public void endEffect() {
        setAvailable(true);
        setUsed(false);
    }

    private void endAction(){
        Mother.motherInstance().getIsland().removeMother();
        Mother.motherInstance().setIsland(motherIsland);
        Mother.motherInstance().getIsland().addMother();
    }

    private void checkInput(int islandId) throws CharacterException{
        if(!checkId(islandId)){
            throw new CharacterException();
        }
    }

    private boolean checkId(int islandId){
        for(Island i: getGame().getIslands()){
            if(i.getID() == islandId){
                return true;
            }
        }
        return false;
    }
}
