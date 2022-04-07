package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;

import java.util.Random;

/**
 * This class represents Sack used in the game to spawn Students.
 * */
public class Sack {
    private int[] numColour;


    /**
     * Default constructor.
     */
    public Sack() {
        numColour = new int[5];
        numColour[0] = 26;
        numColour[1] = 26;
        numColour[2] = 26;
        numColour[3] = 26;
        numColour[4] = 26;
    }

    /**
     * This method creates a Student with its colour if there's the possibility to create that kind of Student
     * Else returns another kind of Student or show a message that the Sack is empty
     */
    public Student extract() {

        //create a random number
        Random rand = new Random();
        int upperLimit = 5;
        Integer randomNumber = rand.nextInt(upperLimit);



        //associates that random number with the Color Enum of the Student
        if (numColour[randomNumber] > 0) {
            numColour[randomNumber]--;
            return new Student(Colour.valueOfAbbreviation(randomNumber.toString()));
            //checking if array is empty
        } else for (int i = 0; i < numColour[i]; i++) {
            if (numColour[i] == 0) {
                System.out.println("\nThe Sack is empty!\n");
                return null;
            } else extract();
        }
        return null;

    }
}

