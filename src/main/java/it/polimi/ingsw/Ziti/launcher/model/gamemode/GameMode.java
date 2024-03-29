package it.polimi.ingsw.Ziti.launcher.model.gamemode;

import it.polimi.ingsw.Ziti.launcher.turnphase.Phase;
import it.polimi.ingsw.Ziti.launcher.action.Action;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.exception.EnabledCharactersException;
import it.polimi.ingsw.Ziti.launcher.model.characters.Character;
import it.polimi.ingsw.Ziti.launcher.model.game.Game;

/**
 * Class used to define a game mode (between normal and expert)
 */
public abstract class GameMode {

    private final Game game;

    public GameMode( Game game){
        this.game=game;
    }



    public abstract void startmode();

    public Game getGame() {
        return game;
    }

    public abstract Character getCharacterbyId(int id);

    /**
     * Call all the necessary methods for updating the phase
     * @param phaseType the actual phase
     */
    public abstract void onPhaseUpdate(PhaseType phaseType);

    /**
     * checks if the chose GameMode supports character.
     * @param character the character to use
     * @param phase the actual phase
     * @throws EnabledCharactersException if characters are not enabled
     * @throws ActionException if ChooseCharacter gives any action errors
     */
    public abstract void enabledCharacters(Character character, Phase phase) throws EnabledCharactersException,ActionException;

    /**
     * Methods called using coins during moveToTable
     * @param colour the colour to check
     * @param action the action calling this method
     */
    public abstract void onCoin(Colour colour,Action action);

    /**
     * Update generated after a showCharacters request
     * @throws EnabledCharactersException if characters are not enabled
     */
    public abstract void onShowCharacters() throws EnabledCharactersException;

}
