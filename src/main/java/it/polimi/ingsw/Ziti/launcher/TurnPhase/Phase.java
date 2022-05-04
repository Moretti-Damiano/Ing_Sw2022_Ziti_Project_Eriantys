package it.polimi.ingsw.Ziti.launcher.TurnPhase;

import it.polimi.ingsw.Ziti.launcher.controller.TurnController;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;

public abstract class Phase {

    private TurnController turncontroller;
    private PhaseType phaseType;
    private int playersDone;

    public Phase(TurnController turnController, PhaseType phaseType){
        this.turncontroller = turnController;
        this.phaseType = phaseType;
        playersDone = 0;
    }

    public PhaseType getPhaseType() {
        return phaseType;
    }

    public TurnController getTurncontroller(){
        return turncontroller;
    }

    public int getPlayersDone() {
        return playersDone;
    }

    public void addPlayersDone() {
        this.playersDone ++;
    }

    public void resetPlayersDone(){
        this.playersDone = 0;
    }

    public abstract void update();
    public abstract void nextPhase();
}
