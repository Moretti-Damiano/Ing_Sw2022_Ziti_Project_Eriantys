package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.model.*;

public class MoveToIsland implements Action{

    private Game game;
    private Island chosenIsland;
    private Colour studentColour;
    private Player player;


    public MoveToIsland(Game game, Player player, Island chosenIsland, Colour studentColour){
        this.game = game;
        this.chosenIsland = chosenIsland;
        this.studentColour = studentColour;
        this.player = player;

    }
    /**
     * Take a color of a waiting student from the Board of a Player and move it into an Island
     * */
    @Override
    public Object execute() {

        chosenIsland.addStudent(player.getBoard().removeStudent(studentColour));

        return null;
    }
}
