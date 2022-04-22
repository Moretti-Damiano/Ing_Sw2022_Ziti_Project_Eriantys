package it.polimi.ingsw.Ziti.launcher.networking.server;

import it.polimi.ingsw.Ziti.launcher.controller.GameController;

import java.io.IOException;

public class Server {

    private GameController gameController;
    private SocketServer socketServer;

    public Server(){
    }

    public void startServer(int port){
        socketServer = new SocketServer(this,port);
        Thread serverThread = new Thread(socketServer);
        serverThread.start();
    }

    public void notifyAllPlayers(Message message) throws IOException {
        for(ClientHandler c: socketServer.getClientHandlers()){
            c.send(message);
        }
    }

    public void notifyPlayer(Message message, String nickName) throws IOException {
        for(ClientHandler c: socketServer.getClientHandlers()){
            if(c.getNickName().equals(nickName)){       //problema controllo omonimi
                c.send(message);
                break;
            }
        }
    }

    public void receive(Message message){
        gameController.menageMessage(message);
    }
}
