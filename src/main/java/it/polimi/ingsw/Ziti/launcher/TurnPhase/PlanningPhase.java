package it.polimi.ingsw.Ziti.launcher.TurnPhase;

import it.polimi.ingsw.Ziti.launcher.controller.TurnController;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.model.Player;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class PlanningPhase extends Phase{

    private int playersDone;

    public PlanningPhase(TurnController turnController) {
        super(turnController, PhaseType.PLANNING);
        playersDone = 0;
    }

    @Override
    public void update() {
        playersDone++;
        getTurncontroller().setNextPlayer();
        // Every player chose an assistant
        if (playersDone == getTurncontroller().getPlayers().size()) {
            // Put in Order used to set the real order of the next player
            getTurncontroller().setOrderPlayers(putInOrder(getTurncontroller().getPlayerAssistants()));

            getTurncontroller().setCurrentPlayer(getTurncontroller().getOrderPlayers().get(0));
            nextPhase();
        }
    }

    @Override
    public void nextPhase() {
        getTurncontroller().setPhase(new MovementPhase(getTurncontroller()));
    }

    /**
     * Used to set the real order of the next player
     * @param map is a map of each assistant-players chosen
     * @return the real order of players
     */
    private ArrayList<Player> putInOrder(Map<Integer,Player> map){
        Map<Integer,Player> orderMap = new TreeMap<>(map);
        ArrayList<Player> inOrder = new ArrayList<>();

        for(Map.Entry<Integer,Player> entry : orderMap.entrySet()){
            inOrder.add(entry.getValue());
        }
        map.clear();
        return inOrder;
    }

}
