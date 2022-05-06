package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.model.Game;
import it.polimi.ingsw.Ziti.launcher.model.Student;
/*
Scegli un'isola e calcola la maggioranza come se Madre Natura avesse terminato il suo movimento lì.
 In questo turno Madre Natura si  muoverà come di consueto e nell'Isola dove terminarà il suo movimento
 la maggioranza verrà normalmente calcolata.
 */
public class Character0 extends Character{

    protected Character0(Game game) {
        super(game);
        setCost(0);
        setUsePhase(PhaseType.MOTHER);
    }



    //starta quando inizia movemother
    @Override
    public void startEffect() {
        for(Colour colour:Colour.values()){
            getGame().getCurrentPlayer().getBoard().addStudenttoColourRow(new Student(colour));
        }
    }

    @Override
    public void endEffect() {
        for(Colour colour:Colour.values()){
            getGame().getCurrentPlayer().getBoard().removeStudentfromColourRow(new Student(colour));
        }
    }
}
