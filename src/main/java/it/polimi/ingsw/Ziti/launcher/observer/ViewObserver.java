package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.*;

public interface ViewObserver {


    void InputErrorHandler(InputError message);
    void ErrorMessageHandler(ErrorMessage message);
    void moveToIslandHandler(MoveToIslandDoneMessage message);
    void moveToTableHandler(MoveToTableDoneMessage message);
    void moveMotherHandler(MoveMotherDoneMessage message);
    void chooseAssistantHandler(ChosoeAssistantDoneMessage message);
    void chooseCharacterHandler(ChooseCharacterDoneMessage message);
    void endTurnHandler(EndTurnDoneMessage message);
    void cloudIslandHandler(ChooseCloudDoneMessage message);

    //Handler per ogni show (con i messaggi che contengono i dati)
}
