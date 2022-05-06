package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.Game;

public abstract class Character {
    private Game game;
    private int id;
    private int cost;
    private String description;
    private PhaseType usePhase;
    private boolean available;

    protected Character(Game game) {
        this.game = game;
    }

    public int getId() {
        return id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public Game getGame() {
        return game;
    }

    public PhaseType getUsePhase() {
        return usePhase;
    }

    public void setUsePhase(PhaseType usePhase) {
        this.usePhase = usePhase;
    }

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

    public abstract void startEffect() throws ActionException;

    public abstract void endEffect();
}
