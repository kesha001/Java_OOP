package ua.lpnuai.oop.berdnyk07;

import java.io.Serializable;
import java.util.ArrayList;


public class Applicant implements Comparable<Applicant>,Serializable{
	private static Integer regNum = 0;
	private Integer myNum;
	private ArrayList<Experience> experience = new ArrayList<Experience>();
	private String education = new String();
	private int[] dismissalDate = new int[3];
	private String[] jobReqs = new String[3];
	
	public Applicant() {
		regNum++;
		myNum = regNum;
	}
	public void addExperience(String place, String time) {
		Experience exp = new Experience();
		exp.setPlace(place);
		exp.setTime(time);
		this.experience.add(exp);
	}
	public Integer getRegNum() {
		return myNum;
	}
	public ArrayList<Experience> getExperience() {
		return experience;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public int[] getDismissalDate() {
	
		return dismissalDate;
	}
	public void setDismissalDate(int[] dismissalDate) {
		this.dismissalDate = dismissalDate;
	}
	public String[] getJobReqs() {
		return jobReqs;
	}
	public void setJobReqs(String[] jobReqs) {
		this.jobReqs = jobReqs;
	}
	@Override
	public int compareTo(Applicant o) {
		return this.getRegNum().compareTo(o.getRegNum());
	}
	
}
