package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;

import java.io.Serializable;
import java.util.ArrayList;

public class CloudIsland implements Serializable {
    private int ID;
    private int size;       //number of student on the cloudisland
    private ArrayList<Student> students;
    private Sack sack;
    private boolean available;

    public CloudIsland(int Id, int PlayerNum, Sack sack){
        this.ID = Id;
        this.sack = sack;
        students = new ArrayList<Student>();
        if(PlayerNum == 3)
            size = 4;
        else
            size = 3;
        this.available = false;
    }

    public int getID() {
        return ID;
    }

    public int getSize() {
        return size;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean isAvailable() {
        return available;
    }

    /**
     * Put 'size' random students from the Sack in the CloudIsland
     */
    public void toFill(){
        for(int i=0;i<size;i++){
            students.add(sack.extract());
        }
        available = true;
    }

    /**
     * @return An arraylist of 'size' students
     */
    public ArrayList<Student> toEmpty(){
        ArrayList<Student> Copy = new ArrayList<Student>(students);
        students.clear();
        available = false;
        return Copy;
    }

    /**
     * shows what the island contains ->èPROBABLY USELESS, IMPLEMENTED IN VIEW
     */
    public void Show(){
        System.out.println("Cloud Island: "+ID);
        //to be implemented later with more ideas of the game
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
}
