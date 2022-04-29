package it.polimi.ingsw.Ziti.launcher.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class  InputObservable {
    private final List<InputObserver> observers = new ArrayList<>();

    /**
     * Adds an observer
     * @param observer is the new observer
     */
    public void addObserver(InputObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer
     * @param observer is the removed observer
     */
    public void removeObserver(InputObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all the current observers through the lambda argument.
     *
     * @param lambda the lambda to be called on the observers.
     */
    public void notifyObserver(Consumer<InputObserver> lambda) {
        for (InputObserver observer : observers) {
            lambda.accept(observer);
        }
    }
}
