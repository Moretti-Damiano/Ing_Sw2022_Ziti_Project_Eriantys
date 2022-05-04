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
    void moveToIslandHandler(MoveToIslandDoneMessage message) throws ExecutionException;
    void moveToTableHandler(MoveToTableDoneMessage message) throws ExecutionException;
    void moveMotherHandler(MoveMotherDoneMessage message);
    void chooseAssistantHandler(ChooseAssistantDoneMessage message);
    void chooseCharacterHandler(ChooseCharacterDoneMessage message);
    void endTurnHandler(EndTurnDoneMessage message);
    void cloudIslandHandler(ChooseCloudDoneMessage message);
    void ConnectionSuccessfulHandler(ConnectionSuccessfulMessage message) throws ExecutionException;
    void CompleteRequestHandler(CompletedRequestMessage message) throws ExecutionException;
    void LoginErrorHandler(LoginError message) throws ExecutionException;
    void NumOfPlayerHandler(NumOfPLayersRequest message) throws ExecutionException, IOException;
    void TurnErrorHandler(TurnError message) throws ExecutionException;
    void TurnNotificationHandler(TurnNotification message) throws ExecutionException;
    void showAssistantHandler(ShowAssistantResponse message) throws ExecutionException;
    void showCharacterHandler(ShowCharacterResponse message) throws ExecutionException;
    void showBoardHandler(ShowBoardResponse message) throws ExecutionException;
    void showBoardsHandler(ShowBoardsResponse message) throws ExecutionException;
    void showCloudHandler(ShowCloudResponse message) throws ExecutionException;
    void showIslandHandler(ShowIslandResponse message) throws ExecutionException;
    void GameStartedHandler(GameStartedMessage message) throws ExecutionException;

    //Handler per ogni show (con i messaggi che contengono i dati)
}
