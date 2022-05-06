package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.action.MoveMother;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.Game;
import it.polimi.ingsw.Ziti.launcher.model.Island;
import it.polimi.ingsw.Ziti.launcher.model.Mother;
import it.polimi.ingsw.Ziti.launcher.model.Tower;

import java.util.ArrayList;

/*
Durante il conteggio dell'influenza le torri non vengono calcolate
 */
public class Character3 extends Character{

    private ArrayList<Island> originalIslands;

    protected Character3(Game game) {
        super(game);
        setCost(3);
    }

    public void choose() {

    }

    @Override
    public void startEffect(){
        originalIslands = new ArrayList<>(getGame().getIslands());
        for(Island island: getGame().getIslands()){
            if(island.getTowerPlayer()!=null){
                island.getTowers().clear();
                island.setTowerPlayer(null);
            }
        }
    }

    @Override
    public void endEffect() {
        Mother mother = Mother.motherInstance();

        for(int i =0; i< originalIslands.size();i++){
            if(getGame().getIslands().get(i)!= mother.getIsland()){
                //set oll towerPlayer
                getGame().getIslands().get(i).setTowerPlayer(originalIslands.get(i).getTowerPlayer());
                //add old towers
                for(Tower tower: originalIslands.get(i).getTowers()){
                    getGame().getIslands().get(i).getTowers().add(tower);
                }
            }
            else{
                //checks if the island near mother needs to be merged
                MoveMother moveMother = new MoveMother(getGame(),0);
                if (moveMother.checkMerge(mother.getIsland(), getGame().getNextIsland(mother.getIsland()))) {
                    moveMother.merge(mother.getIsland(), getGame().getNextIsland(mother.getIsland()));
                }
                if (moveMother.checkMerge(mother.getIsland(), getGame().getPrevIsland(mother.getIsland()))) {
                    moveMother.merge(mother.getIsland(), getGame().getPrevIsland(mother.getIsland()));
                }
            }
        }
    }

}
