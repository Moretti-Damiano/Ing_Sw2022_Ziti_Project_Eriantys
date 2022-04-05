package it.polimi.ingsw.Ziti.launcher;

import java.util.ArrayList;

public class Board {
        private static final int colorrow = 5;
        private ArrayList<Tower> towers;
        private TowerColour tower_colour;
        private ArrayList<Student> students_waiting;
        private ArrayList<Professor> professors;
        private ArrayList<Student>[] students;
        private ArrayList<Coin> wallet;



        public Board(TowerColour tower_colour) {
            this.tower_colour=tower_colour;
            towers = new ArrayList<Tower>();
            professors = new ArrayList<Professor>();
            wallet = new ArrayList<Coin>();
            students_waiting = new ArrayList<Student>();
            students = new ArrayList[colorrow];
            for (int i = 0; i < colorrow; i++) {
                students[i] = new ArrayList<Student>();
            }
        }

        public ArrayList<Professor> getProfessors(){
            return this.professors;
        }


    /**
     *
     * @param p professor to add
     */
    public void addProfessor(Professor p){
            professors.add(p);
        }

    /**
     * @param s student to add
     */
    public void addStudent(Student s){
            students_waiting.add(s);
     }

    /**
     * Remove a tower from towers
     * @return the removed tower
     */
    public Tower removeTower() {
        return  towers.remove(0);

    }


    /**
     * add a tower to towers
     */
    public void addTower(Tower T) {
        towers.add(T);
    }




    public void goLunch(Colour student_colour) {
        students[student_colour.getintabbreviation()] .add(this.leave(student_colour));
        if(this.checkCoin(student_colour)){
            wallet.add(walletController.getCoin());
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

    /**
     *
     * @param student_colour colour of checked row
     * @return true if the size of the specified row is a multiple of 3
     */
    private boolean checkCoin(Colour student_colour){
        if(students[student_colour.getintabbreviation()].size() % 3==0){
            return true;
        }
        return false;
    }
}
