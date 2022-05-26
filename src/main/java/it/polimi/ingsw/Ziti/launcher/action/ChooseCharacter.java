package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.ActionMessage.ActionMessage;
import it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.ActionMessage.ChooseCharacterDoneMessage;
import it.polimi.ingsw.Ziti.launcher.turnphase.Phase;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.characters.Character;
import it.polimi.ingsw.Ziti.launcher.model.game.Game;

/**
 * check if the current Player has enough coins and if there is already a chosen character
 */
public class ChooseCharacter implements Action{
    private final Character character;
    private final Game game;
    private final Phase actualPhase;

    public ChooseCharacter(Game game, Character character, Phase phase){
        this.character=character;
        this.game=game;
        this.actualPhase = phase;
    }
    @Override
    public void execute() throws ActionException {
        checkInput();
        character.setAvailable(false);
        character.increaseCost();
        game.getCurrentPlayer().setUsedACharacter(true);
        
        if(character.isPhase(actualPhase.getPhaseType()))
            character.startEffect();
    }


    @Override
    public ActionMessage toMessage() {
        return new ChooseCharacterDoneMessage(game.getCurrentPlayer().GetName() + " has chosen character " + character.getId()+"\nEffect: "+character.getDescription());
    }

    @Override
    public void addDescription(String s) {

    }

    /**
     * this method check if the chosen character is available for this game
     * @throws ActionException if the character isn't available
     */
    private void checkCharacterInGame() throws ActionException {
        boolean in = false;
        for(Character c: game.getCharacters()){
            if (c.equals(character)) {
                in = true;
                break;
            }
        }
        if(!in)
            throw new ActionException();
    }

    /**
     * check if the current player has enough coin for the chosen character
     * @throws ActionException if the current player hasn't enough coin
     */
    public void checkCoin() throws ActionException{
        if(game.getCurrentPlayer().getBoard().getNumberofCoin() < character.getCost()){
            throw new ActionException();
        }
        if(activeCharacter()){
            throw new ActionException();
        }
    }

    /**
     * check if there is an active character in this round
     * @return true if there is an active character
     */
    private boolean activeCharacter(){
        for(Character c : game.getCharacters()){
            if(!c.isAvailable() ){ return true; }
        }
        return false;
    }

    /**
     * check if the current player has yet used a character during this round
     * @throws ActionException if the current player has already used a character
     */
    private void checkUsedACharacter() throws ActionException {
        if(game.getCurrentPlayer().hasUsedACharacter())
            throw new ActionException();
    }

    @Override
    public void checkInput() throws ActionException {
        checkCharacterInGame();
        checkCoin();
        checkUsedACharacter();
    }
}
