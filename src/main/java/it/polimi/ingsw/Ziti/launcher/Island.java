package it.polimi.ingsw.Ziti.launcher;

import java.util.ArrayList;

public class Island {

    private int ID;
    private ArrayList<Integer> A;
    private ArrayList<Student> Students;
    private ArrayList<Tower> Towers;
    private Player TowerPlayer;
    private boolean isMother;

    public Island(int id){
        this.ID = id;
        this.Students = new ArrayList<Student>();
        this.Towers = new ArrayList<Tower>();
        this.isMother = false;
    }

    /**
     * return number of colour_students
     */
    public int getColor(Colour c){
        int i = 0;
        for(Student s: Students){
            if(s.Colour.equals(c))
                i++;
        }
        return i;
    }

    public boolean getMother(){
        return isMother;
    }


    /**
     * Changes isMother value to the opposite
     */
    public void setMother(){
        isMother = !isMother;
    }

    /**
     *Removes old players towers and put them back to his board
     *Adds the same number of removed Tower from the new players board
     */
    public void UpdateTower(Player player){
        if(TowerPlayer != player){
            for(Tower T : Towers){
                TowerPlayer.board.addTower(T);
            }

            int size = Towers.size();
            Towers.clear;
            TowerPlayer = player;

            for(int i=0; i<size; i++){
                Towers.add(player.board.removeTower());
            }
        }
    }

    /**
     *merge all the param island attributes with this island
     * param island will be removed by controller from island list
     */
    public void merge(Island island){
        //no changes to island id,towerplayer
        this.Students.addAll(island.Students);
        this.Towers.addAll(island.Towers);
        this.isMother = true;
    }
}

