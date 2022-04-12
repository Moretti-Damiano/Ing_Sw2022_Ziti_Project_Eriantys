package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;

import java.util.Arrays;
import java.util.Random;

/**
 * This class represents the Sack used in the game to spawn Students.
 * */
public class Sack {
    private int[] numColour;


    /**
     * Default constructor.
     */
    public Sack(int studentNumber) {
        numColour = new int[5];
        Arrays.fill(numColour, studentNumber / 5);
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

        //associates that random number with the Color Enum of the Student
        if (numColour[randomNumber] > 0) {
            numColour[randomNumber]--;
            return new Student(Colour.valueOfAbbreviation(Integer.toString(randomNumber)));
        }
        else    //checking if array is empty
            for (int j : numColour) {
                if (j != 0) {
                    extract();
                }
            }
        System.out.println("\nThe Sack is empty!\n");
        return null;

    }
}

