package ua.lpnuai.oop.berdnyk03;

import java.util.ArrayList;
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
			case('а') :
				aps.add(new Applicant());
				System.out.println("Added!");
				break;
			case('д'):
				System.out.println("¬вед≥ть ≥ндекс апл≥канта: ");
				int indx = in.nextInt()-1;
				in.nextLine();
				menu.fillInformOfApplicant(aps.get(indx));
				break;
			case('б'):
				for(Applicant i : aps) {
					menu.showInfo(i);
				}
					break;
			case('в'):
				System.out.println("¬вед≥ть ≥ндекс апл≥канта: ");
				indx = in.nextInt()-1;
				in.nextLine();
				aps = apf.delete(aps, indx);
				break;
			case('г'):
				apf.save(aps);
				System.out.println("Saved");
				break;
			case('њ'):
				ArrayList<Applicant> aps2 = apf.load(aps);
				System.out.println("¬ивантажен≥ дан≥: ");
				for(Applicant i : aps2) {
				menu.showInfo(i);
				}
				break;
				
			case('ж'):
				return;
			}	
			
			
		}
	}

}
