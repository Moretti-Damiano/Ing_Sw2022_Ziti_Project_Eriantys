package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.*;

/**
 * Interface used to implement the Observer-Observable pattern between Server and GameController.
 * This interface allows the GameController to observe the Server.
 * It contains all the methods to handle every type of received message.
 */
public interface ServerObserver {

    public void moveToIslandHandler(MoveToIslandMessage message);
    public void moveToTableHandler(MoveToTableMessage message);
    public void moveMotherHandler(MoveMotherMessage message);
    public void choseAssistantHandler(ChooseAssistantMessage message);
    public void cloudIslandHandler(CloudIslandMessage message);
    public void loginHandler(LoginMessage message);
    public void numberOfPlayerHandler(NumberOfPlayersMessage message);
    public void showAssistantRequestHandler(ShowAssistantRequest message);
    public void showBoardsRequestHandler(ShowBoardsRequest message);
    public void showCloudRequestHandler(ShowCloudRequest message);
    public void showBoardRequestHandler(ShowBoardRequest message);
    public void showCharacterRequestHandler(ShowCharacterRequest message);
    public void showIslandRequestHandler(ShowIslandRequest message);
}
