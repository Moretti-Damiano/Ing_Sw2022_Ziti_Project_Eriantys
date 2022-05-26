package it.polimi.ingsw.Ziti.launcher.controller;

import it.polimi.ingsw.Ziti.launcher.messages.*;
import it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.*;
import it.polimi.ingsw.Ziti.launcher.messages.MessageToServer.*;
import it.polimi.ingsw.Ziti.launcher.messages.MessageToServer.CharacterMessage.*;
import it.polimi.ingsw.Ziti.launcher.networking.client.ObserverClient;
import it.polimi.ingsw.Ziti.launcher.networking.client.SocketClient;
import it.polimi.ingsw.Ziti.launcher.observer.ClientObservable;
import it.polimi.ingsw.Ziti.launcher.observer.InputObserver;
import java.io.IOException;
/**
 * This class observes cli and is observed by SocketClient
 * Is used to verify inputs and to bring messages to the server
 * Contains a reference to ClientMessageHandler that allows management of every message to Client
 * Methods "onUpdate" are used to create Message to Client
 * Take String as a parameters, if String should be an Integer it verifies it
 */
public class ClientController extends ClientObservable implements InputObserver {

    ClientMessageHandler clientMessageHandler;
    ObserverClient observerClient;

    public ClientController(ClientMessageHandler clientMessageHandler,ObserverClient ObserverClient){
        this.clientMessageHandler=clientMessageHandler;
        this.observerClient=ObserverClient;
    }

    /**
     * this method is used to bring "Messages to Client" from Server to cli
     */
    public void update(MessageToClient message){ message.handle(clientMessageHandler);}


    @Override
    public void onUpdateLogin(String nickname) {
        LoginMessage message;
        message=new LoginMessage(nickname);
        notifyObserver(obs->obs.send(message));
    }

    @Override
    public void onUpdateConnection(String address) {
        removeAllObservers(); //when starting a new cli, removes the previous socketClient
        SocketClient socketClient;
       try{
           socketClient=new SocketClient(address,observerClient);
           socketClient.connect();
           this.addObserver(socketClient);
           ConnectionSuccessfulMessage message;
           message=new ConnectionSuccessfulMessage(true);
           update(message);
       }catch(IOException e) {
           ErrorMessage message = new ErrorMessage("ClientController", "Generic IO Error");
           update(message);}
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
    public void onUpdateChooseCharacter0(String id) {
        if(isInt(id)) {
            Character0Message message;
            message = new Character0Message();
            notifyObserver(obs -> obs.send(message));

        }
        else{
            InputError message;
            message=new InputError("You didn't insert a numeric input! ");
            update(message);
        }

    }

    @Override
    public void onUpdateChooseCharacter1(String id, String island) {
        if (isInt(island)) {
            if (isInt(id)) {
                Character1Message message;
                message = new Character1Message(Integer.parseInt(island));
                notifyObserver(obs -> obs.send(message));

            } else {
                InputError message;
                message = new InputError("You didn't insert a numeric input for the id! ");
                update(message);
            }
        }else{
            InputError message;
            message = new InputError("You didn't insert a numeric input for the island! ");
            update(message);
        }
    }

    @Override
    public void onUpdateChooseCharacter2(String id) {
        if(isInt(id)) {
            Character2Message message;
            message = new Character2Message();
            notifyObserver(obs -> obs.send(message));

        }
        else{
            InputError message;
            message=new InputError("You didn't insert a numeric input! ");
            update(message);
        }

    }


    @Override
    public void onUpdateChooseCharacter3(String id) {
        if(isInt(id)) {
            Character3Message message;
            message = new Character3Message();
            notifyObserver(obs -> obs.send(message));

        }
        else{
            InputError message;
            message=new InputError("You didn't insert a numeric input! ");
            update(message);
        }

    }


    @Override
    public void onUpdateChooseCharacter4(String id, String colour) {
        if(isInt(id)) {
            Character4Message message;
            message = new Character4Message(colour);
            notifyObserver(obs -> obs.send(message));

        }
        else{
            InputError message;
            message=new InputError("You didn't insert a numeric input! ");
            update(message);
        }

    }


    @Override
    public void onUpdateChooseCharacter5(String id, String colour) {
        if(isInt(id)) {
            Character5Message message;
            message = new Character5Message(colour);
            notifyObserver(obs -> obs.send(message));

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
            //System.out.println("E un numero");
            NumberOfPlayersMessage m;
            m=new NumberOfPlayersMessage(Integer.parseInt(numberOfPlayer));
            notifyObserver(obs -> obs.send(m));
           // System.out.println("Ho mandato il messaggio");
        }
        else{
            InputError message;
            message=new InputError("You didn't insert a numeric input! ");
            update(message);
            clientMessageHandler.NumOfPlayerRequestHandle(new NumOfPLayersRequest());

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

    @Override
    public void onUpdateDisconnection(DisconnectionRequest message) {
        notifyObserver(obs->obs.disconnect());
    }

    @Override
    public void onUpdateShowAndIslandRequest(ShowBoardsandIslandsRequest message) {
        notifyObserver(obs->obs.send(message));
    }

    @Override
    public void onUpdateMode(String mode) {
        ModeResponse message;
        message=new ModeResponse(mode);
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
