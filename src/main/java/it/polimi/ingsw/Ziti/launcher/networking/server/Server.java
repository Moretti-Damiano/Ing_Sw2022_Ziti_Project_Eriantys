package it.polimi.ingsw.Ziti.launcher.networking.server;

import it.polimi.ingsw.Ziti.launcher.Messages.Message;
import it.polimi.ingsw.Ziti.launcher.controller.GameController;
import it.polimi.ingsw.Ziti.launcher.observer.Observable;
import it.polimi.ingsw.Ziti.launcher.observer.Observer;

import java.io.IOException;

public class Server extends Observable{

    private int port;
    private SocketServer socketServer;

    public Server(int port){
        this.port = port;
    }

    public void startServer(){
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
        notifyObserver(message);
    }

}
