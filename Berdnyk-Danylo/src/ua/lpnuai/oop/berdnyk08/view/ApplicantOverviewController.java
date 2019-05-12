package ua.lpnuai.oop.berdnyk08.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ua.lpnuai.oop.berdnyk08.MainApp;
import ua.lpnuai.oop.berdnyk08.model.Applicant;
import ua.lpnuai.oop.berdnyk08.util.DateUtil;

public class ApplicantOverviewController {
	@FXML
	private TableView<Applicant> applicantTable;
	@FXML
	private TableColumn<Applicant,String> firstNameColumn;
	@FXML
	private TableColumn<Applicant,String> lastNameColumn;
	
	
	@FXML
	private Label regNumLabel;
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label specializationExpLabel;
	@FXML
	private Label standingLabel;
	@FXML
	private Label specializationReqLabel;
	@FXML
	private Label conditionalsLabel;
	@FXML
	private Label minalaryLabel;
	@FXML
	private Label dismissalDateLabel;
	
	private MainApp mainApp;
	
	public ApplicantOverviewController(){
	}
	
	@FXML
	private void initialize() {
	    firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty());
	    lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getLastNameProperty());
	    
	    showApplicantDetails(null);
	    
	    applicantTable.getSelectionModel().selectedItemProperty().addListener(
	    		(observable, oldValue, newValue) -> showApplicantDetails(newValue));
	}
	
	 public void setMainApp(MainApp mainApp) {
	    this.mainApp = mainApp;
	        
	    applicantTable.setItems(mainApp.getApplicantData());
	 }
	
	private void showApplicantDetails(Applicant appl) {
		if(appl != null) {
			regNumLabel.setText(Integer.toString(appl.getRegNum()));
			firstNameLabel.setText(appl.getFirstName());
			lastNameLabel.setText(appl.getLastName());
			specializationExpLabel.setText(appl.getSpecializationExp());
			standingLabel.setText(Integer.toString(appl.getStanding()));
			specializationReqLabel.setText(appl.getSpecializationReq());
			conditionalsLabel.setText(appl.getConditionals());
			minalaryLabel.setText(Integer.toString(appl.getSalary()));
			dismissalDateLabel.setText(appl.getDismissalDate());
		}
		else {
			regNumLabel.setText("");
			firstNameLabel.setText("");
			lastNameLabel.setText("");
			specializationExpLabel.setText("");
			standingLabel.setText("");
			specializationReqLabel.setText("");
			conditionalsLabel.setText("");
			minalaryLabel.setText("");
			dismissalDateLabel.setText("");
		}
	}
	
	@FXML
	private void handleDeletePerson() {
		int selectedIndex = applicantTable.getSelectionModel().getSelectedIndex();
		if(selectedIndex >= 0) {
		applicantTable.getItems().remove(selectedIndex);
		}
		else {
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Applicant Selected");
	        alert.setContentText("Please select a person in the table.");
	        alert.showAndWait();
		}
	}
	
	@FXML
	private void handleNewApplicant() {
		Applicant tempAppl = new Applicant();
		boolean okClicked = mainApp.showApplicantEditDialog(tempAppl);
		if(okClicked) {
			mainApp.getApplicantData().add(tempAppl);
		}
	}
	
	@FXML
	private void handleEditPerson() {
		Applicant selectedAppl = applicantTable.getSelectionModel().getSelectedItem();
		if(selectedAppl != null) {
			boolean okClicked = mainApp.showApplicantEditDialog(selectedAppl);
			if(okClicked) {
				showApplicantDetails(selectedAppl);
			}
		}
		else {
			Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Person Selected");
	        alert.setContentText("Please select a person in the table.");

	        alert.showAndWait();
		}
	}
}
