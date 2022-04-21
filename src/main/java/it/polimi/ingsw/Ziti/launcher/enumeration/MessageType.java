package it.polimi.ingsw.Ziti.launcher.enumeration;

/**
 * Type of message used during client-server communication
 */

public enum MessageType {
    ACTION_DONE,
    CLIENT_REQUEST,
    CONNECT,LOGIN,
    DISCONNECT,
    TURN_ERROR,
    INPUT_ERROR,
    END_MATCH;
}
