package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.action.MoveToTable;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.model.Game;
import it.polimi.ingsw.Ziti.launcher.model.Student;
/*
Durante questo turno, prendi il controllo dei Professori anche se nella tua Sala hai lo stesso numero
 di Studenti del giocatore che li controlla in quel momento
 */


public class Character0 extends Character{

    public Character0(Game game) {
        super(game);
        setCost(0);
        setAvailable(true);
        setUsePhase(PhaseType.MOTHER);
    }

    public void choose(){
        setAvailable(false);
    }

    //starta quando inizia movemother
    @Override
    public void startEffect() {
        for(Colour colour:Colour.values()){
            getGame().getCurrentPlayer().getBoard().addStudenttoColourRow(new Student(colour));
            MoveToTable movetotable=new MoveToTable(getGame(),colour.getName());
            movetotable.controlProfessor(colour);
        }

    }

    @Override
    public void endEffect() {
        for(Colour colour:Colour.values()){
            getGame().getCurrentPlayer().getBoard().removeStudentfromColourRow(new Student(colour));
            MoveToTable movetotable = new MoveToTable(getGame(), colour.getName());
            movetotable.controlProfessor(colour);
        }

        increaseCost();
        setAvailable(true);
    }
}
