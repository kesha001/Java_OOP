package ua.lpnuai.oop.berdnyk08.model;

import java.util.List;

import javafx.collections.ObservableList;


public class ApplicantListWrapper {

    private List<Applicant> persons;

    public List<Applicant> getApplicants() {
        return persons;
    }

    public void setPersons(ObservableList<Applicant> persons) {
        this.persons = persons;
    }
}