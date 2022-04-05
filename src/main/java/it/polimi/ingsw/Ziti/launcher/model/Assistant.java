package it.polimi.ingsw.Ziti.launcher.model;

public class Assistant {
    private final int id;
    private final int movesMother;
    private final int value;

    private Assistant (Builder builder){
        this.id=builder.id;
        this.movesMother=builder.movesMother;
        this.value=builder.value;
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
