package it.polimi.ingsw.Ziti.launcher.model.GameMode;

import it.polimi.ingsw.Ziti.launcher.enumeration.ModeType;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.Characters.*;
import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;
import it.polimi.ingsw.Ziti.launcher.model.Coin;
import it.polimi.ingsw.Ziti.launcher.model.Game;
import it.polimi.ingsw.Ziti.launcher.model.Player;


import java.util.ArrayList;
import java.util.Random;

public class ExpertMode extends GameMode {
    private ArrayList<Character> allCharacters;
    private ArrayList<Character>characters;
    private Character activeCharacter;
    private final ModeType modeType=ModeType.EXPERT;

    @Override
    public ModeType getModeType() {
        return modeType;
    }

    public ExpertMode(Game game){
        super(game);
        game.setModeType(getModeType());
    }

    public Character getActiveCharacter(){
        return this.activeCharacter;
    }

    public void setActiveCharacter(Character character){
        this.activeCharacter = character;
    }

    @Override
    public void startmode() {
        for(Player p : getGame().getPlayers()){
            p.getBoard().setWallet(new ArrayList<>());
            p.getBoard().getWallet().add(new Coin());
            p.getBoard().getWallet().add(new Coin());
            p.getBoard().getWallet().add(new Coin());
            p.getBoard().getWallet().add(new Coin());
            p.getBoard().getWallet().add(new Coin());
            p.getBoard().getWallet().add(new Coin());
            p.getBoard().getWallet().add(new Coin());
            p.getBoard().getWallet().add(new Coin());
            p.getBoard().getWallet().add(new Coin());
            p.getBoard().getWallet().add(new Coin());
            p.getBoard().getWallet().add(new Coin());
            p.getBoard().getWallet().add(new Coin());
            p.getBoard().getWallet().add(new Coin());
            p.getBoard().getWallet().add(new Coin());

        }
       getGame().setCharacters(setUpCharacters());

    }

    @Override
    public Character getCharacterbyId(int id){
        for(Character c: characters){
            if(c.getId() == id)
                return c;
        }
        return null;
    }

    @Override
    public void onPhaseUpdate(PhaseType phaseType) {
        endCharacter(phaseType);
       checkCharacter(phaseType);

    }

    private ArrayList<Character> setUpCharacters(){

        allCharacters = new ArrayList<>();
        characters = new ArrayList<>();
        //creates all possible characters
        allCharacters.add(new Character0());
        allCharacters.add(new Character1());
        allCharacters.add(new Character2());
        allCharacters.add(new Character3());
        allCharacters.add(new Character4());
        allCharacters.add(new Character5());

        //set 3 game's characters
        Random rand = new Random();
        int random;
        for(int i = 0; i < 3; i++){
            //create a random number
            random =rand.nextInt(allCharacters.size());
            allCharacters.get(random).setGame(getGame());
            characters.add(allCharacters.remove(random));

        }
        return characters;
    }
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

    private void endCharacter(PhaseType phaseType) {
        if (activeCharacter != null && activeCharacter.getEndPhase().equals(phaseType)) {
            activeCharacter.endEffect();
            activeCharacter = null;
        }
    }

}
