package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.action.MoveMother;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.enumeration.TowerColour;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.*;

import java.util.ArrayList;

/*
When resolving a Conquering on an island, towers do not count towards influence
 */
public class Character3 extends Character{

    int[] numTowers;
    Player[] towerPlayers;

    public Character3() {
        super();
        setId(3);
        setCost(3);
        setDescription(" When resolving a Conquering on an island, towers do not count towards influence ");
        setAvailable(true);
        getUsePhase().add(PhaseType.MOVEMENT);
        getUsePhase().add(PhaseType.MOTHER);
        setEndPhase(PhaseType.CLOUD);

    }

    public void choose() {
    }

    @Override
    public void startEffect(){
        setUsed(true);

        numTowers = new int[getGame().getIslands().size()];
        towerPlayers = new Player[getGame().getIslands().size()];
        Island island;

        for(int i = 0; i < getGame().getIslands().size(); i++ ){
            //saves info
            island = getGame().getIslands().get(i);
            numTowers[i] = island.getTowers().size();
            towerPlayers[i] = island.getTowerPlayer();

            //reset towers and towerPlayer
            island.setTowerPlayer(null);
            island.getTowers().clear();
        }
    }

    @Override
    public void endEffect() {
        Mother mother = getGame().getMother();

        for(int i = 0; i < numTowers.length; i++){
            if(getGame().getIslands().get(i) != mother.getIsland()){
                //set old towerPlayer
                getGame().getIslands().get(i).setTowerPlayer(towerPlayers[i]);
                //add old towers
                if(towerPlayers[i] != null){
                    for(int j = 0; j < numTowers[i]; j++){
                        getGame().getIslands().get(i).getTowers().add(new Tower(towerPlayers[i],towerPlayers[i].getBoard().getTower_colour()));
                    }
                }
            }
            else{
                if(!getGame().getIslands().get(i).getTowerPlayer().equals(towerPlayers[i]) && towerPlayers[i]!=null){  //se il towerplayer è cambiato
                    for(int j = 0; j < numTowers[i]; j++){
                    towerPlayers[i].getBoard().addTower(new Tower(towerPlayers[i],towerPlayers[i].getBoard().getTower_colour()));
                    if(getGame().getIslands().get(i).getTowers().size() < numTowers[i])
                        getGame().getIslands().get(i).getTowers().add(getGame().getIslands().get(i).getTowerPlayer().getBoard().removeTower());
                    }
                }
                else if(getGame().getIslands().get(i).getTowerPlayer().equals(towerPlayers[i]) && towerPlayers[i]!=null){   //se ,lo stesso player ha "ricnoquistato l'isola
                    getGame().getIslands().get(i).getTowers().clear();
                    for(int j = 0; j < numTowers[i]; j++){  //resets old towers
                        getGame().getIslands().get(i).getTowers().add(new Tower(towerPlayers[i],towerPlayers[i].getBoard().getTower_colour()));
                    }
                }
            }
        }

        //checks if the island near mother needs to be merged
        MoveMother moveMother = new MoveMother(getGame(),0,false);
        if (moveMother.checkMerge(mother.getIsland(), getGame().getNextIsland(mother.getIsland()))) {
            moveMother.merge(mother.getIsland(), getGame().getNextIsland(mother.getIsland()));
        }
        if (moveMother.checkMerge(mother.getIsland(), getGame().getPrevIsland(mother.getIsland()))) {
            moveMother.merge(mother.getIsland(), getGame().getPrevIsland(mother.getIsland()));
        }

        setAvailable(true);
        setUsed(false);
    }
}
