package it.polimi.ingsw.Ziti.launcher.action;
import it.polimi.ingsw.Ziti.launcher.Messages.ActionMessage;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.*;

import java.util.stream.IntStream;

/**
 * This action implements last things to do in a match turn such as re-fill CloudIslands and set used Assistants
 **/
public class EndTurn implements Action {

   private Game game;
   private String description;


   public EndTurn(Game game) {
      this.game = game;

   }

   @Override
   public void execute() throws ActionException {
      
         checkEmptyIslands();
         // for each CloudIsland calls the method toFill
         IntStream.range(0, game.getCloudIslands().size()).forEach(i -> game.getCloudIslands().get(i).toFill());
         // for each Player set false actual Assistants
         IntStream.range(0, game.getPlayers().size()).forEach(i -> game.getPlayers().get(i).getAssChosen().setActual(false));
         // for each Player set true used Assistants
         IntStream.range(0, game.getPlayers().size()).forEach(i -> game.getPlayers().get(i).getAssChosen().setAssChose(true));
         // for each Player set actualAssistant as null
         IntStream.range(0, game.getPlayers().size()).forEach(i -> game.getPlayers().get(i).setAssChoosed(null));

         description = "The turn has ended";

      }

    @Override
    public ActionMessage toMessage() {
        return null;
    }


    private void checkEmptyIslands() throws ActionException {
      // check if the Cloud Islands are empty
      for (CloudIsland cloudIsland : game.getCloudIslands()) {
         if(! cloudIsland.getStudents().isEmpty() ) throw new ActionException();
      }
   }
}