package it.polimi.ingsw.Ziti.launcher.networking.server;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.MessageToClient;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.MessagetoServer;
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

    /**
     * Send a message to every connected client
     * @param message the message to be sent
     */
    public void notifyAllPlayers(MessageToClient message)  {
        for(ClientHandler c: socketServer.getClientHandlers()){
            c.send(message);
        }
    }

    /**
     * Send a message to one client
     * @param message the message to be sent
     * @param nickName the client who will receive the message
     */
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
    public void sendToOnePlayer(MessageToClient message, String nickName)  {
        notifyPlayer(message,nickName);
    }

    @Override
    public void sendToAllPlayers(MessageToClient message) {
        notifyAllPlayers(message);
    }

    public void successfulLogin(MessageToClient message, String temporaryName, String newName){
        notifyPlayer(message,temporaryName);
        socketServer.getClientHandlers().get(Integer.parseInt(temporaryName)).setNickName(newName);
    }

    
    public void requestPlayerNumber(MessageToClient message, String nickName){
        notifyPlayer(message,nickName);
    }
}
