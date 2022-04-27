package it.polimi.ingsw.Ziti.launcher.Messages;


import it.polimi.ingsw.Ziti.launcher.observer.ViewObservable;
//OSSERVATA dalla cli
// gestisce le risposte dal server sulla validità dei dati corretti
public class ClientMessageHandler extends ViewObservable {
    public void showCloudsHandle(showCloudsMessage message){notifyObserver(obs->obs.showCloudsMessageHandler(message));}
    public void inputErrorHandle(InputError message) {
        notifyObserver(obs->obs.InputErrorHandler(message));
    }
    public void ErrorMessageHandle(ErrorMessage message){notifyObserver(obs->obs.ErrorMessageHandler(message));}
    // da implementare gli altri metodi della cli (show)
}
