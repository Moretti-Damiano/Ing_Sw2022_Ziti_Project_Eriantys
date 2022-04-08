package it.polimi.ingsw.Ziti.launcher.action;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.model.Game;
import it.polimi.ingsw.Ziti.launcher.model.Player;
import it.polimi.ingsw.Ziti.launcher.model.WalletController;

public class MoveToTable implements Action{

    private Game game;
    private Colour chosencolour;
    private Player activeplayer;
    private WalletController walletController;

    public MoveToTable(Game game,Colour chosencolour,Player activeplayer,WalletController walletController){
        this.game=game;
        this.chosencolour=chosencolour;
        this.activeplayer=activeplayer;
        this.walletController=walletController;
    }

    public void execute(){
        this.goLunch(chosencolour);
        this.controlProfessor(chosencolour);

    }

    /**
     * add a student to the row with the same colour and check if the new student is on a 'coin generator' position
     * @param student_colour the colour of the student to add
     */
    private void goLunch(Colour student_colour) {
        activeplayer.getBoard().addStudenttoColourRow(activeplayer.getBoard().removeStudent(student_colour));
        if(activeplayer.getBoard().checkCoin(student_colour)){
            activeplayer.getBoard().addCoin(walletController.getCoin());
        }
    }

    /**
     * check if the player has the highest value of influence for the chosen colour, in this case add the professor with the same colour to his board
     * @param professor_colour the colour of the professor to check
     */
    private void controlProfessor(Colour professor_colour){
        Player profplayer= game.checkProfessor(professor_colour);
        if(profplayer==null){
            activeplayer.getBoard().addProfessor(game.getProfessorbyColour(professor_colour));
        }
        if(profplayer!=null && profplayer!=activeplayer){
            if(activeplayer.getBoard().getColorRowSize(professor_colour)>profplayer.getBoard().getColorRowSize(professor_colour)){
                activeplayer.getBoard().addProfessor(profplayer.getBoard().removeProfessorByColour(professor_colour));
            }
        }
    }
    }


