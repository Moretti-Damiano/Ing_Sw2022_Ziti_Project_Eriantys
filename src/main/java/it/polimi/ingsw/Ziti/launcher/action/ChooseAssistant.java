package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.ActionMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.ChooseAssistantDoneMessage;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.Assistant;
import it.polimi.ingsw.Ziti.launcher.model.Game.Game;
import it.polimi.ingsw.Ziti.launcher.model.Player;
/**
 * This action is used to Choose an Assistant in the game
 */
public class ChooseAssistant implements Action {
    private Game game;
    private int assistantID;
    private Player player;
    private String description="";

    public ChooseAssistant (Game game, Player player,int assistantID){
        this.game=game;
        this.assistantID=assistantID;
        this.player=player;
    }

    /**
     * Check if AssistantId has a valid value (between 0 and 9)
     * @throws ActionException
     */

    private void ValidID () throws ActionException {
        if(assistantID<0||assistantID>9){
            throw new ActionException();
        }
    }

    /**
     * This method is used in a particular case : when for all the 3 players,
     * all the remaining AssistantCard are taken by other players. In this case two (or more) player
     *can use the same AssistantCard
     * @throws ActionException
     */
    private void ThreePlayerCase ()throws ActionException{
            int count=0;
            for(Assistant assistant: this.player.getAssistants()){
                if(checkUsed(player,assistant.getId())){
                    count++;
                }
            }
            for(Player px: game.getPlayers()){
                if(!checkName(px) && px.getAssChosen()!=null && px.getAssChosen().getId() == assistantID){
                    if(count>7){
                        for(Assistant assistant: px.getAssistants()){
                            if(!checkTaken(px,assistant.getId()) && !checkUsed(player,assistant.getId())){
                                for(Player p2:game.getPlayers()){
                                    if(p2!=px && !checkName(p2)){
                                        if(!checkTaken(p2,assistant.getId())){
                                            throw new ActionException();
                                        }
                                    }
                                }
                            }
                        }
                    }else throw new ActionException();
                }
            }

    }

    /**
     * Check if the assistant can be chosen by the actual player then set the field of his actual assistant as "in use" and "already taken"
     * Also Check if the player can chase an assistant already taken by another player
     */
    @Override
    public void execute()throws ActionException {
        ValidID();
        if(game.getPlayers().size()==2){
        if(checkParticularCase()){
            if(!checkUsed(player,assistantID)){
                SetAssistant();
            }else throw new ActionException();
        }else{
            checkValidate();
            SetAssistant();
        }
    }else
        {   if(game.getPlayers().size()==3){
            if(checkUsed(player,assistantID))throw new ActionException();
            ThreePlayerCase();
            SetAssistant();
            }
        }
    }


    /**
     *
     * @return true if the actual player has already chosen 9/10 assistants
     */

    private boolean checkParticularCase() {
        int count=0;
        for(Assistant ass: this.game.getCurrentPlayer().getAssistants()){
            if(ass.isAssChose()){count++;}
        }
        if(count==9){return true;}
        else {return false;}
    }

    @Override
    public ActionMessage toMessage() {

        return new ChooseAssistantDoneMessage(this.description, player.getAssistants(),game.getCurrentPlayer().GetName() );
    }

    @Override
    public void addDescription(String s) {

    }


    /**
     *
     * @return if the choice is valid
     */
    private void checkValidate() throws ActionException {

        for (Player p: this.game.getPlayers())
        {
            if(checkName(p) && checkUsed(p,assistantID)){
                throw new ActionException();

            }
            if(!checkName(p) && checkTaken(p,assistantID) ){
                throw new ActionException();
            }
        }
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

    /**
     * method used to set assistant as the actual assistant
     */

    private void SetAssistant(){
        player.setAssChoosed(player.getAssistants().get(assistantID));
        player.getAssistants().get(assistantID).setActual(true);
        player.getAssistants().get(assistantID).setAssChose(true);
        description=description.concat(game.getCurrentPlayer().GetName() + " chose the assistant with MotherNature Moves: " + player.getAssistants().get(assistantID).getMovesMother()
                + " and Value: " + player.getAssistants().get(assistantID).getValue());
    }
}
