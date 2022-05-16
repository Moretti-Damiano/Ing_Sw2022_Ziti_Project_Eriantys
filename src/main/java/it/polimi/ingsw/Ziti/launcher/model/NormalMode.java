package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.enumeration.ModeType;

public class NormalMode extends GameMode{
    private final ModeType modeType=ModeType.NORMAL;

    @Override
    public ModeType getModeType() {
        return modeType;
    }

    public NormalMode(Game game){
        super(game);
        game.setModeType(getModeType());
    }
    @Override
    public void startmode() {

    }
}
