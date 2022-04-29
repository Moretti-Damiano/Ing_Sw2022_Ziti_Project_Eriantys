package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.Messages.ActionMessage;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
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
    }

    /**
     *Takes all the students from the chosen cloudIsland and adds them to the player's board
     * @return null
     */
    @Override
    public void execute() throws ActionException {
            checkInput();
            this.chosenCloud = game.getCloudIslands().get(chosenCloudId);
            for (Student s : chosenCloud.toEmpty())
                player.getBoard().addStudent(s);
    }

    @Override
    public ActionMessage toMessage() {
        return null;
    }

    private void checkInput() throws ActionException {
        if(chosenCloudId < 0 || chosenCloudId > game.getCloudIslands().size()-1){
            System.out.println("Cloud "+ chosenCloudId + " does not exist");
            throw new ActionException();
        }
        if(!game.getCloudIslands().get(chosenCloudId).isAvailable()){
            System.out.println("Cloud "+ chosenCloudId + " is not available");
            throw new ActionException();
        }
    }
}
