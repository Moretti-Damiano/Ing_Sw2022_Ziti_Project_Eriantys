package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Class used to implement the Observer-Observable pattern between Server and GameController.
 * This class allows the GameController to be observed.
 */
public class GameControllerObservable {
    private final List<GameControllerObserver> observers = new ArrayList<>();

    /**
     * Adds an observer
     * @param observer is the new observer
     */
    public void addObserver(GameControllerObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer
     * @param observer is the removed observer
     */
    public void removeObserver(GameControllerObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all the observers with a message
     * @param message is the message sent to the observers
     */
    public void notifyObserver(MessageToClient message) {
        for (GameControllerObserver observer : observers) {
            observer.update(message);
        }
    }

    /**
     * Notifies all the observer with a message and a nickName
     * @param message the message to send to client
     * @param nickName the player who will receive the message
     */
    public void notifyObserver(MessageToClient message, String nickName) {
        for (GameControllerObserver observer : observers) {
            observer.update(message,nickName);
        }
    }
}
