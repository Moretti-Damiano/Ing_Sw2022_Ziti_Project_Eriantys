package it.polimi.ingsw.Ziti.launcher;

import it.polimi.ingsw.Ziti.launcher.enumeration.EffectType;

public class Effect {
    private EffectType EffectName;
    private String description;
    public Effect (EffectType EffectName, String description) {
        this.EffectName=EffectName;
        this.description=description;
    }
}
