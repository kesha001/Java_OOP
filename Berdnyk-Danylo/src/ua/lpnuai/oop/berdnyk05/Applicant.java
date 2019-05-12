package ua.lpnuai.oop.berdnyk05;

import java.io.Serializable;

public class Applicant implements Serializable {
	private long regNum = 0;
	private MyLinkedList<Experience> experience = new MyLinkedList<Experience>();
	private String education = new String();
	private String dismissalDate;
	private String[] jobReqs = new String[3];
	
	public Applicant() {
		regNum++;
	}
	public void addExperience(String place, String time) {
		Experience exp = new Experience();
		exp.setPlace(place);
		exp.setTime(time);
		this.experience.add(exp);
	}
	public long getRegNum() {
		return regNum;
	}
	
	public void setRegNum(int indx) {
		this.regNum = indx;
	}
	
	public void setExperience(MyLinkedList<Experience> experience) {
		this.experience = experience;
	}
	@Override
	public String toString() {
		String str = (getRegNum()+'.'+ "ed. "+getEducation()+"exp. " + "disdat. " + getDismissalDate()+
				"jobreqs. " + getJobReqs() +"\n");
		return str;
	}
	public MyLinkedList<Experience> getExperience() {
		return experience;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getDismissalDate() {
	
		return dismissalDate;
	}
	public void setDismissalDate(String dismissalDate) {
		this.dismissalDate = dismissalDate;
	}
	public String[] getJobReqs() {
		return jobReqs;
	}
	public void setJobReqs(String[] jobReqs) {
		this.jobReqs = jobReqs;
	}
}
