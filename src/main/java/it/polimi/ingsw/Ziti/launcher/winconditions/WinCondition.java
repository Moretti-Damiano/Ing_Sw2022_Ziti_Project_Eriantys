package it.polimi.ingsw.Ziti.launcher.winconditions;

import it.polimi.ingsw.Ziti.launcher.controller.TurnController;
import it.polimi.ingsw.Ziti.launcher.exception.WinException;
import it.polimi.ingsw.Ziti.launcher.model.game.Game;
import it.polimi.ingsw.Ziti.launcher.model.Player;

/**
 * Abstract class used to implement win conditions via Strategy Pattern.
 * Every win condition in the game must extend this class.
 */
public abstract class WinCondition {

    private final TurnController turnController;
    private final Game game;

    public WinCondition(TurnController turnController) {
        this.turnController = turnController;
        this.game = turnController.getGameController().getGame();
    }

    public TurnController getTurnController() {
        return turnController;
    }

    public Game getGame() {
        return game;
    }

    /**
     * This method gets called only if one of the winConditions is verified.
     * It calculates the winning player, then throws a winexception containing the winner's name
     * @throws WinException containing the winner's name
     */
    public void chooseWinnerByTowers() throws WinException {
        Player winner = game.getPlayers().get(0);
        int towers = winner.getBoard().getTowerSize();

        for(Player p: game.getPlayers()){
            if(p.getBoard().getTowerSize() < towers){
                winner = p;
                towers = p.getBoard().getTowerSize();

            }
            if(p.getBoard().getTowerSize() == towers){
                if(p.getBoard().getProfessors().size() > winner.getBoard().getProfessors().size()){
                    winner = p;
                }
            }
        }
        throw new WinException(winner.GetName());
    }

    /**
     * Methods used by each winCondition class the check if the  game conditions are matched.
     * @throws WinException whe a player win
     */
    public abstract void check() throws WinException;
}
