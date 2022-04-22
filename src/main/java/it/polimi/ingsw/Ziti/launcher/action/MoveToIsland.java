package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.*;


/*
* This action is used to move a student from the Board to a chosen Island
* */
public class MoveToIsland implements Action{

    private Game game;
    private Island chosenIsland;
    private Colour studentColour;

    public MoveToIsland(Game game, Island chosenIsland, Colour studentColour) {

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
        try{
            checkInput();
            chosenIsland.addStudent(game.getPlayers().get(0).getBoard().removeStudent(studentColour));
        }
        catch (ActionException exception) {
            //System.out.println("There are no students with that colour in your waiting room ");
            //System.out.println("Please insert a valid colour");

        }
    }

    private void checkInput() throws ActionException{
        // check if the Island's ID's right

        // also if(chosenIsland.getID() != game.getIslands().indexOf(chosenIsland))
        if(chosenIsland.getID() < game.getIslands().get(0).getID()  || chosenIsland.getID() > game.getIslands().size())
            throw new ActionException();
        // check if the studentColour is in the Board
        if( ! game.getPlayers().get(0).getBoard().checkpresence(studentColour) )
            throw new ActionException();

    }
}
