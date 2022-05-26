package it.polimi.ingsw.Ziti.launcher.networking.client;

import it.polimi.ingsw.Ziti.launcher.messages.*;
import it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.MessageToClient;
import it.polimi.ingsw.Ziti.launcher.observer.*;

/**
 * This class has a reference to Client Message Handler that will handle messages to client
 * Observes Socket Client
 *
 */
public class ObserverClient implements SocketClientObserver {

    private ClientMessageHandler clientMessageHandler;
    public ObserverClient(ClientMessageHandler clientMessageHandler){
        this.clientMessageHandler=clientMessageHandler;
    }


    /**
     * Method used to handle messages to client
     * @param message used to call the handle in Client Message Handler
     */
    public void update(MessageToClient message){

        message.handle(clientMessageHandler);}

}

