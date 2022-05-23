package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.ActionMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.MoveToIslandDoneMessage;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.*;
import it.polimi.ingsw.Ziti.launcher.model.Game.Game;

import java.util.Locale;


/*
* This action is used to move a student from the Board to a chosen Island
* */
public class MoveToIsland implements Action{

    private Game game;
    private int chosenIsland;
    private String studentColour;
    private String description = "";

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
        island.addStudent(game.getCurrentPlayer().getBoard().removeStudent(Colour.valueOfName(studentColour.toLowerCase(Locale.ROOT))));
        description=description.concat(game.getCurrentPlayer().GetName() + " moved a " + studentColour + " student to the island " + (chosenIsland) );
    }

    @Override
    public ActionMessage toMessage() {
        return new MoveToIslandDoneMessage(this.description, game.getIslands(), game.getCurrentPlayer().getBoard(),game.getCurrentPlayer().GetName());
    }

    @Override
    public void addDescription(String s) {

    }


    /**
     * checks if the given island id is valid
     * @return boolean
     */
    private boolean checkId(){
        for(Island i: game.getIslands()){
            if(i.getID() == chosenIsland){
                return true;
            }
        }
        return false;
    }

    public void checkInput() throws ActionException{
        // check if the island id is right
        if(!checkId())
            throw new ActionException();

        //check if studentColour is an actual colour
        if(!Colour.checkStringToColour(studentColour))
            throw new ActionException();

        // check if the studentColour is in the Board
        if( ! game.getCurrentPlayer().getBoard().checkpresence(Colour.valueOfName(studentColour.toLowerCase(Locale.ROOT))))
            throw new ActionException();

    }
}
