package it.polimi.ingsw.Ziti.launcher.controller;

import it.polimi.ingsw.Ziti.launcher.Messages.*;
import it.polimi.ingsw.Ziti.launcher.observer.ClientObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ClientObserver;
import it.polimi.ingsw.Ziti.launcher.observer.InputObserver;

//Questa classe VIENE OSSERVATA dalla SocketClient e OSSERVA la cli

public class ClientController extends ClientObservable implements InputObserver {
    /**
     *
     * @param message is a "MessageToServer" used to ask information or to do an action
     */
    ClientMessageHandler clientMessageHandler;
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
            ChoseAssistantMessage m;
            m=new ChoseAssistantMessage("cli",Integer.parseInt(id));
            notifyObserver(obs -> obs.send(m));
        }
        else{
            InputError message;
            message=new InputError("Hai inserito un valore non numerico !");
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
            message=new InputError("Hai inserito un valore non numerico !");
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
            message=new InputError("Hai inserito un valore non numerico !");
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
            message=new InputError("Hai inserito un valore non numerico !");
            update(message);
        }
    }

    @Override
    public void onUpdateMoveToTable(String colour) {
        MoveToTableMessage m;
        m=new MoveToTableMessage("cli",colour);
        notifyObserver(obs -> obs.send(m));

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
