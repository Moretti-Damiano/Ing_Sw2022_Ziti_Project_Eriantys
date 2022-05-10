package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.action.Action;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.TowerColour;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.Characters.*;
import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;
import it.polimi.ingsw.Ziti.launcher.observer.Observable;

import java.util.ArrayList;
import java.util.Random;

/*
TO DO:
    *CURRENTPLAYER
    *GAME INIT PER 4 GIOCATORI (SETPLAYERS)
    *ARRAYLIST DI CHARACTER
 */
public class Game extends Observable {
    private ArrayList<Island> islands;
    private ArrayList<Player> players;
    private ArrayList<CloudIsland> cloudIslands;
    private ArrayList<Board> boards;
    private Mother mother;
    private Sack sack;
    //private int maxPlayer;
    private int playerNumber;   //indictes the number of player at the start of the game
    private ArrayList<Professor> professors;
    private Player currentPlayer;
    private Action action;
    private GameWallet gameWallet;
    private ArrayList<Character> allCharacters;
    private ArrayList<Character> characters;

    /**
     * Creates 12 islands,Mother and memorizes the players
     * @param p arraylist containing all the players
     */
    public Game(ArrayList<Player> p){

        this.players = new ArrayList<>(p);

        //creates 12 empty islands
        this.islands = new ArrayList<Island>();
        for(int i=0;i<12;i++){
            islands.add(new Island(i));
        }

        this.gameWallet=new GameWallet();

        //creates mother
        this.mother = Mother.motherInstance();

        //set islands and mother
       setUpIsland_Mother();

        //creates sack with 120 remaining students
        sack = new Sack(130 - (islands.size() - 2));

        //Creates all boards
        boards = new ArrayList<>();
        for(Player player: players){
            Board newBoard = new Board(player);
            player.setBoard(newBoard);
            boards.add(newBoard);
        }

        setPlayers(players);

        //set numplayer
        //this.maxPlayer = players.size();        //PROBABILEMENTE SBAGLIATO
        this.playerNumber = players.size();

        setUpCloudIslands();

        setUpProfessors();

        setUpCharacters();

    }

    /**
     * Places Mother on a random island, then it fills the sack with 10 students (2 per colour)
     * and adds a student from the sack to each island, except for the one with Mother on, and the opposite one.
     */
    private void setUpIsland_Mother(){
        //places mother on a random island
        Random rand = new Random();
        int motherPosition = rand.nextInt(islands.size());
        mother.setIsland(islands.get(motherPosition));
        islands.get(motherPosition).addMother();

        //places 1 random student on each island
        //creates sack with 10 students
        sack = new Sack((islands.size() - 2));
        int emptyIsland = (motherPosition + islands.size()/2) % islands.size();
        for(Island i: islands){
            if(islands.indexOf(i) != motherPosition && islands.indexOf(i) !=emptyIsland ){
                i.addStudent(sack.extract());
            }
        }
    }

    /**
     * creates and setup all the cloudIslands
     */
    private void setUpCloudIslands(){
        cloudIslands = new ArrayList<>();
        for(int i = 0; i < playerNumber; i++){
            cloudIslands.add(new CloudIsland(i,playerNumber,sack));
            cloudIslands.get(i).toFill();
        }
    }

    /**
     * Create all the professor
     */
    private void setUpProfessors(){
        professors = new ArrayList<>();
        for(Colour c: Colour.values()){
            professors.add(new Professor(c));
        }
    }

    private void setUpCharacters(){

        allCharacters = new ArrayList<>();
        characters = new ArrayList<>();
        //creates all possible characters
        allCharacters.add(Character0.getInstance());
        allCharacters.add(Character1.getInstance());
        allCharacters.add(Character2.getInstance());
        allCharacters.add(Character3.getInstance());
        allCharacters.add(Character4.getInstance());
        allCharacters.add(Character5.getInstance());

        //set 3 game's characters
        Random rand = new Random();
        int random;
        for(int i = 0; i < 3; i++){
            //create a random number
            random =rand.nextInt(allCharacters.size()-1);
            allCharacters.get(random).setGame(this);
            characters.add(allCharacters.remove(random));

        }
    }

    public GameWallet getGameWallet() { return gameWallet;}

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

    public void setActivePlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Sack getSack() {return sack;}

    public ArrayList<Board> getBoards() {
        return boards;
    }

    /**
     * depending on the game number of players, this method initializes each player's board
     * adding students and towers of the automatically assigned colour
     * @param p the arraylist containing all the players
     */
    private void setPlayers(ArrayList<Player> p){

        if(p.size() == 2){
            //set player towercolour
            int towerColour = 0;
            for(Player player: p){
                player.getBoard().setTowerColour(TowerColour.valueOfAbbreviation(Integer.toString(towerColour)));
                towerColour ++;
            }

            //add 7 random students on each player's board and 8 towers
            for(Player player:p){
                for(int i = 0; i < 7; i++){
                    player.getBoard().addStudent(sack.extract());
                    player.getBoard().addTower(new Tower(player,player.getBoard().getTower_colour()));
                }
                player.getBoard().addTower(new Tower(player,player.getBoard().getTower_colour())); //adds the 8th tower
            }
        }

        if(p.size() == 3){
            //set player towercolour
            int towerColour = 0;
            for(Player player: p){
                player.getBoard().setTowerColour(TowerColour.valueOfAbbreviation(Integer.toString(towerColour)));
                towerColour ++;
            }

            //add 9 random students on each player's board and 6 towers
            for(Player player:p){
                for(int i = 0; i < 9; i++){
                    player.getBoard().addStudent(sack.extract());
                }
                for(int i = 0; i < 6; i++){
                player.getBoard().addTower(new Tower(player,player.getBoard().getTower_colour())); //adds the 8th tower
                }
            }
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public Island getIslandbyId(int id){
        for(Island i : islands){
            if(i.getID()==id )
                return i;
        }
        return null;
    }

    /**
     * @param professor_colour the colour of the professor
     * @return the professor with the indicated colour
     */
    public Professor getProfessorbyColour(Colour professor_colour){
        for(Professor p : professors){
            if(p.getColour()==professor_colour){
                return p;
            }
        }
        return null;
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
     *
     * @param player is the player chosen
     * @param island is the chosen island
     * @param colour is the colour of the student chosen
     * Adds a students from player's board, choosen by colour, to the specified island
     */

    public void addStudent(Player player, Island island, Colour colour){
        island.addStudent(player.getBoard().removeStudent(colour));
    }

    public void setAction(Action action){
        this.action = action;
    }

    public void doAction() throws ActionException {
        action.execute();
        notifyObserver(action.toMessage());
    }

    /**
     *
     * @param professor_colour the colour of the professor
     * @return the player who controls the professor with the specified colour
     */
    public Player checkProfessor(Colour professor_colour){
        for(Player p : players){
            if(p.getBoard().hasProfessor(professor_colour)){
                return p;
            }
        }
        return null;
    }

    public Character getCharacterbyId(int id){
        for(Character c: characters){
            if(c.getId() == id)
                return c;
        }
        return null;
    }
}
