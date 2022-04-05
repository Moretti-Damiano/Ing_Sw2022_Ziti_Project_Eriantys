package it.polimi.ingsw.Ziti.launcher.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * This enum contains all possible Colours of a Pawn.
 *
 * */
public enum TowerColour {
    BLACK("0"),
    WHITE("1"),
    GRAY("2");

    private String abbreviation;


    /**
     * The set of Colours addressed by abbreviations.
     */
    private static final Map<String, TowerColour> TOWERCOLOURS_BY_ABBR = new HashMap<String, TowerColour>();

    /*
     *static initializer
     * */
    static {
        for (TowerColour towerColour : values()) {
            TOWERCOLOURS_BY_ABBR.put(towerColour.getAbbreviation(),towerColour);
        }
    }

    public String getAbbreviation() {return abbreviation;}


    /**
     * Default constructor.
     */
    TowerColour(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getTowerColour() {
        return abbreviation;
    }


    /**
     * Gets the enum constant with the specified abbreviation.
     *
     * @param abbr the colour's abbreviation.
     * @return the enum constant with the specified abbreviation.
     */
    public static TowerColour valueOfAbbreviation(final String abbr) {
        final TowerColour towerColour = TOWERCOLOURS_BY_ABBR.get(abbr);
        return towerColour;
    }
}
