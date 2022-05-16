package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.enumeration.ModeType;
import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;

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
}
