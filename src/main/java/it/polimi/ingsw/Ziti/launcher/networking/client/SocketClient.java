package it.polimi.ingsw.Ziti.launcher.networking.client;

import it.polimi.ingsw.Ziti.launcher.Messages.*;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

//Questa classe OSSERVA il ClientController e VIENE OSSERVATA dall' observer client

public class SocketClient extends ViewObservable implements ViewObserver {

    private final Socket socket;
    private final ObjectOutputStream outputStm;
    private final ObjectInputStream inputStm;
    private static final int TIMEOUT = 10000;
    private ErrorMessage errorMessage;

    public SocketClient (String address, int port) throws IOException{
            this.socket = new Socket();
            this.socket.connect(new InetSocketAddress(address, port), TIMEOUT);
            this.outputStm = new ObjectOutputStream(socket.getOutputStream());
            this.inputStm = new ObjectInputStream(socket.getInputStream());
    }

    /**
     * SEND METHODS
     * @param message used to determinate which send needs to be used
     */
    public void send(MoveToIslandMessage message) {
        try {
            outputStm.writeObject(message);
            outputStm.reset();
        } catch (IOException e) {
            errorMessage = new ErrorMessage("SocketClient", "Could not send message");
            notifyObserver(obs->obs.update(errorMessage));
        }

    }
    private void send(LoginMessage message) {
        try {
            outputStm.writeObject(message);
            outputStm.reset();
        } catch (IOException e) {
            errorMessage = new ErrorMessage("SocketClient", "Could not send message");
            notifyObserver(obs->obs.update(errorMessage));
        }
    }
    private void send(ChoseAssistantMessage message) {
        try {
            outputStm.writeObject(message);
            outputStm.reset();
        } catch (IOException e) {
            errorMessage = new ErrorMessage("SocketClient", "Could not send message");
            notifyObserver(obs->obs.update(errorMessage));
        }
    }
    private void send(CloudIslandMessage message) {
        try {
            outputStm.writeObject(message);
            outputStm.reset();
        } catch (IOException e) {
            errorMessage = new ErrorMessage("SocketClient", "Could not send message");
            notifyObserver(obs->obs.update(errorMessage));
        }
    }
    private void send(MoveMotherMessage message) {
        try {
            outputStm.writeObject(message);
            outputStm.reset();
        } catch (IOException e) {
            errorMessage = new ErrorMessage("SocketClient", "Could not send message");
            notifyObserver(obs->obs.update(errorMessage));
        }
    }
    private void send(MoveToTableMessage message) {
        try {
            outputStm.writeObject(message);
            outputStm.reset();
        } catch (IOException e) {
            errorMessage = new ErrorMessage("SocketClient", "Could not send message");
            notifyObserver(obs->obs.update(errorMessage));
        }
    }

    /**
     * RECEIVE METHOD
     */
    public void receive() {

        while (true) {
            MessageToClient messageToClient;
            try {
                if (inputStm.available() != 0) {
                    messageToClient = (MessageToClient) inputStm.readObject();
                    notifyObserver(obs -> obs.update(messageToClient));

                }
            } catch (IOException | ClassNotFoundException e) {

                errorMessage = new ErrorMessage("SocketClient", "Connection lost");
                notifyObserver(obs -> obs.update(errorMessage));
                disconnect();
            }
        }
    }




/*

    public void receiveMoveToIslandMessage(){

        while(true){
            MoveToIslandMessage message;
            try{
                if(inputStm.available()!=0){
                    message=(MoveToIslandMessage) inputStm.readObject();
                    notifyObserver(obs->obs.update(message));
                }

            } catch (IOException | ClassNotFoundException e) {

                errorMessage = new ErrorMessage("SocketClient","Connection lost");
                notifyObserver(obs->obs.update(errorMessage));
                disconnect();
            }

        }
    }
    public void receiveLoginMessage(){

        while(true){
            LoginMessage message;
            try{
                if(inputStm.available()!=0){
                    message=(LoginMessage) inputStm.readObject();
                    notifyObserver(obs->obs.update(message));
                }

            } catch (IOException | ClassNotFoundException e) {

                errorMessage = new ErrorMessage("SocketClient","Connection lost");
                notifyObserver(obs->obs.update(errorMessage));
                disconnect();
            }

        }
    }

 */

    public void disconnect() {

        try {
            socket.close();
        } catch (IOException e) {

            errorMessage = new ErrorMessage ("SocketClient","Could not disconnect");
            notifyObserver(obs->obs.update(errorMessage));
        }



    }

    @Override
    public void update(Message message) {

    }

    @Override
    public void moveToIslandHandler(MoveToIslandMessage message) {

    }

    @Override
    public void moveToTableHandler(MoveToTableMessage message) {

    }

    @Override
    public void moveMotherHandler(MoveMotherMessage message) {

    }

    @Override
    public void choseAssistantHandler(ChoseAssistantMessage message) {

    }

    @Override
    public void cloudIslandHandler(CloudIslandMessage message) {

    }

    @Override
    public void showErrorMessageHandler(ErrorMessage message) {

    }

    @Override
    public void showAssistantsMessageHandler() {

    }

    @Override
    public void showCharactersMessageHandler() {

    }

    @Override
    public void showIslandsMessageHandler() {

    }

    @Override
    public void showCloudsMessageHandler() {

    }

    @Override
    public void showMyBoardMessageHandler() {

    }

    @Override
    public void showBoardsMessageHandler() {

    }
}
