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
     * Notifies all the observers with the lambda argument.
     * @param lambda the function to be called on the observers.
     */
    protected void notifyObserver(Consumer<GameControllerObserver> lambda) {
        for (GameControllerObserver observer : observers) {
            lambda.accept(observer);
        }
    }
}
