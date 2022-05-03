package it.polimi.ingsw.Ziti.launcher.controller;

import it.polimi.ingsw.Ziti.launcher.Messages.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ConnectionSuccessfulMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ErrorMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.InputError;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.MessageToClient;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.*;
import it.polimi.ingsw.Ziti.launcher.networking.client.ObserverClient;
import it.polimi.ingsw.Ziti.launcher.networking.client.SocketClient;
import it.polimi.ingsw.Ziti.launcher.networking.server.SocketServer;
import it.polimi.ingsw.Ziti.launcher.observer.ClientObservable;
import it.polimi.ingsw.Ziti.launcher.observer.InputObserver;
import javax.imageio.IIOException;
import java.io.IOException;
/**
 * This class observes cli and is observed by SocketClient
 * Is used to verify inputs and to bring message to the server
 */

public class ClientController extends ClientObservable implements InputObserver {

    ClientMessageHandler clientMessageHandler;
    SocketClient socketClient;
    ObserverClient observerClient;

    public ClientController(ClientMessageHandler clientMessageHandler,ObserverClient ObserverClient){
        this.clientMessageHandler=clientMessageHandler;
        this.observerClient=ObserverClient;
    }

    /**
     * this method is used to bring "Messages to Client" from Server to cli
     */

    public void update(MessageToClient message){ message.handle(clientMessageHandler);}


    /**
     * Methods "onUpdate" are used to create Message to Client
     * Take String as a parameters, if String should be an Integer it verifies it
     */

    @Override
    public void onUpdateLogin(String nickname) {
        LoginMessage message;
        message=new LoginMessage(nickname);
        notifyObserver(obs->obs.send(message));
    }

    @Override
    public void onUpdateConnection(String address, String port) {
        if(isInt(port)){
       try{socketClient=new SocketClient(address,Integer.parseInt(port),observerClient);
           Thread clientThread=new Thread(socketClient);
           clientThread.start();
           this.addObserver(socketClient);
           ConnectionSuccessfulMessage message;
           message=new ConnectionSuccessfulMessage(true);
           update(message);
       }catch(IOException e) {
           ErrorMessage message = new ErrorMessage("ClientController", "Generic IO Error");
           update(message);}
       }
        else{
                InputError message;
                message=new InputError("Not numeric value!");
                update(message);
            }
        }


    @Override
    public void onUpdateChooseAssistant(String id) {
        if(isInt(id)) {
            ChooseAssistantMessage m;
            m=new ChooseAssistantMessage(Integer.parseInt(id));
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
            m=new CloudIslandMessage(Integer.parseInt(id));
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
            m=new MoveMotherMessage(Integer.parseInt(moves));
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
            m = new MoveToIslandMessage( Integer.parseInt(id), colour);
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
        m=new MoveToTableMessage(colour);
        notifyObserver(obs -> obs.send(m));

    }

    @Override
    public void onUpdateNumberOfPlayer(String numberOfPlayer) {
        if(isInt(numberOfPlayer)) {
            System.out.println("E un numero");
            NumberOfPlayersMessage m;
            m=new NumberOfPlayersMessage(Integer.parseInt(numberOfPlayer));
            notifyObserver(obs -> obs.send(m));
            System.out.println("Ho mandato il messaggio");
        }
        else{
            InputError message;
            message=new InputError("You didn't insert a numeric input! ");
            update(message);
        }
    }


    @Override
    public void onUpdateAssistantRequest(ShowAssistantRequest message) {
        notifyObserver(obs->obs.send(message));
    }

    @Override
    public void onUpdateBoardRequest(ShowBoardRequest message) {
        notifyObserver(obs->obs.send(message));
    }

    @Override
    public void onUpdateBoardsRequest(ShowBoardsRequest message) {
        notifyObserver(obs->obs.send(message));
    }

    @Override
    public void onUpdateCharacterRequest(ShowCharacterRequest message) {
        notifyObserver(obs->obs.send(message));
    }

    @Override
    public void onUpdateCloudRequest(ShowCloudRequest message) {
        notifyObserver(obs->obs.send(message));
    }

    @Override
    public void onUpdateIslandRequest(ShowIslandRequest message) {
        notifyObserver(obs->obs.send(message));
    }
    /**
     * Check if the String is an Integer
     * @param value is the String that needs to be verified
     * @return boolean
     */
    private Boolean isInt (String value){
        try{
            int intValue=Integer.parseInt(value);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
