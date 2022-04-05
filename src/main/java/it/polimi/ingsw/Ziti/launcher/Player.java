package it.polimi.ingsw.Ziti.launcher;

import java.util.ArrayList;

public class Player {
    private ArrayList<Assistant> assistants;
    private Board board;
    private String name;


    public Player(String name, TowerColour tower_Colour) {
        this.name = name;
        this.assistants = AssistantParser.parseAssistants("Assistants.xml");
        this.board = new Board(tower_Colour);

    }

        /**
         * @return the player's name
         */
        public String getName () {
            return this.name;
        }

        /**s
         *
         * @return the player's board
         */
        public Board getBoard () {
            return this.board;
        }
    }



