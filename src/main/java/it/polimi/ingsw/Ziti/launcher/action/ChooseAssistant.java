package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.model.Assistant;
import it.polimi.ingsw.Ziti.launcher.model.Game;
import it.polimi.ingsw.Ziti.launcher.model.Player;

public class ChooseAssistant implements Action {
    private Game game;
    private int assistantID;
    private Player player;

    public ChooseAssistant (Game game, Player player,int assistantID){
        this.game=game;
        this.assistantID=assistantID;
        this.player=player;
    }

    /**
     * Check if the assistant can be chosen by the actual player then set the field of his actual assistant as "in use" and "already taken"
     * @return null
     */
    @Override
    public void execute() {

        if(checkValidate()){
            player.setAssChoosed(player.getAssistants().get(assistantID));
            player.getAssistants().get(assistantID).setActual(true);
            player.getAssistants().get(assistantID).setAssChose(true);
        }

    }

    /**
     *
     * @return if the choice is valid
     */
    private boolean checkValidate(){

        for (Player p: this.game.getPlayers())
        {
            if(checkName(p) && checkUsed(p,assistantID)){
                return false;
            }
            if(!checkName(p) && checkTaken(p,assistantID) ){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param p represents a generic player
     * @return if the field "name" of p is the same of actual player ones
     */
    private boolean checkName(Player p){
        return p.GetName().equals(this.player.GetName());
    }

    /**
     *
     * @param p represents a generic player
     * @param ass represents a generic assistant
     * @return if p already used this assistant
     */
    private boolean checkUsed(Player p, int ass){
        return p.getAssistants().get(ass).isAssChose();
    }

    /**
     *
     * @param p represents a generic player
     * @param ass represents a generic assistant
     * @return if p is using this assistant
     */
    private boolean checkTaken(Player p, int ass){
        return p.getAssistants().get(ass).isActual();
    }
}
