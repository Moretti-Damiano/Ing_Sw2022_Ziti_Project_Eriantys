package it.polimi.ingsw.Ziti.launcher;

import java.util.ArrayList;

public class Player {
        private ArrayList<Assistant> assistants;
        private Board board;
        private String name;


        public Player(String name){
            this.name=name;
            board=new Board();
            this.assistants=AssistantParser.parseAssistants("Assistants.xml");
        }

        /**
         * returns the player's name
         */
        public String GetName(){
            return this.name;
        }
    }


