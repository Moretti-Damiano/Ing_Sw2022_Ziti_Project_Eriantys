package it.polimi.ingsw.Ziti.launcher.model.characters;

import it.polimi.ingsw.Ziti.launcher.action.MoveMother;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.exception.CharacterException;
import it.polimi.ingsw.Ziti.launcher.model.Island;


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

    /**
     * this method is used to set the chosen island used by the effect
     * @param islandId the id of the chosen island
     * @throws CharacterException if the parameter isn't valid
     */
    public void choose(int islandId) throws CharacterException {
        checkInput(islandId);
        this.islandId=islandId;

    }

    @Override
    public void startEffect() throws ActionException {
        setUsed(true);
        int moves;
        int islandPosition = getGame().getIslands().indexOf(getGame().getIslandbyId(islandId));
        motherIsland = getGame().getIslandbyId(getGame().getMother().getIsland().getID());
        motherIslandPosition = getGame().getIslands().indexOf(getGame().getMother().getIsland());

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

    /**
     * reset the position of the mother
     */
    private void endAction(){
        getGame().getMother().getIsland().removeMother();
        getGame().getMother().setIsland(motherIsland);
        getGame().getMother().getIsland().addMother();
    }


    private void checkInput(int islandId) throws CharacterException{
        if(!checkId(islandId)){
            throw new CharacterException();
        }
    }

    /**
     * check if the island id is valid
     * @param islandId the id of the island
     * @return true if the of the island is correct
     */
    private boolean checkId(int islandId){
        for(Island i: getGame().getIslands()){
            if(i.getID() == islandId){
                return true;
            }
        }
        return false;
    }
}
