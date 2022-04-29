package it.polimi.ingsw.Ziti.launcher.Messages;


import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.*;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObservable;
//OSSERVATA dalla cli
// gestisce le risposte dal server sulla validità dei dati corretti
public class ClientMessageHandler extends ViewObservable {
    public void MoveMotherDoneHandle(MoveMotherDoneMessage message){notifyObserver(obs->obs.moveMotherHandler(message));}
    public void MoveToIslandDoneHandle(MoveToIslandDoneMessage message){notifyObserver(obs->obs.moveToIslandHandler(message));}
    public void MoveToTableDoneHandle(MoveToTableDoneMessage message){notifyObserver(obs->obs.moveToTableHandler(message));}
    public void ChooseCharacterDoneHandle(ChooseCharacterDoneMessage message){notifyObserver(obs->obs.chooseCharacterHandler(message));}
    public void ChooseAssistantDoneHandle(ChooseAssistantDoneMessage message){notifyObserver(obs->obs.chooseAssistantHandler(message));}
    public void EndTurnDoneHandle(EndTurnDoneMessage message){notifyObserver(obs->obs.endTurnHandler(message));}
    public void ChooseCloudIslandDoneHandle(ChooseCloudDoneMessage message){notifyObserver(obs->obs.cloudIslandHandler(message));}
    public void inputErrorHandle(InputError message) {
        notifyObserver(obs->obs.InputErrorHandler(message));
    }
    public void ErrorMessageHandle(ErrorMessage message){notifyObserver(obs->obs.ErrorMessageHandler(message));}
    // da implementare gli altri metodi della cli (show)
}
