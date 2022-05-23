package it.polimi.ingsw.Ziti.launcher.model;

import java.io.Serializable;

public class Assistant implements Serializable {
    private final int id;
    private  int movesMother;
    private final int value;
    private boolean actual;
    private boolean assChose;

    private Assistant (Builder builder){
        this.id=builder.id;
        this.movesMother=builder.movesMother;
        this.value=builder.value;
        this.actual=false;
        this.assChose=false;
    }

    /**
     *
     * @return Number of MotherNature possible moves
     */
    public int getMovesMother() {
        return movesMother;
    }

    /**
     *
     * @return Value used to choose next round player order
     */
    public int getValue() {
        return value;
    }

    /**
     *
     * @return Assistant id, used to identify AssistantCard
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return if this assistant is in use by his player
     */

    public boolean isActual() {return actual;}

    /**
     *
     * @return if this assistant has been chosen in previous round
     */
    public boolean isAssChose() {
        return assChose;
    }

    /**
     *
     * @param actual true if it's the "actual assistant"
     */

    public void setActual(boolean actual) {
        this.actual = actual;
    }

    /**
     *
     * @param assChose true if the player has already chosen this assistant
     */
    public void setAssChose(boolean assChose) {
        this.assChose = assChose;
    }

    /**
     * Method used for Character 2
     * @param movesMother
     */
    public void addMoves(int movesMother) {
        this.movesMother += movesMother;
    }

    /**
     * Method used for Character 2
     * @param movesMother
     */
    public void reduceMoves(int movesMother) {
        this.movesMother -= movesMother;
    }

    public static class Builder {
        private final int id;
        private int movesMother;
        private int value;

        public Builder(int id){
            this.id=id;
        }

        public Builder withmovesMother(int movesMother){
            this.movesMother=movesMother;
            return this;
        }

        public Builder withvalue(int value){
            this.value=value;
            return this;
        }

        public Assistant build() { return new Assistant(this);}

    }
}
