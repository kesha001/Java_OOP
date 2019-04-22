package ua.lpnuai.oop.berdnyk03;

import java.util.Scanner;

public class Menu {
	Scanner in = new Scanner(System.in);
	
	char showMenu() {
		System.out.println("а -Додати апліканта \nд - заповнити форму апліканта по індексу\nб - показати доданих аплікантів \nв - видалити аплікатна за індексом\n"
				+ "г - зберегти дані про доданих аплікантів в файл \nї - вивантажити з файлу дані про аплікантів \nж - вийти ");
		return in.next().charAt(0);
	}
	
	void fillInformOfApplicant(Applicant appl) {
		ApplicantFunct  apsf = new ApplicantFunct();
		
		System.out.println("Введіть досвід роботи апліканта  ");
		in.nextLine();
		while(true) {
			//in.nextLine();
			System.out.println("Спеціальність: ");
			String spez = in.nextLine();
			System.out.println("Стаж на ній: ");
			String stazh = in.nextLine();
			appl.addExperience(spez, stazh);
			System.out.println("Маєте ще досвід роботи?(так/ні)");
			if (in.nextLine().equals("ні"))
				break;
		}
		System.out.println("Введіть освіту апліканта ");
		appl.setEducation(in.nextLine());
		System.out.println("Введіть дату звільнення(день місяць рік): ");
		int[] asked = apsf.askDissmisDate(appl);
		appl.setDismissalDate(asked);
		System.out.println("Введіть вимоги до майбутньої роботи апліканта: ");
		String[] reqs = new String[3];
		System.out.println("Спецальність: ");
		reqs[0] = in.nextLine();
		System.out.println("Умови праці: ");
		reqs[1] = in.nextLine();
		System.out.println("Мінімальна заробітна плата: ");
		reqs[2] = in.nextLine();
		appl.setJobReqs(reqs);
		System.out.println("Вся протрібна інформація про апліканта була додана");
	}
	void showInfo(Applicant appl) {
		ApplicantFunct  apsf = new ApplicantFunct(); 
		System.out.println("Реєстраційний номер: " + appl.getRegNum() + "\nДосвід роботи: ");
		apsf.showExp(appl);
		System.out.println("Освіта: " + appl.getEducation());
		System.out.println(" Дата звільнення: ");
		apsf.showDissmisDate(appl);
		System.out.println("\nВимоги до роботи:");
		apsf.showReqs(appl);
	}
	
}