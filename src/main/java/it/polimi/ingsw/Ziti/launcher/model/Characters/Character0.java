package it.polimi.ingsw.Ziti.launcher.model.Characters;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.model.Game;
import it.polimi.ingsw.Ziti.launcher.model.Student;

public class Character0 extends Character{

    protected Character0(Game game) {
        super(game);
        setUsePhase(PhaseType.MOTHER);
    }

    @Override
    public void choose() {

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
