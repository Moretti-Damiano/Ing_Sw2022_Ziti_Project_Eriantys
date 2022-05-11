package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.ActionMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.MoveMotherDoneMessage;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.*;
import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;

import static java.util.Objects.isNull;

/**
 * This Action takes 2 parameters, the game instance and number of moves that the mother can do
 * Functions: checks valid input, if not valid it returns an exception
 *            checks if an island will change players
 *            updates the tower on the island and on player's board
 *            can merge islands
 */
public class MoveMother implements Action {
    private Game game;
    private int moves;
    private Mother mother;
    private String description = "";
    private Boolean checkInput;


    public MoveMother(Game game, int moves,boolean checkInput) {
        this.game = game;
        this.moves = moves;
        this.mother = Mother.motherInstance();
        this.checkInput = checkInput;
    }

    /**
     * This action moves the Mother of nature
     * @throws ActionException
     */
    @Override
    public void execute() throws ActionException {
        if(checkInput)
            checkInput();

        move();
        if(!checkInput)
            description = description.concat("Action called by character\n");

        description = description.concat(game.getCurrentPlayer().GetName() + "moved the Mother to Island (id): " + mother.getIsland().getID());
        updateIsland(mother.getIsland(), getControl(mother.getIsland()));

        if (mother.getIsland().getTowerPlayer() == null) {
            description = description.concat("\nIsland(id) " + mother.getIsland().getID() + " is still controlled by nobody");
        } else
            description = description.concat("\nIsland(id) " + mother.getIsland().getID() + " is now under control of : " + mother.getIsland().getTowerPlayer().GetName());

        if (checkMerge(mother.getIsland(), game.getNextIsland(mother.getIsland()))) {
            description = description.concat("\nMerged Island " + mother.getIsland().getID() + " with Island " + game.getNextIsland(mother.getIsland()).getID());
            merge(mother.getIsland(), game.getNextIsland(mother.getIsland()));
        }
        if (checkMerge(mother.getIsland(), game.getPrevIsland(mother.getIsland()))) {
            description = description.concat("\nMerged Island " + mother.getIsland().getID() + " with Island " + game.getPrevIsland(mother.getIsland()).getID());
            merge(mother.getIsland(), game.getPrevIsland(mother.getIsland()));
        }
    }

    @Override
    public ActionMessage toMessage() {
        return new MoveMotherDoneMessage(this.description, game.getIslands());
    }


    /**
     * Calculate mother current position and assign mother her new island
     */
    private void move() {
        mother.getIsland().removeMother();
        int newPosition = (game.getIslands().indexOf(mother.getIsland()) + moves) % (game.getIslands().size());
        mother.setIsland(game.getIslands().get(newPosition));
        mother.getIsland().addMother();
    }

    /**
     * changes all the tower and the island with the new player's ones
     *
     * @param island
     * @param player is the new owner of the island, is passed by getControl. has value null when
     *               the new player has the same points as the old one
     */
    private void updateIsland(Island island, Player player) {
        System.out.println("In updateisland:");
        if (island.getTowerPlayer() != player && !isNull(player)) {
            for (Tower T : island.getTowers()) {
                if (!isNull(island.getTowerPlayer())) {
                    island.getTowerPlayer().getBoard().addTower(new Tower(island.getTowerPlayer(),island.getTowerPlayer().getBoard().getTower_colour())); //give back all towers to old towerplayer
                }
            }

            int size = island.getTowers().size();
            island.getTowers().clear();
            island.setTowerPlayer(player);

            if(size == 0){
                island.getTowers().add(player.getBoard().removeTower());
            }
            else{
                for (int i = 0; i < size; i++) {
                    System.out.println("Removing tower from " + player.GetName());
                    island.getTowers().add(player.getBoard().removeTower());
                }
            }
        }
    }

    /**
     * @param island
     * @return the player with most influence on the island
     * if more than 1 players have the same max influence, this methods returns a 'null' player
     */
    private Player getControl(Island island) {
        int max = 0;
        int infl;
        Player maxPlayer = game.getPlayers().get(0);  //initialize to first player
        for (Player p : game.getPlayers()) {
            infl = 0;
            if (p.equals(island.getTowerPlayer())) {      //adds towers influence points to the TowerPlayer
                infl += island.getTowers().size();
            }
            for (Professor prof : p.getBoard().getProfessors()) {      //for each professor of the players, count how many students with the same colour
                infl += island.getColour(prof.getColour());
            }
            if (infl == max) {
                maxPlayer = null;
            }
            if (infl > max) {
                max = infl;
                maxPlayer = p;
            }
        }
        return maxPlayer;
    }

    /**
     * checks if island1 and island2 can be merged
     *
     * @param island1
     * @param island2
     * @return true if the islands can be merged, else false
     */
    public boolean checkMerge(Island island1, Island island2) {
        return (island1.getTowerPlayer() == (island2.getTowerPlayer())) && island1.getTowerPlayer() != null;
    }


    /**
     * Merges two islands into one
     *
     * @param island1 is the 'main' island that will be updated
     * @param island2 will be deleted after the merge
     */
    public void merge(Island island1, Island island2) {
        System.out.println("Merging island " + island1.getID() + " with island " + island2.getID());
        island1.getStudents().addAll(island2.getStudents());
        island1.getTowers().addAll(island2.getTowers());
        game.getIslands().remove(island2);
    }

    // checks input of moves
    private void checkInput() throws ActionException {
        if (moves < 1 || moves > game.getCurrentPlayer().getAssChosen().getMovesMother())
            throw new ActionException();

    }
}
