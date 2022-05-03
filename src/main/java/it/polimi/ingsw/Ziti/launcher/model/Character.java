package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.Effect;

import java.io.Serializable;

public class Character implements Serializable {
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

    /**
     *
     * @return Character id, used to identify CharacterCard
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return CharacterCard Effect
     */
    public Effect getEffect() {
        return effect;
    }

    /**
     *
     * @return The cost of the Card, in order to use this card, the player have to use this amount of coins
     */
    public int getCost() {
        return cost;
    }

    /**
     *
     * @return The description of the Effect provided by this Character
     */
    public String getDescription() {
        return description;
    }

    /**
     * Simple function that allow to increase the cost of the card, in fact (and only) after the first use, the cost is increased by one
     */
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
