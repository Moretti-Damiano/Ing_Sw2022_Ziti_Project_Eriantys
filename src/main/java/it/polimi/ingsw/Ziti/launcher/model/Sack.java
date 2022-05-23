package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

/**
 * This class represents the Sack used in the game to spawn Students.
 * */
public class Sack implements Serializable {
    private int[] numColour;


    /**
     *
     * @param studentNumber
     */

    public Sack(int studentNumber) {
        numColour = new int[5];
        Arrays.fill(numColour, (studentNumber / 5));
    }

    /**
     * This method creates a Student with its colour if there's the possibility to create that kind of Student
     * Else returns another kind of Student or show a message that the Sack is empty
     */
    public Student extract() {

        //create a random number
        Random rand = new Random();
        int upperLimit = numColour.length;
        int randomNumber = rand.nextInt(upperLimit);

        //check if the sack is empty
        boolean empty = true;
        for(int i = 0; i< 5; i++){
            if (numColour[i] != 0) {
                empty = false;
                break;
            }
        }
        if(empty){
            System.out.println("The sack is empty!");
            return null;
        }

        //if selected colour is not available, generates another random colour
        while (numColour[randomNumber] == 0) {
            randomNumber = rand.nextInt(upperLimit);
        }
        numColour[randomNumber]--;
        return new Student(Colour.valueOfAbbreviation(Integer.toString(randomNumber)));
    }

    /**
     * insert a student in the sack
     * @param student to be inserted
     */
    public void insert(Student student){
        numColour[student.getColour().getIntAbbreviation()]++;
    }

    /**
     *
     * @return if the sack is empty or not
     */
    public boolean isEmpty(){
        for(int i = 0; i < 5; i++){
            if(numColour[i]!=0)
                return false;
        }
        return true;
    }
}

