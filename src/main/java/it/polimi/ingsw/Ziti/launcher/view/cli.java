package it.polimi.ingsw.Ziti.launcher.view;

import it.polimi.ingsw.Ziti.launcher.Messages.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.*;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.model.*;
import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObserver;

import java.lang.Character;
import java.util.List;
import java.util.Scanner;

public class cli extends InputObservable implements view, ViewObserver {

    //Questa classe OSSERVA il ClientMessageHandler e VIENE OSSERVATA dal ClientController

    private final Scanner sc;

    public cli(ClientMessageHandler clientMessageHandler){
        this.sc = new Scanner(System.in);
    }

    @Override
    public void showAssistants(List<Assistant> assistants) {
        System.out.println("Available assistants are :");
        for(Assistant ass : assistants){
            if(!ass.isAssChose()) {
                System.out.println(" ID : " + ass.getId());
                System.out.println(" MotherNature Moves : " + ass.getMovesMother());
                System.out.println(" Value : " + ass.getValue());
            }
        }

    }

    @Override
    public void showCharacters(List<Character> characters) {

    }

    @Override
    public void showIslands(List<Island> islands) {
        System.out.println("Available islands are ");
        for(Island island : islands){
            System.out.println(" ID : "+island.getID());
            if(island.getMother()){
                System.out.println("In this island there's MotherNature ");
            }
            if(island.getTowerPlayer()==null){
                System.out.println("There's no player that owns a tower in this island ");
            }
            else
            {
                System.out.println("In this island there is "+island.getTowerPlayer().GetName()+"'s tower");
            }
                System.out.println("There are :");
            for(Colour c: Colour.values()){
                if(island.getColour(c)!=0){
                    System.out.println(island.getColour(c)+" students "+c.getColour());
                }
            }
            }
    }

    @Override
    public void showClouds(List<CloudIsland> clouds) {
        System.out.println("Available Cloud Islands are: ");
        for(CloudIsland c : clouds) {
            System.out.println("CloudID: " + c.getID());
            System.out.println("In this Cloud Island there are: ");
            for(Colour colour: Colour.values()){
                System.out.println(c.getColour(colour)+" "+colour.getColour()+" students");
            }
        }
    }

    @Override
    public void showMyBoard(Board board) {
        // show waiting Students
        for (Colour c : Colour.values()) {
            System.out.println("There are " + board.countStudentColor(c)+" "+ c.getColour() + " students waiting " );
        }

        // show dining Students
        for (Colour c : Colour.values()) {
            System.out.println("There are " + board.getColorRowSize(c)+" "+ c.getColour() + " students in the dining room " );
        }

        // show coins
        System.out.println("You have  " + board.getNumberofCoin() + " coins");

        // show professors
        for (Colour c : Colour.values()) {
            if (board.hasProfessor(c))
                System.out.println("You have " + c.getColour()+" professor");
        }
    }

    @Override
    public void showBoards(List<Player> players){
        for(Player p:players){
            // do showMyBoard for each board
            System.out.println(p.GetName()+"'s board: ");
            // show waiting Students
            for (Colour c : Colour.values()) {
                System.out.println("There are " +p.getBoard().countStudentColor(c)+" "+ c.getColour() + " students waiting " );
            }

            // show dining Students
            for (Colour c : Colour.values()) {
                System.out.println("There are " +p.getBoard().getColorRowSize(c)+" "+ c.getColour() + " students in the dining room " );
            }

            // show coins
            System.out.println(p.GetName()+" has " + p.getBoard().getNumberofCoin() + " coins");

            // show professors
            for (Colour c : Colour.values()) {
                if (p.getBoard().hasProfessor(c))
                    System.out.println(p.GetName()+" has " + c.getColour()+" professor");
            }
        }

    }

    @Override
    public void showErrorMessage(ErrorMessage message) {
        System.out.println(message.getDescription()+"from "+message.getSender());
    }
    public void showInputErrorMessage(InputError message) {
        System.out.println(message.getDescription()+"from server");
    }

    @Override
    public void askLogin() {
        System.out.println("Insert your username: ");
        String username;
        username=sc.nextLine();
        notifyObserver(obs->obs.onUpdateLogin(username));
    }

    @Override
    public String askAssistant() {
        System.out.println("Insert Assistant's id: ");
        String assistantId;
        assistantId=sc.nextLine();
        return assistantId;
    }

    @Override
    public String askCharacter() {
        System.out.println("Insert Character's id: ");
        String characterId;
        characterId=sc.nextLine();
        return characterId;
    }

    @Override
    public String askIsland() {
        System.out.println("Insert an Island's id: ");
        String islandId;
       islandId=sc.nextLine();
        return islandId;
    }

    @Override
    public String askColour() {
        System.out.println("Insert a colour: ");
        String colour;
        colour=sc.nextLine();
        return colour;

    }

    @Override
    public void askMoveToTable() {
        notifyObserver(obs -> obs.onUpdateMoveToTable(askColour()));

    }

    @Override
    public void askMoveToIsland() {
        notifyObserver(obs -> obs.onUpdateMoveToIsland(askColour(),askIsland()));
    }

    @Override
    public void askMoveMother() {
        String moves;
        System.out.println("Insert how many moves the MotherNature should do: ");
        moves=sc.nextLine();
        notifyObserver(obs -> obs.onUpdateMoveMother(moves));

    }

    @Override
    public void askCloudIsland() {
        String cloudID;
        System.out.println("Insert CloudIsland's id that you want: ");
        cloudID=sc.nextLine();
        notifyObserver(obs -> obs.onUpdateCloudIsland(cloudID));
    }

    @Override
    public void askChoseAssistant() {
        notifyObserver(obs -> obs.onUpdateChooseAssistant(askAssistant()));
    }

    public void InputErrorHandler(InputError message) {
        showInputErrorMessage(message);
    }


    @Override
    public void ErrorMessageHandler(ErrorMessage message) {
        showErrorMessage(message);
    }

    @Override
    public void moveToIslandHandler(MoveToIslandDoneMessage message) {
        System.out.println(message.getDescription());
        showIslands(message.getIslands());
        System.out.println("Player "+message.getPlayername()+"'s board: ");
        showMyBoard(message.getBoard());



    }

    @Override
    public void moveToTableHandler(MoveToTableDoneMessage message) {
        System.out.println(message.getDescription());
        System.out.println("Player "+message.getPlayername()+"'s board: ");
        showMyBoard(message.getBoard());

    }

    @Override
    public void moveMotherHandler(MoveMotherDoneMessage message) {
        System.out.println(message.getDescription());
        showIslands(message.getIslands());

    }

    @Override
    public void chooseAssistantHandler(ChooseAssistantDoneMessage message) {
        System.out.println(message.getDescription());
        showAssistants(message.getAssistants());

    }

    @Override
    public void chooseCharacterHandler(ChooseCharacterDoneMessage message) {


    }

    @Override
    public void endTurnHandler(EndTurnDoneMessage message) {
        System.out.println(message.getDescription());
        showIslands(message.getIslands());
        showClouds(message.getCloudIslands());
        showBoards(message.getPlayers());

    }

    @Override
    public void cloudIslandHandler(ChooseCloudDoneMessage message) {
        System.out.println(message.getDescription());
        showClouds(message.getCloudIslands());
    }

    @Override
    public void ConnectionSuccessfulHandler(ConnectionSuccessfulMessage message) {
        if(message.getSuccess()){
            gameStarter();
        }
    }

    @Override
    public void CompleteRequestHandler(CompletedRequestMessage message) {
        System.out.println(message.getDescription());
    }

    @Override
    public void LoginErrorHandler(LoginError message) {
        System.out.println(message.getDescription());
        gameStarter();
    }

    @Override
    public void NumOfPlayerHandler(NumOfPLayersRequest message) {
        askNumberOfPlayer();
    }

    @Override
    public void TurnErrorHandler(TurnError message) {
        System.out.println(message.getDescription());
    }

    public void init(){
        System.out.println("\n" +
                "8888888888 "+" 8888888b.  "+"8888888  "+"       d8888   "+"888b    888   "+"88888888888 "+"Y88b   d88P "+" .d8888b.      \n"+
                "888        "+" 888   Y88b "+"  888    "+"      d88888   "+"8888b   888  "+"     888     "+" Y88b d88P  "+"d88P  Y88b     \n"+
                "888        "+" 888    888 "+"  888    "+"     d88P888   "+"88888b  888  "+"     888     "+"  Y88o88P   "+"Y88b.          \n"+
                "8888888    "+" 888   d88P "+"  888    "+"    d88P 888   "+"888Y88b 888  "+"     888     "+"   Y888P    "+"   Y888b.      \n"+
                "888        "+" 8888888P   "+"  888    "+"   d88P  888   "+"888 Y88b888  "+"     888     "+"    888     "+"      Y88b.    \n"+
                "888        "+" 888 T88b   "+"  888    "+"  d88P   888   "+"888  Y88888  "+"     888     "+"    888     "+"        888$   \n"+
                "888        "+" 888  T88b  "+"  888    "+" d8888888888   "+"888   Y8888  "+"     888     "+"    888     "+"Y88b  d88P     \n"+
                "8888888888 "+" 888   T88b "+"8888888  "+"d88P     888   "+"888    Y888  "+"     888     "+"    888     "+"   Y8888P      \n");

        String defaultAddress = "localhost";
        String defaultPort = "16847";
        System.out.println("Please insert Server Settings. Default value is shown as §DEFAULT§");
        System.out.println("Enter the server address §"+defaultAddress+"§");
        String address=sc.nextLine();
        System.out.println("Enter the server port §"+defaultPort+"§");
        String port=sc.nextLine();
        notifyObserver(obs->obs.onUpdateConnection(address,port));

    }
    public void gameStarter(){
        System.out.println("If is your first action, Type LOGIN to insert your username");
        System.out.println("MAIN ACTION");
        System.out.println("Type CHOOSEASSISTANT to chose your assistant");
        System.out.println("Type CHOOSECHARACTER to choose your character");
        System.out.println("Type CHOOSECLOUD to chose your cloud");
        System.out.println("Type MOVEMOTHER to chose the number of mother's movements");
        System.out.println("Type MOVETOISLAND to chose the island where you want to put your students");
        System.out.println("Type MOVETOTABLE if you want to put your studend on the table");
        while(true){
            String input;
            input=sc.nextLine();
            switch(input){
                case "CHOOSEASSISTANT":
                    askChoseAssistant();
                    break;
                case "CHOOSECHARACTER":
                    askCharacter();
                    break;
                case "CHOOSECLOUD":
                    askCloudIsland();
                    break;
                case "MOVEMOTHER":
                    askMoveMother();
                    break;
                case "MOVETOISLAND":
                    askMoveToIsland();
                    break;
                case "MOVETOTABLE":
                    askMoveToTable();
                    break;
                default:
                    System.out.println("Invalid");
            }
        }


    }


        }
