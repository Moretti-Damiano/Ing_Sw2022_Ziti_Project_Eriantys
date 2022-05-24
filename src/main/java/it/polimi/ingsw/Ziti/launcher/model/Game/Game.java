package it.polimi.ingsw.Ziti.launcher.model.Game;

import it.polimi.ingsw.Ziti.launcher.action.Action;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
import it.polimi.ingsw.Ziti.launcher.model.*;
import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;
import it.polimi.ingsw.Ziti.launcher.model.GameMode.GameMode;
import it.polimi.ingsw.Ziti.launcher.observer.Observable;

import java.util.ArrayList;
import java.util.Random;

/**
 * Abstract class used to implement games for different number of players via Strategy Pattern
 */
public abstract class Game extends Observable {
    private final ArrayList<Island> islands;
    private final ArrayList<Player> players;
    private final ArrayList<CloudIsland> cloudIslands;
    private ArrayList<Board> boards;
    private final Mother mother;
    private Sack sack;
    private final int playerNumber;
    private ArrayList<Professor> professors;
    private Player currentPlayer;
    private Action action;
    private final GameWallet gameWallet;
    private ArrayList<Character> characters;
    private GameMode gameMode;

    /**
     * Creates 12 islands,Mother and memorizes the players
     * @param p arraylist containing all the players
     */
    public Game(ArrayList<Player> p){
        this.cloudIslands=new ArrayList<>();
        this.boards=new ArrayList<>();

        this.players = new ArrayList<>(p);

        //creates 12 empty islands
        this.islands = new ArrayList<>();
        for(int i=0;i<12;i++){
            islands.add(new Island(i));
        }

        this.gameWallet=new GameWallet();

        //creates mother
        this.mother = new Mother();

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

        this.playerNumber = players.size();

        setUpCloudIslands();

        setUpProfessors();

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
  public  void setUpCloudIslands(){
            for (int i = 0; i < getPlayerNumber(); i++) {
                getCloudIslands().add(new CloudIsland(i, getPlayerNumber(), getSack()));
                getCloudIslands().get(i).toFill();
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


   public void setCharacters(ArrayList<Character> characters){
        this.characters=characters;
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
    public abstract void setPlayers(ArrayList<Player> p);


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

    /**
     * Set the current action that will be played
     * @param action the action to be set
     */
    public void setAction(Action action){
        this.action = action;
    }

    /**
     * Do the chosen action
     * @throws ActionException ifan error occurs during the action.execute()
     */
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


    public Mother getMother(){
        return this.mother;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public Action getAction() {
        return action;
    }

    public GameMode getGameMode() {
        return gameMode;
    }
    
    public void setGameMode(GameMode gamemode){
        this.gameMode=gamemode;
    }
}
