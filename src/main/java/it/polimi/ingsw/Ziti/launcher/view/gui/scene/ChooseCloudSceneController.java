package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.ShowBoardsandIslandsRequest;
import it.polimi.ingsw.Ziti.launcher.model.Board;
import it.polimi.ingsw.Ziti.launcher.model.CloudIsland;
import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class ChooseCloudSceneController extends InputObservable implements GenericSceneController{
    @FXML
    private Group Cld0;

    @FXML
    private Group Cld1;

    @FXML
    private Group Cld2;

    @FXML
    private ImageView Cloud0;

    @FXML
    private ImageView Cloud1;

    @FXML
    private ImageView Cloud2;

    @FXML
    private Button ConfirmBtn;

    @FXML
    private ImageView S00;

    @FXML
    private ImageView S01;

    @FXML
    private ImageView S02;

    @FXML
    private ImageView S03;

    @FXML
    private ImageView S10;

    @FXML
    private ImageView S11;

    @FXML
    private ImageView S12;

    @FXML
    private ImageView S13;

    @FXML
    private ImageView S20;

    @FXML
    private ImageView S21;

    @FXML
    private ImageView S22;

    @FXML
    private ImageView S23;

    @FXML
    private RadioButton Select0;

    @FXML
    private RadioButton Select1;

    @FXML
    private RadioButton Select2;

    @FXML
    private ToggleGroup SelectIsld;

    @FXML
    private Button BackToMenu;

    private List<CloudIsland> availableCloud;

    private ArrayList<Group> groups = new ArrayList<>();
    private ArrayList<ImageView> Cld0Students=new ArrayList<>();
    private ArrayList<ImageView> Cld1Students=new ArrayList<>();
    private ArrayList<ImageView> Cld2Students=new ArrayList<>();


    @FXML
    public void initialize(){
        ConfirmBtn.setDisable(true);
        Select0.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onSelectClick);
        Select1.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onSelectClick);
        Select2.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onSelectClick);
        ConfirmBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onConfirmClick);
        BackToMenu.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onBackToMenuClick);
        groups.add(Cld0);
        groups.add(Cld1);
        groups.add(Cld2);
        if(availableCloud.size()==3){
            Cld0.setDisable(false);
            Cld1.setDisable(false);
            Cld2.setDisable(false);
            Select0.setId("0");
            Select1.setId("1");
            Select2.setId("2");
            //Image img= new Image(getClass().getResourceAsStream("/images/Cloud.png"));
           // ArrayList<ImageView> Cld2Students = new ArrayList<>();
            Cld0Students.add(S00);
            Cld0Students.add(S01);
            Cld0Students.add(S02);
            Cld0Students.add(S03);
            Cld1Students.add(S10);
            Cld1Students.add(S11);
            Cld1Students.add(S12);
            Cld1Students.add(S13);
            Cld2Students.add(S20);
            Cld2Students.add(S21);
            Cld2Students.add(S22);
            Cld2Students.add(S23);
            setStudentsCloud(Cld0Students,availableCloud);
            setStudentsCloud(Cld1Students,availableCloud);
            setStudentsCloud(Cld2Students,availableCloud);
            setCloudIslandImages(groups,availableCloud);


        }else{
            Cld0.setDisable(false);
            Cld1.setDisable(false);
            Cld2.setDisable(true);
            Cloud2.setVisible(false);

            Select0.setId("0");
            Select1.setId("1");
            Cld0Students.add(S00);
            Cld0Students.add(S01);
            Cld0Students.add(S02);
            S03.setDisable(true);
            Cld1Students.add(S10);
            Cld1Students.add(S11);
            Cld1Students.add(S12);
            S23.setDisable(true);
            setStudentsCloud(Cld0Students,availableCloud);
            setStudentsCloud(Cld1Students,availableCloud);
            setCloudIslandImages(groups,availableCloud);

        }

    }
    private void onConfirmClick(Event event) {
        ConfirmBtn.setDisable(true);
        RadioButton selectedRadioButton = (RadioButton) SelectIsld.getSelectedToggle();
        String chosenCloudIsland = ""+selectedRadioButton.getId();

        new Thread(() -> notifyObserver(obs -> obs.onUpdateCloudIsland(chosenCloudIsland))).start();
    }


    private void setStudentsCloud(ArrayList<ImageView> students,List<CloudIsland> cloudIslands){
        Image blue_student = new Image(getClass().getResourceAsStream("/images/blue_student.png"));
        Image green_student = new Image(getClass().getResourceAsStream("/images/green_student.png"));
        Image pink_student = new Image(getClass().getResourceAsStream("/images/pink_student.png"));
        Image red_student = new Image(getClass().getResourceAsStream("/images/red_student.png"));
        Image yellow_student = new Image(getClass().getResourceAsStream("/images/yellow_student.png"));
        for(int j=0; j<cloudIslands.size();j++) {
            for (int i = 0; i < cloudIslands.get(j).getStudents().size(); i++) {

                switch (cloudIslands.get(j).getStudents().get(i).getColour()) {
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
                    default:
                        break;

                }
            }
        }
    }
    private void setCloudIslandImages(ArrayList<Group> groups,List<CloudIsland> cloudIslands){
        for(CloudIsland c : cloudIslands){
            if(c.getStudents().size()==0)
                switch (c.getID()){
                    case 0:
                        groups.get(0).setVisible(false);
                    case 1:
                        groups.get(1).setVisible(false);
                    case 2:
                        groups.get(2).setVisible(false);
                    default:break;
                }else{}
        }
    }
    private void onSelectClick(Event event){
        ConfirmBtn.setDisable(false);
    }

    @FXML
    void  onBackToMenuClick(Event event) {

        new Thread(() -> notifyObserver(obs -> obs.onUpdateShowAndIslandRequest(new ShowBoardsandIslandsRequest()))).start();
    }

    public void setCloud(List<CloudIsland> Clouds){
        this.availableCloud=Clouds;
    }
}
