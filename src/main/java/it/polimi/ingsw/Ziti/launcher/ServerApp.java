package it.polimi.ingsw.Ziti.launcher;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ServerApp {

    private int port;

    public int insertPort(){   //aggiungere un controllo
        Scanner in = new Scanner(System.in);
       return parseInt(in.nextLine());
    }

    public void newGame(){
        System.out.println("Starting a new game at Port: " + this.port);
        new Thread(new GameRunner(port,this)).start();
        this.port++;
    }

    public static void main(String[] Args){
        ServerApp serverApp = new ServerApp();
        System.out.println("Insert a port [16847]\nthe next games will run on consecutive port");
        serverApp.port = serverApp.insertPort();

        //starts first game
        serverApp.newGame();
    }
}
