package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.*;

public interface ViewObserver {
    void update(Message message);
    void moveToIslandHandler(MoveToIslandMessage message);
    void moveToTableHandler(MoveToTableMessage message);
    void moveMotherHandler(MoveMotherMessage message);
    void choseAssistantHandler(ChoseAssistantMessage message);
    void cloudIslandHandler(CloudIslandMessage message);
    void showErrorMessageHandler(ErrorMessage message);
    void showAssistantsMessageHandler();
    void showCharactersMessageHandler();
    void showIslandsMessageHandler();
    void showCloudsMessageHandler();
    void showMyBoardMessageHandler();
    void showBoardsMessageHandler();
}
