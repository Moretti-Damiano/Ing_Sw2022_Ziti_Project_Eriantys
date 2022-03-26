package it.polimi.ingsw.Ziti.launcher;

public class Assistant {
    private final int id;
    private final int movesMother;
    private final int value;

    private Assistant (Builder builder){
        this.id=builder.id;
        this.movesMother=builder.movesMother;
        this.value=builder.value;
    }
    public int getMovesMother() {
        return movesMother;
    }

    public int getValue() {
        return value;
    }

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
