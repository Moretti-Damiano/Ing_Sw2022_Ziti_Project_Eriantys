package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.model.Parser.AssistantParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * This class represents the player by collecting his main information.
 * This class has references to player's board, characater and assistant.
 * Assistants are managed by using an XML parser
 */
public class Player implements Serializable {
    private final List<Assistant> assistants;
    private Board board;
    private final String name;
    private Assistant assChosen;
    private boolean usedACharacter;

    public Player(String name) throws ParserConfigurationException, IOException, SAXException {
        this.name=name;
        assistants= AssistantParser.parseAssistants("Assistants.xml");
        assChosen=null;
        usedACharacter = false;
    }

    /**
     * returns the player's name
     */
    public String GetName(){
            return this.name;
        }

        public Board getBoard() {
        return board;
        }

    public void setAssChoosed(Assistant assChoosed) {
        this.assChosen = assChoosed;
    }

    public List<Assistant> getAssistants() {
        return assistants;
    }

    public Assistant getAssChosen() {
        return assChosen;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean hasUsedACharacter() {
        return usedACharacter;
    }

    public void setUsedACharacter(boolean usedACharacter) {
        this.usedACharacter = usedACharacter;
    }
}


