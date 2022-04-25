package it.polimi.ingsw.Ziti.launcher.controller;
import it.polimi.ingsw.Ziti.launcher.Messages.*;
import it.polimi.ingsw.Ziti.launcher.action.*;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.*;
import it.polimi.ingsw.Ziti.launcher.model.Player;
import it.polimi.ingsw.Ziti.launcher.networking.server.Server;
import it.polimi.ingsw.Ziti.launcher.observer.GameControllerObservable;
import it.polimi.ingsw.Ziti.launcher.observer.Observable;
import it.polimi.ingsw.Ziti.launcher.observer.Observer;
import it.polimi.ingsw.Ziti.launcher.observer.ServerObserver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class GameController extends GameControllerObservable implements ServerObserver {

    Game game;
    TurnController turnController;
    Server server;
    ArrayList<Player> players;

    public GameController(Server server){
        this.turnController = new TurnController();
        this.server = server;
        players = new ArrayList<>();
    }

    private Player getPlayerByName(String nickName){
        for(Player p:players){
            if(p.GetName().equals(nickName)){
                return p;
            }
        }
        return null;
    }

    public boolean checkActivePlayer(String player){
        return turnController.getCurrentPlayer().equals(getPlayerByName(player));
    }

    @Override
    public void moveToIslandHandler(MoveToIslandMessage message) {
        if(checkActivePlayer(message.getSender())){
        game.setAction( new MoveToIsland(game,message.getIslandID(),message.getColour().toLowerCase(Locale.ROOT)));
        try {
            game.doAction();
        } catch (ActionException e) {
            notifyObserver(new InputError("Invalid action request"),message.getSender());
        }
        }
        else{
            /* MANDA ERRORE NON E' IL TUO TURNO*/
        }

    }

    @Override
    public void moveToTableHandler(MoveToTableMessage message) {
        if(checkActivePlayer(message.getSender())){
            game.setAction(new MoveToTable(game,message.getColour().toLowerCase(Locale.ROOT)));
            try {
                game.doAction();
            } catch (ActionException e) {
                /*MANDA ERRORE AL CLIENT*/
            }
        }
        else{
            /* MANDA ERRORE NON E' IL TUO TURNO*/
        }
    }

    @Override
    public void moveMotherHandler(MoveMotherMessage message) {
        if(checkActivePlayer(message.getSender())){
            game.setAction(new MoveMother(game,message.getMoves()));
            try {
                game.doAction();
            } catch (ActionException e) {
                /*MANDA ERRORE AL CLIENT*/
            }
        }
        else{
            /* MANDA ERRORE NON E' IL TUO TURNO*/
        }
    }

    @Override
    public void choseAssistantHandler(ChoseAssistantMessage message) {
        if(checkActivePlayer(message.getSender())){
            game.setAction(new ChooseAssistant(game, turnController.getCurrentPlayer(),message.getAssistantId()));
            try{
                game.doAction();
            }
            catch (ActionException e){
                /*
                manda errore al client
                 */
            }
        }
        else{
            /*
            ERRORE NON è IL TUO TURNO
             */
        }

    }

    @Override
    public void cloudIslandHandler(CloudIslandMessage message) {
        if(checkActivePlayer(message.getSender())){
            game.setAction(new ChooseCloud(game,turnController.getCurrentPlayer(),message.getCloudId()));
            try{
                game.doAction();
            }
            catch(ActionException e){
                /*MANDA ERRORE AL CLIENT*/
            }
        }
        else{
            /*MANDA ERRORE NON E' IL TUO TURNO*/
        }
    }
}
