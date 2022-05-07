package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.ActionMessage;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;
import it.polimi.ingsw.Ziti.launcher.model.Game;

public class ChooseCharacter implements Action{
    private Character character;
    private Game game;

    public ChooseCharacter(Character character, Game game){
        this.character=character;
        this.game=game;

    }
    public void execute() throws ActionException {
       checkCoin();
    }

    @Override
    public ActionMessage toMessage() {
        return null;
    }

    public void checkCoin() throws ActionException{
        if(game.getCurrentPlayer().getBoard().getNumberofCoin() < character.getCost()){
            throw new ActionException();
        }
        if(activeCharacter()){
            throw new ActionException();
        }
    }
    public boolean activeCharacter(){
        for(Character c : game.getCharacters()){
            if(c.isAvailable() ){ return false; }
        }
        return true;
    }
}
