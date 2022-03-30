package it.polimi.ingsw.Ziti.launcher;

    /**
     * This class represents all Pawns usable in the game
     */
    public class Pawn {

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


