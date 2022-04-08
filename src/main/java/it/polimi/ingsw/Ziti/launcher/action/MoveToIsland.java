package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.model.*;

public class MoveToIsland implements Action{

    private Game game;
    private Island chosenIsland;
    private Colour studentColour;


    public MoveToIsland(Game game, Island chosenIsland, Colour studentColour){
        this.game = game;
        this.chosenIsland = chosenIsland;
        this.studentColour = studentColour;

    }
    /**
     * Take a color of a waiting student from the Board of a Player and move it into an Island
     * */
    @Override
    public void execute() {

        chosenIsland.addStudent(game.getCurrentPlayer().getBoard().removeStudent(studentColour));

    }
}
