package it.polimi.ingsw.Ziti.launcher.networking.server;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;
import it.polimi.ingsw.Ziti.launcher.Messages.MessagetoServer;
import it.polimi.ingsw.Ziti.launcher.Messages.ServerMessageHandler;
import it.polimi.ingsw.Ziti.launcher.observer.GameControllerObserver;

public class Server implements GameControllerObserver {

    private int port;
    private SocketServer socketServer;
    private ServerMessageHandler serverMessageHandler; //needs to be observed by gamecontroller

    public Server(int port){
        this.port = port;
    }

    public void startServer(){
        socketServer = new SocketServer(this,port);
        serverMessageHandler = new ServerMessageHandler();
        Thread serverThread = new Thread(socketServer);
        serverThread.start();
    }

    public void notifyAllPlayers(MessageToClient message)  {
        for(ClientHandler c: socketServer.getClientHandlers()){
            c.send(message);
        }
    }

    public void notifyPlayer(MessageToClient message, String nickName)  {
        for(ClientHandler c: socketServer.getClientHandlers()){
            if(c.getNickName().equals(nickName)){       //problema controllo omonimi
                c.send(message);
                break;
            }
        }
    }

    public void receive(MessagetoServer message){
        message.handle(serverMessageHandler);
    }

    @Override
    public void update(MessageToClient message, String nickName)  {
        notifyPlayer(message,nickName);
    }
}
