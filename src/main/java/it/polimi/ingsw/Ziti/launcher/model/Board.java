package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.TowerColour;

import java.io.Serializable;
import java.util.ArrayList;

public class Board implements Serializable {
        private static final int colorrow = 5;
        private String playername;
        private ArrayList<Tower> towers;
        private TowerColour tower_colour;
        private ArrayList<Student> students_waiting;
        private ArrayList<Professor> professors;
        private ArrayList<Student>[] students;
        private ArrayList<Coin> wallet;




        public Board(Player player) {
            playername = player.GetName();
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

    public String getPlayername() {
        return playername;
    }

    public void setTowerColour(TowerColour tower_colour) {
        this.tower_colour = tower_colour;
    }

    public TowerColour getTower_colour() { return tower_colour; }

    public void addCoin(Coin c){
        wallet.add(c);
    }

    public ArrayList<Student> getStudents_waiting() {
        return students_waiting;
    }

    public int getNumberofCoin(){
        return wallet.size();
    }
    /**
     * Remove a tower from towers and returns it
     */
    public Tower removeTower() {
       return towers.remove(0);
    }

    /**
     * add a student to the row that contains the student with the same colour
     * @param s student to add
     */
    public void addStudenttoColourRow( Student s){
        students[s.getColour().getIntAbbreviation()].add(s);
    }

    /**
     * remove a student from the row that contains the student with the same colour
     * @param s student to add
     */
    public void removeStudentfromColourRow( Student s){
        students[s.getColour().getIntAbbreviation()].remove(s);
    }

    /**
     * add a tower to towers
     */
    public void addTower(Tower T) {
        towers.add(T);
    }


    /**
     *
     * @param student_colour colour of the student to be removed
     * @return the removed student
     */
    public Student removeStudent(Colour student_colour){
        for(Student s : students_waiting){
            if(s.getColour().equals(student_colour)){
               students_waiting.remove(s);
               return s;
            }
        }
        return null;
    }

    public void addProfessor(Professor p){
        professors.add(p);
    }

    /**
     * check if the player has the professor with the specified colour
     * @param professor_colour colour of the professor
     * @return true if the player controls the professor
     */
    public boolean hasProfessor(Colour professor_colour){
        for(Professor p : professors){
            if(p.getColour()==professor_colour){
                return true;
            }
        }
        return false;
    }

    /**
     * @param colour of the row
     * @return the size of the specified row
     */
    public int getColorRowSize(Colour colour){
        return students[colour.getIntAbbreviation()].size();
    }

    /**
     * check if the size of the chosen row is a multiple of 3
     * @param student_colour the colour of the row to check
     * @return true if the size  is a multiple of 3
     */
    public boolean checkCoin(Colour student_colour){
        if(students[student_colour.getIntAbbreviation()].size() % 3==0){
            return true;
        }
        return false;
    }

    /**
     * @param professor_colour the colour of the professor to be removed
     * @return the removed professor
     */
    public Professor removeProfessorByColour(Colour professor_colour){
        for(Professor p : professors){
            if(p.getColour()==professor_colour){
                professors.remove(p);
                return p;
            }
        }
        return null;
    }

    /**
     * check if there is a student with the specified colour in students_waiting
     * @param colour the specified colour
     */
    public boolean checkpresence(Colour colour){
        for(Student s : students_waiting){
            if(colour.equals(s.getColour()))
                return true;
        }
        return false;
    }
    /**
     * counts how many students there are with the specified colour in students_waiting
     * @param colour the specified colour
     * @return count
     */
    public int countStudentColor(Colour colour){
        int count=0;
        for(Student s : students_waiting){
            if(colour.equals(s.getColour())) count++;
        }
        return count;
    }

    public void removeCoin(int cost) {
        for(int i = 0; i<cost; i++){
            wallet.remove(wallet.size()-1);
        }
    }

    /**
     * Return the dining room row of the specified colour
     * @param colour
     * @return
     */
    public ArrayList<Student> getColourRow(Colour colour){
        return students[colour.getIntAbbreviation()];
    }
}
