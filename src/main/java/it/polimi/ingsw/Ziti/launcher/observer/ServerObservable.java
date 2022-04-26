package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Class used to implement the Observer-Observable pattern between Server and GameController.
 * This class allows the ServerMessageHandler to be observed by GameController.
 */
public class ServerObservable {

    /**
     * List containing al the observers
     */
    private final List<ServerObserver> observers = new ArrayList<>();

    /**
     * add an observer to the observers list
     * @param observer the observer to be added
     */
    public void addObserver(ServerObserver observer) {
        observers.add(observer);
    }

    /**
     * removes an observer
     * @param observer the observer to be removed
     */
    public void removeObserver(ServerObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all the observers with the lambda argument.
     * @param lambda the function to be called on the observers.
     */
    protected void notifyObserver(Consumer<ServerObserver> lambda) {
        for (ServerObserver observer : observers) {
            lambda.accept(observer);
        }
    }
}
