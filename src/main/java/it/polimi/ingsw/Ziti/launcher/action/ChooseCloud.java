package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.ActionMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.ChooseCloudDoneMessage;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.*;
import it.polimi.ingsw.Ziti.launcher.model.Game.Game;

/**
 * This action is used to Choose a Cloud Island in the game
 */
public class ChooseCloud implements Action{

    private Game game;
    private int chosenCloudId;
    private Player player;
    private CloudIsland chosenCloud;
    private String description = "";

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

            description = (game.getCurrentPlayer().GetName() + " has chose cloudIsland n. " + chosenCloud);

            for (Student s : chosenCloud.toEmpty())
                player.getBoard().addStudent(s);
    }

    @Override
    public ActionMessage toMessage() {
        return new ChooseCloudDoneMessage(description,game.getCloudIslands());
    }

    @Override
    public void addDescription(String s) {

    }


    /**
     * Check that input is correct
     * @throws ActionException
     */
    public void checkInput() throws ActionException {
        // verify chosenCloud's Id
        if(chosenCloudId < 0 || chosenCloudId > game.getCloudIslands().size()-1){
            System.out.println(" Cloud "+ chosenCloudId + " does not exist ");
            throw new ActionException();
        }
        // verify chosenCloud's Id
        if(!game.getCloudIslands().get(chosenCloudId).isAvailable()){
            System.out.println(" Cloud "+ chosenCloudId + " is not available ");
            throw new ActionException();
        }
    }
}
