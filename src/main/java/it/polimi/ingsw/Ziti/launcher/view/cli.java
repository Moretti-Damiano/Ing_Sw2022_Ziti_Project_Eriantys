package it.polimi.ingsw.Ziti.launcher.view;

import it.polimi.ingsw.Ziti.launcher.enumeration.MessageType;
import it.polimi.ingsw.Ziti.launcher.networking.Message;
import it.polimi.ingsw.Ziti.launcher.observer.Observable;

import java.util.Scanner;

public class cli extends Observable implements view{

    private Thread readThread;

    private Message message;

    private Boolean valid;

    private Scanner sc=new Scanner(System.in);

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

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
    public void showMessage(Message message) {
        System.out.println(message.getBody()+"from "+message.getSender());

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
    public Message askIsland() {
        System.out.println(" Inserisci un isola :");
        Message message;
        message=new Message(MessageType.ID_GIVEN,"askIsland",sc.nextLine());
        return message;
    }

    @Override
    public void askColour() {

    }

    @Override
    public void askMoveToTable() {

    }

    @Override
    public void askMoveToIsland() {
        do{
            notifyObserver(askIsland());
        }while(!valid);

        Message message=new Message(MOVETOISLAND,"cli",)

        do{
            askColour();
        }while(!valid);

    }

    @Override
    public void askMoveMother() {

    }

    @Override
    public void askCloudIsland() {

    }
}
