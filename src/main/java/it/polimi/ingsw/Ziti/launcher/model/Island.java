package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;

import java.io.Serializable;
import java.util.ArrayList;

public class Island implements Serializable {

    private int ID;
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

    public int getID() {
        return ID;
    }

    /**
     *
     * @param c is the colour chosen
     * @return number of students of that colour
     */
    public int getColour(Colour c){
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

    public Player getTowerPlayer(){
        return TowerPlayer;
    }

    public boolean getMother(){
        return isMother;
    }



    public void addMother(){
        isMother = true;
    }

    public void removeMother() {isMother = false;}

    /**
     * add a student to the island
     * @param s student to add
     */
    public void addStudent(Student s){
        students.add(s);
    }

    public void setTowerPlayer(Player player){
        this.TowerPlayer = player;
    }


}

