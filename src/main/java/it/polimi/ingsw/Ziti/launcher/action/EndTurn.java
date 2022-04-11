package it.polimi.ingsw.Ziti.launcher.action;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.*;

import java.util.stream.IntStream;

/*
 *This action implements last things to do in a match turn such as re-fill CloudIslands and set used Assistants
 **/
public class EndTurn implements Action{

   private Game game;
   private Player player;


   public EndTurn (Game game, Player player){
      this.game = game;
      this.player = player;
   }

   @Override
   public void execute() throws ActionException {

      try{
         checkInput();
      }
      catch (ActionException exc) {
         //TO DO
      }
      finally{
         //TO DO
      }
      // for each CloudIsland calls the method toFill
      IntStream.range(0, game.getCloudIslands().size()).forEach(i -> game.getCloudIslands().get(i).toFill());
      // for each Player set used Assistants
      IntStream.range(0, game.getPlayers().size()).forEach(i -> game.getPlayers().get(i).getAssChosen().setActual(false));

   }

   private void checkInput() throws ActionException{

   }
}
