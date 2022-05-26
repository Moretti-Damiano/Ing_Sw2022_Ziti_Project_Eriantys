package it.polimi.ingsw.Ziti.launcher.messages;

import java.io.Serializable;
/**
 * this class is used to create a summary of a character
 */
public class CharacterSummary implements Serializable {
    private int id;
    private int cost;
    private String description;


    public CharacterSummary(int id, int cost, String description) {
        this.id = id;
        this.cost = cost;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }
}
