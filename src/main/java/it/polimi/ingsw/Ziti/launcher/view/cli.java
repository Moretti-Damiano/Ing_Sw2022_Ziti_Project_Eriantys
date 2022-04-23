package it.polimi.ingsw.Ziti.launcher.view;

import it.polimi.ingsw.Ziti.launcher.Messages.ErrorMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.Message;
import it.polimi.ingsw.Ziti.launcher.Messages.MoveToIslandMessage;
import it.polimi.ingsw.Ziti.launcher.enumeration.MessageType;
import it.polimi.ingsw.Ziti.launcher.networking.ObserverClient;
import it.polimi.ingsw.Ziti.launcher.observer.Observable;
import it.polimi.ingsw.Ziti.launcher.observer.Observer;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObserver;

import java.util.Scanner;

public class cli extends ViewObservable implements view, ViewObserver {

    //Questa classe OSSERVA l' ObserverClient e VIENE OSSERVATA dal ClientController

    private Scanner sc=new Scanner(System.in);

    @Override
    public void showAssistant() {

    }

    @Override
    public void showCharacter() {

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

    }

    @Override
    public void askAssistant() {

    }

    @Override
    public void askCharacter() {

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
        notifyObserver(viewObserver -> viewObserver.updateMoveToIslandMessage(m));
    }

    @Override
    public void askMoveMother() {

    }

    @Override
    public void askCloudIsland() {

    }


    /**
     *
     * Not Used here
     */
    @Override
    public void updateMoveToIslandMessage(MoveToIslandMessage message) {
        if(message.getCorrect()==false){
            System.out.println("I dati inseriti non sono validi ! ");
            askMoveToIsland();
        }
    }

    @Override
    public void updateErrorMessage(ErrorMessage message) {
        showErrorMessage(message);
    }
}
