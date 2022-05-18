package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.CharacterException;
import it.polimi.ingsw.Ziti.launcher.model.Player;
import it.polimi.ingsw.Ziti.launcher.model.Student;

/*
Choose a type of student : every player (including yourself) must return 3 students of that type from their dining room to the bag.
If any player has fewer than 3 students of that type, return as many students as they have
 */
public class Character4 extends Character{

    private Colour colour;

    public Character4() {
        super();
        setId(4);
        setCost(3);
        setDescription(" Choose a type of student : every player (including yourself) must return 3 students of that type from their dining room to the bag." +
                " If any player has fewer than 3 students of that type, return as many students as they have ");
        getUsePhase().add(PhaseType.MOVEMENT);
        getUsePhase().add(PhaseType.MOTHER);
        setAvailable(true);
        setEndPhase(PhaseType.CLOUD);
    }


    public void choose(String colour) throws CharacterException {
     checkInput(colour);
     this.colour = Colour.valueOfName(colour);
    }

    /**
     * Removes 3 student of the selected colour from each player's table.
     * If there are less than 3, it removes all.
     */
    @Override
    public void startEffect(){
        setUsed(true);
        for(Player player: getGame().getPlayers()){
            if(player.getBoard().getColorRowSize(colour) < 3){
                int size = player.getBoard().getColorRowSize(colour);
                player.getBoard().getColourRow(colour).clear();
                for(int i = 0; i < size; i++){
                    getGame().getSack().insert(new Student(colour));
                }
            }
            else
            {
                for(int i = 0; i < 3; i++){
                    player.getBoard().getColourRow(colour).remove(player.getBoard().getColorRowSize(colour)-1);
                    getGame().getSack().insert(new Student(colour));
                }
            }
        }
    }

    @Override
    public void endEffect() {
        setAvailable(true);
        setUsed(false);
    }

    private void checkInput(String colour) throws CharacterException{
        if(!Colour.checkStringToColour(colour)){
            throw new CharacterException();
        }
    }

}
