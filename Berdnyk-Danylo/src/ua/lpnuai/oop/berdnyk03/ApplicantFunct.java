package ua.lpnuai.oop.berdnyk03;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class ApplicantFunct {
		Scanner in = new Scanner(System.in);
		void showExp(Applicant appl) {
			ArrayList<Experience> exp = appl.getExperience();
				for(Experience j : exp)
				System.out.println(" ������: " + j.getPlace() + "\n ����: " + j.getTime());
			}
		void showReqs(Applicant appl) {
			System.out.println(" �����������: " + appl.getJobReqs()[0] + "\n ����� �����: " + appl.getJobReqs()[1] + "\n ̳������� �������� �����:"
					+ " " + appl.getJobReqs()[2]);
		}
		int[] askDissmisDate(Applicant appl) {
			int[] date = new int[3];
			for(int i = 0; i<3; i++) {
				date[i] = in.nextInt();
			}
			return date;
		}
		ArrayList<Applicant> delete(ArrayList<Applicant> aps,  int indx) {
			aps.remove(indx);
			return aps;
		}
		void showDissmisDate(Applicant appl) {
			for(int i = 0; i<3; i++) {
				System.out.print(appl.getDismissalDate()[i] + "/");
			}
		}
		
		File selectFile() {
			File f = new File(System.getProperty("user.dir"));
			while(true) {
				System.out.println("��� �������� ���� �����: \n" + f.getAbsolutePath());
				System.out.println("��������� �����:");
				String arr[] = f.list();
				for(String i : arr) {
					System.out.println(i);
					File f1=new File(i); 
					if(f1.isFile()) 
						System.out.println(":::file"); 
					if(f1.isDirectory()) 
						System.out.println(":::directory"); 
				}
				System.out.println("������ ������ ����? (�/�)");
				if(in.nextLine().equals("�")) {
					System.out.println("����� / ���� ? (��/��)");
					if(in.nextLine().equals("��")) {
						System.out.println("������ �����");
						f = new File(f.getAbsoluteFile() + "\\" + in.nextLine().trim());
					}
					else {
						f = new File(f.getParent());
					}
				}
				else {
					f = new File(f.getAbsoluteFile() + "\\savedfile.xml");
					break;
				}
			}
			return f;
		}
		
		void save(ArrayList<Applicant> aps) {
			File f = selectFile();
			XMLEncoder encoder;
			try {
				encoder = new XMLEncoder(new FileOutputStream(f.getAbsolutePath()));
				encoder.writeObject(aps);
				for (Applicant i : aps)
					encoder.writeObject(i);
				encoder.close();
			} catch (FileNotFoundException e) {
				System.out.println("������� ���� �� ���������");
			}
		}
		@SuppressWarnings("unchecked")
		ArrayList<Applicant> load(ArrayList<Applicant> aps) {
			File f = selectFile();
			XMLDecoder decoder;
			try {
				decoder = new XMLDecoder(new FileInputStream(f.getAbsolutePath()));
				aps = (ArrayList<Applicant>) decoder.readObject();
				decoder.close();
			}catch (FileNotFoundException e) {
				System.out.println("������� ���� �� ���������");
		}
			
		return aps;
	}
}

	
