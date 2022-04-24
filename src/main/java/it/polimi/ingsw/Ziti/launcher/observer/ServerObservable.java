package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ServerObservable {

    private final List<ServerObserver> observers = new ArrayList<>();

    public void addObserver(ServerObserver observer) {
        observers.add(observer);
    }

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
