package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.action.Action;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.TowerColour;
import it.polimi.ingsw.Ziti.launcher.exception.ActionException;
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
    private int maxPlayer;
    private int playerNumber;
    private ArrayList<Professor> professors;
    private ArrayList<CharacterOLD> characters;
    private Player currentPlayer;
    private Action action;
    private GameWallet gameWallet;

    /**
     * Creates 12 islands,Mother and memorizes the players
     * @param p arraylist containing all the players
     */
    public Game(ArrayList<Player> p){

        //Creates all boards
        boards = new ArrayList<>();
        for(Player player: p){
            Board newBoard = new Board(player);
            boards.add(newBoard);
            player.setBoard(newBoard);
        }

        //creates 12 empty islands
        this.islands = new ArrayList<Island>();
        for(int i=0;i<12;i++){
            islands.add(new Island(i));
        }

        this.gameWallet=new GameWallet();

        //creates mother
        this.mother = Mother.motherInstance();


                    //set islands and mother
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

        //creates sack with 120 remaining students
        sack = new Sack(130 - (islands.size() - 2));

        //copies p into players
        this.players = new ArrayList<Player>(p);

        //set numplayer
        this.maxPlayer = players.size();        //PROBABILEMENTE SBAGLIATO
        this.playerNumber = players.size();

        //set sack
        this.sack = new Sack(islands.size()-2);

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

        //set players'board
        setPlayers(p);


        //set characters TO BE DONE!!!
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

    public ArrayList<CharacterOLD> getCharacters() {
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

    private void setPlayers(ArrayList<Player> p){
        players = new ArrayList<>(p);
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

        if(p.size() == 4){
            //TO BE IMPLEMENTED
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
}
