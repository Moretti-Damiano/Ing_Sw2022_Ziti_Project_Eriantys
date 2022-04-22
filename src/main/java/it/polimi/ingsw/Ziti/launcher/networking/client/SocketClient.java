package it.polimi.ingsw.Ziti.launcher.networking.client;

import it.polimi.ingsw.Ziti.launcher.controller.ClientController;
import it.polimi.ingsw.Ziti.launcher.enumeration.MessageType;
import it.polimi.ingsw.Ziti.launcher.networking.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketClient {

    private final Socket socket;

    private final ClientController clientController;
    private final ObjectOutputStream outputStm;
    private final ObjectInputStream inputStm;
    private static final int TIMEOUT = 10000;

    public SocketClient (String address, int port) throws IOException{
            this.socket = new Socket();
            this.socket.connect(new InetSocketAddress(address, port), TIMEOUT);
            this.clientController=new ClientController();
            this.outputStm = new ObjectOutputStream(socket.getOutputStream());
            this.inputStm = new ObjectInputStream(socket.getInputStream());
    }

    public void receiveMessage(){

        while(true){
            Message message;
            try{
                if(inputStm.available()!=0){
                    message=(Message) inputStm.readObject();
                    clientController.update(message);
                }

            } catch (IOException | ClassNotFoundException e) {

                message = new Message (MessageType.RECEIVE_ERROR,"SocketClient","Connection lost");
                clientController.update(message);
                disconnect();
            }

        }
    };
    public void sendMessage(Message message) {
        try {
            outputStm.writeObject(message);
            outputStm.reset();
        } catch (IOException e) {
            message = new Message (MessageType.SEND_ERROR,"SocketClient","Could not send message");
            clientController.update(message);
        }

    };

    public void disconnect() {
        Message message;
        try {
            socket.close();
        } catch (IOException e) {

            message = new Message (MessageType.RECEIVE_ERROR,"SocketClient","Could not disconnect");
            clientController.update(message);
        }



    }
}
