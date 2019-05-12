package ua.lpnuai.oop.berdnyk08;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ua.lpnuai.oop.berdnyk08.model.Applicant;
import ua.lpnuai.oop.berdnyk08.model.ApplicantListWrapper;
import ua.lpnuai.oop.berdnyk08.view.ApplicantEditDialogController;
import ua.lpnuai.oop.berdnyk08.view.ApplicantOverviewController;
import ua.lpnuai.oop.berdnyk08.view.RootLayoutController;


public class MainApp extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
	
    private ObservableList<Applicant> applicantData = FXCollections.observableArrayList();
    
    public MainApp() {
    	applicantData.add(new Applicant("Example", "Person"));
    }
    
    public ObservableList<Applicant> getApplicantData(){
		return applicantData;
    }
    
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Applications Data Base");
		
		initRootLayout();
		showApplicantOverview();
	}
	
	public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void showApplicantOverview() {
	    try {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/ApplicantOverview.fxml"));
	        AnchorPane applicantOverview = (AnchorPane) loader.load();

	        rootLayout.setCenter(applicantOverview);

	        ApplicantOverviewController controller = loader.getController();
	        controller.setMainApp(this);

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public boolean showApplicantEditDialog(Applicant person) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/ApplicantEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Applicant");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);
	        
	        ApplicantEditDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setApplicant(person);
	        
	        dialogStage.showAndWait();
	        
	        return controller.isOkClicked();
		}catch (IOException e) {
			e.printStackTrace();
	        return false;
	    }
	}
	
	
	public Stage getPrimaryStage() {
        return primaryStage;
    }
	public static void main(String[] args) {
		launch(args);
	}
	
	
	 public void loadApplicantDataFromFile(File file) {
	    	XMLEncoder encoder;
	        try {
	        	FileInputStream fileIn =
						new FileInputStream(file);
	        	ObjectInputStream in = new ObjectInputStream(fileIn);
	        	List<Applicant> list = (List<Applicant>) in.readObject();
	        	ApplicantListWrapper wrapper = new ApplicantListWrapper();
	        	applicantData.clear();
	        	applicantData.addAll(FXCollections.observableList(list));
	        	for(Applicant i : applicantData) {
	        		System.out.println(i.getFirstName());
	        	}
	        	fileIn.close();
	            setPersonFilePath(file);
	        } catch (Exception e) { // catches ANY exception
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Error");
	            alert.setHeaderText("Could not load data");
	            alert.setContentText("Could not load data from file:\n" + file.getPath());

	            alert.showAndWait();
	        }
	    }
	
	 public void saveApplicantDataToFile(File file) {
	        try {
	        	FileOutputStream fos = new FileOutputStream(file);
	        	ApplicantListWrapper wrapper = new ApplicantListWrapper();
	        	 wrapper.setPersons(applicantData);
	        	 ObjectOutputStream oos = new ObjectOutputStream(fos);
	        	 oos.writeObject(new ArrayList<Applicant>(wrapper.getApplicants()));
	        	 oos.close();
	            setPersonFilePath(file);
	        } catch (Exception e) { // catches ANY exception
	        	e.printStackTrace();
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Error");
	            alert.setHeaderText("Could not save data");
	            alert.setContentText("Could not save data to file:\n" + file.getPath());

	            alert.showAndWait();
	        }
	    }
	 
	 
	public File getApplicantFilePath() {
	    Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
	    String filePath = prefs.get("filePath", null);
	    if (filePath != null) {
	        return new File(filePath);
	    } else {
	        return null;
	    }
	}
	public void setPersonFilePath(File file) {
	    Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
	    if (file != null) {
	        prefs.put("filePath", file.getPath());

	        primaryStage.setTitle("AddressApp - " + file.getName());
	    } else {
	        prefs.remove("filePath");

	        primaryStage.setTitle("AddressApp");
	    }
	}
	
}
