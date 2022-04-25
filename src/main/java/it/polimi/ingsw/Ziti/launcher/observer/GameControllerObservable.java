package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.*;

import java.util.ArrayList;
import java.util.List;

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
    public void notifyObserver(MessageToClient message, String nickName) {
        for (GameControllerObserver observer : observers) {
            observer.update(message,nickName);
        }
    }
}
