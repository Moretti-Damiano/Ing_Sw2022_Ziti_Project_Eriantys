package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.enumeration.ModeType;
import it.polimi.ingsw.Ziti.launcher.model.Characters.*;
import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;


import java.util.ArrayList;
import java.util.Random;

public class ExpertMode extends GameMode {
    private ArrayList<Character> allCharacters;
    private ArrayList<Character>characters;
    private final ModeType modeType=ModeType.EXPERT;

    @Override
    public ModeType getModeType() {
        return modeType;
    }

    public ExpertMode(Game game){
        super(game);
        game.setModeType(getModeType());
    }

    @Override
    public void startmode() {
        for(Player p : getGame().getPlayers()){
            p.getBoard().setWallet(new ArrayList<>());
            p.getBoard().getWallet().add(new Coin());
        }
       getGame().setCharacters(setUpCharacters());

    }

    private ArrayList<Character> setUpCharacters(){

        allCharacters = new ArrayList<>();
        characters = new ArrayList<>();
        //creates all possible characters
        allCharacters.add(Character0.getInstance());
        allCharacters.add(Character1.getInstance());
        allCharacters.add(Character2.getInstance());
        allCharacters.add(Character3.getInstance());
        allCharacters.add(Character4.getInstance());
        allCharacters.add(Character5.getInstance());

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

}
