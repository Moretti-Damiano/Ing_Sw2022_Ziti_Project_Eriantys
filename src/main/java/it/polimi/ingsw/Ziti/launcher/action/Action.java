package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.Messages.ActionMessage;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;

/**
 * This is the interface used to implement game mechanics
 */
public interface Action {
    
    public void execute() throws ActionException;
    public ActionMessage toMessage();
}
