package it.polimi.ingsw.Ziti.launcher.networking;

import it.polimi.ingsw.Ziti.launcher.Messages.ErrorMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.Message;
import it.polimi.ingsw.Ziti.launcher.Messages.MoveToIslandMessage;
import it.polimi.ingsw.Ziti.launcher.observer.Observer;
import it.polimi.ingsw.Ziti.launcher.view.cli;
import sun.jvm.hotspot.utilities.Observable;

public class ObserverClient extends Observable implements Observer {
    //chiama il corrispondente show nella view, vanno implementate tutte le show da fare in ogni caso
    //funziona solo in mesaggi in ricezione dal server
    @Override
    public void updateError(ErrorMessage message) {
        notifyErrorMessage(message);
    }

    @Override
    public void updateMoveToIsland(MoveToIslandMessage message) {

    }

}

