package ua.lpnuai.oop.berdnyk08.model;

import java.io.Serializable;
import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Applicant implements Serializable{
	
	private  Integer regNum;
	private  String firstName;
    private  String lastName;
	private  String specializationExp;
	private  Integer standing;
	private  String specializationReq;
	private  String conditionals;
	private  Integer salary;
	private  String dismissalDate;
	
	
	public Applicant() {
		this(null,null);
	}
	
	public Applicant(String firstName, String lastName) {
		this.regNum = 1234;
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.specializationExp = "some specialization";
		this.standing = 1234;
		this.specializationReq = "some specialization";
		this.conditionals = "willing conditionls";
		this.salary = 1234;
		this.dismissalDate = "22.04.2010";
	}

//	public IntegerProperty getRegNumProperty() {
//		return regNum;
//	}
	
	public int getRegNum() {
		return regNum;
	}

	public StringProperty getFirstNameProperty() {
		return new SimpleStringProperty(firstName);
	}
	
	public String getFirstName() {
		return firstName;
	}

	public StringProperty getLastNameProperty() {
		return new SimpleStringProperty(lastName);
	}
	
	public String getLastName() {
		return lastName;
	}

//	public StringProperty getSpecializationExpPropery() {
//		return specializationExp;
//	}
	
	public String getSpecializationExp() {
		return specializationExp;
	}

//	public IntegerProperty getStandingProperty() {
//		return standing;
//	}
	
	public int getStanding() {
		return standing;
	}

//	public StringProperty getSpecializationReqProperty() {
//		return specializationReq;
//	}
	
	public String getSpecializationReq() {
		return specializationReq;
	}

//	public StringProperty getConditionalsProperty() {
//		return conditionals;
//	}
	
	public String getConditionals() {
		return conditionals;
	}

//	public IntegerProperty getSalaryProperty() {
//		return salary;
//	}
	
	public int getSalary() {
		return salary;
	}

//	public ObjectProperty<LocalDate> getDismissalDateProperty() {
//		return dismissalDate;
//	}
	
	public String getDismissalDate() {
		return dismissalDate;
	}
	
	public void setRegNum(int regNum) {
		this.regNum = regNum;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setSpecExp(String specializationExp) {
		this.specializationExp= specializationExp;
	}
	
	public void setStanding(int standing) {
		this.standing = standing;
	}
	
	public void setSpecReq(String specializationReq) {
		this.specializationReq = specializationReq;
	}
	
	public void setConditionals(String conditionals) {
		this.conditionals = conditionals;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void setDismissalDate(String dismissalDate) {
		this.dismissalDate = dismissalDate;
	}
}
