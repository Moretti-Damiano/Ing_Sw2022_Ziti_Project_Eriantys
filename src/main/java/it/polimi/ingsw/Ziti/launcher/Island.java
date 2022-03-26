package it.polimi.ingsw.Ziti.launcher;

import java.util.ArrayList;

public class Island {

    private int ID;
    private ArrayList<Integer> A;
    private ArrayList<Student> students;
    private ArrayList<Tower> towers;
    private Player TowerPlayer;
    private boolean isMother;

    public Island(int id){
        this.ID = id;
        this.students = new ArrayList<Student>();
        this.towers = new ArrayList<Tower>();
        this.isMother = false;
    }


    /**
     * return number of colour_students
     */
    public int getColor(Colour c){
        int i = 0;
        for(Student s: students){
            if(s.getColour().equals(c))
                i++;
        }
        return i;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Tower> getTowers() {
        return towers;
    }

    public boolean getMother(){
        return isMother;
    }


    /**
     * Changes isMother value to his opposite
     */
    public void setMother(){
        isMother = !isMother;
    }

    /**
     *Removes old players towers and put them back to his board
     *Adds the same number of removed Tower from the new players board
     * @param player is the new island owner
     */
    public void UpdateTower(Player player){
        if(TowerPlayer != player){
            for(Tower T : towers){
                TowerPlayer.getBoard().addTower(T);
            }

            int size = towers.size();
            towers.clear();
            TowerPlayer = player;

            for(int i=0; i<size; i++){
                towers.add(player.getBoard().removeTower());
            }
        }
    }

    /**
     * merge all the param island attributes with this island
     * @param island referes to the near island to merge with.
     *               will be removed from the game by Game Controller
     */
    public void merge(Island island){
        //no changes to island id,towerplayer
        this.students.addAll(island.getStudents());
        this.towers.addAll(island.getTowers());
        this.isMother = true;
    }
}

