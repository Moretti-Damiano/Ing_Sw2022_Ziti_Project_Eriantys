package it.polimi.ingsw.Ziti.launcher.networking.server;

import it.polimi.ingsw.Ziti.launcher.controller.GameController;
import it.polimi.ingsw.Ziti.launcher.observer.LoginObserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainSocketServer implements LoginObserver {

    private int port;
    private ServerSocket serverSocket;
    GameController gameController;
    MatchServer server;

    public MainSocketServer(int port){
        this.port = port;
    }

    public void startServer(){
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("MAINSOCKETSERVER - Main server started");
        } catch (IOException e) {System.out.println("MAINSOCKETSERVER - Server could not start");}

        createNewGame();

        while(true) {
            try {
                System.out.println("MAINSOCKETSERVER - Waiting for connection:");
                Socket socket = serverSocket.accept();
                System.out.println("MAINSOCKETSERVER - New connection received!");
                ClientHandler clientHandler = new ClientHandler(socket,server,Integer.toString(server.getClientHandlers().size()));
                server.getClientHandlers().add(clientHandler);
                new Thread(clientHandler).start();

            } catch (IOException e) {System.out.println("MAINSOCKETSERVER - Connection failed");}
        }
    }


    private void createNewGame(){
        System.out.println("MAINSOCKETSERVER - Creating a new game: ");
        gameController = new GameController(this);
        server = new MatchServer();
        server.getServerMessageHandler().addObserver(gameController);
        gameController.addObserver(server);
        gameController.addObserver(this);
    }

    @Override
    public void update() {
        createNewGame();
    }
}
