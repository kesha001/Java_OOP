package ua.lpnuai.oop.berdnyk08.view;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ua.lpnuai.oop.berdnyk08.model.Applicant;
import ua.lpnuai.oop.berdnyk08.util.DateUtil;

public class ApplicantEditDialogController {
	
	@FXML
	private TextField regNumField;
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField specializationExpField;
	@FXML
	private TextField standingField;
	@FXML
	private TextField specializationReqField;
	@FXML
	private TextField conditionalsField;
	@FXML
	private TextField minSalaryField;
	@FXML
	private TextField dismissalDateField;
	
	private Stage dialogStage;
	private boolean okClicked = false;
	private Applicant appl;
	
	
	@FXML
    private void initialize() {
    }
	
	public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	
	public void setApplicant(Applicant appl) {
		this.appl = appl;
		
		regNumField.setText(Integer.toString(appl.getRegNum()));
		firstNameField.setText(appl.getFirstName());
		lastNameField.setText(appl.getLastName());
		specializationExpField.setText(appl.getSpecializationExp());
		standingField.setText(Integer.toString(appl.getStanding()));
		specializationReqField.setText(appl.getSpecializationReq());
		conditionalsField.setText(appl.getConditionals());
		minSalaryField.setText(Integer.toString(appl.getSalary()));
		dismissalDateField.setText(appl.getDismissalDate());
		dismissalDateField.setPromptText("dd.mm.yyyy");
	}
	
	public boolean isOkClicked() {
        return okClicked;
    }
	
	@FXML
	private void handleOk() {
		if(isInputValid()) {
			appl.setRegNum(Integer.parseInt(regNumField.getText()));

			appl.setFirstName(firstNameField.getText());

			appl.setLastName(lastNameField.getText());

			appl.setSpecExp(specializationExpField.getText());

			appl.setStanding(Integer.parseInt(standingField.getText()));

			appl.setSpecReq(specializationReqField.getText());

			appl.setConditionals(conditionalsField.getText());

			appl.setSalary(Integer.parseInt(minSalaryField.getText()));

			
			okClicked = true;
			dialogStage.close();
		}
	}
	@FXML
	private void handleCancel() {
        dialogStage.close();
    }
	
	private boolean isInputValid() {
        String errorMessage = "";
        if(regNumField.getText() == null || regNumField.getText().length() == 0) {
        	errorMessage += "No valid registration number\n";
        }
         else {
            try {
                Integer.parseInt(regNumField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid registration number (must be an integer)!\n"; 
            }
        }
        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; 
        }
        if (specializationExpField.getText() == null || specializationExpField.getText().length() == 0) {
            errorMessage += "No valid specialization!\n"; 
        }

        if (standingField.getText() == null || standingField.getText().length() == 0) {
            errorMessage += "No valid stanging time!\n";
        }
            else {
                try {
                    Integer.parseInt(standingField.getText());
                } catch (NumberFormatException e) {
                    errorMessage += "No valid stanging time number (must be an integer)!\n"; 
                }
            }

        if (specializationReqField.getText() == null || specializationReqField.getText().length() == 0) {
            errorMessage += "No valid specialization!\n"; 
        }
        
        if(conditionalsField.getText() == null || conditionalsField.getText().length() == 0) {
        	errorMessage += "No valid conditionals\n";
        }
        if(minSalaryField.getText() == null || minSalaryField.getText().length() == 0) {
        	errorMessage += "No valid minimal salary\n";
        }else {
            try {
                Integer.parseInt(minSalaryField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid minumal salary (must be an integer)!\n"; 
            }
        }
        
        if (dismissalDateField.getText() == null || dismissalDateField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        } else {
            if (!DateUtil.validDate(dismissalDateField.getText())) {
                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }
	
}
