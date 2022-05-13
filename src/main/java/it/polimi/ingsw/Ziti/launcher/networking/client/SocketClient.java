package it.polimi.ingsw.Ziti.launcher.networking.client;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ErrorMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.MessageToClient;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.MessagetoServer;
import it.polimi.ingsw.Ziti.launcher.observer.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * This class observes Client Controller and is observed by Observer Client
 * Used to interface with client
 */


public class SocketClient extends SocketClientObservable implements ClientObserver{

    private final Socket socket;
    private final ObjectOutputStream outputStm;
    private final ObjectInputStream inputStm;
    private static final int TIMEOUT = 10000;
    private ErrorMessage errorMessage;
    MessageToClient messageToClient;
    private final ExecutorService readExecutionQueue;

    public SocketClient (String address, int port,ObserverClient observerClient) throws IOException{
            this.socket = new Socket();
            this.addObserver(observerClient);
            try {
                this.socket.connect(new InetSocketAddress(address, port), TIMEOUT);
            }catch(IllegalArgumentException i){
                errorMessage=new ErrorMessage("SocketClint","Invalid port/host");
                notifyObserver(obs->obs.update(errorMessage));
                socket.close();
            }
            this.readExecutionQueue= Executors.newSingleThreadExecutor();
            this.outputStm = new ObjectOutputStream(socket.getOutputStream());
            this.inputStm = new ObjectInputStream(socket.getInputStream());

    }
    public void connect() {

        final Thread outThread = new Thread(){
            public void run() {
                receive();
            }
    };
    outThread.start();
    }

    /**
     * Send messages to the server
     * @param message used to determinate which send needs to be used
     */
    public void send(MessagetoServer message) {
        try {
            //System.out.println("Sending " + message.toString());
            outputStm.writeObject(message);
            outputStm.reset();
        } catch (IOException e) {
            errorMessage = new ErrorMessage("SocketClient", "Could not send message");
            notifyObserver(obs->obs.update(errorMessage));
        }
    }

    /**
     * Receive methods(messages) from server
     */
    public void receive() {
        readExecutionQueue.execute(() ->{
        while (!readExecutionQueue.isShutdown()) {
            try {
                    System.out.println("waiting input :");
                    messageToClient = (MessageToClient) inputStm.readObject();
                    //System.out.println("Ho letto mesaggio di tipo: " + messageToClient.toString());
                    notifyObserver(obs -> obs.update(messageToClient));

            } catch (IOException | ClassNotFoundException e) {
                errorMessage = new ErrorMessage("SocketClient", "Connection lost");
                notifyObserver(obs -> obs.update(errorMessage));
                disconnect();
            }
        }
    });
    }

    /**
     * Method used to close the Socket
     */
    public void disconnect() {

        try {
            if(!socket.isClosed()){
                readExecutionQueue.shutdownNow();
                socket.close();
            }
        } catch (IOException e) {
            errorMessage = new ErrorMessage ("SocketClient","Could not disconnect");
            notifyObserver(obs->obs.update(errorMessage));
        }
    }

}
