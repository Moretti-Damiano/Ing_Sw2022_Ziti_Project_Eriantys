package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.model.*;

public class ChooseCloud implements Action{

    private Game game;
    private int chosenCloudId;
    private Player player;
    private CloudIsland chosenCloud;

    public ChooseCloud(Game game, Player player , int chosenCloudId){
        this.game = game;
        this.player = player;
        this.chosenCloudId = chosenCloudId;
        this.chosenCloud = game.getCloudIslands().get(chosenCloudId);
    }

    /**
     *Takes all the students from the chosen cloudIsland and adds them to the player's board
     * @return null
     */
    @Override
    public void execute() {
        for(Student s: chosenCloud.toEmpty())
        player.getBoard().addStudent(s);

    }
}
