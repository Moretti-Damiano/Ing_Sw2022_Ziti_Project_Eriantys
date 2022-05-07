package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.Game;
import it.polimi.ingsw.Ziti.launcher.model.Player;
import it.polimi.ingsw.Ziti.launcher.model.Student;

/*
Choose a type of student : every player (including yourself) must return 3 students of that type from their dining room to the bag.
If any player has fewer than 3 students of that type, return as many students as they have
 */
public class Character4 extends Character{

    private Colour colour;

    public Character4(Game game) {
        super(game);
        setCost(3);
        setDescription(" Choose a type of student : every player (including yourself) must return 3 students of that type from their dining room to the bag." +
                " If any player has fewer than 3 students of that type, return as many students as they have ");
        setUsePhase(PhaseType.MOVEMENT);
        setAvailable(true);
    }


    public void choose(String colour) throws ActionException{
     checkInput(colour);
     setAvailable(false);
     this.colour=Colour.valueOfName(colour);
    }

    @Override
    public void startEffect(){
        for(Player player: getGame().getPlayers()){
            if(player.getBoard().getColorRowSize(colour) < 3){
                for(Student student: player.getBoard().getColourRow(colour)){
                    player.getBoard().getColourRow(colour).remove(student);
                    getGame().getSack().insert(new Student(colour));
                }
            }
            else
            {
                for(int i = 0; i<3;i++){
                    player.getBoard().getColourRow(colour).remove(player.getBoard().getColorRowSize(colour)-1);
                    getGame().getSack().insert(new Student(colour));
                }
            }
        }
    }

    @Override
    public void endEffect() {
        setAvailable(true);
        increaseCost();
    }

    private void checkInput(String colour) throws ActionException{
        if(!Colour.checkStringToColour(colour)){
            throw new ActionException();
        }
    }

}
