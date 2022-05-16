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

        private ArrayList<ImageView> professors;
        private ArrayList<ImageView> towers;
        private ArrayList<ArrayList<ImageView>> diningStudents;
        private List<Island> islands;
        private ArrayList<ImageView> islands_images;
        private ArrayList<ImageView> mother_nature_images;
        private ArrayList<ImageView> towerisland_images;
        private String RequestPlayer="";
        private String StudentColour="";
        private String IslandId="";
        private PhaseType phaseType;



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
        BoardName.setText(RequestPlayer);

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
        setIslands_images(islands_images,islands);

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
        //VANNO AGGIUNTE TUTTE LE ARRAYLIST DELLE ISLANDS, 1 PER OGNI COLORE DI STUDENTI POSSIBILI
        //VANNO AGGIUNTI TUTTE LE ARRAYLIST DELLE QUANTITA' DEGLI STUDENTI UNO PER OGNI COLORE
        //VANNO CHIAMATI I METODI CHE LI IMPLEMENTANO
        //MANCA IL METODO CHE IMPLEMENTA LA QUANTITA' DELLE TORRI

        islandStudentsGreen=new ArrayList<>();
        islandStudentsPink=new ArrayList<>();
         islandStudentsRed=new ArrayList<>();
         islandStudentsYellow=new ArrayList<>();

        Island0.addEventHandler(MouseEvent.MOUSE_ENTERED,this::showStudentsOnIsland0);
        Island1.addEventHandler(MouseEvent.MOUSE_ENTERED,this::showStudentsOnIsland1);
        Island2.addEventHandler(MouseEvent.MOUSE_ENTERED,this::showStudentsOnIsland2);
        Island3.addEventHandler(MouseEvent.MOUSE_ENTERED,this::showStudentsOnIsland3);
        Island4.addEventHandler(MouseEvent.MOUSE_ENTERED,this::showStudentsOnIsland4);
        Island5.addEventHandler(MouseEvent.MOUSE_ENTERED,this::showStudentsOnIsland5);
        Island6.addEventHandler(MouseEvent.MOUSE_ENTERED,this::showStudentsOnIsland6);
        Island7.addEventHandler(MouseEvent.MOUSE_ENTERED,this::showStudentsOnIsland7);
        Island8.addEventHandler(MouseEvent.MOUSE_ENTERED,this::showStudentsOnIsland8);
        Island9.addEventHandler(MouseEvent.MOUSE_ENTERED,this::showStudentsOnIsland9);
        Island10.addEventHandler(MouseEvent.MOUSE_ENTERED,this::showStudentsOnIsland10);
        Island11.addEventHandler(MouseEvent.MOUSE_ENTERED,this::showStudentsOnIsland11);
        setMother_nature_images(mother_nature_images,islands);
        setTowerIsland_images(towerisland_images,islands);
    }

    private void setTowerIsland_images(ArrayList<ImageView> towerisland_images, List<Island> islands) {
        for(ImageView imm:towerisland_images){
            imm.setImage(null);
        }
        Image TW = new Image(getClass().getResourceAsStream("/images/white_tower.png"));
        Image TB = new Image(getClass().getResourceAsStream("/images/black_tower.png"));
        Image TG = new Image(getClass().getResourceAsStream("/images/grey_tower.png"));
        for(int i=0;i<islands.size();i++){
            if(islands.get(i).getTowers().size()!=0){
                switch(islands.get(i).getTowers().get(0).getTowerColour()){
                    case BLACK:
                        towerisland_images.get(islands.get(i).getID()).setImage(TB);
                        break;
                    case GRAY:
                        towerisland_images.get(islands.get(i).getID()).setImage(TG);
                        break;
                    case WHITE:
                        towerisland_images.get(islands.get(i).getID()).setImage(TW);
                        break;
                    default:break;
                }
            }
        }

    }

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
        SelectBtn.setDisable(false);
    }
    @FXML
    void onStudent1Click (Event event){
        StudentColour=WaitingStudent1.getId();
        SelectBtn.setDisable(false);
    }
    @FXML
    void onStudent2Click (Event event){
        StudentColour=WaitingStudent2.getId();
        SelectBtn.setDisable(false);
    }
    @FXML
    void onStudent3Click (Event event){
        StudentColour=WaitingStudent3.getId();
        SelectBtn.setDisable(false);
    }
    @FXML
    void onStudent4Click (Event event){
        StudentColour=WaitingStudent4.getId();
        SelectBtn.setDisable(false);
    }
    @FXML
    void onStudent5Click (Event event){
        StudentColour=WaitingStudent5.getId();
        SelectBtn.setDisable(false);
    }
    @FXML
    void onStudent6Click (Event event){
        StudentColour=WaitingStudent6.getId();
        SelectBtn.setDisable(false);
    }
    @FXML
    void onStudent7Click (Event event){
        StudentColour=WaitingStudent7.getId();
        SelectBtn.setDisable(false);
    }
    @FXML
    void onStudent8Click (Event event){
        StudentColour=WaitingStudent8.getId();
        SelectBtn.setDisable(false);
    }
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

    private void setIslands_images(ArrayList<ImageView> islands_images,List<Island> islands){
        for(ImageView imm:islands_images){
            imm.setImage(null);
        }
        Image island = new Image(getClass().getResourceAsStream("/images/island.png"));

        for(int i=0; i<islands.size(); i++){
            islands_images.get(islands.get(i).getID()).setImage(island);
            islands_images.get(islands.get(i).getID()).setId(Integer.toString(islands.get(i).getID()));
        }
    }
    private void setMother_nature_images(ArrayList<ImageView> mother_nature_images,List<Island> islands){
        Image mother = new Image(getClass().getResourceAsStream("/images/mother.png"));

        for(Island i: islands){
            if(i.getMother()){
                mother_nature_images.get(i.getID()).setImage(mother);
            }

        }
    }
    private void setStudentsDiningBlue(ArrayList<ImageView> students,Board board) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        Image blue_student = new Image(getClass().getResourceAsStream("/images/blue_student.png"));

        for (int i = 0; i < board.getColorRowSize(Colour.BLUE); i++) {
            students.get(i).setImage(blue_student);
        }
    }
    private void setStudentsDiningGreen(ArrayList<ImageView> students,Board board) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        Image green_student = new Image(getClass().getResourceAsStream("/images/green_student.png"));

        for (int i = 0; i < board.getColorRowSize(Colour.GREEN); i++) {
            students.get(i).setImage(green_student);
        }
    }
    private void setStudentsDiningPink(ArrayList<ImageView> students,Board board) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        Image pink_student = new Image(getClass().getResourceAsStream("/images/pink_student.png"));

        for (int i = 0; i < board.getColorRowSize(Colour.PINK); i++) {
            students.get(i).setImage(pink_student);
        }
    }
    private void setStudentsDiningRed(ArrayList<ImageView> students,Board board) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        Image red_student = new Image(getClass().getResourceAsStream("/images/red_student.png"));

        for (int i = 0; i < board.getColorRowSize(Colour.RED); i++) {
            students.get(i).setImage(red_student);
        }
    }


    private void setStudentsDiningYellow(ArrayList<ImageView> students,Board board) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        Image yellow_student = new Image(getClass().getResourceAsStream("/images/yellow_student.png"));

        for (int i = 0; i < board.getColorRowSize(Colour.YELLOW); i++) {
            students.get(i).setImage(yellow_student);
        }
    }
    private void setStudentsIslandBlue(ArrayList<ImageView> students,ArrayList<Island> islands,ArrayList<Label> description) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        Image blue_student = new Image(getClass().getResourceAsStream("/images/blue_student.png"));

        for (int i = 0; i < islands.size(); i++) {
            students.get(islands.get(i).getID()).setImage(blue_student);
            description.get(islands.get(i).getID()).setText("x"+islands.get(i).getColour(Colour.BLUE));

        }
    }
    private void setStudentsIslandGreen(ArrayList<ImageView> students,ArrayList<Island> islands,ArrayList<Label> description) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        Image green_student = new Image(getClass().getResourceAsStream("/images/green_student.png"));

        for (int i = 0; i < islands.size(); i++) {
            students.get(islands.get(i).getID()).setImage(green_student);
            description.get(islands.get(i).getID()).setText("x"+islands.get(i).getColour(Colour.GREEN));

        }
    }
    private void setStudentsIslandPink(ArrayList<ImageView> students,ArrayList<Island> islands,ArrayList<Label> description) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        Image pink_student = new Image(getClass().getResourceAsStream("/images/pink_student.png"));

        for (int i = 0; i < islands.size(); i++) {
            students.get(islands.get(i).getID()).setImage(pink_student);
            description.get(islands.get(i).getID()).setText("x"+islands.get(i).getColour(Colour.PINK));

        }
    }
    private void setStudentsIslandRed(ArrayList<ImageView> students,ArrayList<Island> islands,ArrayList<Label> description) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        Image red_student = new Image(getClass().getResourceAsStream("/images/red_student.png"));

        for (int i = 0; i < islands.size(); i++) {
            students.get(islands.get(i).getID()).setImage(red_student);
            description.get(islands.get(i).getID()).setText("x"+islands.get(i).getColour(Colour.RED));

        }
    }


    private void setStudentsIslandYellow(ArrayList<ImageView> students,ArrayList<Island> islands,ArrayList<Label> description) {
        for(ImageView imm:students){
            imm.setImage(null);
        }
        Image yellow_student = new Image(getClass().getResourceAsStream("/images/yellow_student.png"));

        for (int i = 0; i < islands.size(); i++) {
            students.get(islands.get(i).getID()).setImage(yellow_student);
            description.get(islands.get(i).getID()).setText("x"+islands.get(i).getColour(Colour.YELLOW));

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
    public void SetRequestPlayer(String player){
        this.RequestPlayer=player;
    }

    @FXML
    void onConfirmClick(Event event) {
        RemoveIslandsHandler();
        if(phaseType==PhaseType.MOVEMENT) new Thread(() -> notifyObserver(obs -> obs.onUpdateMoveToIsland(StudentColour, IslandId))).start();
        else if(phaseType==PhaseType.MOTHER) new Thread(() -> notifyObserver(obs -> obs.onUpdateMoveMother(MoveMotherMoves.getText()))).start();
        ConfirmBtn.setDisable(true);
        MoveMotherBtn.setDisable(true);
        MoveMotherMoves.setDisable(true);
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
    public void setPhase(PhaseType phase){
        this.phaseType=phase;
    }

    @FXML
    void onMoveToTableClick(Event event){
        new Thread(() -> notifyObserver(obs -> obs.onUpdateMoveToTable(StudentColour))).start();
    }
    @FXML
    void onMoveToIslandClick(Event event){
        AddIslandsHandler();
        MTTBtn.setDisable(true);
        ConfirmBtn.setDisable(true);
        MTIBtn.setDisable(true);
    }
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
    private void setMoveMotherBtn(){
        if(phaseType==PhaseType.MOTHER) MoveMotherBtn.setDisable(false);
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

    @FXML
    void onSelectBtnClick(Event event){
        RemoveStudentsHandler();
        MTTBtn.setDisable(false);
        MTIBtn.setDisable(false);
        SelectBtn.setDisable(true);

    }

    @FXML
    void onAssistantBtnClick(Event event){
        new Thread(() -> notifyObserver(obs -> obs.onUpdateAssistantRequest(new ShowAssistantRequest()))).start();
    }
    @FXML
    void onCharacterBtnClick(Event event){
        new Thread(() -> notifyObserver(obs -> obs.onUpdateCharacterRequest(new ShowCharacterRequest()))).start();
    }
    @FXML
    void onCloudBtnClick(Event event){
        new Thread(() -> notifyObserver(obs -> obs.onUpdateCloudRequest(new ShowCloudRequest()))).start();
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
    public void addIslands(List<Island> islands){this.islands=islands;}
    public String showIslandStudents(Island island) {
        String partial="";
            if (island.getStudents().isEmpty()) partial=("There are no students ");
                else {
                    for (Colour c : Colour.values()) {
                        if (island.getColour(c) != 0) {
                            partial = partial.concat("°"+ island.getColour(c) + " " + c.getName() + " students\n");
                        }
                    }
                }
                return partial;
    }

    public void showStudentsOnIsland0(Event event){
        IslandDesc.setText(showIslandStudents(islands.get(0)));
    }
    public void showStudentsOnIsland1(Event event){
        IslandDesc.setText(showIslandStudents(islands.get(1)));
    }
    public void showStudentsOnIsland2(Event event){
        IslandDesc.setText(showIslandStudents(islands.get(2)));
    }
    public void showStudentsOnIsland3(Event event){
        IslandDesc.setText(showIslandStudents(islands.get(3)));
    }
    public void showStudentsOnIsland4(Event event){
        IslandDesc.setText(showIslandStudents(islands.get(4)));
    }
    public void showStudentsOnIsland5(Event event){
        IslandDesc.setText(showIslandStudents(islands.get(5)));
    }
    public void showStudentsOnIsland6(Event event){
        IslandDesc.setText(showIslandStudents(islands.get(6)));
    }
    public void showStudentsOnIsland7(Event event){IslandDesc.setText(showIslandStudents(islands.get(7)));}
    public void showStudentsOnIsland8(Event event){
        IslandDesc.setText(showIslandStudents(islands.get(8)));
    }
    public void showStudentsOnIsland9(Event event){
        IslandDesc.setText(showIslandStudents(islands.get(9)));
    }
    public void showStudentsOnIsland10(Event event){
        IslandDesc.setText(showIslandStudents(islands.get(10)));
    }
    public void showStudentsOnIsland11(Event event){
        IslandDesc.setText(showIslandStudents(islands.get(11)));
    }



}
