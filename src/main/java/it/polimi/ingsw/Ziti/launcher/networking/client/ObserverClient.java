package it.polimi.ingsw.Ziti.launcher.networking.client;

import it.polimi.ingsw.Ziti.launcher.Messages.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.MessageToClient;
import it.polimi.ingsw.Ziti.launcher.observer.*;

/**
 * This class has a reference to Client Message Handler that will handle messages to client
 * Observes Socket Client
 *
 */
public class ObserverClient implements SocketClientObserver {

    ClientMessageHandler clientMessageHandler;



    public void update(MessageToClient message){ message.handle(clientMessageHandler);}

}

