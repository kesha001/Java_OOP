package ua.lpnuai.oop.berdnyk05;

import java.io.Serializable;

public class Experience implements Serializable {	
	private String place; 
	private String time;


	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
 }
