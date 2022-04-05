package it.polimi.ingsw.Ziti.launcher.model;

/**
 * This class is a Singleton and represents the Mother Of Nature in the game
 * */
public class Mother {
    private Island island;
    private static Mother instance;

    private Mother(){}

    public static Mother motherInstance() {
        if (instance == null) instance = new Mother();
        return instance;
    }

    public void setIsland(Island island) {
        this.island = island;
    }

    public Island getIsland() {
        return island;
    }
}
