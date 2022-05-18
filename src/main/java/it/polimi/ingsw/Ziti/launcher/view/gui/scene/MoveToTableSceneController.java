package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.ShowAssistantRequest;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.ShowBoardsandIslandsRequest;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.ShowCharacterRequest;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.ShowCloudRequest;
import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;
import it.polimi.ingsw.Ziti.launcher.enumeration.PhaseType;
import it.polimi.ingsw.Ziti.launcher.model.Assistant;
import it.polimi.ingsw.Ziti.launcher.model.Board;
import it.polimi.ingsw.Ziti.launcher.model.Island;
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
import java.util.Locale;
import java.util.Objects;

import static com.sun.javafx.scene.control.skin.Utils.getResource;
import static it.polimi.ingsw.Ziti.launcher.enumeration.TowerColour.BLACK;

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
        private ArrayList<ImageView> islandStudentsBlue;
        private ArrayList<ImageView> islandStudentsGreen;
        private ArrayList<ImageView> islandStudentsPink;
        private ArrayList<ImageView> islandStudentsRed;
        private ArrayList<ImageView> islandStudentsYellow;
        private ArrayList<Label> islandStudentsBlueQ;
        private ArrayList<Label> islandStudentsGreenQ;
        private ArrayList<Label> islandStudentsPinkQ;
        private ArrayList<Label> islandStudentsRedQ;
        private ArrayList<Label> islandStudentsYellowQ;
        private ArrayList<Text> islands_id_values;

        private ArrayList<ImageView> professors;
        private ArrayList<ImageView> towers;
        private ArrayList<ArrayList<ImageView>> diningStudents;
        private List<Island> islands;
        private ArrayList<ImageView> islands_images;
        private ArrayList<ImageView> mother_nature_images;
        private ArrayList<ImageView> towerisland_images;
        private ArrayList<Label> towerIslandQ;
        private String RequestPlayer="";
        private String StudentColour="";
        private String IslandId="";
        private PhaseType phaseType;
        private String ActivePlayer="";


    @FXML
    private ImageView assChoseImage;

    @FXML
    private Label phaseDesc;
    @FXML
    private ImageView BoardImage;

    @FXML
    private Label YQ0;

    @FXML
    private Label YQ1;

    @FXML
    private Label YQ10;

    @FXML
    private Label YQ11;

    @FXML
    private Label YQ2;

    @FXML
    private Label YQ3;

    @FXML
    private Label YQ4;

    @FXML
    private Label YQ5;

    @FXML
    private Label YQ6;

    @FXML
    private Label YQ7;

    @FXML
    private Label YQ8;

    @FXML
    private Label YQ9;

    @FXML
    private ImageView YS0;

    @FXML
    private ImageView YS1;

    @FXML
    private ImageView YS10;

    @FXML
    private ImageView YS11;

    @FXML
    private ImageView YS2;

    @FXML
    private ImageView YS3;

    @FXML
    private ImageView YS4;

    @FXML
    private ImageView YS5;

    @FXML
    private ImageView YS6;

    @FXML
    private ImageView YS7;

    @FXML
    private ImageView YS8;

    @FXML
    private ImageView YS9;

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
    private Label PQ0;

    @FXML
    private Label PQ1;

    @FXML
    private Label PQ10;

    @FXML
    private Label PQ11;

    @FXML
    private Label PQ2;

    @FXML
    private Label PQ3;

    @FXML
    private Label PQ4;

    @FXML
    private Label PQ5;

    @FXML
    private Label PQ6;

    @FXML
    private Label PQ7;

    @FXML
    private Label PQ8;

    @FXML
    private Label PQ9;

    @FXML
    private ImageView PS0;

    @FXML
    private ImageView PS1;

    @FXML
    private ImageView PS10;

    @FXML
    private ImageView PS11;

    @FXML
    private ImageView PS2;

    @FXML
    private ImageView PS3;

    @FXML
    private ImageView PS4;

    @FXML
    private ImageView PS5;

    @FXML
    private ImageView PS6;

    @FXML
    private ImageView PS7;

    @FXML
    private ImageView PS8;

    @FXML
    private ImageView PS9;

    @FXML
    private Label RQ0;

    @FXML
    private Label RQ01;

    @FXML
    private Label RQ011;

    @FXML
    private Label RQ10;

    @FXML
    private Label RQ11;

    @FXML
    private Label RQ3;

    @FXML
    private Label RQ4;

    @FXML
    private Label RQ5;

    @FXML
    private Label RQ6;

    @FXML
    private Label RQ7;

    @FXML
    private Label RQ8;

    @FXML
    private Label RQ9;


    //it's RS5
    @FXML
    private ImageView RS;

    @FXML
    private ImageView RS0;

    @FXML
    private ImageView RS01;

    @FXML
    private ImageView RS011;

    @FXML
    private ImageView RS10;

    @FXML
    private ImageView RS11;

    @FXML
    private ImageView RS3;

    @FXML
    private ImageView RS4;

    @FXML
    private ImageView RS6;

    @FXML
    private ImageView RS7;

    @FXML
    private ImageView RS8;

    @FXML
    private ImageView RS9;

    @FXML
    private Button SelectBtn;

    @FXML
    private ImageView T;

    @FXML
    private Label T0Q;

    @FXML
    private ImageView T1;

    @FXML
    private ImageView T10;

    @FXML
    private Label T10Q;

    @FXML
    private ImageView T11;

    @FXML
    private Label T11Q;

    @FXML
    private Label T1Q;

    @FXML
    private ImageView T2;

    @FXML
    private Label T2Q;

    @FXML
    private ImageView T3;

    @FXML
    private Label T3Q;

    @FXML
    private ImageView T4;

    @FXML
    private Label T4Q;

    @FXML
    private ImageView T5;

    @FXML
    private Label T5Q;

    @FXML
    private ImageView T6;

    @FXML
    private Label T6Q;

    @FXML
    private ImageView T7;

    @FXML
    private Label T7Q;

    @FXML
    private ImageView T8;

    @FXML
    private Label T8Q;

    @FXML
    private ImageView T9;

    @FXML
    private Label T9Q;

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
    private Label GQ0;

    @FXML
    private Label GQ1;

    @FXML
    private Label GQ10;

    @FXML
    private Label GQ11;

    @FXML
    private Label GQ2;

    @FXML
    private Label GQ3;

    @FXML
    private Label GQ4;

    @FXML
    private Label GQ5;

    @FXML
    private Label GQ6;

    @FXML
    private Label GQ7;

    @FXML
    private Label GQ8;

    @FXML
    private Label GQ9;

    @FXML
    private ImageView GS0;

    @FXML
    private ImageView GS1;

    @FXML
    private ImageView GS10;

    @FXML
    private ImageView GS11;

    @FXML
    private ImageView GS2;

    @FXML
    private ImageView GS3;

    @FXML
    private ImageView GS4;

    @FXML
    private ImageView GS5;

    @FXML
    private ImageView GS6;


    @FXML
    private Label BQ0;

    @FXML
    private Label BQ1;

    @FXML
    private Label BQ10;

    @FXML
    private Label BQ11;

    @FXML
    private Label BQ2;

    @FXML
    private Label BQ3;

    @FXML
    private Label BQ4;

    @FXML
    private Label BQ5;

    @FXML
    private Label BQ6;

    @FXML
    private Label BQ7;

    @FXML
    private Label BQ8;

    @FXML
    private Label BQ9;

    @FXML
    private ImageView BS0;

    @FXML
    private ImageView BS1;

    @FXML
    private ImageView BS10;

    @FXML
    private ImageView BS11;

    @FXML
    private ImageView BS2;

    @FXML
    private ImageView BS3;

    @FXML
    private ImageView BS4;

    @FXML
    private ImageView BS5;

    @FXML
    private ImageView BS6;

    @FXML
    private ImageView BS7;

    @FXML
    private ImageView BS8;

    @FXML
    private ImageView BS9;

    @FXML
    private ImageView GS7;

    @FXML
    private ImageView GS8;

    @FXML
    private ImageView GS9;

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
    private Button AssistantBtn;

    @FXML
    private Button CharacterBtn;

    @FXML
    private Button CloudsBtn;

    @FXML
    private Button MoveMotherBtn;

    @FXML
    private TextField MoveMotherMoves;




    public MoveToTableSceneController(){
        numBoard=0;
        boards= new ArrayList<>();
        islands = new ArrayList<>();
       // PhaseType phase=PhaseType.NULL;
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
        AssistantBtn.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onAssistantBtnClick);
        CharacterBtn.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onCharacterBtnClick);
        CloudsBtn.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onCloudBtnClick);
        MoveMotherBtn.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onMoveMotherBtnClick);
        MoveMotherBtn.setDisable(true);
        MoveMotherMoves.setDisable(true);
        MoveMotherMoves.setText("");
        MTTBtn.setDisable(true);
        MTIBtn.setDisable(true);
        SelectBtn.setDisable(true);
        ConfirmBtn.setDisable(true);
        setMoveMotherBtn();





      //  Label  BoardName = new Label("Board");  //maybe need to be changed
        BoardName.setText(boards.get(0).getPlayername());

        board = boards.get(0);

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
        AddStudentsHandler();

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

        islands_images = new ArrayList<>();
        islands_images.add(Island0);
        islands_images.add(Island1);
        islands_images.add(Island2);
        islands_images.add(Island3);
        islands_images.add(Island4);
        islands_images.add(Island5);
        islands_images.add(Island6);
        islands_images.add(Island7);
        islands_images.add(Island8);
        islands_images.add(Island9);
        islands_images.add(Island10);
        islands_images.add(Island11);
        islands_id_values=new ArrayList<>();
        islands_id_values.add(Id0);
        islands_id_values.add(Id1);
        islands_id_values.add(Id2);
        islands_id_values.add(Id3);
        islands_id_values.add(Id4);
        islands_id_values.add(Id5);
        islands_id_values.add(Id6);
        islands_id_values.add(Id7);
        islands_id_values.add(Id8);
        islands_id_values.add(Id9);
        islands_id_values.add(Id10);
        islands_id_values.add(Id11);

        setIslands_images(islands_images,islands,islands_id_values);

        mother_nature_images=new ArrayList<>();
        mother_nature_images.add(M);
        mother_nature_images.add(M1);
        mother_nature_images.add(M2);
        mother_nature_images.add(M3);
        mother_nature_images.add(M4);
        mother_nature_images.add(M5);
        mother_nature_images.add(M6);
        mother_nature_images.add(M7);
        mother_nature_images.add(M8);
        mother_nature_images.add(M9);
        mother_nature_images.add(M10);
        mother_nature_images.add(M11);

        towerisland_images=new ArrayList<>();
        towerisland_images.add(T);
        towerisland_images.add(T1);
        towerisland_images.add(T2);
        towerisland_images.add(T3);
        towerisland_images.add(T4);
        towerisland_images.add(T5);
        towerisland_images.add(T6);
        towerisland_images.add(T7);
        towerisland_images.add(T8);
        towerisland_images.add(T9);
        towerisland_images.add(T10);
        towerisland_images.add(T11);
        towerIslandQ= new ArrayList<>();
        towerIslandQ.add(T0Q);
        towerIslandQ.add(T1Q);
        towerIslandQ.add(T2Q);
        towerIslandQ.add(T3Q);
        towerIslandQ.add(T4Q);
        towerIslandQ.add(T5Q);
        towerIslandQ.add(T6Q);
        towerIslandQ.add(T7Q);
        towerIslandQ.add(T8Q);
        towerIslandQ.add(T9Q);
        towerIslandQ.add(T10Q);
        towerIslandQ.add(T11Q);

        setTowerIsland(towerisland_images,islands,towerIslandQ);


         islandStudentsBlue=new ArrayList<>();
         islandStudentsBlue.add(BS0);
        islandStudentsBlue.add(BS1);
        islandStudentsBlue.add(BS2);
        islandStudentsBlue.add(BS3);
        islandStudentsBlue.add(BS4);
        islandStudentsBlue.add(BS5);
        islandStudentsBlue.add(BS6);
        islandStudentsBlue.add(BS7);
        islandStudentsBlue.add(BS8);
        islandStudentsBlue.add(BS9);
        islandStudentsBlue.add(BS10);
        islandStudentsBlue.add(BS11);
        islandStudentsBlueQ=new ArrayList<>();
        islandStudentsBlueQ.add(BQ0);
        islandStudentsBlueQ.add(BQ1);
        islandStudentsBlueQ.add(BQ2);
        islandStudentsBlueQ.add(BQ3);
        islandStudentsBlueQ.add(BQ4);
        islandStudentsBlueQ.add(BQ5);
        islandStudentsBlueQ.add(BQ6);
        islandStudentsBlueQ.add(BQ7);
        islandStudentsBlueQ.add(BQ8);
        islandStudentsBlueQ.add(BQ9);
        islandStudentsBlueQ.add(BQ10);
        islandStudentsBlueQ.add(BQ11);
        setStudentsIslandBlue(islandStudentsBlue,islands,islandStudentsBlueQ);

        islandStudentsGreen=new ArrayList<>();
        islandStudentsGreen.add(GS0);
        islandStudentsGreen.add(GS1);
        islandStudentsGreen.add(GS2);
        islandStudentsGreen.add(GS3);
        islandStudentsGreen.add(GS4);
        islandStudentsGreen.add(GS5);
        islandStudentsGreen.add(GS6);
        islandStudentsGreen.add(GS7);
        islandStudentsGreen.add(GS8);
        islandStudentsGreen.add(GS9);
        islandStudentsGreen.add(GS10);
        islandStudentsGreen.add(GS11);
        islandStudentsGreenQ=new ArrayList<>();
        islandStudentsGreenQ.add(GQ0);
        islandStudentsGreenQ.add(GQ1);
        islandStudentsGreenQ.add(GQ2);
        islandStudentsGreenQ.add(GQ3);
        islandStudentsGreenQ.add(GQ4);
        islandStudentsGreenQ.add(GQ5);
        islandStudentsGreenQ.add(GQ6);
        islandStudentsGreenQ.add(GQ7);
        islandStudentsGreenQ.add(GQ8);
        islandStudentsGreenQ.add(GQ9);
        islandStudentsGreenQ.add(GQ10);
        islandStudentsGreenQ.add(GQ11);
        setStudentsIslandGreen(islandStudentsGreen,islands,islandStudentsGreenQ);

        islandStudentsPink=new ArrayList<>();
        islandStudentsPink.add(PS0);
        islandStudentsPink.add(PS1);
        islandStudentsPink.add(PS2);
        islandStudentsPink.add(PS3);
        islandStudentsPink.add(PS4);
        islandStudentsPink.add(PS5);
        islandStudentsPink.add(PS6);
        islandStudentsPink.add(PS7);
        islandStudentsPink.add(PS8);
        islandStudentsPink.add(PS9);
        islandStudentsPink.add(PS10);
        islandStudentsPink.add(PS11);
        islandStudentsPinkQ=new ArrayList<>();
        islandStudentsPinkQ.add(PQ0);
        islandStudentsPinkQ.add(PQ1);
        islandStudentsPinkQ.add(PQ2);
        islandStudentsPinkQ.add(PQ3);
        islandStudentsPinkQ.add(PQ4);
        islandStudentsPinkQ.add(PQ5);
        islandStudentsPinkQ.add(PQ6);
        islandStudentsPinkQ.add(PQ7);
        islandStudentsPinkQ.add(PQ8);
        islandStudentsPinkQ.add(PQ9);
        islandStudentsPinkQ.add(PQ10);
        islandStudentsPinkQ.add(PQ11);
        setStudentsIslandPink(islandStudentsPink,islands,islandStudentsPinkQ);

        islandStudentsRed=new ArrayList<>();
        islandStudentsRed.add(RS0);
        islandStudentsRed.add(RS01);
        islandStudentsRed.add(RS011);
        islandStudentsRed.add(RS3);
        islandStudentsRed.add(RS4);
        islandStudentsRed.add(RS);
        islandStudentsRed.add(RS6);
        islandStudentsRed.add(RS7);
        islandStudentsRed.add(RS8);
        islandStudentsRed.add(RS9);
        islandStudentsRed.add(RS10);
        islandStudentsRed.add(RS11);
        islandStudentsRedQ=new ArrayList<>();
        islandStudentsRedQ.add(RQ0);
        islandStudentsRedQ.add(RQ01);
        islandStudentsRedQ.add(RQ011);
        islandStudentsRedQ.add(RQ3);
        islandStudentsRedQ.add(RQ4);
        islandStudentsRedQ.add(RQ5);
        islandStudentsRedQ.add(RQ6);
        islandStudentsRedQ.add(RQ7);
        islandStudentsRedQ.add(RQ8);
        islandStudentsRedQ.add(RQ9);
        islandStudentsRedQ.add(RQ10);
        islandStudentsRedQ.add(RQ11);
        setStudentsIslandRed(islandStudentsRed,islands,islandStudentsRedQ);

        islandStudentsYellow=new ArrayList<>();
        islandStudentsYellow.add(YS0);
        islandStudentsYellow.add(YS1);
        islandStudentsYellow.add(YS2);
        islandStudentsYellow.add(YS3);
        islandStudentsYellow.add(YS4);
        islandStudentsYellow.add(YS5);
        islandStudentsYellow.add(YS6);
        islandStudentsYellow.add(YS7);
        islandStudentsYellow.add(YS8);
        islandStudentsYellow.add(YS9);
        islandStudentsYellow.add(YS10);
        islandStudentsYellow.add(YS11);
        islandStudentsYellowQ=new ArrayList<>();
        islandStudentsYellowQ.add(YQ0);
        islandStudentsYellowQ.add(YQ1);
        islandStudentsYellowQ.add(YQ2);
        islandStudentsYellowQ.add(YQ3);
        islandStudentsYellowQ.add(YQ4);
        islandStudentsYellowQ.add(YQ5);
        islandStudentsYellowQ.add(YQ6);
        islandStudentsYellowQ.add(YQ7);
        islandStudentsYellowQ.add(YQ8);
        islandStudentsYellowQ.add(YQ9);
        islandStudentsYellowQ.add(YQ10);
        islandStudentsYellowQ.add(YQ11);
        setStudentsIslandYellow(islandStudentsYellow,islands,islandStudentsYellowQ);






        // fatto VANNO AGGIUNTE TUTTE LE ARRAYLIST DELLE ISLANDS, 1 PER OGNI COLORE DI STUDENTI POSSIBILI
        //fatto VANNO AGGIUNTI TUTTE LE ARRAYLIST DELLE QUANTITA' DEGLI STUDENTI UNO PER OGNI COLORE
        //setStudentsIslandBlue
        //VANNO CHIAMATI I METODI CHE LI IMPLEMENTANO
        //MANCA IL METODO CHE IMPLEMENTA LA QUANTITA' DELLE TORRI

        islandStudentsGreen=new ArrayList<>();
        islandStudentsGreen.add(GS0);
        islandStudentsGreen.add(GS1);
        islandStudentsGreen.add(GS2);
        islandStudentsGreen.add(GS3);
        islandStudentsGreen.add(GS4);
        islandStudentsGreen.add(GS5);
        islandStudentsGreen.add(GS6);
        islandStudentsGreen.add(GS7);
        islandStudentsGreen.add(GS8);
        islandStudentsGreen.add(GS9);
        islandStudentsGreen.add(GS10);
        islandStudentsGreen.add(GS11);


        islandStudentsPink=new ArrayList<>();
         islandStudentsRed=new ArrayList<>();
         islandStudentsYellow=new ArrayList<>();


        setMother_nature_images(mother_nature_images,islands);
        setTowerIsland(towerisland_images,islands,towerIslandQ);

        phaseDesc.setText("it's "+phaseType+"phase");
    }

    /**
     *
     * @param towerisland_images contains all island ImageView
     * @param islands contains all the actual island
     * @param towerIslandQ contains all tower quantity on the single islands
     */
    private void setTowerIsland(ArrayList<ImageView> towerisland_images, List<Island> islands,ArrayList<Label> towerIslandQ) {
        for(ImageView imm:towerisland_images){
            imm.setImage(null);
        }
        for(Label desc : towerIslandQ) {
            desc.setText("");
        }
        Image TW = new Image(getClass().getResourceAsStream("/images/white_tower.png"));
        Image TB = new Image(getClass().getResourceAsStream("/images/black_tower.png"));
        Image TG = new Image(getClass().getResourceAsStream("/images/grey_tower.png"));
        for(int i=0;i<islands.size();i++){
            if(islands.get(i).getTowers().size()==0){towerIslandQ.get(islands.get(i).getID()).setText("");
            }
            else{
                switch(islands.get(i).getTowers().get(0).getTowerColour()){
                    case BLACK:
                        towerisland_images.get(islands.get(i).getID()).setImage(TB);
                        towerIslandQ.get(islands.get(i).getID()).setText("x" + islands.get(i).getTowers().size());
                        break;
                    case GRAY:
                        towerisland_images.get(islands.get(i).getID()).setImage(TG);
                        towerIslandQ.get(islands.get(i).getID()).setText("x" + islands.get(i).getTowers().size());
                        break;
                    case WHITE:
                        towerisland_images.get(islands.get(i).getID()).setImage(TW);
                        towerIslandQ.get(islands.get(i).getID()).setText("x" + islands.get(i).getTowers().size());
                        break;
                    default:break;
                }
            }

        }
    }

    /**
     *
     * @param students contains StudentsWaiting student
     * @param board actual player board
     */


    private void setStudentsWaiting(ArrayList<ImageView> students,Board board){
        for(ImageView imm:students){
            imm.setImage(null);
        }
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
                    students.get(i).setId("BLUE");
                    break;
                case GREEN:
                    students.get(i).setImage(green_student);
                    students.get(i).setId("GREEN");
                    break;
                case PINK:
                    students.get(i).setImage(pink_student);
                    students.get(i).setId("PINK");
                    break;
                case RED:
                    students.get(i).setImage(red_student);
                    students.get(i).setId("RED");
                    break;
                case YELLOW:
                    students.get(i).setImage(yellow_student);
                    students.get(i).setId("YELLOW");
                    break;
                default: break;
            }
        }

    }

    /**
     *
     * @param event click on MoveMotherBtn
     */

    void onMoveMotherBtnClick(Event event){
        MoveMotherMoves.setDisable(false);
        MTTBtn.setDisable(true);
        MTIBtn.setDisable(true);
        MoveMotherMoves.getText();
        ConfirmBtn.setDisable(false);

    }
    @FXML
    void onStudent0Click (Event event){
        StudentColour=WaitingStudent0.getId();
        setSelectBtn();
    }
    @FXML
    void onStudent1Click (Event event){
        StudentColour=WaitingStudent1.getId();
        setSelectBtn();
    }
    @FXML
    void onStudent2Click (Event event){
        StudentColour=WaitingStudent2.getId();
        setSelectBtn();
    }
    @FXML
    void onStudent3Click (Event event){
        StudentColour=WaitingStudent3.getId();
        setSelectBtn();
    }
    @FXML
    void onStudent4Click (Event event){
        StudentColour=WaitingStudent4.getId();
        setSelectBtn();
    }
    @FXML
    void onStudent5Click (Event event){
        StudentColour=WaitingStudent5.getId();
        setSelectBtn();
    }
    @FXML
    void onStudent6Click (Event event){
        StudentColour=WaitingStudent6.getId();
        setSelectBtn();
    }
    @FXML
    void onStudent7Click (Event event){
        StudentColour=WaitingStudent7.getId();
        setSelectBtn();
    }
    @FXML
    void onStudent8Click (Event event){
        StudentColour=WaitingStudent8.getId();
        setSelectBtn();
    }

    /**
     * Remove the possibility to click on Students waiting student
     */
    void RemoveStudentsHandler(){
        WaitingStudent0.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onStudent0Click);
        WaitingStudent1.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onStudent1Click);
        WaitingStudent2.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onStudent2Click);
        WaitingStudent3.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onStudent3Click);
        WaitingStudent4.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onStudent4Click);
        WaitingStudent5.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onStudent5Click);
        WaitingStudent6.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onStudent6Click);
        WaitingStudent7.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onStudent7Click);
        WaitingStudent8.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onStudent8Click);
    }

    /**
     * Add the possibilitu to click on Student waiting student
     */
    void AddStudentsHandler(){
        WaitingStudent0.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onStudent0Click);
        WaitingStudent1.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onStudent1Click);
        WaitingStudent2.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onStudent2Click);
        WaitingStudent3.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onStudent3Click);
        WaitingStudent4.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onStudent4Click);
        WaitingStudent5.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onStudent5Click);
        WaitingStudent6.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onStudent6Click);
        WaitingStudent7.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onStudent7Click);
        WaitingStudent8.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onStudent8Click);
    }

    /**
     *
     * @param islands_images contains island images
     * @param islands actual island
     * @param IslandId contains all island Text (where is written islandId)
     */

    private void setIslands_images(ArrayList<ImageView> islands_images,List<Island> islands,ArrayList<Text> IslandId){
        for(ImageView imm:islands_images){
            imm.setImage(null);
        }
        for(Text id:IslandId){
            id.setText("");
        }
        Image island = new Image(getClass().getResourceAsStream("/images/island.png"));

        for(int i=0; i<islands.size(); i++){
            islands_images.get(islands.get(i).getID()).setImage(island);
            islands_images.get(islands.get(i).getID()).setId(Integer.toString(islands.get(i).getID()));
            IslandId.get(islands.get(i).getID()).setText(Integer.toString(islands.get(i).getID()));
        }
    }

    /**
     *
     * @param mother_nature_images contains images for all possible mother nature position
     * @param islands contains all the islands
     */
    private void setMother_nature_images(ArrayList<ImageView> mother_nature_images,List<Island> islands){
        Image mother = new Image(getClass().getResourceAsStream("/images/mother.png"));

        for(Island i: islands){
            if(i.getMother()){
                mother_nature_images.get(i.getID()).setImage(mother);
            }

        }
    }

    /**
     *
     * @param students contains images for blue students on the table
     * @param board actual player board
     */
    private void setStudentsDiningBlue(ArrayList<ImageView> students,Board board) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        Image blue_student = new Image(getClass().getResourceAsStream("/images/blue_student.png"));

        for (int i = 0; i < board.getColorRowSize(Colour.BLUE); i++) {
            students.get(i).setImage(blue_student);
        }
    }
    /**
     *
     * @param students contains images for green students on the table
     * @param board actual player board
     */
    private void setStudentsDiningGreen(ArrayList<ImageView> students,Board board) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        Image green_student = new Image(getClass().getResourceAsStream("/images/green_student.png"));

        for (int i = 0; i < board.getColorRowSize(Colour.GREEN); i++) {
            students.get(i).setImage(green_student);
        }
    }
    /**
     *
     * @param students contains images for pink students on the table
     * @param board actual player board
     */
    private void setStudentsDiningPink(ArrayList<ImageView> students,Board board) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        Image pink_student = new Image(getClass().getResourceAsStream("/images/pink_student.png"));

        for (int i = 0; i < board.getColorRowSize(Colour.PINK); i++) {
            students.get(i).setImage(pink_student);
        }
    }
    /**
     *
     * @param students contains images for red students on the table
     * @param board actual player board
     */
    private void setStudentsDiningRed(ArrayList<ImageView> students,Board board) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        Image red_student = new Image(getClass().getResourceAsStream("/images/red_student.png"));

        for (int i = 0; i < board.getColorRowSize(Colour.RED); i++) {
            students.get(i).setImage(red_student);
        }
    }
    /**
     *
     * @param students contains images for Yellow students on the table
     * @param board actual player board
     */

    private void setStudentsDiningYellow(ArrayList<ImageView> students,Board board) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        Image yellow_student = new Image(getClass().getResourceAsStream("/images/yellow_student.png"));

        for (int i = 0; i < board.getColorRowSize(Colour.YELLOW); i++) {
            students.get(i).setImage(yellow_student);
        }
    }

    /**
     *
     * @param students contains all blue students imageView (one for each island)
     * @param islands contains all islands
     * @param description contains the amount of blue students, one label for each islands
     */
    private void setStudentsIslandBlue(ArrayList<ImageView> students,List<Island> islands,ArrayList<Label> description) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        for(Label desc : description){
            desc.setText("");
        }
        Image blue_student = new Image(getClass().getResourceAsStream("/images/blue_student.png"));

        for (int i = 0; i < islands.size(); i++) {
            if(islands.get(i).getColour(Colour.BLUE)==0){description.get(islands.get(i).getID()).setText("");}
            else {
                students.get(islands.get(i).getID()).setImage(blue_student);
                description.get(islands.get(i).getID()).setText("x" + islands.get(i).getColour(Colour.BLUE));
            }
        }
    }
    /**
     *
     * @param students contains all green students imageView (one for each island)
     * @param islands contains all islands
     * @param description contains the amount of blue students, one label for each islands
     */

    private void setStudentsIslandGreen(ArrayList<ImageView> students,List<Island> islands,ArrayList<Label> description) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        for(Label desc : description){
            desc.setText("");
        }

        Image green_student = new Image(getClass().getResourceAsStream("/images/green_student.png"));

        for (int i = 0; i < islands.size(); i++) {
            if(islands.get(i).getColour(Colour.GREEN)==0){description.get(islands.get(i).getID()).setText("");}
            else {
                students.get(islands.get(i).getID()).setImage(green_student);
                description.get(islands.get(i).getID()).setText("x" + islands.get(i).getColour(Colour.GREEN));
            }

        }
    }
    /**
     *
     * @param students contains all pink students imageView (one for each island)
     * @param islands contains all islands
     * @param description contains the amount of blue students, one label for each islands
     */
    private void setStudentsIslandPink(ArrayList<ImageView> students,List<Island> islands,ArrayList<Label> description) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        for(Label desc : description){
            desc.setText("");
        }
        Image pink_student = new Image(getClass().getResourceAsStream("/images/pink_student.png"));

        for (int i = 0; i < islands.size(); i++) {
            if(islands.get(i).getColour(Colour.PINK)==0){description.get(islands.get(i).getID()).setText("");}
            else {
                students.get(islands.get(i).getID()).setImage(pink_student);
                description.get(islands.get(i).getID()).setText("x" + islands.get(i).getColour(Colour.PINK));
            }

        }
    }
    /**
     *
     * @param students contains all red students imageView (one for each island)
     * @param islands contains all islands
     * @param description contains the amount of blue students, one label for each islands
     */
    private void setStudentsIslandRed(ArrayList<ImageView> students,List<Island> islands,ArrayList<Label> description) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        for(Label desc : description){
            desc.setText("");
        }
        Image red_student = new Image(getClass().getResourceAsStream("/images/red_student.png"));

        for (int i = 0; i < islands.size(); i++) {
            if(islands.get(i).getColour(Colour.RED)==0){description.get(islands.get(i).getID()).setText("");}
            else {
                students.get(islands.get(i).getID()).setImage(red_student);
                description.get(islands.get(i).getID()).setText("x" + islands.get(i).getColour(Colour.RED));
            }

        }
    }
    /**
     *
     * @param students contains all yellow students imageView (one for each island)
     * @param islands contains all islands
     * @param description contains the amount of blue students, one label for each islands
     */

    private void setStudentsIslandYellow(ArrayList<ImageView> students,List<Island> islands,ArrayList<Label> description) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        for(Label desc : description){
            desc.setText("");
        }
        Image yellow_student = new Image(getClass().getResourceAsStream("/images/yellow_student.png"));

        for (int i = 0; i < islands.size(); i++) {
            if(islands.get(i).getColour(Colour.YELLOW)==0){description.get(islands.get(i).getID()).setText("");}
            else {
                students.get(islands.get(i).getID()).setImage(yellow_student);
                description.get(islands.get(i).getID()).setText("x" + islands.get(i).getColour(Colour.YELLOW));
            }

        }
    }

    /**
     * these methods set the images of students sit on table
     */
    private void setStudentsDining(){
        setStudentsDiningBlue(diningStudentsBlue,board);
        setStudentsDiningPink(diningStudentsPink,board);
        setStudentsDiningRed(diningStudentsRed,board);
        setStudentsDiningGreen(diningStudentsGreen,board);
        setStudentsDiningYellow(diningStudentsYellow,board);

    }

    /**
     *
     * @param professors contains all ImageView of board professors
     * @param board actual board
     */
    private void setProfessors(ArrayList<ImageView> professors,Board board){
        for(ImageView imm:professors){
            imm.setImage(null);
        }
        Image blue_professor = new Image(getClass().getResourceAsStream("/images/blue_professor.png"));
        Image green_professor = new Image(getClass().getResourceAsStream("/images/green_professor.png"));
        Image pink_professor = new Image(getClass().getResourceAsStream("/images/pink_professor.png"));
        Image red_professor = new Image(getClass().getResourceAsStream("/images/red_professor.png"));
        Image yellow_professor = new Image(getClass().getResourceAsStream("/images/yellow_professor.png"));

        for(int i=0;i<board.getProfessors().size();i++){

            switch (board.getProfessors().get(i).getColour()){
                case BLUE:
                    professors.get(0).setImage(blue_professor);
                    break;
                case GREEN:
                    professors.get(1).setImage(green_professor);
                    break;
                case PINK:
                    professors.get(2).setImage(pink_professor);
                    break;
                case RED:
                    professors.get(3).setImage(red_professor);
                    break;
                case YELLOW:
                    professors.get(4).setImage(yellow_professor);
                    break;
                default: break;
            }
        }

    }

    /**
     *
     * @param towers contains all the ImageView of The Tower on board
     * @param board actual board
     */
    public void setTowers(ArrayList<ImageView> towers,Board board){
        for(ImageView imm:towers){
            imm.setImage(null);
        }
        Image black_tower = new Image(getClass().getResourceAsStream("/images/black_tower.png"));
        Image white_tower = new Image(getClass().getResourceAsStream("/images/white_tower.png"));
        Image grey_tower = new Image(getClass().getResourceAsStream("/images/grey_tower.png"));
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

    /**
     *
     * @param player the player who made the request to see his board
     */
    public void SetRequestPlayer(String player){
        this.RequestPlayer=player;
    }

    public void setActivePlayer(String player){
        this.ActivePlayer=player;
    }

    /**
     * If MovementPhase send a MoveToIslandMessage, if MotherPhase send a MoveMotherMessage
     * @param event Mouse Click on ConfirmBtn
     */
    @FXML
    void onConfirmClick(Event event) {
        RemoveIslandsHandler();
        if(phaseType==PhaseType.MOVEMENT) {
            ConfirmBtn.setDisable(true);
            MoveMotherBtn.setDisable(true);
            MoveMotherMoves.setDisable(true);
            new Thread(() -> notifyObserver(obs -> obs.onUpdateMoveToIsland(StudentColour, IslandId))).start();
        }
        else if(phaseType==PhaseType.MOTHER) {
            ConfirmBtn.setDisable(true);
            MoveMotherBtn.setDisable(true);
            MoveMotherMoves.setDisable(true);
            new Thread(() -> notifyObserver(obs -> obs.onUpdateMoveMother(MoveMotherMoves.getText()))).start();

        }
    }

    /**
     * Show the next Board
     * @param event MouseClick on NextButton
     */
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

    /**
     * Show the previous Board
     * @param event MouseClick on PreviousButton
     */
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

    /**
     *
     * @param phase the actual GamePhase
     */
    public void setPhase(PhaseType phase){
        this.phaseType=phase;
    }

    /**
     * Send a MoveToTableMessage
     * @param event MouseClick on MoveToTableBtn
     */

    @FXML
    void onMoveToTableClick(Event event){
        new Thread(() -> notifyObserver(obs -> obs.onUpdateMoveToTable(StudentColour))).start();
    }

    /**
     * Allow to select Island, deactivate MoveToTableBtn
     * @param event Click on MoveToIsland
     */
    @FXML
    void onMoveToIslandClick(Event event){
        AddIslandsHandler();
        MTTBtn.setDisable(true);
        ConfirmBtn.setDisable(true);
        MTIBtn.setDisable(true);
    }

    /**
     * Allow to click on islands
     */
    void AddIslandsHandler(){
        Island0.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland0Click);
        Island1.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland1Click);
        Island2.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland2Click);
        Island3.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland3Click);
        Island4.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland4Click);
        Island5.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland5Click);
        Island6.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland6Click);
        Island7.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland7Click);
        Island8.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland8Click);
        Island9.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland9Click);
        Island10.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland10Click);
        Island11.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland11Click);

    }

    /**
     * Removes the possibility to click on islands
     */
    void RemoveIslandsHandler(){
        Island0.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland0Click);
        Island1.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland1Click);
        Island2.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland2Click);
        Island3.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland3Click);
        Island4.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland4Click);
        Island5.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland5Click);
        Island6.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland6Click);
        Island7.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland7Click);
        Island8.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland8Click);
        Island9.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland9Click);
        Island10.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland10Click);
        Island11.removeEventHandler(MouseEvent.MOUSE_CLICKED,this::onIsland11Click);

    }

    /**
     * Activate MoveMotherBtn only if is MotherPhase
     */
    private void setMoveMotherBtn(){
        if(phaseType==PhaseType.MOTHER) MoveMotherBtn.setDisable(false);
        else MoveMotherBtn.setDisable(true);
    }

    @FXML
    void onIsland0Click(Event event){
        IslandId=Island0.getId();
        ConfirmBtn.setDisable(false);
    }

    @FXML
    void onIsland1Click(Event event){
        IslandId=Island1.getId();
        ConfirmBtn.setDisable(false);

    }
    @FXML
    void onIsland2Click(Event event){
        IslandId=Island2.getId();
        ConfirmBtn.setDisable(false);

    }
    @FXML
    void onIsland3Click(Event event){
        IslandId=Island3.getId();
        ConfirmBtn.setDisable(false);

    }
    @FXML
    void onIsland4Click(Event event){
        IslandId=Island4.getId();
        ConfirmBtn.setDisable(false);

    }
    @FXML
    void onIsland5Click(Event event){
        IslandId=Island5.getId();
        ConfirmBtn.setDisable(false);

    }
    @FXML
    void onIsland6Click(Event event){
        IslandId=Island6.getId();
        ConfirmBtn.setDisable(false);

    }
    @FXML
    void onIsland7Click(Event event){
        IslandId=Island7.getId();
        ConfirmBtn.setDisable(false);

    }
    @FXML
    void onIsland8Click(Event event){
        IslandId=Island8.getId();
        ConfirmBtn.setDisable(false);

    }
    @FXML
    void onIsland9Click(Event event){
        IslandId=Island9.getId();
        ConfirmBtn.setDisable(false);

    }
    @FXML
    void onIsland10Click(Event event){
        IslandId=Island10.getId();
        ConfirmBtn.setDisable(false);

    }
    @FXML
    void onIsland11Click(Event event){
        IslandId=Island11.getId();
        ConfirmBtn.setDisable(false);

    }

    /**
     * Remove the possibility to click on Students, allow the next possible moves (MoveToTable or MoveToIsland)
     * @param event Click on SelectBtn
     */
    @FXML
    void onSelectBtnClick(Event event){
        RemoveStudentsHandler();
        MTTBtn.setDisable(false);
        MTIBtn.setDisable(false);
        SelectBtn.setDisable(true);

    }
    private void setSelectBtn(){
        if(board.getPlayername()==ActivePlayer && board.getPlayername()==RequestPlayer) SelectBtn.setDisable(false);
        else SelectBtn.setDisable(true);
    }

    /**
     * Allow to Select and View Assistant in the next scene
     * @param event Click on AssistantBtn
     */
    @FXML
    void onAssistantBtnClick(Event event){
        new Thread(() -> notifyObserver(obs -> obs.onUpdateAssistantRequest(new ShowAssistantRequest()))).start();
    }

    /**
     * Allow to Select and View Character in the next scene
     * @param event Click on CharacterBtn
     */
    @FXML
    void onCharacterBtnClick(Event event){
        new Thread(() -> notifyObserver(obs -> obs.onUpdateCharacterRequest(new ShowCharacterRequest()))).start();
    }

    /**
     * Allow to Select and View Cloud in the next scene
     * @param event Click on CloudBtn
     */
    @FXML
    void onCloudBtnClick(Event event){
        new Thread(() -> notifyObserver(obs -> obs.onUpdateCloudRequest(new ShowCloudRequest()))).start();
    }

    public void addBoards(List<Board> pr){
        this.boards=pr;
    }

    /**
     *
     * @param button Actual Button
     * @param number
     * @return
     */
    private boolean checkAndDisableButton(Button button, int number) {
        if (numBoard == number) {
            button.setDisable(true);
            return true;
        }
        button.setDisable(false);
        return false;
    }

    /**
     *
     * @param islands actual islands
     */
    public void addIslands(List<Island> islands){this.islands=islands;}




}
