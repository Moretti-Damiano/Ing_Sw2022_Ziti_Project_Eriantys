package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.MessageToClient;

import java.util.ArrayList;
import java.util.List;

public class LoginObservable {
    private final List<LoginObserver> observers = new ArrayList<>();

    /**
     * Adds an observer
     * @param observer is the new observer
     */
    public void addObserver(LoginObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer
     * @param observer is the removed observer
     */
    public void removeObserver(LoginObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all the observers with a message
     */
    public void notifyObserver() {
        for (LoginObserver observer : observers) {
            observer.update();
        }
    }
}
