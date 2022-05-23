package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.model.Game.Game;

/**
 * this class is used to generate characters for the game
 */
public class CharacterFactory {

    private final Game game;

    public CharacterFactory(Game game) {
        this.game = game;
    }

    public Character getCharacter(int id){
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
