package it.polimi.ingsw.Ziti.launcher.model.GameMode;

import it.polimi.ingsw.Ziti.launcher.TurnPhase.Phase;
import it.polimi.ingsw.Ziti.launcher.action.Action;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.exception.EnabledCharactersException;
import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;
import it.polimi.ingsw.Ziti.launcher.model.Game.Game;

/**
 * Class used to define a game mode (between normal and expert)
 */
public abstract class GameMode {

    private final Game game;

    public GameMode( Game game){
        this.game=game;
    }


    /**
     * this method is used to start the chosen game mode in game
     */
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
     * this method is used to show characters in game
     * @throws EnabledCharactersException if the selected game mode doesen't support characters
     */
    public abstract void onShowCharacters() throws EnabledCharactersException;

}
