package it.polimi.ingsw.Ziti.launcher;

/**
 * This class contains the encoding referring to XML files.
 */

public enum XMLName {
    ID("id"),
    MOVES("moves"),
    VALUE("value"),
    COST("cost"),
    DESCRIPTION("description");

    private final String text;

    XMLName(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}
