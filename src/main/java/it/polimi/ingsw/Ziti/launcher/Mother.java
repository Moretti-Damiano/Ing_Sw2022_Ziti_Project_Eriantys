package it.polimi.ingsw.Ziti.launcher;

/**
 * This classe is a Singleton and represents the Mother Of Nature in the game
 * */
public class Mother {
    private Island island;
    private static Mother mother;

    private Mother(){
        this.island = island;
    }

    public static Mother MotherInstance() {
        if (mother == null) mother  = new Mother();
        return mother;
    }

    /**
     * Moves Mother from an island to an other
     */
    public void move(Island i){
        mother.island = mother.i;
    }
}
