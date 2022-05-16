package it.polimi.ingsw.Ziti.launcher.model.GameMode;

import it.polimi.ingsw.Ziti.launcher.TurnPhase.Phase;
import it.polimi.ingsw.Ziti.launcher.enumeration.ModeType;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.exception.EnabledCharactersException;
import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;
import it.polimi.ingsw.Ziti.launcher.model.Game;

public abstract class GameMode {
    private ModeType modeType;
    private Game game;

    public GameMode( Game game){
        this.game=game;
    }

    public ModeType getModeType() {
        return modeType;
    }

    public void setModeType(ModeType modeType) {
        this.modeType = modeType;
    }

    public abstract void startmode();

    public Game getGame() {
        return game;
    }

    public abstract Character getCharacterbyId(int id);

    public abstract void onPhaseUpdate(PhaseType phaseType);

    public abstract void enabledCharacters(Character character, Phase phase) throws EnabledCharactersException,ActionException;

}
