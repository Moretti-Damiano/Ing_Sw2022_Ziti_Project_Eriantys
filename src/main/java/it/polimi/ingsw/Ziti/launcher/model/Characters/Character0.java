package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.action.MoveToTable;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.model.Game;
import it.polimi.ingsw.Ziti.launcher.model.Mother;
import it.polimi.ingsw.Ziti.launcher.model.Student;
/*
During this turn, you take control of any number of professor even if you have the same number of student as the player who controls them
 */


public class Character0 extends Character{

    private static Character0 instance;

    public static Character0 getInstance(){
        if (instance == null) instance = new Character0();
        return instance;
    }

    private Character0() {
        setCost(2);
        setDescription(" During this turn, you take control of any number of professor even if you have the same number of student as the player who controls them\n ");
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
