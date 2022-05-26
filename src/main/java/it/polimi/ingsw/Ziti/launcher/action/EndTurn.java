package it.polimi.ingsw.Ziti.launcher.action;
import it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.ActionMessage.ActionMessage;
import it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.ActionMessage.EndTurnDoneMessage;
import it.polimi.ingsw.Ziti.launcher.model.game.Game;

import java.util.stream.IntStream;

/**
 * This action implements last things to do in a match turn such as re-fill CloudIslands and set used Assistants
 **/
public class EndTurn implements Action {

   private final Game game;
   private String description = "";


   public EndTurn(Game game) {
      this.game = game;

   }
   @Override
   public void execute(){

       // for each CloudIsland calls the method toFill (if the sack isn't empty)
       if(!game.getSack().isEmpty())
           IntStream.range(0, game.getCloudIslands().size()).forEach(i -> game.getCloudIslands().get(i).toFill());
       // for each Player set false actual Assistants
       IntStream.range(0, game.getPlayers().size()).forEach(i -> game.getPlayers().get(i).getAssChosen().setActual(false));
       // for each Player set true used Assistants
       IntStream.range(0, game.getPlayers().size()).forEach(i -> game.getPlayers().get(i).getAssChosen().setAssChose(true));
       // for each Player set actualAssistant as null
       IntStream.range(0, game.getPlayers().size()).forEach(i -> game.getPlayers().get(i).setAssChoosed(null));
       // for each player set usedACharacter to false
       IntStream.range(0, game.getPlayers().size()).forEach(i -> game.getPlayers().get(i).setUsedACharacter(false));

       description = " The turn has ended ";
   }

    @Override
    public ActionMessage toMessage() {
        return new EndTurnDoneMessage(description,game.getIslands(),game.getBoards(),game.getCloudIslands());
    }

    @Override
    public void addDescription(String s) {
    }

    @Override
    public void checkInput(){}



}