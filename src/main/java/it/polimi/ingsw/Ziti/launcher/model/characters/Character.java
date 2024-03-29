package it.polimi.ingsw.Ziti.launcher.model.characters;

import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.game.Game;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Abstract class that must be extended bey every character class.
 * It contains the main attributes adn methods for implementing characters.
 */
public abstract class Character implements Serializable {
    private Game game;
    private int id;
    private int cost;
    private String description;
    private final ArrayList<PhaseType> usePhase;
    private PhaseType endPhase;
    private boolean available;
    private boolean used;

    public Character(){
        this.usePhase = new ArrayList<>();
        this.used = false;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setDescription(String description){this.description=description;}

    public String getDescription() {
        return description;
    }

    public Game getGame() {
        return game;
    }

    public ArrayList<PhaseType> getUsePhase() {
        return usePhase;
    }

    public PhaseType getEndPhase() {
        return endPhase;
    }

    public void setEndPhase(PhaseType endPhase) {
        this.endPhase = endPhase;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    /**
     *
     * @param phase the actual phase
     * @return true if the character can activate his effect in this phase
     */
    public boolean isPhase(PhaseType phase){
        return usePhase.contains(phase);
    }

    /**
     * this method is used to increase the cost of a character
     */
    public void increaseCost(){
        game.getCurrentPlayer().getBoard().removeCoin(cost);
        game.getGameWallet().reduceCoin();
        game.getGameWallet().increase(cost-1);
        this.cost++;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    /**
     * this method starts the character's effect
     */
    public abstract void startEffect() throws ActionException;

    /**
     * this method ends the character's effect
     */
    public abstract void endEffect();
}
