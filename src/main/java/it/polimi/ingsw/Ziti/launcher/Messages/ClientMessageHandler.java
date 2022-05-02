package it.polimi.ingsw.Ziti.launcher.Messages;


import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.*;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObservable;

import java.util.concurrent.ExecutionException;

/**
 * This class is observed by cli and by ClientController
 * Every method handles a request of the similar message: notifies observer calling its method with the message as a parameter
 */

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
    public void ConnectionSuccessfulHandle(ConnectionSuccessfulMessage message){notifyObserver(obs-> {
        try {
            obs.ConnectionSuccessfulHandler(message);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    });}
    public void CompletedRequestHandle(CompletedRequestMessage message){notifyObserver(obs->obs.CompleteRequestHandler(message));}
    public void LoginErrorHandle(LoginError message){notifyObserver(obs-> {
        try {
            obs.LoginErrorHandler(message);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    });}
    public void NumOfPlayerRequestHandle(NumOfPLayersRequest message){notifyObserver(obs-> {
        try {
            obs.NumOfPlayerHandler(message);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    });}
    public void TurnErrorHandle(TurnError message){notifyObserver(obs->obs.TurnErrorHandler(message));}
    public void ShowAssistantResponseHandle(ShowAssistantResponse message){notifyObserver(obs->obs.showAssistantHandler(message));}
    public void ShowCharacterResponseHandle(ShowCharacterResponse message){notifyObserver(obs->obs.showCharacterHandler(message));}
    public void ShowBoardResponseHandle(ShowBoardResponse message){notifyObserver(obs->obs.showBoardHandler(message));}
    public void ShowBoardsResponseHandle(ShowBoardsResponse message){notifyObserver(obs->obs.showBoardsHandler(message));}
    public void ShowCloudsResponseHandle(ShowCloudResponse message){notifyObserver(obs->obs.showCloudHandler(message));}
    public void ShowIslandsResponseHandle(ShowIslandResponse message){notifyObserver(obs->obs.showIslandHandler(message));}
    // da implementare gli altri metodi della cli (show)
}
