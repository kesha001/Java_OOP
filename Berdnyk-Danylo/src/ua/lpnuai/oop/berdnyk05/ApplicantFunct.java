package ua.lpnuai.oop.berdnyk05;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ApplicantFunct {
		Scanner in = new Scanner(System.in);
		Menu menu = new Menu();
		MyLinkedList<Applicant> apps = new MyLinkedList<Applicant>();
		
		void showReqs(Applicant appl) {
			System.out.println(" Specalization: " + appl.getJobReqs()[0] + "\n Умови праці: " + appl.getJobReqs()[1] + "\n Заробітна плата:"
					+ " " + appl.getJobReqs()[2]);
			
		}
		void automode() {
			try {
				Scanner autoIn = new Scanner(new File("automode.txt"));
				if(!autoIn.hasNextLine()) {
					deserialize();
				}
				while(autoIn.hasNext()) {
					Applicant appl = new Applicant();
					appl.setRegNum(autoIn.nextInt());
					autoIn.nextLine();
					while(true) {
						appl.addExperience(autoIn.nextLine(), autoIn.nextLine());
						String answ = autoIn.nextLine();
						if(answ.equals("ні")) {
							break;
							}
						}
						appl.setEducation(autoIn.nextLine());
						String tmp = autoIn.nextLine();
						appl.setDismissalDate(tmp);
						String[] reqs = new String[3];
						for(int i = 0; i<3;i++) {
							reqs[i] = autoIn.nextLine();
						}
						appl.setJobReqs(reqs);
						apps.add(appl);
				}
				autoIn.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			
		}
		@Override
		public String toString() {
			return apps.toString();
		}
		
		void add() {
			Applicant ap = new Applicant();
			menu.fillInformOfApplicant(ap);
			apps.add(ap);
		}
		
		
		public void showExp(Applicant appl) {
			MyLinkedList<Experience> exp = appl.getExperience();
			for(Experience j : exp)
			System.out.println(" Spazialization: " + j.getPlace() + "\n Стаж: " + j.getTime());
			
		}
		
		String askDissmisDate(Applicant appl) {
			String date = new String();
			
			return date;
		}
		void showDissmisDate(Applicant appl) {
			System.out.println(appl.getDismissalDate());
		}
		
		void showAll() {
			for(Applicant i : apps) {
				menu.showInfo(i);
			}
		}
		
		boolean check(Applicant appl) {
			if(!RegCheck.checkDataExp(appl.getDismissalDate()) || !RegCheck.checkSalary(appl.getJobReqs()[2])) 
				return false; 
			MyLinkedList<Experience> exp = appl.getExperience();
			for(Experience i : exp) {
				if(!RegCheck.checkStazhExp(i.getTime()))
					return false;
			}
			return true;
		}
		
		void remove(int indx) {
			apps.remove(indx);
		}
		
		void removeAll() {
			for(int i = apps.size()-1; i>=0;i--) {
				apps.remove(i);
			}
		}
		
		File selectFile() {
			File f = new File(System.getProperty("user.dir"));
			while(true) {
				System.out.println("ur current directory: \n" + f.getAbsolutePath());
				System.out.println("Вмістилище:");
				String arr[] = f.list();
				for(String i : arr) {
					System.out.println(i);
					File f1=new File(i); 
					if(f1.isFile()) 
						System.out.println(":::file"); 
					if(f1.isDirectory()) 
						System.out.println(":::directory"); 
				}
				String answ;
				String answ2;
				do {
				System.out.println("Змінити даректорію? (так/ні)");
				answ = in.nextLine();
				}while(!RegCheck.checkYeNo(answ));
				if(answ.equals("так")) {
					do {
					System.out.println("вверх / вниз ? (вв/вн)");
					answ2 = in.nextLine();
					}while(!RegCheck.checkUpDown(answ2));
					if(answ2.equals("вн")) {
						System.out.println("назва файлу");
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
		
		public boolean saveXml() {
			File f = selectFile();
			XMLEncoder encoder;
			try {
				encoder = new XMLEncoder(new FileOutputStream(f.getAbsolutePath()));
				encoder.writeObject(apps);
				for (Applicant i : apps) {
					encoder.writeObject(i);
					for(Experience g : i.getExperience()) {
						encoder.writeObject(g);
					}
				}
				encoder.close();
				System.out.println("saved xml");
				return true;
			} catch (FileNotFoundException e) {
				System.out.println("File not found");
				return false;
			}
		}
		@SuppressWarnings("unchecked")
		public void loadXml() {
			File f = selectFile();
			XMLDecoder decoder;
			
			try {
				decoder = new XMLDecoder(new FileInputStream(f.getAbsolutePath()));
				apps = (MyLinkedList<Applicant>) decoder.readObject();
				Object o = null;
				while(true) {
					try {
						Applicant ap;
						if(o == null) {
							ap = (Applicant) decoder.readObject();
						}
						else {
							ap = (Applicant) o;
						}
						MyLinkedList<Experience> experience = new MyLinkedList<Experience>() /*= (MyLinkedList<Experience>) decoder.readObject()*/; 
						while (true) {
							try {
								o = decoder.readObject();
								if(o.getClass().equals(Experience.class)) {
									Experience exp = (Experience) o;
									experience.add(exp);
									}
								else {
									break;
								}
							}catch(Exception e) {
								//e.printStackTrace();
								break;
							}
						}
						ap.setExperience(experience);
						apps.add(ap);
					}catch(Exception e) {
						//System.out.println("157 line err \n");
						//e.printStackTrace();
						break;
					}
				}
				decoder.close();
				for(Applicant i : apps) {
					if(!check(i))
						System.out.println("Wrong format"); return;
					
				}
			} catch (FileNotFoundException e1) {
				//System.out.println("164 err");
				e1.printStackTrace();
			}
			
			System.out.println("Xml saved");
			showAll();

	}
		public boolean serialize() {
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
		public MyLinkedList<Applicant> deserialize() {
			try {
				FileInputStream fileIn =
						new FileInputStream("serialized.ser");
						ObjectInputStream in = new ObjectInputStream(fileIn);
						apps = (MyLinkedList<Applicant>) in.readObject();
						in.close();
						fileIn.close();
//						for(Applicant i : apps) {
//							if(!check(i))
//								System.out.println("Wrong format"); return null;
//							
//						}
						System.out.println("Deserialized ");
						//showAll();
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
