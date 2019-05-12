package ua.lpnuai.oop.berdnyk07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		controlPanel();
		
	}
	static void controlPanel() {
		ArrayList<Applicant> aps = new ArrayList<Applicant>();
		ApplicantFunct apf = new ApplicantFunct();
		Menu menu = new Menu();
		while(true) {
			char c = menu.showMenu();
			switch(c) {
			case('a') :
				aps.add(new Applicant());
				System.out.println("Added!");
				break;
			case('b'):
				System.out.println("index of applicant to fill form: ");
				int indx = in.nextInt()-1;
				in.nextLine();
				menu.fillInformOfApplicant(aps.get(indx));
				break;
			case('c'):
				for(Applicant i : aps) {
					menu.showInfo(i);
				}
					break;
			case('d'):
				System.out.println("index of applicant to delete: ");
				indx = in.nextInt()-1;
				in.nextLine();
				aps = apf.delete(aps, indx);
				break;
			case('f'):
				apf.save(aps);
				System.out.println("Saved");
				break;
			case('g'):
				ArrayList<Applicant> aps2 = apf.load(aps);
				System.out.println("Deserialized standart: ");
				for(Applicant i : aps2) {
				menu.showInfo(i);
				}
				aps = aps2;
				break;
			case('h'):
				System.out.println("index of applicant to find : ");
				int index = in.nextInt();
				menu.showInfo(aps.get(index-1));
				break;
			case('s'):
				Collections.sort(aps);
				System.out.println("Sorted!");
				break;
			case('p'):
				apf.serialize(aps);
				break;
			case('i'):
				aps = apf.deserialize();
				break;
			case('`'):
				Collections.shuffle(aps);
				break;
			case('e'):
				return;
			}	
			
			
		}
	}

}
