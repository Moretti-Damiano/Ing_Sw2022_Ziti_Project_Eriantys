package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.AssistantParser;
import it.polimi.ingsw.Ziti.launcher.model.Assistant;
import it.polimi.ingsw.Ziti.launcher.model.Board;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Player {
        private List<Assistant> assistants;
        private Board board;
        private String name;


        public Player(String name) throws ParserConfigurationException, IOException, SAXException {
            this.name=name;
            board=new Board();
            assistants= AssistantParser.parseAssistants("Assistants.xml");
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

    public List<Assistant> getAssistants() {
        return assistants;
    }
}


