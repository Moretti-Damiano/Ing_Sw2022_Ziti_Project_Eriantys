package it.polimi.ingsw.Ziti.launcher;

public class Character {
    private final int id;
    private int cost;
    private final String description;
    private final Effect effect;

    private Character(Builder builder){
        this.id=builder.id;
        this.cost=builder.cost;
        this.description=builder.description;
        this.effect=builder.effect;

    }

    public int getId() {
        return id;
    }

    public Effect getEffect() {
        return effect;
    }

    public int getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    void increaseCost(){
        this.cost++;
    }

    public static class Builder {
        private final int id;
        private int cost;
        private String description;
        private Effect effect;


        public Builder(int id) {
            this.id = id;
        }

        public Builder withCost(int cost) {
            this.cost = cost;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withEffect(Effect effect){
            this.effect=effect;
            return this;
        }

        public Character build(){return new Character(this);}

    }
}
