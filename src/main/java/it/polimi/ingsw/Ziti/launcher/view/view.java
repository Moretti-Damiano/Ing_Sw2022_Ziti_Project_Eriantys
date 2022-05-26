package it.polimi.ingsw.Ziti.launcher.view;

import it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.ErrorMessage;

/**
 * Interface implemented by gui and cli
 */
public interface view {
    void showErrorMessage(ErrorMessage message);
}
