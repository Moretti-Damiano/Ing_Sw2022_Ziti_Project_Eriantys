package it.polimi.ingsw.Ziti.launcher.TurnPhase;

import it.polimi.ingsw.Ziti.launcher.controller.TurnController;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;

public abstract class Phase {

    private TurnController turncontroller;
    private PhaseType phaseType;
    private int playersDone;
    private Character activeCharacter;

    public Phase(TurnController turnController, PhaseType phaseType){
        this.turncontroller = turnController;
        this.phaseType = phaseType;
        playersDone = 0;
        checkCharacter();
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


    /**
     * Check if in the game there's an active character whose effect starts in this phase,
     * if it exists, the method starts the character effect if it hasn't started already
     */
    public void checkCharacter(){
        for(Character c: getTurncontroller().getGameController().getGame().getCharacters()){
            if(!c.isAvailable() && c.isPhase(this.getPhaseType())){
                try {
                    setActiveCharacter(c);
                    if(!c.isUsed())
                        c.startEffect();
                } catch (ActionException e) {
                    //send invalid input error (never gonna happen)
                }
            }
        }
    }

    /**
     * Run the end_effect of the active character started in this phase
     */
    public void endCharacter(){
        if(activeCharacter != null && activeCharacter.getEndPhase().equals(phaseType)){
            activeCharacter.endEffect();
        }
    }

    public void setActiveCharacter(Character activeCharacter) {
        this.activeCharacter = activeCharacter;
    }

    public abstract void update();
    public abstract void nextPhase();
}
