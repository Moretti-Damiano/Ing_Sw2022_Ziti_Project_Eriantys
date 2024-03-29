package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import it.polimi.ingsw.Ziti.launcher.observer.InputObserver;
import java.util.logging.Logger;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.List;

/**
 * This class implements the controller of a generic scene.
 */
public class SceneController extends InputObservable {

    //public static final String GOD_IMAGE_PREFIX = "/images/gods/podium_";

    private static Scene activeScene;
    private static GenericSceneController activeController;

    /**
     * Returns the active scene.
     *
     * @return active scene.
     */
    public static Scene getActiveScene() {
        return activeScene;
    }

    /**
     * Returns the active controller.
     *
     * @return active controller.
     */
    public static GenericSceneController getActiveController() {
        return activeController;
    }


    /**
     * Changes the root panel of the scene argument.
     *
     * @param observerList a list of observers to be set into the scene controller.
     * @param scene        the scene whose change the root panel. This will become the active scene.
     * @param fxml         the new scene fxml name. It must include the extension ".fxml" (i.e. next_scene.fxml).
     * @param <T>          this is the type parameter.
     * @return the controller of the new scene loaded by the FXMLLoader.
     */
    public static <T> T changeRootPane(List<InputObserver> observerList, Scene scene, String fxml) {
        T controller = null;

        try {
            FXMLLoader loader = new FXMLLoader(SceneController.class.getResource("/fxml/" + fxml));
            Parent root = loader.load();
            controller = loader.getController();
            ((InputObservable) controller).addAllObservers(observerList);

            activeController = (GenericSceneController) controller;
            activeScene = scene;
            activeScene.setRoot(root);
        } catch (IOException e) {

        }
        return controller;
    }

    /**
     * Changes the root panel of the scene argument.
     *
     * @param observerList a list of observers to be set into the scene controller.
     * @param event        the event which is happened into the scene.
     * @param fxml         the new scene fxml name. It must include the extension ".fxml" (i.e. next_scene.fxml).
     * @param <T>          this is the type parameter.
     * @return the controller of the new scene loaded by the FXMLLoader.
     */
    public static <T> T changeRootPane(List<InputObserver> observerList, Event event, String fxml) {
        Scene scene = ((Node) event.getSource()).getScene();
        return changeRootPane(observerList, scene, fxml);
    }

    /**
     * Changes the root panel of the active scene.
     *
     * @param observerList a list of observers to be set into the scene controller.
     * @param fxml         the new scene fxml name. It must include the extension ".fxml" (i.e. next_scene.fxml).
     * @param <T>          this is the type parameter.
     * @return the controller of the new scene loaded by the FXMLLoader.
     */
    public static <T> T changeRootPane(List<InputObserver> observerList, String fxml) {
        return changeRootPane(observerList, activeScene, fxml);
    }

    /**
     * Changes the root panel of the scene argument.
     * Offers the possibility to set a custom controller to the FXMLLoader.
     *
     * @param controller the custom controller that will be set into the FXMLLoader.
     * @param scene      the scene whose change the root panel. This will become the active scene.
     * @param fxml       the new scene fxml name. It must include the extension ".fxml" (i.e. next_scene.fxml).
     */
    public static void changeRootPane(GenericSceneController controller, Scene scene, String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneController.class.getResource("/fxml/" + fxml));

            // Setting the controller BEFORE the load() method.
            loader.setController(controller);
            activeController = controller;
            Parent root = loader.load();

            activeScene = scene;
            activeScene.setRoot(root);
        } catch (IOException e) {

        }
    }

    /**
     * Changes the root panel of the scene argument.
     * Offers the possibility to set a custom controller to the FXMLLoader.
     *
     * @param controller the custom controller that will be set into the FXMLLoader.
     * @param event      the event which is happened into the scene.
     * @param fxml       the new scene fxml name. It must include the extension ".fxml" (i.e. next_scene.fxml).
     */
    public static void changeRootPane(GenericSceneController controller, Event event, String fxml) {
        Scene scene = ((Node) event.getSource()).getScene();
        changeRootPane(controller, scene, fxml);
    }

    /**
     * Changes the root panel of the active scene.
     * Offers the possibility to set a custom controller to the FXMLLoader.
     *
     * @param controller the custom controller that will be set into the FXMLLoader.
     * @param fxml       the new scene fxml name. It must include the extension ".fxml" (i.e. next_scene.fxml).
     */
    public static void changeRootPane(GenericSceneController controller, String fxml) {
        changeRootPane(controller, activeScene, fxml);
    }

    /**
     * Shows a custom message in a popup.
     *
     * @param title   the title of the popup.
     * @param message the message of the popup.
     */

    public static void showAlert(String title, String message) {
        FXMLLoader loader = new FXMLLoader(SceneController.class.getResource("/fxml/alert_scene.fxml"));

        Parent parent;
        try {
            parent = loader.load();
        } catch (IOException e) {
            return;
        }
        AlertSceneController alertSceneController = loader.getController();
        Scene alertScene = new Scene(parent);
        alertSceneController.setScene(alertScene);
        alertSceneController.setAlertTitle(title);
        alertSceneController.setAlertMessage(message);
        alertSceneController.displayAlert();
    }
/* needs to be implemented
    public static void showPlayAgain() {
        FXMLLoader loader = new FXMLLoader(SceneController.class.getResource("/fxml/playAgain_scene.fxml"));

        Parent parent;
        try {
            parent = loader.load();
        } catch (IOException e) {
            return;
        }
        PlayAgainSceneController playAgainSceneController = loader.getController();
        Scene playAgain = new Scene(parent);
        playAgainSceneController.setScene(playAgain);
        playAgainSceneController.setAlertTitle(title);
        playAgainSceneController.setAlertMessage(message);
        playAgainSceneController.displayAlert();
    }



    /**
     * Shows the win message popup.
     *
     * @param nickname the nickname of the winning player.
     */

/*needs to be implemented
    public static void showWin(String nickname) {
        FXMLLoader loader = new FXMLLoader(SceneController.class.getResource("/fxml/win_scene.fxml"));

        Parent parent;
        try {
            parent = loader.load();
        } catch (IOException e) {
            Logger.getLogger(Client.class.getName()).severe(e.getMessage());
            return;
        }
        WinSceneController winSceneController = loader.getController();
        Scene winScene = new Scene(parent);
        winSceneController.setScene(winScene);
        winSceneController.setWinnerNickname(nickname);
        winSceneController.displayWinScene();
    }
*/
}
