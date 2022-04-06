package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.TowerColour;

import java.util.ArrayList;

public class Board {
        private static final int colorrow = 5;
        private ArrayList<Tower> towers;
        private TowerColour tower_colour;
        private ArrayList<Student> students_waiting;
        private ArrayList<Professor> professors;
        private ArrayList<Student>[] students;
        private ArrayList<Coin> wallet;



        public Board() {
            towers = new ArrayList<Tower>();
            professors = new ArrayList<Professor>();
            wallet = new ArrayList<Coin>();
            students_waiting = new ArrayList<Student>();
            students = new ArrayList[colorrow];
            for (int i = 0; i < colorrow; i++) {
                students[i] = new ArrayList<Student>();
            }
        }

    public ArrayList<Professor> getProfessors(){ return this.professors;}

    /**
     * @param s student to add
     */
    public void addStudent(Student s){
            students_waiting.add(s);
    }


    public void setTowerColour(TowerColour tower_colour) {
        this.tower_colour = tower_colour;
    }


    /**
     * Removes a tower from towers and returns it
     */
    public Tower removeTower() {
       return towers.remove(0);
    }


    /**
     * adds a tower to towers
     */
    public void addTower(Tower T) {
        towers.add(T);
    }



    //getintabbreviation dovrebbe restituire l'intero associato al colore
    public void goLunch(Colour student_colour) {
        students[student_colour.getIntAbbreviation()] .add(this.leave(student_colour));
        if(this.checkCoin(student_colour)){
            wallet.add(WalletController.getCoin());
        }
    }


    public Student leave(Colour student_colour){
        for(Student s : students_waiting){
            if(s.getColour()==student_colour){
               students_waiting.remove(s);
               return s;
            }
        }
        return null;

    }



    private boolean checkCoin(Colour student_colour){
        if(students[student_colour.getIntAbbreviation()].size() % 3==0){
            return true;
        }
        return false;
    }
}
