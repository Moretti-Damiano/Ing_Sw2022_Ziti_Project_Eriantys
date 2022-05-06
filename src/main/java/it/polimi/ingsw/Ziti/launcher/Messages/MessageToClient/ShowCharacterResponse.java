package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.model.CharacterOLD;

import java.util.ArrayList;
/**
 * This message has a list of characters as a response to a Show Character request
 */
public class ShowCharacterResponse extends MessageToClient{
    private ArrayList<CharacterOLD> characters;

    public ShowCharacterResponse(ArrayList<CharacterOLD> characters){
        this.characters=characters;
    }

    public ArrayList<CharacterOLD> getCharacters() {
        return characters;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.ShowCharacterResponseHandle(this);
    }
}
