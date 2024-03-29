package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.ActionMessage.ActionMessage;
import it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.ActionMessage.MoveToTableDoneMessage;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.game.Game;
import it.polimi.ingsw.Ziti.launcher.model.Player;

import java.util.Locale;

/**
 * This action is used to Move a student from the waiting room to the dining room
 */
public class MoveToTable implements Action{

    private final Game game;
    private final String chosenColour;
    private String description = "";


    public MoveToTable(Game game, String chosenColour){
        this.game=game;
        this.chosenColour=chosenColour;
    }
    @Override
    public void execute() throws ActionException{
        checkInput();
        this.goLunch(Colour.valueOfName(chosenColour.toLowerCase(Locale.ROOT)));
        this.controlProfessor(Colour.valueOfName(chosenColour.toLowerCase(Locale.ROOT)));
    }

    @Override
    public ActionMessage toMessage() {
        return new MoveToTableDoneMessage(this.description,game.getCurrentPlayer().getBoard(),game.getCurrentPlayer().GetName());
    }

    @Override
    public void addDescription(String s) {
       description=description.concat(s);
    }

    /**
     * add a student to the row with the same colour and check if the new student is on a 'coin generator' position
     * @param student_colour the colour of the student to add
     */
    private void goLunch(Colour student_colour) {
        game.getCurrentPlayer().getBoard().addStudenttoColourRow(game.getCurrentPlayer().getBoard().removeStudent(student_colour));
        description=description.concat(game.getCurrentPlayer().GetName() + " moved a "+ chosenColour + " student from his waiting room to his dining room ");
        game.getGameMode().onCoin(student_colour,this);
        }



    /**
     * check if the player has the highest value of influence for the chosen colour, in this case adds the professor with the same colour to his board
     * @param professor_colour the colour of the professor to check
     */
    public void controlProfessor(Colour professor_colour){
        Player profplayer= game.checkProfessor(professor_colour);
        if(profplayer==null){
            game.getCurrentPlayer().getBoard().addProfessor(game.getProfessorbyColour(professor_colour));
            description=description.concat( game.getCurrentPlayer().GetName() + " now controls the " + chosenColour + " professor\n");
        }
        if(profplayer!=null && profplayer!=game.getCurrentPlayer()){
            if(checkInfluence(profplayer,professor_colour)){
                game.getCurrentPlayer().getBoard().addProfessor(profplayer.getBoard().removeProfessorByColour(professor_colour));
                description=description.concat(game.getCurrentPlayer().GetName() + " now controls the " + chosenColour + " professor");
            }
        }
    }

    /**
     *
     * @param profplayer the player who controls the professor of the specified colour
     * @param professor_colour the colour of the professor
     * @return true if the current player has an higher number of student in the row of the specified colour
     */
    private boolean checkInfluence(Player profplayer,Colour professor_colour){
        return game.getCurrentPlayer().getBoard().getColorRowSize(professor_colour) > profplayer.getBoard().getColorRowSize(professor_colour);
    }

    public void checkInput() throws ActionException{

        //check if the given string is a colour
        if(!Colour.checkStringToColour(chosenColour)){
            throw new ActionException();
        }

        //check if the player has a student available with the given colour
        if (!checkColour(Colour.valueOfName(chosenColour.toLowerCase(Locale.ROOT)))) {
            throw new ActionException();
        }
    }

    /**
     * check if the current player has a student with the specified colour that can be moved
     * @param colour the specified colour
     */
    private boolean checkColour(Colour colour){
        return game.getCurrentPlayer().getBoard().checkpresence(colour);
    }

}


