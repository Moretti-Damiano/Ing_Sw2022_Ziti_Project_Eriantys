package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.enumeration.ModeType;
import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;

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

    @Override
    public Character getCharacterbyId(int id) {
        return null;
    }


}
