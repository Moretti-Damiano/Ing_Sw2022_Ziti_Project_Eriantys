package it.polimi.ingsw.Ziti.launcher.enumeration;

public enum Phase {
    NULL,PLANNING, MOVEMENT, MOTHER, CLOUD;

    public static Phase next(Phase phase){
        switch(phase){
            case NULL:
                return PLANNING;
            case PLANNING:
                return MOVEMENT;
            case MOVEMENT:
                return MOTHER;
            case MOTHER:
                return CLOUD;
            case CLOUD:
                return PLANNING;
            default:
                return NULL;
        }
    }
}
