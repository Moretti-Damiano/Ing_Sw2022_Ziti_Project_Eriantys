package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.ActionMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.ChooseCharacterDoneMessage;
import it.polimi.ingsw.Ziti.launcher.TurnPhase.Phase;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.exception.CharacterException;
import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;
import it.polimi.ingsw.Ziti.launcher.model.Game;

/**
 * check if the current Player has enough coins and if there is already a chosen character
 */
public class ChooseCharacter implements Action{
    private Character character;
    private Game game;
    private Phase actualPhase;

    public ChooseCharacter(Game game, Character character, Phase phase){
        this.character=character;
        this.game=game;
        this.actualPhase = phase;
    }
    public void execute() throws ActionException {
        checkCharacterInGame();
        checkCoin();
        checkUsedACharacter();
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

    private void checkCharacterInGame() throws ActionException {
        boolean in = false;
        for(Character c: game.getCharacters()){
            if(c.equals(character))
                in = true;
        }
        if(!in)
            throw new ActionException();
    }

    public void checkCoin() throws ActionException{
        if(game.getCurrentPlayer().getBoard().getNumberofCoin() < character.getCost()){
            throw new ActionException();
        }
        if(activeCharacter()){
            throw new ActionException();
        }
    }
    private boolean activeCharacter(){
        for(Character c : game.getCharacters()){
            if(!c.isAvailable() ){ return true; }
        }
        return false;
    }
    
    private void checkUsedACharacter() throws ActionException {
        if(game.getCurrentPlayer().hasUsedACharacter())
            throw new ActionException();
    }
}
