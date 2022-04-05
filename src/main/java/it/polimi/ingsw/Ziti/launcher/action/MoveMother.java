package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.model.Game;

public class MoveMother implements Action{
    private Game game;
    private int moves;

    public MoveMother(Game game, int moves){
        this.game = game;
        this.moves = moves;
    }

    @Override
    public Object execute() {

    }
}
