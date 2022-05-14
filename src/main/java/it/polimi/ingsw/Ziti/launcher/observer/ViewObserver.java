package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
/**
 * Interface used to implement the Observer-Observable pattern between Cli and Client Message Handler.
 * This interface allows Cli to observe the Client Message Handler.
 * It contains the methods to handle answer messages to clients.
 */
public interface ViewObserver {


    void InputErrorHandler(InputError message);
    void ErrorMessageHandler(ErrorMessage message);
    void moveToIslandHandler(MoveToIslandDoneMessage message);
    void moveToTableHandler(MoveToTableDoneMessage message);
    void moveMotherHandler(MoveMotherDoneMessage message);
    void chooseAssistantHandler(ChooseAssistantDoneMessage message);
    void chooseCharacterHandler(ChooseCharacterDoneMessage message);
    void endTurnHandler(EndTurnDoneMessage message);
    void cloudIslandHandler(ChooseCloudDoneMessage message);
    void ConnectionSuccessfulHandler(ConnectionSuccessfulMessage message);
    void CompleteRequestHandler(CompletedRequestMessage message);
    void LoginErrorHandler(LoginError message);
    void NumOfPlayerHandler(NumOfPLayersRequest message);
    void ModeRequestHandler(ModeRequest message);
    void TurnErrorHandler(TurnError message);
    void TurnNotificationHandler(TurnNotification message);
    void showAssistantHandler(ShowAssistantResponse message);
    void showCharacterHandler(ShowCharacterResponse message);
    void showBoardHandler(ShowBoardResponse message);
    void showBoardsHandler(ShowBoardsResponse message);
    void showCloudHandler(ShowCloudResponse message);
    void showIslandHandler(ShowIslandResponse message);
    void GameStartedHandler(GameStartedMessage message);
    void YourTurnNotificationHandler(YourTurnNotification message);
    void showBoardsandIslandsHandler(ShowBoardsandIslandsResponse message);
    void winHandler(WinMessage message);

    //Handler per ogni show (con i messaggi che contengono i dati)
}
