package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.action.MoveToTable;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.model.Student;
/*
During this turn, you take control of any number of professor even if you have the same number of student as the player who controls them
 */


public class Character0 extends Character{

    public Character0() {
        super();
        setId(0);
        setCost(2);
        setDescription(" During this turn, you take control of any number of professor even if you have the same number of student as the player who controls them\n ");
        setAvailable(true);
        getUsePhase().add(PhaseType.MOVEMENT);
        getUsePhase().add(PhaseType.MOTHER);
        setEndPhase(PhaseType.CLOUD);
    }

    public void choose(){
    }

    @Override
    public void startEffect() {
        setUsed(true);
        for(Colour colour:Colour.values()){
            if(getGame().getCurrentPlayer().getBoard().getColorRowSize(colour) > 0){

            getGame().getCurrentPlayer().getBoard().addStudenttoColourRow(new Student(colour));

            MoveToTable movetotable=new MoveToTable(getGame(),colour.getName());
            movetotable.controlProfessor(colour);
            }
        }
    }

    @Override
    public void endEffect() {
        for(Colour colour:Colour.values()){
            if(getGame().getCurrentPlayer().getBoard().getColorRowSize(colour) > 0){
            getGame().getCurrentPlayer().getBoard().removeStudentfromColourRow(colour);
            MoveToTable movetotable = new MoveToTable(getGame(), colour.getName());
            movetotable.controlProfessor(colour);
            }
        }
        setAvailable(true);
        setUsed(false);
    }
}
