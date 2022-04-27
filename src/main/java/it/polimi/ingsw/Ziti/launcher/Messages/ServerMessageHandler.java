package it.polimi.ingsw.Ziti.launcher.Messages;

import it.polimi.ingsw.Ziti.launcher.observer.Observable;
import it.polimi.ingsw.Ziti.launcher.observer.ServerObservable;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * This class calls the correct handler methods from the observer class to manage the message received by the server
 */
public class ServerMessageHandler extends ServerObservable {

    public void loginHandler(LoginMessage message) throws ParserConfigurationException,IOException,SAXException{
        notifyObserver(obs -> obs.loginHandler(message));
    }

    public void moveToIslandHandler(MoveToIslandMessage message) {
        notifyObserver(obs -> obs.moveToIslandHandler(message));
    }

    public void moveToTableHandler(MoveToTableMessage message) {
        notifyObserver(obs -> obs.moveToTableHandler(message));
    }

    public void moveMotherHandler(MoveMotherMessage message) {
        notifyObserver(obs -> obs.moveMotherHandler(message));
    }

    public void choseAssistantHandler(ChoseAssistantMessage message) {
        notifyObserver(obs -> obs.choseAssistantHandler(message));
    }

    public void cloudIslandHandler(CloudIslandMessage message) {
        notifyObserver(obs -> obs.cloudIslandHandler(message));
    }

    public void numberOfPlayersHandler(NumberOfPlayersMessage message){
        notifyObserver(obs -> obs.numberOfPlayerHandler(message));
    }


}
