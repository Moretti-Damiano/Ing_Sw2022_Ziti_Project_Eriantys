package it.polimi.ingsw.Ziti.launcher.model.GameMode;

import it.polimi.ingsw.Ziti.launcher.TurnPhase.Phase;
import it.polimi.ingsw.Ziti.launcher.action.Action;
import it.polimi.ingsw.Ziti.launcher.action.ChooseCharacter;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.exception.EnabledCharactersException;
import it.polimi.ingsw.Ziti.launcher.model.Characters.*;
import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;
import it.polimi.ingsw.Ziti.launcher.model.Coin;
import it.polimi.ingsw.Ziti.launcher.model.Game.Game;
import it.polimi.ingsw.Ziti.launcher.model.Player;


import java.util.ArrayList;
import java.util.Random;

public class ExpertMode extends GameMode {

    private Character activeCharacter;

    public ExpertMode(Game game) {
        super(game);

    }

    public void setActiveCharacter(Character character) {
        this.activeCharacter = character;
    }

    @Override
    public void startmode() {
        for (Player p : getGame().getPlayers()) {
            p.getBoard().setWallet(new ArrayList<>());
            p.getBoard().getWallet().add(new Coin());
        }
        getGame().setCharacters(setUpCharacters());

    }

    @Override
    public Character getCharacterbyId(int id) {
        for (Character c : getGame().getCharacters()) {
            if (c.getId() == id)
                return c;
        }
        return null;
    }

    @Override
    public void onPhaseUpdate(PhaseType phaseType) {
        endCharacter(phaseType);
        checkCharacter(phaseType);
    }

    /**
     * Creates via factory method an ArrayList of 3 different characters
     * @return an ArrayList containing 3 different characters
     */
    private ArrayList<Character> setUpCharacters() {
        ArrayList<Character> gameCharacters = new ArrayList<>();
        CharacterFactory characterFactory = new CharacterFactory(getGame());
        ArrayList<Integer> ids = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            ids.add(i);
        }


        Random rand = new Random();
        int number;

        while (gameCharacters.size() < 3) {
            number = rand.nextInt(ids.size());
            if(ids.contains(number)) {
                gameCharacters.add(characterFactory.getCharacter(number));
                ids.remove((Integer)number);
            }
        }
        return gameCharacters;
    }

    /**
     * check if there is an active character; then it checks if the current phase match the starting phase of the character,
     * if so, it activates the character effect.
     * @param phaseType the actual phase
     */
    private void checkCharacter(PhaseType phaseType) {
        for (Character c : getGame().getCharacters()) {
            if (!c.isAvailable() && c.isPhase(phaseType)) {
                try {
                    setActiveCharacter(c);
                    if (!c.isUsed())
                        c.startEffect();
                } catch (ActionException e) {
                    //send invalid input error (never gonna happen)
                }
            }
        }
    }

    /**
     * check if the actual phase matches the activeCharacter endPhase, if so it calls Character.endEffect().
     * @param phaseType the actual phase.
     */
    private void endCharacter(PhaseType phaseType) {
        if (activeCharacter != null && activeCharacter.getEndPhase().equals(phaseType)) {
            activeCharacter.endEffect();
            activeCharacter = null;
        }
    }

    /**
     * Used to set up the action
     * @param character the character to use
     * @param phase the actual phase
     */
    public void enabledCharacters(Character character, Phase phase) throws  ActionException {
        getGame().setAction(new ChooseCharacter(getGame(), character, phase));
        getGame().doAction();
    }

    @Override
    public void onCoin(Colour colour,Action movetotable) {
        if (getGame().getCurrentPlayer().getBoard().checkCoin(colour)) {
            getGame().getCurrentPlayer().getBoard().addCoin(getGame().getGameWallet().getCoin());
            movetotable.addDescription("\nnew coin added to " + getGame().getCurrentPlayer().GetName() + " wallet\n");
        }

    }

    @Override
    public void onShowCharacters() {

    }
}
