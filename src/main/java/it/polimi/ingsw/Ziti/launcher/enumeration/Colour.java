package it.polimi.ingsw.Ziti.launcher.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * This enum contains all possible Colours of a Pawn.
 *
 * */
public enum Colour {
    BLUE("0","blue"),
    GREEN("1","green"),
    PINK("2","pink"),
    RED("3","red"),
    YELLOW("4","yellow");

    private String abbreviation;
    private String name;

    /**
     * The set of Colours addressed by abbreviations.
     */
    private static final Map<String, Colour> COLOURS_BY_ABBR = new HashMap<String, Colour>();
    private static final Map<String, Colour> COLOURS_BY_NAME = new HashMap<String, Colour>();

    /**
     * Static initializer
     */
    static {
        for (Colour colour : values()) {
            COLOURS_BY_ABBR.put(colour.getAbbreviation(), colour);
        }
        for(Colour colour : values()){
            COLOURS_BY_NAME.put(colour.getName(), colour);
        }
    }

    /**
     * Default constructor.
     */
    Colour(String abbreviation, String name) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getColour() {
        return abbreviation;
    }

    public String getAbbreviation() {return abbreviation;}

    public String getName() {
        return name;
    }

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

    /**
     * Gets the enum constant with the specified name.
     *
     * @param name the colour's name.
     * @return the enum constant with the specified name.
     */
    public static Colour valueOfName(final String name) {
        final Colour colour = COLOURS_BY_ABBR.get(name);
        return colour;
    }

    /**
     * Converts the abbreviation of a colour into a ìn int
     * @return colour's int
     * */
    public int getIntAbbreviation(){
        int abbrev = Integer.parseInt(this.getAbbreviation());
        return abbrev;
    }



}


