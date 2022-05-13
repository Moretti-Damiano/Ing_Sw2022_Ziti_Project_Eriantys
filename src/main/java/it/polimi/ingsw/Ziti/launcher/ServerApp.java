package it.polimi.ingsw.Ziti.launcher;

import it.polimi.ingsw.Ziti.launcher.controller.GameController;
import it.polimi.ingsw.Ziti.launcher.networking.server.Server;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ServerApp {

    public int insertPort(){   //aggiungere un controllo
        Scanner in = new Scanner(System.in);
       return parseInt(in.nextLine());
    }

    public void newGame(){
        System.out.println("Starting a new game, insert a port [16847]:");
        //stampa porte gia in uso

        int port = insertPort();
        new Thread(new GameRunner(port,this)).start();
    }

    public static void main(String[] Args){
        ServerApp serverApp = new ServerApp();

        //starts first game
        serverApp.newGame();
    }
}
