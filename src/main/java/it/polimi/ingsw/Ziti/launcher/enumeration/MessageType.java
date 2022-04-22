package it.polimi.ingsw.Ziti.launcher.enumeration;

/**
 * Type of message used during client-server communication
 */

public enum MessageType {
    ACTION_DONE,
    CHOOSEASSISTANT,
    CHOOSECLOUD,
    MOVEMOTHER,
    MOVETOISLAND,
    MOVETOTABLE,

    ID_GIVEN,
    COLOUR_GIVEN,
    CONNECT,
    LOGIN,
    DISCONNECT,

    TURN_ERROR,
    INPUT_ERROR,
    ERROR,
    END_MATCH;
}
