package it.polimi.ingsw.Ziti.launcher.controller;

import it.polimi.ingsw.Ziti.launcher.Messages.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.InputError;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.MessageToClient;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.*;
import it.polimi.ingsw.Ziti.launcher.observer.ClientObservable;
import it.polimi.ingsw.Ziti.launcher.observer.InputObserver;

/**
 * This class observes cli and is observed by SocketClient
 */


public class ClientController extends ClientObservable implements InputObserver {

    ClientMessageHandler clientMessageHandler;

    /**
     * this method is used to bring Messages to Client from Server to cli
     */

    public void update(MessageToClient message){ message.handle(clientMessageHandler);}



    @Override
    public void onUpdateLogin(String nickname) {
        LoginMessage message;
        message=new LoginMessage("cli",nickname);
        notifyObserver(obs->obs.send(message));
    }

    @Override
    public void onUpdateChooseAssistant(String id) {
        if(isInt(id)) {
            ChooseAssistantMessage m;
            m=new ChooseAssistantMessage("cli",Integer.parseInt(id));
            notifyObserver(obs -> obs.send(m));
        }
        else{
            InputError message;
            message=new InputError("You didn't insert a numeric input! ");
            update(message);
        }


    }

    @Override
    public void onUpdateCloudIsland(String id) {
        if(isInt(id)) {
            CloudIslandMessage m;
            m=new CloudIslandMessage("cli",Integer.parseInt(id));
            notifyObserver(obs -> obs.send(m));
        }
        else{
            InputError message;
            message=new InputError("You didn't insert a numeric input! ");
            update(message);
        }


    }

    @Override
    public void onUpdateMoveMother(String moves) {
        if(isInt(moves)) {
            MoveMotherMessage m;
            m=new MoveMotherMessage("cli",Integer.parseInt(moves));
            notifyObserver(obs -> obs.send(m));
        }
        else{
            InputError message;
            message=new InputError("You didn't insert a numeric input! ");
            update(message);
        }


    }

    @Override
    public void onUpdateMoveToIsland(String colour, String id) {
        if(isInt(id)) {
            MoveToIslandMessage m;
            m = new MoveToIslandMessage("cli", Integer.parseInt(id), colour);
            notifyObserver(obs -> obs.send(m));
        }
        else{
            InputError message;
            message=new InputError("You didn't insert a numeric input! ");
            update(message);
        }
    }

    @Override
    public void onUpdateMoveToTable(String colour) {
        MoveToTableMessage m;
        m=new MoveToTableMessage("cli",colour);
        notifyObserver(obs -> obs.send(m));

    }

    @Override
    public void onUpdateNumberOfPlayer(String numberOfPlayer) {
        if(isInt(numberOfPlayer)) {
            NumberOfPlayersMessage m;
            m=new NumberOfPlayersMessage("cli",Integer.parseInt(numberOfPlayer));
            notifyObserver(obs -> obs.send(m));
        }
        else{
            InputError message;
            message=new InputError("You didn't insert a numeric input! ");
            update(message);
        }
    }

    private Boolean isInt (String value){
        try{
            int intValue=Integer.parseInt(value);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
