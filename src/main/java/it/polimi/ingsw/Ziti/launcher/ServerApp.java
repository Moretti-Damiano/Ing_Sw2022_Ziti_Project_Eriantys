package it.polimi.ingsw.Ziti.launcher;

import it.polimi.ingsw.Ziti.launcher.networking.server.MainSocketServer;

import static java.lang.Integer.parseInt;

public class ServerApp {

    private final MainSocketServer mainSocketServer;


    public static void main(String[] Args){

        ServerApp serverApp = new ServerApp();
        serverApp.startServer();
    }


    public ServerApp(){
        mainSocketServer = new MainSocketServer(16847);
    }

    public void startServer(){
        System.out.println("Starting server on port 16847");
        mainSocketServer.startServer();
    }
}
