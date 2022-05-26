package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.model.Game.Game;
import it.polimi.ingsw.Ziti.launcher.model.Game.GameFactory;

/**
 * Class used to generate the characters for the game by using a Factory pattern.
 * This class also implements the Singleton Pattern.
 */
public class CharacterFactory {

    private static CharacterFactory instance;
    public CharacterFactory() {}

    public static CharacterFactory getInstance(){
        if(instance == null)
            instance = new CharacterFactory();
        return instance;
    }

    /**
     * Generates a Character by his id
     * @param id the character's id
     * @param game the game to assign the character to
     * @return the requested character
     */
    public Character getCharacter(int id, Game game){
        Character character;
        switch (id){
            case 0:
                character = new Character0();
                character.setGame(game);
                return character;
            case 1:
                character = new Character1();
                character.setGame(game);
                return character;
            case 2:
                character = new Character2();
                character.setGame(game);
                return character;
            case 3:
                character = new Character3();
                character.setGame(game);
                return character;
            case 4:
                character = new Character4();
                character.setGame(game);
                return character;
            case 5:
                character = new Character5();
                character.setGame(game);
                return character;
            default:
                return null;
        }
    }
}
