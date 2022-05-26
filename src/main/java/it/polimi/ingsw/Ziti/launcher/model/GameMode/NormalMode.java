package it.polimi.ingsw.Ziti.launcher.model.GameMode;

import it.polimi.ingsw.Ziti.launcher.TurnPhase.Phase;
import it.polimi.ingsw.Ziti.launcher.action.Action;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.EnabledCharactersException;
import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;
import it.polimi.ingsw.Ziti.launcher.model.Game.Game;

/**
 * GameMode without characters
 */
public  class NormalMode extends GameMode {

    public NormalMode(Game game){
        super(game);

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

    @Override
    public void enabledCharacters(Character character, Phase phase) throws EnabledCharactersException {
        throw new EnabledCharactersException();
    }

    @Override
    public void onCoin(Colour colour, Action movetotable) {
        //nothing to do
    }

    @Override
    public void onShowCharacters() throws EnabledCharactersException {
        throw new EnabledCharactersException();
    }
}
