package it.polimi.ingsw.Ziti.launcher.view;

import it.polimi.ingsw.Ziti.launcher.Messages.*;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObserver;

import java.util.Scanner;

public class cli extends ViewObservable implements view, ViewObserver {

    //Questa classe OSSERVA l' ObserverClient e VIENE OSSERVATA dal ClientController

    private Scanner sc=new Scanner(System.in);

    @Override
    public void showAssistants() {

    }

    @Override
    public void showCharacters() {

    }

    @Override
    public void showIslands() {

    }

    @Override
    public void showClouds() {

    }

    @Override
    public void showMyBoard() {

    }

    @Override
    public void showBoards() {

    }

    @Override
    public void showErrorMessage(ErrorMessage message) {
        System.out.println(message.getDescription()+"from "+message.getSender());
    }

    @Override
    public void askLogin() {
        System.out.println("Inserisci il nome utente");
        String username;
        username=sc.nextLine();
        LoginMessage message;
        message=new LoginMessage("cli",username);
        notifyObserver(obs->obs.update(message));
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

    }

    @Override
    public void askMoveToIsland() {
        MoveToIslandMessage m;
        m=new MoveToIslandMessage("cli",askIsland(),askColour());
        notifyObserver(obs -> obs.update(m));
    }

    @Override
    public void askMoveMother() {

    }

    @Override
    public void askCloudIsland() {

    }

    @Override
    public void askChoseAssistant() {

    }



    public void update(MoveToIslandMessage message) {
        if(! message.getCorrect()){
            System.out.println("I dati inseriti non sono validi ! ");
            askMoveToIsland();
        }
    }

    public void update(ErrorMessage message) {
        showErrorMessage(message);
    }

    public void update(LoginMessage message) {
        if( ! message.getCorrect()){
            System.out.println("I dati inseriti non sono validi ! ");
            askLogin();
        }
    }

    public void update(MoveMotherMessage message) {
        if(!message.getCorrect()){
            System.out.println("I dati inseriti non sono validi ! ");
            askMoveMother();
        }
    }

    public void update(CloudIslandMessage message) {
        if(!message.getCorrect()){
            System.out.println("I dati inseriti non sono validi ! ");
            askCloudIsland();
        }

    }

    public void update(MoveToTableMessage message) {
        if(!message.getCorrect()){
            System.out.println("I dati inseriti non sono validi ! ");
            askMoveToTable();
        }

    }

    public void update(ChoseAssistantMessage message) {
        if(!message.getCorrect()){
            System.out.println("I dati inseriti non sono validi ! ");
            askChoseAssistant();
        }

    }

    @Override
    public void update(Message message) {

    }
}
