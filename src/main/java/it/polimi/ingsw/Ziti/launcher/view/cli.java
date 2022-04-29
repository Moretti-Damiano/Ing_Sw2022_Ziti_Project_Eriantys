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
        System.out.println("Gli assistenti disponibili sono :");
        for(Assistant ass : assistants){
            System.out.println(" ID : "+ass.getId());
            System.out.println(" MotherNature Moves : "+ass.getMovesMother());
            System.out.println(" Value : "+ass.getValue());
        }

    }

    @Override
    public void showCharacters(List<Character> characters) {

    }

    @Override
    public void showIslands(List<Island> islands) {
        System.out.println("Le isole disponibili sono :");
        for(Island island : islands){
            System.out.println(" ID : "+island.getID());
            if(island.getMother()){
                System.out.println("Sull' isola è presente Madre Natura");
            }
            if(island.getTowerPlayer()==null){
                System.out.println("Nessun player possiede una torre sull'isola");
            }
            else
            {
                System.out.println("Sull'isola è presente la torre di "+island.getTowerPlayer().GetName());
            }
                System.out.println("Sull'isola sono presenti :");
            for(Colour c: Colour.values()){
                if(island.getColour(c)!=0){
                    System.out.println(island.getColour(c)+"studenti"+c.getColour());
                }
            }
            }
    }

    @Override
    public void showClouds(List<CloudIsland> clouds) {
        System.out.println("Le nuvole a disposizione sono: ");
        for(CloudIsland c : clouds){
            System.out.println("CloudID: "+c.getID());
            System.out.println("Sull'isola sono presenti :");
            for(Student s: c.getStudents()){
                    System.out.println("-studente "+s.getColour().getColour());
            }
        }

    }

    @Override
    public void showMyBoard(Player currentPlayer) {
        // show waiting Students
        for (Colour c : Colour.values()) {
            System.out.println("Gli studenti in attesa di colore " + c.getColour() + " sono: " + currentPlayer.getBoard().countStudentColor(c));
        }

        // show dining Students
        for (Colour c : Colour.values()) {
            System.out.println("Gli studenti in mensa di colore " + c.getColour() + " sono: " + currentPlayer.getBoard().getColorRowSize(c));
        }

        // show coins
        System.out.println("Hai " + currentPlayer.getBoard().getNumberofCoin() + " coins");

        // show professors
        for (Colour c : Colour.values()) {
            if (currentPlayer.getBoard().hasProfessor(c))
                System.out.println("Hai il professore di colore " + c.getColour());
        }
    }

    @Override
    public void showBoards(List<Player> players){
        for(Player p: players){
            // do showMyBoard for each player

            // show waiting Students
            for (Colour c : Colour.values()) {
                System.out.println("Gli studenti in attesa di colore " + c.getColour() + " sono: " + p.getBoard().countStudentColor(c));
            }

            // show dining Students
            for (Colour c : Colour.values()) {
                System.out.println("Gli studenti in mensa di colore " + c.getColour() + " sono: " + p.getBoard().getColorRowSize(c));
            }

            // show coins
            System.out.println("Hai " + p.getBoard().getNumberofCoin() + " coins");

            // show professors
            for (Colour c : Colour.values()) {
                if (p.getBoard().hasProfessor(c))
                    System.out.println("Hai il professore di colore " + c.getColour());
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
        System.out.println("Inserisci il nome utente");
        String username;
        username=sc.nextLine();
        notifyObserver(obs->obs.onUpdateLogin(username));
    }

    @Override
    public String askAssistant() {
        System.out.println(" Inserisci l'id di un assistente :");
        String assistantId;
        assistantId=sc.nextLine();
        return assistantId;
    }

    @Override
    public String askCharacter() {
        System.out.println(" Inserisci l'id del character :");
        String characterId;
        characterId=sc.nextLine();
        return characterId;
    }

    @Override
    public String askIsland() {
        System.out.println(" Inserisci un isola :");
        String islandId;
       islandId=sc.nextLine();
        return islandId;
    }

    @Override
    public String askColour() {
        System.out.println(" Inserisci un colore :");
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
        System.out.println("Inserisci di quanto si deve muovere madre natura: ");
        moves=sc.nextLine();
        notifyObserver(obs -> obs.onUpdateMoveMother(moves));

    }

    @Override
    public void askCloudIsland() {
        String cloudID;
        System.out.println("Inserisci l'id della nuvola che desideri : ");
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

    }

    @Override
    public void moveToTableHandler(MoveToTableDoneMessage message) {

    }

    @Override
    public void moveMotherHandler(MoveMotherDoneMessage message) {

    }

    @Override
    public void chooseAssistantHandler(ChooseAssistantDoneMessage message) {

    }

    @Override
    public void chooseCharacterHandler(ChooseCharacterDoneMessage message) {

    }

    @Override
    public void endTurnHandler(EndTurnDoneMessage message) {

    }

    @Override
    public void cloudIslandHandler(ChooseCloudDoneMessage message) {

    }

    @Override
    public void ConnectionSuccessfulHandler(ConnectionSuccessfulMessage message) {
        if(message.getSuccess()){
            gameStarter();
        }
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

    }
    public void gameStarter(){

    }


        }
