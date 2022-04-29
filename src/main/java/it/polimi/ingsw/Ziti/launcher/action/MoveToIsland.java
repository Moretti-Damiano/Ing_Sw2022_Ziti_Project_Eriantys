package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.Messages.ActionMessage;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.*;

import java.util.Locale;


/*
* This action is used to move a student from the Board to a chosen Island
* */
public class MoveToIsland implements Action{

    private Game game;
    private int chosenIsland;
    private String studentColour;

    public MoveToIsland(Game game, int chosenIsland, String studentColour) {

        this.game = game;
        this.chosenIsland = chosenIsland;
        this.studentColour = studentColour;

    }

    /**
     * Take a color of a waiting student from the Board of a Player and move it into an Island
     * @throws ActionException
     */
    @Override
    public void execute() throws ActionException {
        checkInput();
        Island island = game.getIslandbyId(chosenIsland);
        island.addStudent(game.getCurrentPlayer().getBoard().removeStudent(Colour.valueOf(studentColour.toLowerCase(Locale.ROOT))));

    }

    @Override
    public ActionMessage toMessage() {
        return null;
    }

    /**
     * checks if the given island id is valid
     * @return
     */
    private boolean checkId(){
        for(Island i: game.getIslands()){
            if(i.getID() == chosenIsland){
                return true;
            }
        }
        return false;
    }

    private void checkInput() throws ActionException{
        // check if the island id is right
        if(!checkId())
            throw new ActionException();

        //check if studentColour is an actual colour
        if(!Colour.checkStringToColour(studentColour))
            throw new ActionException();


        // check if the studentColour is in the Board
        if( ! game.getCurrentPlayer().getBoard().checkpresence(Colour.valueOfName(studentColour.toLowerCase(Locale.ROOT))))
            throw new ActionException();


        // also if(chosenIsland.getID() != game.getIslands().indexOf(chosenIsland))
        //if(chosenIsland.getID() < game.getIslands().get(0).getID()  || chosenIsland.getID() > game.getIslands().size())
        //  throw new ActionException();
    }
}
