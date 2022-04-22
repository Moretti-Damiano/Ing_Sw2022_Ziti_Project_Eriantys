package it.polimi.ingsw.Ziti.launcher.view;

import it.polimi.ingsw.Ziti.launcher.Messages.ErrorMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.Message;
import it.polimi.ingsw.Ziti.launcher.Messages.MoveToIslandMessage;
import it.polimi.ingsw.Ziti.launcher.enumeration.MessageType;
import it.polimi.ingsw.Ziti.launcher.networking.ObserverClient;
import it.polimi.ingsw.Ziti.launcher.observer.Observable;
import it.polimi.ingsw.Ziti.launcher.observer.Observer;

import java.util.Scanner;

public class cli extends Observable implements view {


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
        notifyObserverMoveToIslandMessage(m);
    }

    @Override
    public void askMoveMother() {

    }

    @Override
    public void askCloudIsland() {

    }

    @Override
    public void setValid(Boolean valid) {
        
    }

    @Override
    public void updateError(ErrorMessage message) {
    showErrorMessage(message);
    }

    @Override
    public void updateMoveToIsland(MoveToIslandMessage message) {

    }
}
