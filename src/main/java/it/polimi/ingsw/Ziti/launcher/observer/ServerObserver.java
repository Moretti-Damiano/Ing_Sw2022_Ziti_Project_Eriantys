package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.*;

public interface ServerObserver {
    //da inserire uno per messaggio da ricevere
    public void moveToIslandHandler(MoveToIslandMessage message);
    public void moveToTableHandler(MoveToTableMessage message);
    public void moveMotherHandler(MoveMotherMessage message);
    public void choseAssistantHandler(ChoseAssistantMessage message);
    public void cloudIslandHandler(CloudIslandMessage message);

    //public void loginHandler(LoginMessage message);
}
