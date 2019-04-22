package ua.lpnuai.oop.berdnyk03;

import java.util.Scanner;

public class Menu {
	Scanner in = new Scanner(System.in);
	
	char showMenu() {
		System.out.println("� -������ �������� \n� - ��������� ����� �������� �� �������\n� - �������� ������� �������� \n� - �������� �������� �� ��������\n"
				+ "� - �������� ��� ��� ������� �������� � ���� \n� - ����������� � ����� ��� ��� �������� \n� - ����� ");
		return in.next().charAt(0);
	}
	
	void fillInformOfApplicant(Applicant appl) {
		ApplicantFunct  apsf = new ApplicantFunct();
		
		System.out.println("������ ����� ������ ��������  ");
		in.nextLine();
		while(true) {
			//in.nextLine();
			System.out.println("������������: ");
			String spez = in.nextLine();
			System.out.println("���� �� ��: ");
			String stazh = in.nextLine();
			appl.addExperience(spez, stazh);
			System.out.println("���� �� ����� ������?(���/�)");
			if (in.nextLine().equals("�"))
				break;
		}
		System.out.println("������ ����� �������� ");
		appl.setEducation(in.nextLine());
		System.out.println("������ ���� ���������(���� ����� ��): ");
		int[] asked = apsf.askDissmisDate(appl);
		appl.setDismissalDate(asked);
		System.out.println("������ ������ �� ��������� ������ ��������: ");
		String[] reqs = new String[3];
		System.out.println("�����������: ");
		reqs[0] = in.nextLine();
		System.out.println("����� �����: ");
		reqs[1] = in.nextLine();
		System.out.println("̳������� �������� �����: ");
		reqs[2] = in.nextLine();
		appl.setJobReqs(reqs);
		System.out.println("��� �������� ���������� ��� �������� ���� ������");
	}
	void showInfo(Applicant appl) {
		ApplicantFunct  apsf = new ApplicantFunct(); 
		System.out.println("������������ �����: " + appl.getRegNum() + "\n����� ������: ");
		apsf.showExp(appl);
		System.out.println("�����: " + appl.getEducation());
		System.out.println(" ���� ���������: ");
		apsf.showDissmisDate(appl);
		System.out.println("\n������ �� ������:");
		apsf.showReqs(appl);
	}
	
}