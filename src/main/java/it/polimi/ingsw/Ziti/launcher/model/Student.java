package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;

import java.io.Serializable;

/**
 * This class represents Student: a kind of a Pawn
 */
public class Student extends Pawn implements Serializable {


    public Student(Colour c) {
        super(c);
    }
}
