package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;

import java.io.Serializable;

/**
 * This class represents Professor: a kind of a Pawn
 */
public class Professor extends Pawn implements Serializable {

    public Professor(Colour c) {
        super(c);
    }
    private Player player;

}
