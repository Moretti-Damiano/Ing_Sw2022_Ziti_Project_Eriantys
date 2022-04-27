package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.*;

public interface ViewObserver {


    void InputErrorHandler(InputError message);
    void moveToIslandHandler(MoveToIslandMessage message);
    void moveToTableHandler(MoveToTableMessage message);
    void moveMotherHandler(MoveMotherMessage message);
    void choseAssistantHandler(ChoseAssistantMessage message);
    void cloudIslandHandler(CloudIslandMessage message);
    void showErrorMessageHandler(ErrorMessage message);
    void showAssistantsMessageHandler();
    void showCharactersMessageHandler();
    void showIslandsMessageHandler();
    void showCloudsMessageHandler(showCloudsMessage message);
    void showMyBoardMessageHandler();
    void showBoardsMessageHandler();
    void ErrorMessageHandler(ErrorMessage message);
    //Handler per ogni show (con i messaggi che contengono i dati)
}
