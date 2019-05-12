package ua.lpnuai.oop.berdnyk07;

import java.util.Scanner;

public class Menu {
	Scanner in = new Scanner(System.in);
	
	char showMenu() {
		System.out.println("a - add empty applicant \nb - fill information abou applicant by index\nc - show list of applicants"
				+ "\nd - delete applicant by index\nh - find applicant by index\ns - sort the list\n` - shuffle the list\np - serialize (standart)\ni - deserialize (standart)\n"
				+ "f - save list (xml) \ng - load list(xml)\ne - exit program ");
		return in.next().charAt(0);
	}
	
	void fillInformOfApplicant(Applicant appl) {
		ApplicantFunct  apsf = new ApplicantFunct();
		
		System.out.println("Fill inforf of applicant  ");
		in.nextLine();
		while(true) {
			//in.nextLine();
			System.out.println("Specialization: ");
			String spez = in.nextLine();
			System.out.println("Time of working there: ");
			String stazh = in.nextLine();
			appl.addExperience(spez, stazh);
			System.out.println("Do u want to add 1 more experience?(y/n)");
			if (in.nextLine().equals("n"))
				break;
		}
		System.out.println("Fill education of applicant ");
		appl.setEducation(in.nextLine());
		System.out.println("fill dissmisal date (dd mm yyyy): ");
		int[] asked = apsf.askDissmisDate(appl);
		appl.setDismissalDate(asked);
		System.out.println("Requirements for the future work: ");
		String[] reqs = new String[3];
		System.out.println("Specialization : ");
		reqs[0] = in.nextLine();
		System.out.println("Working conditionals: ");
		reqs[1] = in.nextLine();
		System.out.println("̳Salary: ");
		reqs[2] = in.nextLine();
		appl.setJobReqs(reqs);
		System.out.println("All needed information were added");
	}
	void showInfo(Applicant appl) {
		ApplicantFunct  apsf = new ApplicantFunct(); 
		System.out.println("Reg number: " + appl.getRegNum() + "\nExparience: ");
		apsf.showExp(appl);
		System.out.println("Education: " + appl.getEducation());
		System.out.println(" Dissmisal date: ");
		apsf.showDissmisDate(appl);
		System.out.println("\nReqs for the future work:");
		apsf.showReqs(appl);
	}
	
}