package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.model.Island;

import java.util.ArrayList;
    public class MoveMotherDoneMessage extends ActionMessage{
    private ArrayList<Island> islands;

    public MoveMotherDoneMessage(String description, ArrayList<Island> islands) {
        super(description);
        this.islands = new ArrayList<>(islands);
    }

        public ArrayList<Island> getIslands() {
            return islands;
        }

        @Override
        public void handle(ClientMessageHandler clientMessageHandler) {
            clientMessageHandler.MoveMotherDoneHandle(this);
        }
    }
