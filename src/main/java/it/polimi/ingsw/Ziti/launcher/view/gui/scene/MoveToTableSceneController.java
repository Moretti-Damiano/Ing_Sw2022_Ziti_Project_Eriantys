package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
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

        private int numBoard;
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


    public MoveToTableSceneController(){
        numBoard=0;
        boards= new ArrayList<>();
    }





    @FXML
    public void initialize() {
        checkAndDisableButton(PreviousBtn, 0);
        checkAndDisableButton(NextBtn, boards.size()-1);

        ConfirmBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onConfirmClick);
        NextBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onNextClick);
        PreviousBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onPreviousClick);
        BoardName.setText(boards.get(0).getPlayername());   //maybe need to be changed

        MoveToTableChoiceBtn.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onMoveToTableChoiceBtn);
        board=boards.get(0);
        studentsWaiting = new ArrayList<>();
        studentsWaiting.add(WaitingStudent0);
        studentsWaiting.add(WaitingStudent1);
        studentsWaiting.add(WaitingStudent2);
        studentsWaiting.add(WaitingStudent3);
        studentsWaiting.add(WaitingStudent4);
        studentsWaiting.add(WaitingStudent5);
        studentsWaiting.add(WaitingStudent6);
        studentsWaiting.add(WaitingStudent7);
        studentsWaiting.add(WaitingStudent8);
        setStudentsWaiting(studentsWaiting,board);
        MoveBlue.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onMoveBlueClick);
        MoveGreen.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onMoveGreenClick);
        MovePink.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onMovePinkClick);
        MoveRed.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onMoveRedClick);
        MoveYellow.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onMoveYellowClick);

    }
    private void setStudentsWaiting(ArrayList<ImageView> students,Board board){
        Image blue_student = new Image(getClass().getResourceAsStream("/images/blue_student.png"));
        Image green_student = new Image(getClass().getResourceAsStream("/images/green_student.png"));
        Image pink_student = new Image(getClass().getResourceAsStream("/images/pink_student.png"));
        Image red_student = new Image(getClass().getResourceAsStream("/images/red_student.png"));
        Image yellow_student = new Image(getClass().getResourceAsStream("/images/yellow_student.png"));

        for(int i=0;i<board.getStudents_waiting().size();i++){

            switch (board.getStudents_waiting().get(i).getColour()){
                case BLUE:
                    students.get(i).setImage(blue_student);
                    break;
                case GREEN:
                    students.get(i).setImage(green_student);
                    break;
                case PINK:
                    students.get(i).setImage(pink_student);
                    break;
                case RED:
                    students.get(i).setImage(red_student);
                    break;
                case YELLOW:
                    students.get(i).setImage(yellow_student);
                    break;
                default: break;
            }
        }

    }

    @FXML
    void onConfirmClick(Event event) {
        new Thread(() -> notifyObserver(obs -> obs.onUpdateMoveToTable(board.getStudents_waiting().get(numBoard).toString()))).start();
        SceneController.changeRootPane(observers, event, "select_scene.fxml");
    }

    @FXML
    void onNextClick(Event event) {
        int max= boards.size();
        if(numBoard<=max){
            numBoard++;
            board=boards.get(numBoard);
            BoardName.setText(board.getPlayername());
            checkAndDisableButton(PreviousBtn, 0);
            checkAndDisableButton(NextBtn, boards.size()-1);
            checkAndAbleButton( MoveToTableChoiceBtn,0);



            Image img = new Image(getClass().getResourceAsStream("/images/Plancia_DEF2.png"));
            BoardImage.setImage(img);
            setStudentsWaiting(studentsWaiting,board);
        }

    }
    @FXML
    void onMoveToTableChoiceBtn(Event event){


    }

    @FXML
    void onPreviousClick(Event event) {
        if(numBoard>0){
            numBoard--;
            BoardName.setText(boards.get(numBoard).getPlayername());

            board=boards.get(numBoard);
            Image img = new Image(getClass().getResourceAsStream("/images/Plancia_DEF2.png"));
            BoardImage.setImage(img);
            checkAndDisableButton(PreviousBtn, 0);
            checkAndDisableButton(NextBtn, boards.size()-1);
            checkAndAbleButton( MoveToTableChoiceBtn,0);
            setStudentsWaiting(studentsWaiting,board);
        }
    }

    public void addBoards(List<Board> pr){
        this.boards=pr;
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
    private boolean checkAndDisableButton(Button button, int number) {
        if (numBoard == number) {
            button.setDisable(true);
            return true;
        }
        button.setDisable(false);
        return false;
    }
    private boolean checkAndAbleButton(MenuButton button, int number) {
        if (numBoard == number) {
            button.setDisable(false);
            return false;
        }
        button.setDisable(true);
        return true;
    }


}
