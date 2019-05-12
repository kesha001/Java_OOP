package ua.lpnuai.oop.berdnyk05;

import java.util.Scanner;

public class Menu {
	Scanner in = new Scanner(System.in);
	char showMenu() {
		System.out.println("а -додати апліканта \nб - показати алпікантів в списку \nс - видалити елемент за індексом\n"
				+ "д - збрегти в XML \nї - вивантажити XML \nж - серіалізувати Standart"
				+ "\nз - десеріалізувати Standart\nе - вийти ");
		return in.next().charAt(0);
	}
	
	void fillInformOfApplicant(Applicant appl) {
		ApplicantFunct  apsf = new ApplicantFunct();
		
		System.out.println("Введіть досвід апліканта  ");
		while(true) {
			System.out.println("Специалізація: ");
			String spez = in.nextLine();
			String stazh;
			do {
			System.out.println("Стаж(в роках): ");
			stazh = in.nextLine();
			}while(!RegCheck.checkStazhExp(stazh));
			appl.addExperience(spez, stazh);
			String answ;
			do {
			System.out.println("Маєте ще стаж? (так/ні)");
			answ = in.nextLine();
			}while(!RegCheck.checkYeNo(answ));
			if (answ.equals("ні"))
				break;
		}
		System.out.println("Освіта апліканта ");
		appl.setEducation(in.nextLine());
		String asked;
		do {
		System.out.println("Дата звільнення(dd-mm-yyyy): ");
		asked = in.nextLine();
		}while(!RegCheck.checkDataExp(asked));
		appl.setDismissalDate(asked);
		System.out.println("Вимоги до майбутньої спеціальності: ");
		String[] reqs = new String[3];
		System.out.println("Спeціальність: ");
		reqs[0] = in.nextLine();
		System.out.println("Умови праці: ");
		reqs[1] = in.nextLine();
		do {
		System.out.println("Заробітна плата в $ : ");
		reqs[2] = in.nextLine();
		}while(!RegCheck.checkSalary(reqs[2]));
		appl.setJobReqs(reqs);
		System.out.println("Всі потрібні дані були записані");
	}
	void showInfo(Applicant appl) {
		ApplicantFunct  apsf = new ApplicantFunct(); 
		System.out.println("Reg num: " + appl.getRegNum() + "\nExperience: ");
		apsf.showExp(appl);
		System.out.println("Education: " + appl.getEducation());
		System.out.println(" DissmisalDate: ");
		System.out.println(appl.getDismissalDate());
		System.out.println("\nRequirments for future work:");
		apsf.showReqs(appl);
	}
}