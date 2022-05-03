package it.polimi.ingsw.Ziti.launcher.Messages;


import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.*;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObservable;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * This class is observed by cli and by ClientController
 * Every method handles a request of the similar message: notifies observer calling its method with the message as a parameter
 */

public class ClientMessageHandler extends ViewObservable {
    public void MoveMotherDoneHandle(MoveMotherDoneMessage message){notifyObserver(obs->obs.moveMotherHandler(message));}
    public void MoveToIslandDoneHandle(MoveToIslandDoneMessage message){notifyObserver(obs-> {
        try {
            obs.moveToIslandHandler(message);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    });}
    public void MoveToTableDoneHandle(MoveToTableDoneMessage message){notifyObserver(obs-> {
        try {
            obs.moveToTableHandler(message);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    });}
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
    public void CompletedRequestHandle(CompletedRequestMessage message){notifyObserver(obs-> {
        try {
            obs.CompleteRequestHandler(message);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    });}
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    });}
    public void TurnErrorHandle(TurnError message){notifyObserver(obs-> {
        try {
            obs.TurnErrorHandler(message);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    });}
    public void ShowAssistantResponseHandle(ShowAssistantResponse message){notifyObserver(obs-> {
        try {
            obs.showAssistantHandler(message);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    });}
    public void ShowCharacterResponseHandle(ShowCharacterResponse message){notifyObserver(obs-> {
        try {
            obs.showCharacterHandler(message);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    });}
    public void ShowBoardResponseHandle(ShowBoardResponse message){notifyObserver(obs-> {
        try {
            obs.showBoardHandler(message);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    });}
    public void ShowBoardsResponseHandle(ShowBoardsResponse message){notifyObserver(obs-> {
        try {
            obs.showBoardsHandler(message);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    });}
    public void ShowCloudsResponseHandle(ShowCloudResponse message){notifyObserver(obs-> {
        try {
            obs.showCloudHandler(message);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    });}
    public void ShowIslandsResponseHandle(ShowIslandResponse message){notifyObserver(obs-> {
        try {
            obs.showIslandHandler(message);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    });}
    public void GameStartedMessageHandle(GameStartedMessage message){notifyObserver(obs-> {
        try {
            obs.GameStartedHandler(message);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    });}
    // da implementare gli altri metodi della cli (show)
}
