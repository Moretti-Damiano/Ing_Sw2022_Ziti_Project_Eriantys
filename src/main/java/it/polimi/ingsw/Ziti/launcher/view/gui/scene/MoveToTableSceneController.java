package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.model.Assistant;
import it.polimi.ingsw.Ziti.launcher.model.Board;
import it.polimi.ingsw.Ziti.launcher.model.Student;
import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class MoveToTableSceneController extends InputObservable implements GenericSceneController {

        private int numBoard;
        private List<Board> boards;
        private Board board;
        private ArrayList<ImageView> studentsWaiting;
        private ArrayList<ImageView> diningStudentsBlue;
        private ArrayList<ImageView> diningStudentsGreen;
        private ArrayList<ImageView> diningStudentsPink;
        private ArrayList<ImageView> diningStudentsRed;
        private ArrayList<ImageView> diningStudentsYellow;
        private ArrayList<ImageView> professors;
        private ArrayList<ImageView> towers;
        private ArrayList<ArrayList<ImageView>> diningStudents;
    @FXML
    private ImageView BoardImage;

    @FXML
    private Label BoardName;

    @FXML
    private Button ConfirmBtn;

    @FXML
    private ImageView DiningStudentBlue0;

    @FXML
    private ImageView DiningStudentBlue01;

    @FXML
    private ImageView DiningStudentBlue02;

    @FXML
    private ImageView DiningStudentBlue03;

    @FXML
    private ImageView DiningStudentBlue04;

    @FXML
    private ImageView DiningStudentBlue05;

    @FXML
    private ImageView DiningStudentBlue06;

    @FXML
    private ImageView DiningStudentBlue07;

    @FXML
    private ImageView DiningStudentBlue08;

    @FXML
    private ImageView DiningStudentBlue09;

    @FXML
    private ImageView DiningStudentGreen0;

    @FXML
    private ImageView DiningStudentGreen01;

    @FXML
    private ImageView DiningStudentGreen02;

    @FXML
    private ImageView DiningStudentGreen03;

    @FXML
    private ImageView DiningStudentGreen04;

    @FXML
    private ImageView DiningStudentGreen05;

    @FXML
    private ImageView DiningStudentGreen06;

    @FXML
    private ImageView DiningStudentGreen07;

    @FXML
    private ImageView DiningStudentGreen08;

    @FXML
    private ImageView DiningStudentGreen09;

    @FXML
    private ImageView DiningStudentPink0;

    @FXML
    private ImageView DiningStudentPink01;

    @FXML
    private ImageView DiningStudentPink02;

    @FXML
    private ImageView DiningStudentPink03;

    @FXML
    private ImageView DiningStudentPink04;

    @FXML
    private ImageView DiningStudentPink05;

    @FXML
    private ImageView DiningStudentPink06;

    @FXML
    private ImageView DiningStudentPink07;

    @FXML
    private ImageView DiningStudentPink08;

    @FXML
    private ImageView DiningStudentPink09;

    @FXML
    private ImageView DiningStudentRed0;

    @FXML
    private ImageView DiningStudentRed01;

    @FXML
    private ImageView DiningStudentRed02;

    @FXML
    private ImageView DiningStudentRed03;

    @FXML
    private ImageView DiningStudentRed04;

    @FXML
    private ImageView DiningStudentRed05;

    @FXML
    private ImageView DiningStudentRed06;

    @FXML
    private ImageView DiningStudentRed07;

    @FXML
    private ImageView DiningStudentRed08;

    @FXML
    private ImageView DiningStudentRed09;

    @FXML
    private ImageView DiningStudentYellow0;

    @FXML
    private ImageView DiningStudentYellow01;

    @FXML
    private ImageView DiningStudentYellow02;

    @FXML
    private ImageView DiningStudentYellow03;

    @FXML
    private ImageView DiningStudentYellow04;

    @FXML
    private ImageView DiningStudentYellow05;

    @FXML
    private ImageView DiningStudentYellow06;

    @FXML
    private ImageView DiningStudentYellow07;

    @FXML
    private ImageView DiningStudentYellow08;

    @FXML
    private ImageView DiningStudentYellow09;

    @FXML
    private Button NextBtn;

    @FXML
    private Button PreviousBtn;

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
    private ImageView blueProfessor;

    @FXML
    private ImageView greenProfessor;

    @FXML
    private ImageView pinkProfessor;

    @FXML
    private ImageView redProfessor;

    @FXML
    private ImageView yellowProfessor;

    @FXML
    private ImageView tower0;

    @FXML
    private ImageView tower01;

    @FXML
    private ImageView tower02;

    @FXML
    private ImageView tower03;

    @FXML
    private ImageView tower04;

    @FXML
    private ImageView tower05;

    @FXML
    private ImageView tower06;

    @FXML
    private ImageView tower07;

    @FXML
    private Text Id0;

    @FXML
    private Text Id1;

    @FXML
    private Text Id10;

    @FXML
    private Text Id11;

    @FXML
    private Text Id2;

    @FXML
    private Text Id3;

    @FXML
    private Text Id4;

    @FXML
    private Text Id5;

    @FXML
    private Text Id6;

    @FXML
    private Text Id7;

    @FXML
    private Text Id8;

    @FXML
    private Text Id9;

    @FXML
    private ImageView Island0;

    @FXML
    private ImageView Island1;

    @FXML
    private ImageView Island10;

    @FXML
    private ImageView Island11;

    @FXML
    private ImageView Island2;

    @FXML
    private ImageView Island3;

    @FXML
    private ImageView Island4;

    @FXML
    private ImageView Island5;

    @FXML
    private ImageView Island6;

    @FXML
    private ImageView Island7;

    @FXML
    private ImageView Island8;

    @FXML
    private ImageView Island9;

    @FXML
    private Text IslandDesc;

    @FXML
    private Group IslandGroup;

    @FXML
    private ImageView M;

    @FXML
    private ImageView M1;

    @FXML
    private ImageView M10;

    @FXML
    private ImageView M11;

    @FXML
    private ImageView M2;

    @FXML
    private ImageView M3;

    @FXML
    private ImageView M4;

    @FXML
    private ImageView M5;

    @FXML
    private ImageView M6;

    @FXML
    private ImageView M7;

    @FXML
    private ImageView M8;

    @FXML
    private ImageView M9;

    @FXML
    private Button MTIBtn;

    @FXML
    private Button MTTBtn;

    @FXML
    private ImageView T;

    @FXML
    private ImageView T1;

    @FXML
    private ImageView T10;

    @FXML
    private ImageView T11;

    @FXML
    private ImageView T2;

    @FXML
    private ImageView T3;

    @FXML
    private ImageView T4;

    @FXML
    private ImageView T5;

    @FXML
    private ImageView T6;

    @FXML
    private ImageView T7;

    @FXML
    private ImageView T8;

    @FXML
    private ImageView T9;

    @FXML
    private Button SelectBtn;





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
        MTTBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onMoveToTableClick);
        MTIBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onMoveToIslandClick);
        SelectBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onSelectBtnClick);

        Label  BoardName = new Label("Board");  //maybe need to be changed
        BoardName.setText(boards.get(0).getPlayername());

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

        diningStudentsBlue = new ArrayList<>();
        diningStudentsBlue.add(DiningStudentBlue0);
        diningStudentsBlue.add(DiningStudentBlue01);
        diningStudentsBlue.add(DiningStudentBlue02);
        diningStudentsBlue.add(DiningStudentBlue03);
        diningStudentsBlue.add(DiningStudentBlue04);
        diningStudentsBlue.add(DiningStudentBlue05);
        diningStudentsBlue.add(DiningStudentBlue06);
        diningStudentsBlue.add(DiningStudentBlue07);
        diningStudentsBlue.add(DiningStudentBlue08);
        diningStudentsBlue.add(DiningStudentBlue09);
        diningStudentsGreen = new ArrayList<>();
        diningStudentsGreen.add(DiningStudentGreen0);
        diningStudentsGreen.add(DiningStudentGreen01);
        diningStudentsGreen.add(DiningStudentGreen02);
        diningStudentsGreen.add(DiningStudentGreen03);
        diningStudentsGreen.add(DiningStudentGreen04);
        diningStudentsGreen.add(DiningStudentGreen05);
        diningStudentsGreen.add(DiningStudentGreen06);
        diningStudentsGreen.add(DiningStudentGreen07);
        diningStudentsGreen.add(DiningStudentGreen08);
        diningStudentsGreen.add(DiningStudentGreen09);
        diningStudentsPink = new ArrayList<>();
        diningStudentsPink.add(DiningStudentPink0);
        diningStudentsPink.add(DiningStudentPink01);
        diningStudentsPink.add(DiningStudentPink02);
        diningStudentsPink.add(DiningStudentPink03);
        diningStudentsPink.add(DiningStudentPink04);
        diningStudentsPink.add(DiningStudentPink05);
        diningStudentsPink.add(DiningStudentPink06);
        diningStudentsPink.add(DiningStudentPink07);
        diningStudentsPink.add(DiningStudentPink08);
        diningStudentsPink.add(DiningStudentPink09);
        diningStudentsRed = new ArrayList<>();
        diningStudentsRed.add(DiningStudentRed0);
        diningStudentsRed.add(DiningStudentRed01);
        diningStudentsRed.add(DiningStudentRed02);
        diningStudentsRed.add(DiningStudentRed03);
        diningStudentsRed.add(DiningStudentRed04);
        diningStudentsRed.add(DiningStudentRed05);
        diningStudentsRed.add(DiningStudentRed06);
        diningStudentsRed.add(DiningStudentRed07);
        diningStudentsRed.add(DiningStudentRed08);
        diningStudentsRed.add(DiningStudentRed09);
        diningStudentsYellow = new ArrayList<>();
        diningStudentsYellow.add(DiningStudentYellow0);
        diningStudentsYellow.add(DiningStudentYellow01);
        diningStudentsYellow.add(DiningStudentYellow02);
        diningStudentsYellow.add(DiningStudentYellow03);
        diningStudentsYellow.add(DiningStudentYellow04);
        diningStudentsYellow.add(DiningStudentYellow05);
        diningStudentsYellow.add(DiningStudentYellow06);
        diningStudentsYellow.add(DiningStudentYellow07);
        diningStudentsYellow.add(DiningStudentYellow08);
        diningStudentsYellow.add(DiningStudentYellow09);
        diningStudents = new ArrayList<ArrayList<ImageView>>();
        diningStudents.add(diningStudentsBlue);
        diningStudents.add(diningStudentsGreen);
        diningStudents.add(diningStudentsPink);
        diningStudents.add(diningStudentsRed);
        diningStudents.add(diningStudentsYellow);
        setStudentsDining();

        professors = new ArrayList<>();
        professors.add(blueProfessor);
        professors.add(greenProfessor);
        professors.add(pinkProfessor);
        professors.add(redProfessor);
        professors.add(yellowProfessor);
        setProfessors(professors,board);

        towers = new ArrayList<>();
        towers.add(tower0);
        towers.add(tower01);
        towers.add(tower02);
        towers.add(tower03);
        towers.add(tower04);
        towers.add(tower05);
        towers.add(tower06);
        towers.add(tower07);
        setTowers(towers,board);


    }
    private void setStudentsWaiting(ArrayList<ImageView> students,Board board){
        Image blue_student = new Image(getClass().getResourceAsStream("/images/blue_student.png"));
        Image green_student = new Image(getClass().getResourceAsStream("/images/green_student.png"));
        Image pink_student = new Image(getClass().getResourceAsStream("/images/pink_student.png"));
        Image red_student = new Image(getClass().getResourceAsStream("/images/red_student.png"));
        Image yellow_student = new Image(getClass().getResourceAsStream("/images/yellow_student.png"));
   /*     for(Student student :board.getStudents_waiting()){
            students.get(student.getColour().getIntAbbreviation()).setImage(Image.); find a method to parse
        }*/
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
    private void setStudentsDiningBlue(ArrayList<ImageView> students,Board board) {
        Image blue_student = new Image(getClass().getResourceAsStream("/images/blue_student.png"));

        for (int i = 0; i < board.getColorRowSize(Colour.BLUE); i++) {
            students.get(i).setImage(blue_student);
        }
    }
    private void setStudentsDiningGreen(ArrayList<ImageView> students,Board board) {
        Image green_student = new Image(getClass().getResourceAsStream("/images/green_student.png"));

        for (int i = 0; i < board.getColorRowSize(Colour.GREEN); i++) {
            students.get(i).setImage(green_student);
        }
    }
    private void setStudentsDiningPink(ArrayList<ImageView> students,Board board) {
        Image pink_student = new Image(getClass().getResourceAsStream("/images/pink_student.png"));

        for (int i = 0; i < board.getColorRowSize(Colour.PINK); i++) {
            students.get(i).setImage(pink_student);
        }
    }
    private void setStudentsDiningRed(ArrayList<ImageView> students,Board board) {
        Image red_student = new Image(getClass().getResourceAsStream("/images/red_student.png"));

        for (int i = 0; i < board.getColorRowSize(Colour.RED); i++) {
            students.get(i).setImage(red_student);
        }
    }
    private void setStudentsDiningYellow(ArrayList<ImageView> students,Board board) {
        Image yellow_student = new Image(getClass().getResourceAsStream("/images/yellow_student.png"));

        for (int i = 0; i < board.getColorRowSize(Colour.YELLOW); i++) {
            students.get(i).setImage(yellow_student);
        }
    }
    private void setStudentsDining(){
        setStudentsDiningBlue(diningStudentsBlue,board);
        setStudentsDiningPink(diningStudentsPink,board);
        setStudentsDiningRed(diningStudentsRed,board);
        setStudentsDiningGreen(diningStudentsGreen,board);
        setStudentsDiningYellow(diningStudentsYellow,board);

    }
    private void setProfessors(ArrayList<ImageView> professors,Board board){
        Image blue_professor = new Image(getClass().getResourceAsStream("/images/blue_professor.png"));
        Image green_professor = new Image(getClass().getResourceAsStream("/images/green_professor.png"));
        Image pink_professor = new Image(getClass().getResourceAsStream("/images/pink_professor.png"));
        Image red_professor = new Image(getClass().getResourceAsStream("/images/red_professor.png"));
        Image yellow_professor = new Image(getClass().getResourceAsStream("/images/yellow_professor.png"));

        for(int i=0;i<board.getProfessors().size();i++){

            switch (board.getProfessors().get(i).getColour()){
                case BLUE:
                    professors.get(i).setImage(blue_professor);
                    break;
                case GREEN:
                    professors.get(i).setImage(green_professor);
                    break;
                case PINK:
                    professors.get(i).setImage(pink_professor);
                    break;
                case RED:
                    professors.get(i).setImage(red_professor);
                    break;
                case YELLOW:
                    professors.get(i).setImage(yellow_professor);
                    break;
                default: break;
            }
        }

    }
    public void setTowers(ArrayList<ImageView> towers,Board board){
        Image black_tower = new Image(getClass().getResourceAsStream("/images/black_tower.png"));
        Image white_tower = new Image(getClass().getResourceAsStream("/images/white_tower.png"));
        Image grey_tower = new Image(getClass().getResourceAsStream("/images/grey_tower.png"));
       /* Image black_tower = new Image(getClass().getResourceAsStream("/images/blue_professor.png"));
        Image white_tower = new Image(getClass().getResourceAsStream("/images/green_professor.png"));
        Image grey_tower = new Image(getClass().getResourceAsStream("/images/pink_professor.png"));*/
        for(int i=0;i<board.getTowerSize();i++){
            switch (board.getTower_colour()){
                case BLACK:
                    towers.get(i).setImage(black_tower);
                    break;
                case WHITE:
                    towers.get(i).setImage(white_tower);
                    break;
                case GRAY:
                    towers.get(i).setImage(grey_tower);
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
            //checkAndAbleButton( MoveToTableChoiceBtn,0);



            Image img = new Image(getClass().getResourceAsStream("/images/Plancia_DEF2.png"));
            BoardImage.setImage(img);
            setStudentsWaiting(studentsWaiting,board);
            setStudentsDining();
            setProfessors(professors,board);
            setTowers(towers,board);
        }

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
           // checkAndAbleButton( MoveToTableChoiceBtn,0);
            setStudentsWaiting(studentsWaiting,board);
            setStudentsDining();
            setProfessors(professors,board);
            setTowers(towers,board);
        }
    }

    @FXML
    void onMoveToTableClick(Event event){

    }
    @FXML
    void onMoveToIslandClick(Event event){

    }
    @FXML
    void onSelectBtnClick(Event event){

    }

    public void addBoards(List<Board> pr){
        this.boards=pr;
    }

    private boolean checkAndDisableButton(Button button, int number) {
        if (numBoard == number) {
            button.setDisable(true);
            return true;
        }
        button.setDisable(false);
        return false;
    }
    /*
    private boolean checkAndAbleButton(MenuButton button, int number) {
        if (numBoard == number) {
            button.setDisable(false);
            return false;
        }
        button.setDisable(true);
        return true;
    }
*/

}
