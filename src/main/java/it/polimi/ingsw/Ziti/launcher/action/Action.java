package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.ActionMessage;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;

/**
 * This is the interface used to implement game mechanics
 */
public interface Action {
    /**
     * This method is used to do an action
     * @throws ActionException
     */
    public void execute() throws ActionException;

    /**
     * This method is used to send parameters throught messages and finally to be printed in cli
     * @return an ActionMessage
     */
    public ActionMessage toMessage();

   public void addDescription(String s);
}
