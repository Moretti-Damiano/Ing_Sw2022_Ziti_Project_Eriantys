package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.model.Assistant;
import it.polimi.ingsw.Ziti.launcher.model.Board;
import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class MoveToTableSceneController extends InputObservable implements GenericSceneController {

        @FXML
        private Button ConfirmBtn;

        @FXML
        private Button NextBtn;

        @FXML
        private Button PreviousBtn;

        @FXML
        private TextField BoardName;

        @FXML
        private ImageView BoardImage;

        private int numBoard=1;
        private List<Board> boards;
        private Board board;
        private ArrayList<ImageView> studentsWaiting;


         @FXML
        private MenuButton MoveToTableChoiceBtn;
         @FXML
         private MenuItem MoveBlue;
        @FXML
        private MenuItem MoveGreen;
        @FXML
        private MenuItem MovePink;
        @FXML
        private MenuItem MoveRed;
        @FXML
        private MenuItem MoveYellow;
         @FXML
         private ImageView WaitingStudent0;
         @FXML
         private ImageView WaitingStudent1;
        @FXML
        private ImageView WaitingStudent2;
        @FXML
        private ImageView WaitingStudent3;
        @FXML
        private ImageView WaitingStudent4;
        @FXML
        private ImageView WaitingStudent5;
        @FXML
        private ImageView WaitingStudent6;
//needs to be added 7 and 8 for 3 players
        @FXML
        private ImageView WaitingStudent7;
        @FXML
        private ImageView WaitingStudent8;
        @FXML
        private ImageView DiningStudentGreen0;
        @FXML
        private ImageView DiningStudentBlue0;
        @FXML
        private ImageView DiningStudentRed0;
        @FXML
        private ImageView DiningStudentPink0;
        @FXML
        private ImageView DiningStudentYellow0;








    @FXML
    public void initialize() {
        ConfirmBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onConfirmClick);
        NextBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onNextClick);
        PreviousBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onPreviousClick);
        BoardName.setText(boards.get(0).getPlayername());   //maybe need to be changed
        MoveToTableChoiceBtn.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onMoveToTableChoiceBtn);
        studentsWaiting = new ArrayList<>();
        studentsWaiting.add(WaitingStudent0);
        studentsWaiting.add(WaitingStudent1);
        studentsWaiting.add(WaitingStudent2);
        studentsWaiting.add(WaitingStudent3);
        studentsWaiting.add(WaitingStudent4);
        studentsWaiting.add(WaitingStudent5);
        studentsWaiting.add(WaitingStudent6);
        MoveBlue.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onMoveBlueClick);
        MoveGreen.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onMoveGreenClick);
        MovePink.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onMovePinkClick);
        MoveRed.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onMoveRedClick);
        MoveYellow.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onMoveYellowClick);

    }

    @FXML
    void onConfirmClick(Event event) {
        new Thread(() -> notifyObserver(obs -> obs.onUpdateMoveToTable(board.getStudents_waiting().get(numBoard).toString()))).start();
        SceneController.changeRootPane(observers, event, "select_scene.fxml");
    }

    @FXML
    void onNextClick(Event event) {
        BoardName.setText(boards.get(numBoard).getPlayername());
        int max= boards.size();
        if(numBoard<max){
            numBoard++;
            board=boards.get(numBoard);
            Image img = new Image(getClass().getResourceAsStream("/images/Plancia_DEF2.png"));
            BoardImage.setImage(img);
        }

    }
    @FXML
    void onMoveToTableChoiceBtn(Event event){


    }

    @FXML
    void onPreviousClick(Event event) {
        BoardName.setText(boards.get(numBoard).getPlayername());
        if(numBoard>0)
        {
            numBoard--;
            board=boards.get(numBoard);
            Image img = new Image(getClass().getResourceAsStream("/images/Plancia_DEF2.png"));
            BoardImage.setImage(img);
        }
    }

    public void addBoards(List<Board> boards){
        this.boards=boards;
    }

    @FXML
    void onMoveBlueClick(Event event){

    }
    @FXML
    void onMoveGreenClick(Event event){

    }
    @FXML
    void onMovePinkClick(Event event){

    }
    @FXML
    void onMoveRedClick(Event event){

    }
    @FXML
    void onMoveYellowClick(Event event){

    }

}
