package it.polimi.ingsw.Ziti.launcher;

import java.util.HashMap;
import java.util.Map;

/**
 * This enum contains all possible Colours of a Pawn.
 *
 * */
public enum Colour {
    BLUE("0"),
    GREEN("1"),
    PINK("2"),
    RED("3"),
    YELLOW("4");

    private String abbreviation;


    /**
     * The set of Colours addressed by abbreviations.
     */
    private static final Map<String, Colour> COLOURS_BY_ABBR = new HashMap<String, Colour>();



    /**
     * Static initializer
     */
    static {
        for (Colour colour : values()) {
            COLOURS_BY_ABBR.put(colour.getAbbreviation(), colour);
        }
    }


    /**
     * Default constructor.
     */
    Colour(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getColour() {
        return abbreviation;
    }

    public String getAbbreviation() {return abbreviation;}

    /**
     * Gets the enum constant with the specified abbreviation.
     *
     * @param abbr the colour's abbreviation.
     * @return the enum constant with the specified abbreviation.
     */
    public static Colour valueOfAbbreviation(final String abbr) {
        final Colour colour = COLOURS_BY_ABBR.get(abbr);
        return colour;
    }



}


