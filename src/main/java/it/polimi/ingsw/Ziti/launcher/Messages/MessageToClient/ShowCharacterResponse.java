package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;

import java.util.ArrayList;

public class ShowCharacterResponse extends MessageToClient{
    private ArrayList<Character> characters;

    public ShowCharacterResponse(ArrayList<Character> characters){
        this.characters=characters;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.ShowCharacterResponseHandle(this);
    }
}
