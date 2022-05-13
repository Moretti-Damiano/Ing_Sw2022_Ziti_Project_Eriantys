package it.polimi.ingsw.Ziti.launcher.view.cli;

import it.polimi.ingsw.Ziti.launcher.InputReadThread;
import it.polimi.ingsw.Ziti.launcher.Messages.CharacterSummary;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.*;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.model.*;
import it.polimi.ingsw.Ziti.launcher.model.Characters.Character;
import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObserver;
import it.polimi.ingsw.Ziti.launcher.view.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * This class observes ClientMessageHandler and is observed by ClientController
 * It's the real client who calls methods from "command line interface"
 */
public class cli extends InputObservable implements view, ViewObserver {

    private InputReadThread inputThread;
    private Scanner scanner;
    private boolean freeInput;



    public cli(){
        scanner = new Scanner(System.in);
        freeInput = false;
    }

    @Override
    public void showAssistants(List<Assistant> assistants) {
        System.out.println("Available assistants are :");
        for(Assistant ass : assistants){
            if(!ass.isAssChose()) {
                System.out.println(" ID : " + ass.getId()+"\t\t MotherNature Moves : " + ass.getMovesMother()+"\t\t Value : " + ass.getValue());
            }
        }

    }

    @Override
    public void showCharacters(ArrayList<CharacterSummary> characterSummary) {
        for(CharacterSummary character:characterSummary){
            System.out.println("Character ID: "+character.getId()+"\t\t"+"Cost "+character.getCost());
            System.out.println("Summary: "+character.getDescription());
            System.out.println();
        }

    }


    @Override
    public void showIslands(List<Island> islands) {
        System.out.println();
        System.out.println("Available islands are ");
        for(Island island : islands) {
            if (island.getMother()) {
                System.out.println(" ID : " + island.getID() + "\t\tIn this island there's MotherNature ");
            } else System.out.println(" ID : " + island.getID());
            if (island.getTowerPlayer() != null) {
                System.out.println("In this island there is " + island.getTowerPlayer().GetName() + "'s tower");
            }
            if (island.getStudents().isEmpty()) System.out.println("There are no students ");
            else {
                String partial="";
                for (Colour c : Colour.values()) {
                    if (island.getColour(c) != 0) {
                        partial = partial.concat("\t  " + island.getColour(c) +" " + c.getName()+" students " );
                    }
                }
                System.out.println("There are: "+partial);
            }
        }
    }

    @Override
    public void showClouds(List<CloudIsland> clouds) {
        System.out.println("Available Cloud Islands are: ");
        for (CloudIsland c : clouds) {
            System.out.println("CloudID: " + c.getID());
            if (c.getStudents().isEmpty()) System.out.println("In this Cloud Island there are no students");
            else {
                System.out.println("In this Cloud Island there are: ");
                for (Colour colour : Colour.values()) {
                    if (c.getColour(colour) != 0)
                        System.out.println(c.getColour(colour) + " " + colour.getName() + " students");
                }
            }
        }
    }
    @Override
    public void showMyBoard(Board board) {
        // show waiting Students
        System.out.println("     WAITING ROOM                                                       DINING ROOM");
        for (Colour c : Colour.values()) {
            System.out.printf("%-50s ", "There are " +  board.countStudentColor(c)+ " " + c.getName() + " students waiting ");
            System.out.printf("           " + "%-50s ", "" + board.getColorRowSize(c) + " " + c.getName() + " students in the dining room");
            System.out.println();
        }
        // show coins
        System.out.println("There are  " + board.getNumberofCoin() + " coins in wallet");

        // show professors
        for (Colour c : Colour.values()) {
            if (board.hasProfessor(c))
                System.out.println("You have " + c.getName()+" professor");
        }

        //show towers
        System.out.println("There are " + board.getTowerSize() + " towers");
    }

    @Override
    public void showBoards(List<Board> boards){
        for(Board board: boards){
            System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t\t"+board.getPlayername().toUpperCase(Locale.ROOT)+"'s BOARD");
            showMyBoard(board);
        }
    }


    @Override
    public void showErrorMessage(ErrorMessage message) {
        System.out.println(message.getDescription()+" from "+message.getSender());
    }
    public void showInputErrorMessage(InputError message) {
        System.out.println(message.getDescription()+" from server");
    }

    @Override
    public void askLogin()  {
        System.out.println("Insert your username: ");
        String username;
        username=readLine();
        notifyObserver(obs->obs.onUpdateLogin(username));
    }

    @Override
    public String askAssistant()  {
        System.out.println("Insert Assistant's id: ");
        String assistantId;
        assistantId=readLine();
        inputThread.setFreeInput(true);
        return assistantId;
    }

    @Override
    public String askCharacter(){
        System.out.println("Insert Character's id: ");
        String characterId;
        characterId=readLine();
        inputThread.setFreeInput(true);
        return characterId;
    }

    @Override
    public String askIsland()  {
        System.out.println("Insert an Island's id: ");
        String islandId;
        islandId=readLine();
        inputThread.setFreeInput(true);
        return islandId;
    }

    @Override
    public String askColour()  {
        System.out.println("Insert a colour: ");
        String colour;
        colour=readLine();
        inputThread.setFreeInput(true);
        return colour;

    }
    public void askNumberOfPlayer()  {
        System.out.println("Insert the number of players: ");
        //Scanner scanner=new Scanner(System.in);
        String numberOfPlayer=readLine();
        System.out.println("Ho superato il readLine");
        notifyObserver(obs->obs.onUpdateNumberOfPlayer(numberOfPlayer));
    }

    @Override
    public void GameStartedHandler(GameStartedMessage message)  {
        gameStarter();
    }

    @Override
    public void YourTurnNotificationHandler(YourTurnNotification message) {
        System.out.println(message.Description);
    }

    @Override
    public void showBoardsandIslandsHandler(ShowBoardsandIslandsResponse message) {
        showBoards(message.getBoards());
        showIslands(message.getIslands());
    }

    @Override
    public void winHandler(WinMessage message) {
        System.out.println("\t\t Game is over!!");
        System.out.println("The winner is:  ............................................."+message.getWinner());
    }

    @Override
    public void askMoveToTable() {
        notifyObserver(obs ->
                obs.onUpdateMoveToTable(askColour()));
    }

    @Override
    public void askMoveToIsland(){
        notifyObserver(obs ->
                obs.onUpdateMoveToIsland(askColour(),askIsland()));

    }

    @Override
    public void askMoveMother() {
        String moves;
        System.out.println("Insert how many moves the MotherNature should do: ");
        moves=readLine();
        notifyObserver(obs -> obs.onUpdateMoveMother(moves));
        inputThread.setFreeInput(true);
    }

    @Override
    public void askCloudIsland() {
        String cloudID;
        System.out.println("Insert CloudIsland's id that you want: ");
        cloudID=readLine() ;
        notifyObserver(obs -> obs.onUpdateCloudIsland(cloudID));
        inputThread.setFreeInput(true);

    }

    @Override
    public void askChoseCharacter() {
        String characterId = askCharacter();
        switch (characterId){
            case"0":
                notifyObserver(obs -> obs.onUpdateChooseCharacter0(characterId));
                break;
            case"1":
                notifyObserver(obs -> obs.onUpdateChooseCharacter1(characterId,askIsland()));
                break;
            case"2":
                notifyObserver(obs -> obs.onUpdateChooseCharacter2(characterId));
                break;
            case"3":
                notifyObserver(obs -> obs.onUpdateChooseCharacter3(characterId));
                break;
            case"4":
                notifyObserver(obs -> obs.onUpdateChooseCharacter4(characterId,askColour()));
                break;
            case"5":
                notifyObserver(obs -> obs.onUpdateChooseCharacter5(characterId,askColour()));
                break;
            default: break;
        }

    }


    @Override
    public void askChoseAssistant() {
        notifyObserver(obs -> obs.onUpdateChooseAssistant(askAssistant()));
    }

    public void InputErrorHandler(InputError message){
        showInputErrorMessage(message);

    }


    @Override
    public void ErrorMessageHandler(ErrorMessage message) {
        showErrorMessage(message);
    }

    @Override
    public void moveToIslandHandler(MoveToIslandDoneMessage message){
        System.out.println(message.getDescription());
        showIslands(message.getIslands());
        System.out.println("Player "+message.getPlayername()+"'s board: ");
        showMyBoard(message.getBoard());

    }

    @Override
    public void moveToTableHandler(MoveToTableDoneMessage message)   {
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
        System.out.println(message.getDescription());


    }

    @Override
    public void endTurnHandler(EndTurnDoneMessage message) {
        System.out.println(message.getDescription());
        showIslands(message.getIslands());
        showClouds(message.getCloudIslands());
        showBoards(message.getBoards());

    }

    @Override
    public void cloudIslandHandler(ChooseCloudDoneMessage message) {
        System.out.println(message.getDescription());
        showClouds(message.getCloudIslands());
    }

    @Override
    public void ConnectionSuccessfulHandler(ConnectionSuccessfulMessage message)  {
        if(message.getSuccess()){
            askLogin();
        }
    }

    @Override
    public void CompleteRequestHandler(CompletedRequestMessage message)  {
        System.out.println(message.getDescription());
    }

    @Override
    public void LoginErrorHandler(LoginError message)  {
        System.out.println(message.getDescription());
        askLogin();
    }

    @Override
    public void NumOfPlayerHandler(NumOfPLayersRequest message){
        System.out.println("Sto per chiedere il numero dei player");
        askNumberOfPlayer();

    }

    @Override
    public void TurnErrorHandler(TurnError message)  {
        System.out.println(message.getDescription());
    }

    public void TurnNotificationHandler(TurnNotification message)  {
        System.out.println(message.getDescription());
    }

    @Override
    public void showAssistantHandler(ShowAssistantResponse message)  {
        showAssistants(message.getAssistants());
    }

    @Override
    public void showCharacterHandler(ShowCharacterResponse message) {
        showCharacters(message.getCharacterSummaries());
    }



    @Override
    public void showBoardHandler(ShowBoardResponse message)  {
        showMyBoard(message.getBoard());
    }

    @Override
    public void showBoardsHandler(ShowBoardsResponse message)  {
        showBoards(message.getBoards());
    }

    @Override
    public void showCloudHandler(ShowCloudResponse message)  {
        showClouds(message.getClouds());
    }

    @Override
    public void showIslandHandler(ShowIslandResponse message)  {
        showIslands(message.getIslands());
    }

    /**
     * The first method called by cli
     * It's used to set address and port and finally to create a connection between client and server
     *
     */
    public void init()  {
        System.out.println("\n" +
                "8888888888 "+" 8888888b.  "+"8888888  "+"       d8888   "+"888b    888   "+"88888888888 "+"Y88b   d88P "+" .d8888b.      \n"+
                "888        "+" 888   Y88b "+"  888    "+"      d88888   "+"8888b   888  "+"     888     "+" Y88b d88P  "+"d88P  Y88b     \n"+
                "888        "+" 888    888 "+"  888    "+"     d88P888   "+"88888b  888  "+"     888     "+"  Y88o88P   "+"Y88b.          \n"+
                "8888888    "+" 888   d88P "+"  888    "+"    d88P 888   "+"888Y88b 888  "+"     888     "+"   Y888P    "+"   Y888b.      \n"+
                "888        "+" 8888888P   "+"  888    "+"   d88P  888   "+"888 Y88b888  "+"     888     "+"    888     "+"      Y88b.    \n"+
                "888        "+" 888 T88b   "+"  888    "+"  d88P   888   "+"888  Y88888  "+"     888     "+"    888     "+"        888    \n"+
                "888        "+" 888  T88b  "+"  888    "+" d8888888888   "+"888   Y8888  "+"     888     "+"    888     "+"Y88b  d88P     \n"+
                "8888888888 "+" 888   T88b "+"8888888  "+"d88P     888   "+"888    Y888  "+"     888     "+"    888     "+"   Y8888P      \n");

        String defaultAddress = "localhost";
        String defaultPort = "16847";
        System.out.println("Please insert Server Settings. Default value is shown as [DEFAULT]");
        System.out.println("Enter the server address ["+defaultAddress+"]");
        String address=readLine();
        System.out.println("Enter the server port ["+defaultPort+"]");
        String port=readLine();
        notifyObserver(obs->obs.onUpdateConnection(address,port));

    }

    /**
     * Method used to start a reading thread to catch client's input
     * @return input read
     * @
     */

    public String readLine(){
        return scanner.nextLine();
    }



    public void command(String input){
        switch(input){
            case "CHOOSEASSISTANT":
                inputThread.setFreeInput(false);
                askChoseAssistant();
                break;
            case "CHOOSECHARACTER":
                inputThread.setFreeInput(false);
                askChoseCharacter();
                break;
            case "CHOOSECLOUD":
                inputThread.setFreeInput(false);
                askCloudIsland();
                break;
            case "MOVEMOTHER":
                inputThread.setFreeInput(false);
                askMoveMother();
                break;
            case "MOVETOISLAND":
                inputThread.setFreeInput(false);
                askMoveToIsland();
                break;
            case "MOVETOTABLE":
                inputThread.setFreeInput(false);
                askMoveToTable();
                break;
            case "SHOWASSISTANTS":
                notifyObserver(obs->obs.onUpdateAssistantRequest(new ShowAssistantRequest()));
                break;
            case "SHOWBOARD":
                notifyObserver(obs->obs.onUpdateBoardRequest(new ShowBoardRequest()));
                break;
            case "SHOWBOARDS":
                notifyObserver(obs->obs.onUpdateBoardsRequest(new ShowBoardsRequest()));
                break;
            case "SHOWCHARACTERS":
                notifyObserver(obs->obs.onUpdateCharacterRequest(new ShowCharacterRequest()));
                break;
            case "SHOWCLOUDS":
                notifyObserver(obs->obs.onUpdateCloudRequest(new ShowCloudRequest()));
                break;
            case "SHOWISLANDS":
                notifyObserver(obs->obs.onUpdateIslandRequest(new ShowIslandRequest()));
                break;
            case "SHOWBOARDSANDISLANDS":
                notifyObserver(obs->obs.onUpdateShowAndIslandRequest(new ShowBoardsandIslandsRequest()));
                break;
            case "DISCONNECT":
                notifyObserver(obs->obs.onUpdateDisconnection(new DisconnectionRequest()));
                init();
                break;
            default:
                System.out.println("Invalid");
                break;
        }
    }

    /**
     * Method used to ask what a client wants to do
     * @
     */
    public void gameStarter()  {
        System.out.println("MAIN ACTION");
        System.out.println("Type CHOOSEASSISTANT to chose your assistant");
        System.out.println("Type CHOOSECHARACTER to choose your character");
        System.out.println("Type CHOOSECLOUD to chose your cloud");
        System.out.println("Type MOVEMOTHER to chose the number of mother's movements");
        System.out.println("Type MOVETOISLAND to chose the island where you want to put your students");
        System.out.println("Type MOVETOTABLE if you want to put your student on the table");
        System.out.println("Type SHOWASSISTANTS to print the available assistants");
        System.out.println("Type SHOWBOARD to print your board");
        System.out.println("Type SHOWBOARDS to print the board of each player");
        System.out.println("Type SHOWBOARDSANDISLANDS to print all boards and all islands");
        System.out.println("Type SHOWCHARACTERS to print the available characters");
        System.out.println("Type SHOWCLOUDS to print the available clouds");
        System.out.println("Type SHOWISLANDS to print all the islands");
        System.out.println("Type DISCONNECT to end this game and restart an other one");

        inputThread = new InputReadThread(this);
        new Thread(inputThread).start();
    }
}