package it.polimi.ingsw.Ziti.launcher.networking.client;

import it.polimi.ingsw.Ziti.launcher.Messages.ErrorMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.LoginMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.MoveToIslandMessage;
import it.polimi.ingsw.Ziti.launcher.enumeration.MessageType;
import it.polimi.ingsw.Ziti.launcher.networking.ObserverClient;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObserver;
import it.polimi.ingsw.Ziti.launcher.view.cli;

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


    public void sendMoveToIslandMessage(MoveToIslandMessage message) {
        try {
            outputStm.writeObject(message);
            outputStm.reset();
        } catch (IOException e) {
            errorMessage = new ErrorMessage("SocketClient", "Could not send message");
            notifyObserver(obs->obs.updateErrorMessage(errorMessage));
        }

    }
    private void sendLoginMessage(LoginMessage message) {
        try {
            outputStm.writeObject(message);
            outputStm.reset();
        } catch (IOException e) {
            errorMessage = new ErrorMessage("SocketClient", "Could not send message");
            notifyObserver(obs->obs.updateErrorMessage(errorMessage));
        }
    }

    public void receiveMoveToIslandMessage(){

        while(true){
            MoveToIslandMessage message;
            try{
                if(inputStm.available()!=0){
                    message=(MoveToIslandMessage) inputStm.readObject();
                    notifyObserver(obs->obs.updateMoveToIslandMessage(message));
                }

            } catch (IOException | ClassNotFoundException e) {

                errorMessage = new ErrorMessage("SocketClient","Connection lost");
                notifyObserver(obs->obs.updateErrorMessage(errorMessage));
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
                    notifyObserver(obs->obs.updateLoginMessage(message));
                }

            } catch (IOException | ClassNotFoundException e) {

                errorMessage = new ErrorMessage("SocketClient","Connection lost");
                notifyObserver(obs->obs.updateErrorMessage(errorMessage));
                disconnect();
            }

        }
    }

    public void disconnect() {

        try {
            socket.close();
        } catch (IOException e) {

            errorMessage = new ErrorMessage ("SocketClient","Could not disconnect");
            notifyObserver(obs->obs.updateErrorMessage(errorMessage));
        }



    }

    @Override
    public void updateMoveToIslandMessage(MoveToIslandMessage message) {
        sendMoveToIslandMessage(message);
    }
    @Override
    public void updateLoginMessage(LoginMessage message) {
        sendLoginMessage(message);
    }

    /**
     *
     * Not implemented here
     */

    @Override
    public void updateErrorMessage(ErrorMessage message) {

    }
}
