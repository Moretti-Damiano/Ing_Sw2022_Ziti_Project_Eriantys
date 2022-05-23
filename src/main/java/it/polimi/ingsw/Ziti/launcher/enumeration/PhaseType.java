package it.polimi.ingsw.Ziti.launcher.enumeration;

import java.io.Serializable;

/**
 * This enumeration is a collection of every Phase of the game
 */
public enum PhaseType implements Serializable {
    NULL("NULL"),PLANNING("PLANNING"), MOVEMENT("MOVEMENT"), MOTHER("MOTHER"),
    CLOUD("CLOUD"),ENDGAME("ENDGAME");
    private String abbreviation;

    PhaseType(String abbreviation){
         this.abbreviation=abbreviation;
    }

    public String getAbbreviation(){
         return this.abbreviation;
    }


}
