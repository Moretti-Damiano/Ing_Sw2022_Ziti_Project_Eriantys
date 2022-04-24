package it.polimi.ingsw.Ziti.launcher.controller;
import it.polimi.ingsw.Ziti.launcher.Messages.Message;
import it.polimi.ingsw.Ziti.launcher.action.*;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.*;
import it.polimi.ingsw.Ziti.launcher.model.Player;
import it.polimi.ingsw.Ziti.launcher.networking.server.Server;
import it.polimi.ingsw.Ziti.launcher.observer.Observable;
import it.polimi.ingsw.Ziti.launcher.observer.Observer;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class GameController implements Observer {

    Game game;
    Server server;
    ArrayList<Player> players;

    public GameController(Server server){
        this.server = server;
        players = new ArrayList<>();
    }

    //se al GameController il messaggio va bene, chiama la action (controlla player attivo e turno corretto)
    public void menageMessage(Message message){
        /*switch (message.getMessageType()){
            case LOGIN:
                try{
                players.add(new Player(message.getBody()));
                //ECCEZIONI DA SISTEMARE
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                }
                break;

            case CHOOSEASSISTANT:
                //DA RIVEDERE -> DOVE PRENDO ASSISTANT?
                //game.setAction(new ChooseAssistant(game,getPlayerByName(message.getSender()),);
                break;

            case CHOOSECLOUD:
                game.setAction(new ChooseCloud(game,getPlayerByName(message.getSender()),Integer.parseInt(message.getBody())));
                try {
                    game.doAction();
                } catch (ActionException e) {/*MANDA ERRORE AL CLIENT}
                break;

            case MOVEMOTHER:
                game.setAction(new MoveMother(game,Integer.parseInt(message.getBody())));
                try {
                    game.doAction();
                } catch (ActionException e) {/*MANDA ERRORE AL CLIENT}
                break;

            case MOVETOISLAND:
                String[] body = message.getBody().split(" ");

                Island chosenIsland = game.getIslands().get(Integer.parseInt(body[0]));
                Colour chosenColour = Colour.valueOfName(body[1]);

                game.setAction(new MoveToIsland(game,chosenIsland,chosenColour));
                try {
                    game.doAction();
                } catch (ActionException e) {
                    /*MANDA ERRORE AL CLIENT
                }
                break;

            case MOVETOTABLE:
                break;
        }*/

    }

    private Player getPlayerByName(String nickName){
        for(Player p:players){
            if(p.GetName().equals(nickName)){
                return p;
            }
        }
        return null;
    }

    @Override
    public void update(Message message) {

    }

    public void onUpdateTest(Message message){

    }
}
