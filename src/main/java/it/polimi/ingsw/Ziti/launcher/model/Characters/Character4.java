package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.Game;
import it.polimi.ingsw.Ziti.launcher.model.Player;
import it.polimi.ingsw.Ziti.launcher.model.Student;

/*
Scegli un colore di studente, ogni giocatore incluso te, deve rimetttere nel sacchetto 3 studenti di quel colore presenti
nella sala; chi ne ha meno, li rimette tutti.
 */
public class Character4 extends Character{

    private Colour colour;

    protected Character4(Game game) {
        super(game);
        setCost(3);
        setUsePhase(PhaseType.MOTHER);
    }


    public void choose() {

    }

    @Override
    public void startEffect(){
        for(Player player: getGame().getPlayers()){
            if(player.getBoard().getColorRowSize(colour) < 3){
                for(Student student: player.getBoard().getColourRow(colour)){
                    player.getBoard().getColourRow(colour).remove(student);
                    getGame().getSack().insert(new Student(colour));
                }
            }
            else
            {
                for(int i = 0; i<3;i++){
                    player.getBoard().getColourRow(colour).remove(player.getBoard().getColorRowSize(colour)-1);
                    getGame().getSack().insert(new Student(colour));
                }
            }
        }
    }

    @Override
    public void endEffect() {
        //nothing to do
    }
}
