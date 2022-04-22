package it.polimi.ingsw.Ziti.launcher.networking.client;

import it.polimi.ingsw.Ziti.launcher.controller.ClientController;
import it.polimi.ingsw.Ziti.launcher.networking.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClient {

    private final Socket socket;

    private final ClientController clientController;

    private final ObjectOutputStream outputStm;
    private final ObjectInputStream inputStm;

    public SocketClient () throws IOException{
        this.socket = new Socket();
            this.outputStm = new ObjectOutputStream(socket.getOutputStream());
            this.inputStm = new ObjectInputStream(socket.getInputStream());
    }

    public void receiveMessage();
    public void sendMessage(Message message);
}
