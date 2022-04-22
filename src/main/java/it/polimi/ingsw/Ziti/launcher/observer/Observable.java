package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.ErrorMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.Message;
import it.polimi.ingsw.Ziti.launcher.Messages.MoveToIslandMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the observable class
 */
public class Observable {

    private final List<Observer> observers = new ArrayList<>();

    /**
     * Adds an observer
     * @param observer is the new observer
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer
     * @param observer is the removed observer
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all the observers with a message
     * @param message is the message sent to the observers
     */
    protected void notifyObserverErrorMessage(ErrorMessage message) {
        for (Observer observer : observers) {
            observer.updateError(message);
        }
    }
    protected void notifyObserverMoveToIslandMessage(MoveToIslandMessage message) {
        for (Observer observer : observers) {
            observer.updateMoveToIsland(message);
        }
    }
}
