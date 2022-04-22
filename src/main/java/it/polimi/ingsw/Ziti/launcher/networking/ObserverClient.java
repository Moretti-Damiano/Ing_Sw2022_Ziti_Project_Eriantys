package it.polimi.ingsw.Ziti.launcher.networking;

import it.polimi.ingsw.Ziti.launcher.observer.Observer;
import it.polimi.ingsw.Ziti.launcher.view.view;

public class ObserverClient implements Observer {
    view view;
    //chiama il corrispondente show nella view, vanno implementate tutte le show da fare in ogni caso
    //funziona solo in mesaggi in ricezione dal server
    @Override
    public void update(Message message) {
        switch (message.getMessageType()) {
            case ERROR:
                view.showMessage(message);

        }
    }
}
