package it.polimi.ingsw.Ziti.launcher.exception;

public class WinException extends Exception{
    private final String nickname;
    
    public WinException(String nickname ){
        super();
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}
