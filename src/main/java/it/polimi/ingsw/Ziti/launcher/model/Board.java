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
        private WalletController walletController;

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


    public void setTowerColour(TowerColour tower_colour) {
        this.tower_colour = tower_colour;
    }


    /**
     * Removes a tower from towers and returns it
     */
    public Tower removeTower() {
        int index = (int) (Math.random() * towers.size());
        return towers.get(index);
        towers.remove(index);
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
            wallet.add(walletController.getCoin());
        }
    }


    public Student leave(Colour student_colour){
        ArrayList<Student> s_leave=new ArrayList<Student>();
        for(Student s : students_waiting){
            if(s.getColour()==student_colour){
                s_leave.add(s);
            }
        }
        int index = (int) (Math.random() * s_leave.size());
        return s_leave.get(index);
        students_waiting.remove(s_leave.get(index));
    }



    private boolean checkCoin(Colour student_colour){
        if(students[student_colour.getIntAbbreviation()].size() % 3==0){
            return true;
        }
        return false;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }
}
