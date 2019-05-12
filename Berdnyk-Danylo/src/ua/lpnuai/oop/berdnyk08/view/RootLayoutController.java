package ua.lpnuai.oop.berdnyk08.view;

import java.io.File;

import ua.lpnuai.oop.berdnyk08.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

public class RootLayoutController {
	private MainApp mainApp;


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    private void handleNew() {
        mainApp.getApplicantData().clear();
        mainApp.setPersonFilePath(null);
    }


    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "SER files (*.ser)", "*.ser");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (file != null) {
            mainApp.loadApplicantDataFromFile(file);
        }
    }


    @FXML
    private void handleSave() {
        File personFile = mainApp.getApplicantFilePath();
        if (personFile != null) {
            mainApp.saveApplicantDataToFile(personFile);
        } else {
            handleSaveAs();
        }
    }


    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "SER files (*.ser)", "*.ser");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            if (!file.getPath().endsWith(".ser")) {
                file = new File(file.getPath() + ".ser");
            }
            mainApp.saveApplicantDataToFile(file);
        }
    }


    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About author");
        alert.setHeaderText("About");
        alert.setContentText("Author: Berdnyk Danylo \nKN-108");

        alert.showAndWait();
    }


    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
