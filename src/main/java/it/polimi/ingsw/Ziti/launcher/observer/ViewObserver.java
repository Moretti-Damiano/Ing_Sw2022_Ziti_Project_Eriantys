package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

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
    void ConnectionSuccessfulHandler(ConnectionSuccessfulMessage message) throws ExecutionException;
    void CompleteRequestHandler(CompletedRequestMessage message);
    void LoginErrorHandler(LoginError message) throws ExecutionException;
    void NumOfPlayerHandler(NumOfPLayersRequest message) throws ExecutionException, IOException;
    void TurnErrorHandler(TurnError message);
    void showAssistantHandler(ShowAssistantResponse message);
    void showCharacterHandler(ShowCharacterResponse message);
    void showBoardHandler(ShowBoardResponse message);
    void showBoardsHandler(ShowBoardsResponse message);
    void showCloudHandler(ShowCloudResponse message);
    void showIslandHandler(ShowIslandResponse message);

    //Handler per ogni show (con i messaggi che contengono i dati)
}
