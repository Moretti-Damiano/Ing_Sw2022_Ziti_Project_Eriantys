package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.CharacterSummary;
import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;

import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * This message has a list of characters as a response to a Show Character request
 */
public class ShowCharacterResponse extends MessageToClient implements Serializable {

    ArrayList<CharacterSummary> characterSummaries;

    public ShowCharacterResponse(ArrayList<CharacterSummary> characterSummaries){
        this.characterSummaries = new ArrayList<>(characterSummaries);
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.ShowCharacterResponseHandle(this);
    }

    public ArrayList<CharacterSummary> getCharacterSummaries() {
        return characterSummaries;
    }
}
