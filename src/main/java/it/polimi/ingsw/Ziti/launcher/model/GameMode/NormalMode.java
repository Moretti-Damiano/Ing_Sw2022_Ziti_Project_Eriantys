package it.polimi.ingsw.Ziti.launcher.model.GameMode;

import it.polimi.ingsw.Ziti.launcher.enumeration.ModeType;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;
import it.polimi.ingsw.Ziti.launcher.model.Game;
import it.polimi.ingsw.Ziti.launcher.model.GameMode.GameMode;

public class NormalMode extends GameMode {
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
        //nothing to do
    }

    @Override
    public Character getCharacterbyId(int id) {
        return null;
    }

    @Override
    public void onPhaseUpdate(PhaseType phaseType) {
        //nothing to do
    }
}
