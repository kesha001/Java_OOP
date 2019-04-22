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
			case('�') :
				aps.add(new Applicant());
				System.out.println("Added!");
				break;
			case('�'):
				System.out.println("������ ������ ��������: ");
				int indx = in.nextInt()-1;
				in.nextLine();
				menu.fillInformOfApplicant(aps.get(indx));
				break;
			case('�'):
				for(Applicant i : aps) {
					menu.showInfo(i);
				}
					break;
			case('�'):
				System.out.println("������ ������ ��������: ");
				indx = in.nextInt()-1;
				in.nextLine();
				aps = apf.delete(aps, indx);
				break;
			case('�'):
				apf.save(aps);
				System.out.println("Saved");
				break;
			case('�'):
				ArrayList<Applicant> aps2 = apf.load(aps);
				System.out.println("���������� ���: ");
				for(Applicant i : aps2) {
				menu.showInfo(i);
				}
				break;
				
			case('�'):
				return;
			}	
			
			
		}
	}

}
