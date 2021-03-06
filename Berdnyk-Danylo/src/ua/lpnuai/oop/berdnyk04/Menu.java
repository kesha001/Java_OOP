package ua.lpnuai.oop.berdnyk04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
	Scanner in = new Scanner(System.in);
	
	char showMenu() {
		System.out.println("а -додати апліканта \nб - покизати алпікантів в списку \nс - видалити елемент за індексом\n"
				+ "д - збрегти в XML \nї - вивантажити XML \nж - серіалізувати Standart"
				+ "\nз - десеріалізувати Standart\nе - вийти ");
		return in.next().charAt(0);
	}
	
	
	
	void fillInformOfApplicant(Applicant appl) {
		ApplicantFunct  apsf = new ApplicantFunct();
		
		System.out.println("Введіть досвід апліканта  ");
		//in.nextLine();
		while(true) {
			//in.nextLine();
			System.out.println("Специалізація: ");
			String spez = in.nextLine();
			System.out.println("Стаж: ");
			String stazh = in.nextLine();
			appl.addExperience(spez, stazh);
			System.out.println("Маєте ще стаж? (так/ні)");
			if (in.nextLine().equals("ні"))
				break;
		}
		System.out.println("Освіта апліканта ");
		appl.setEducation(in.nextLine());
		System.out.println("Дата звільнення: ");
		int[] asked = apsf.askDissmisDate(appl);
		appl.setDismissalDate(asked);
		System.out.println("Вимоги до майбутньої спеціальності: ");
		String[] reqs = new String[3];
		System.out.println("Спаціальність: ");
		reqs[0] = in.nextLine();
		System.out.println("Умови праці: ");
		reqs[1] = in.nextLine();
		System.out.println("̳Заробінта плата : ");
		reqs[2] = in.nextLine();
		appl.setJobReqs(reqs);
		System.out.println("Всі потрібні дані були записані");
	}
	void showInfo(Applicant appl) {
		ApplicantFunct  apsf = new ApplicantFunct(); 
		System.out.println("Reg num: " + appl.getRegNum() + "\nExperience: ");
		apsf.showExp(appl);
		System.out.println("Education: " + appl.getEducation());
		System.out.println(" DissmisalDate: ");
		apsf.showDissmisDate(appl);
		System.out.println("\nRequirments for future work:");
		apsf.showReqs(appl);
	}
	
}