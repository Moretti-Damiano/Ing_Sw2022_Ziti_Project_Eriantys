package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.action.Action;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;

import java.util.ArrayList;

/*
TO DO
    *CURRENTPLAYER
    *ARRAYLIST DI CHARACTER

 */

public class Game {
    private ArrayList<Island> islands;
    private ArrayList<Player> players;
    private ArrayList<CloudIsland> cloudIslands;
    private Mother mother;
    private Sack sack;
    private int maxPlayer;
    private int playerNumber;
    private ArrayList<Professor> professors;
    private ArrayList<Character> characters;
    private Player currentPlayer;
    private Action action;

    /**
     * Creates 12 islands,Mother and memorizes the players
     * @param p arraylist containing all the players
     */
    public Game(ArrayList<Player> p){

        //creates 12 islands
        this.islands = new ArrayList<Island>();
        for(int i=0;i<12;i++){
            islands.add(new Island(i));
        }

        //creates mother
        this.mother = Mother.motherInstance();

        //copies p into players
        this.players = new ArrayList<Player>(p);

        //set numplayer
        this.maxPlayer = players.size();        //PROBABILEMTE SBAGLIATO
        this.playerNumber = players.size();

        //set sack
        this.sack = new Sack();

        //set cloudislands
        cloudIslands = new ArrayList<>();
        for(int i = 0; i < playerNumber; i++){
            cloudIslands.add(new CloudIsland(i,playerNumber,sack));
            cloudIslands.get(i).toFill();
        }

        //set professors
        professors = new ArrayList<>();
        for(Colour c: Colour.values()){
            professors.add(new Professor(c));
        }


        //set characters TO BE DONE!!!
    }


    public ArrayList<Island> getIslands() {
        return islands;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<CloudIsland> getCloudIslands() {
        return cloudIslands;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * @param i is the main island
     * @return next island to i
     * if i is the last island, returns the first island
     */
    public Island getNextIsland(Island i){
        int index = islands.indexOf(i);
        if(index == islands.size()-1){  //i is last element
            return islands.get(0);
        }
        else
            return islands.get(index+1);
    }

    /**
     * @param i is the main island
     * @return the previous island to i
     * if i is the first islands, return the last island
     */
    public Island getPrevIsland(Island i){
        int index = islands.indexOf(i);
        if(index == 0){         //i is first element
            return islands.get(islands.size()-1);
        }
        else
            return islands.get(index-1);
    }

    /**
     *Adds a students from player's board, choosen by colour, to the specified island
     */
    public void addStudent(Player player, Island island, Colour colour){
        island.addStudent(player.getBoard().leave(colour));
    }

    public void setAction(Action action){
        this.action = action;
    }

    public void doAction(){
        action.execute();
    }
}
