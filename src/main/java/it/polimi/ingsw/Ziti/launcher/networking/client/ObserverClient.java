package it.polimi.ingsw.Ziti.launcher.networking.client;

import it.polimi.ingsw.Ziti.launcher.Messages.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.MessageToClient;
import it.polimi.ingsw.Ziti.launcher.observer.*;

public class ObserverClient implements SocketClientObserver {

    ClientMessageHandler clientMessageHandler;
    //Questa classe OSSERVA il SocketClient

    //chiama il clientmessagehandler che gestirà i messaggi che arrivano dal server
    //funziona solo in mesaggi in ricezione dal server


    public void update(MessageToClient message){ message.handle(clientMessageHandler);}

}

