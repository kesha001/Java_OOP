package ua.lpnuai.oop.berdnyk07;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class ApplicantFunct {
		Scanner in = new Scanner(System.in);
		void showExp(Applicant appl) {
			ArrayList<Experience> exp = appl.getExperience();
				for(Experience j : exp)
				System.out.println(" Place: " + j.getPlace() + "\n Time: " + j.getTime());
			}
		void showReqs(Applicant appl) {
			System.out.println(" Specialization: " + appl.getJobReqs()[0] + "\n Working conditions: " + appl.getJobReqs()[1] + "\n Salary:"
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
				System.out.println("Your current path: \n" + f.getAbsolutePath());
				System.out.println("Directory list:");
				String arr[] = f.list();
				for(String i : arr) {
					System.out.println(i);
					File f1=new File(i); 
					if(f1.isFile()) 
						System.out.println(":::file"); 
					if(f1.isDirectory()) 
						System.out.println(":::directory"); 
				}
				System.out.println("Do u want to change directory? (y/n)");
				if(in.nextLine().equals("y")) {
					System.out.println("Up / down ? (up/dn)");
					if(in.nextLine().equals("dn")) {
						System.out.println("File name");
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
				System.out.println("File not found");
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
				System.out.println("File not found");
		}
			
		return aps;
	}
	
		public boolean serialize(ArrayList<Applicant> apps) {
			try {
				FileOutputStream fileOut =
				         new FileOutputStream("serialized.ser");
				         ObjectOutputStream out = new ObjectOutputStream(fileOut);
				         out.writeObject(apps);
				         out.close();
				         fileOut.close();
				         System.out.println("Serialized");
				         return true;
			}catch (IOException i){
		         i.printStackTrace();
		         return false;
		      }
		}
		public ArrayList<Applicant> deserialize() {
			try {
				FileInputStream fileIn =
						new FileInputStream("serialized.ser");
						ObjectInputStream in = new ObjectInputStream(fileIn);
						ArrayList<Applicant> apps = (ArrayList<Applicant>) in.readObject();
						in.close();
						fileIn.close();
						System.out.println("Deserialized ");
						return apps;
			}catch (IOException i) {
		         i.printStackTrace();
		         return null;
			}catch (ClassNotFoundException c) {
		         System.out.println("Employee class not found");
		         c.printStackTrace();
		         return null;
		      }
			
		}
		
}

	
