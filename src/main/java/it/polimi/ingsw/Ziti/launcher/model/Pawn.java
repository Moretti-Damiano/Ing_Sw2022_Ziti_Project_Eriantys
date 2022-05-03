package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;

import java.io.Serializable;

/**
     * This class represents all Pawns usable in the game
     */
    public class Pawn implements Serializable {

        private Colour colour;

        public Pawn(Colour c ){
            this.colour=c;
        }

        /**
         *
         * @return colour used to determinate which colour a Pawn is
         */
        public  Colour getColour(){
            return colour;
        }
    }


