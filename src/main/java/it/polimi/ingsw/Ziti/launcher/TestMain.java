package it.polimi.ingsw.Ziti.launcher;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;

import java.util.Locale;

public class TestMain {
    public static void main(String[] args){
        String s1 = "RED";
        if(Colour.checkStringToColour(s1)){
            System.out.println("CheckString funziona");
        }
        if(Colour.valueOfAbbreviation("0").equals(Colour.RED)){
            System.out.println("valueofabbreviation funziona");
        }
        if(Colour.valueOfName(s1.toLowerCase(Locale.ROOT)).equals(Colour.RED))
            System.out.println("Funziona valueof");
    }
}
