package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.ActionMessage;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;

/**
 * This is the interface used to implement game mechanics
 */
public interface Action {
    /**
     * This method is used to do an action
     * @throws ActionException when is impossible to complete the requested action
     */
    void execute() throws ActionException;

    /**
     * This method is used to send parameters through messages and finally to be printed in cli
     * @return an ActionMessage
     */
    ActionMessage toMessage();

    /**
     * this method is used to add a description to the action message
     * @param s the description to add
     */
   void addDescription(String s);

    /**
     * this method check if the parameters of the action are correct
     * @throws ActionException if the parameters aren't correct
     */
   void checkInput() throws ActionException;
}
