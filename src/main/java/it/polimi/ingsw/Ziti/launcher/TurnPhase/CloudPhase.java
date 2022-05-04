package it.polimi.ingsw.Ziti.launcher.TurnPhase;

import it.polimi.ingsw.Ziti.launcher.action.EndTurn;
import it.polimi.ingsw.Ziti.launcher.controller.TurnController;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;

public class CloudPhase extends Phase{
    public CloudPhase(TurnController turnController) {
        super(turnController, PhaseType.CLOUD);
    }

    @Override
    public void update() {
        if (getTurncontroller().getPlayersDone() == getTurncontroller().getPlayers().size()) {
            getTurncontroller().getGameController().getGame().setAction(new EndTurn(getTurncontroller().getGameController().getGame()));
            // If every player completed his turn, Game controller calls EndTurn action
            try {
                getTurncontroller().getGameController().getGame().doAction();
            } catch (ActionException e) {
                e.printStackTrace(); //non verrà mai chiamata perchè chiamo solo endturn
            }
            getTurncontroller().setCurrentPlayer(getTurncontroller().getOrderPlayers().get(0)); //first player for next round
            nextPhase(); //rientro fase planning

        }
        else {
            addPlayersDone();
            getTurncontroller().setNextPlayer();
            getTurncontroller().setPhase(new MovementPhase(getTurncontroller()));
        }
    }

    @Override
    public void nextPhase() {
        getTurncontroller().setPhase(new PlanningPhase(getTurncontroller()));
    }
}
