package it.polimi.ingsw.Ziti.launcher.networking.server;

import it.polimi.ingsw.Ziti.launcher.controller.GameController;
import it.polimi.ingsw.Ziti.launcher.observer.LoginObserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class contains the serverSocket of the server.
 * When started it initializes a new gameController and set this as on observer.
 * When the gameController is ready to start the game, it notifies this class, which will proceed to create
 * a new gameController for a new game.
 */
public class MainSocketServer implements LoginObserver {

    private final int port;
    private ServerSocket serverSocket;
    GameController gameController;
    MatchServer server;

    public MainSocketServer(int port){
        this.port = port;
    }

    /**
     * Initializies the serverSocket and start waiting for connections.
     * When a client connects, it creates his dedicated clientHandler and assigns it to his matchServer.
     */
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

    /**
     * Creates a new gameController and a new matchServer, then it sets all the necessary
     * observers
     */
    private void createNewGame(){
        System.out.println("MAINSOCKETSERVER - Creating a new game: ");
        gameController = new GameController();
        server = new MatchServer();
        server.getServerMessageHandler().addObserver(gameController);
        gameController.addObserver(server);
        gameController.addObserver(this);
    }

    /**
     * Called when a game starts, this method allows to create a new game and players to connect
     */
    @Override
    public void update() {
        createNewGame();
    }
}
