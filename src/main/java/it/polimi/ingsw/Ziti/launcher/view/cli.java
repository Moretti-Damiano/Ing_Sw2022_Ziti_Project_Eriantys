package it.polimi.ingsw.Ziti.launcher.view;

import it.polimi.ingsw.Ziti.launcher.Messages.*;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.model.*;
import it.polimi.ingsw.Ziti.launcher.observer.ClientObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObserver;

import java.lang.Character;
import java.util.List;
import java.util.Scanner;

public class cli extends ClientObservable implements view, ViewObserver {

    //Questa classe OSSERVA il ClientMessageHandler e VIENE OSSERVATA dal ClientController

    private Scanner sc;

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
        LoginMessage message;
        message=new LoginMessage("cli",username);
        notifyObserver(obs->obs.send(message));
    }

    @Override
    public int askAssistant() {
        System.out.println(" Inserisci l'id di un assistente :");
        int assistantId;
        assistantId=sc.nextInt();
        return assistantId;
    }

    @Override
    public int askCharacter() {
        System.out.println(" Inserisci l'id del character :");
        int characterId;
        characterId=sc.nextInt();
        return characterId;
    }

    @Override
    public int askIsland() {
        System.out.println(" Inserisci un isola :");
        int islandId;
       islandId=sc.nextInt();
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
        MoveToTableMessage m;
        m=new MoveToTableMessage("cli",askColour());
        notifyObserver(obs -> obs.send(m));

    }

    @Override
    public void askMoveToIsland() {
        MoveToIslandMessage m;
        m=new MoveToIslandMessage("cli",askIsland(),askColour());
        notifyObserver(obs -> obs.send(m));
    }

    @Override
    public void askMoveMother() {
        MoveMotherMessage m;
        int moves;
        System.out.println("Inserisci di quanto si deve muovere madre natura: ");
        moves=sc.nextInt();
        m=new MoveMotherMessage("cli",moves);
        notifyObserver(obs -> obs.send(m));

    }

    @Override
    public void askCloudIsland() {
        CloudIslandMessage m;
        int cloudID;
        System.out.println("Inserisci l'id della nuvola che desideri : ");
        cloudID=sc.nextInt();
        m=new CloudIslandMessage("cli",cloudID);
        notifyObserver(obs -> obs.send(m));
    }

    @Override
    public void askChoseAssistant() {
        ChoseAssistantMessage m;
        m=new ChoseAssistantMessage("cli",askAssistant());
        notifyObserver(obs -> obs.send(m));
    }

    public void InputErrorHandler(InputError message) {
        showInputErrorMessage(message);
    }


    @Override
    public void ErrorMessageHandler(ErrorMessage message) {
        showErrorMessage(message);
    }


    @Override
    public void moveToIslandHandler(MoveToIslandMessage message) {

    }

    @Override
    public void moveToTableHandler(MoveToTableMessage message) {

    }

    @Override
    public void moveMotherHandler(MoveMotherMessage message) {

    }

    @Override
    public void choseAssistantHandler(ChoseAssistantMessage message) {

    }

    @Override
    public void cloudIslandHandler(CloudIslandMessage message) {

    }

    @Override
    public void showErrorMessageHandler(ErrorMessage message) {

    }

    @Override
    public void showAssistantsMessageHandler() {

    }

    @Override
    public void showCharactersMessageHandler() {

    }

    @Override
    public void showIslandsMessageHandler() {

    }

    @Override
    public void showCloudsMessageHandler(showCloudsMessage message) {
        showClouds(message.getCloudIslands());
    }

    @Override
    public void showMyBoardMessageHandler() {

    }

    @Override
    public void showBoardsMessageHandler() {

    }
}
