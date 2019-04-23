package ua.lpnuai.oop.berdnyk04;

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
			//System.out.println("25");
			try {
				//System.out.println("27");
				Scanner autoIn = new Scanner(new File("automode.txt"));
				//System.out.println("29");
				if(!autoIn.hasNextLine()) {
					deserialize();
				}
				while(autoIn.hasNext()) {
					//System.out.println("31");
					Applicant appl = new Applicant();
					//System.out.println("33");
					appl.setRegNum(autoIn.nextInt());
					autoIn.nextLine();
					//System.out.println("35");
					while(true) {
						//System.out.println("38");
						appl.addExperience(autoIn.nextLine(), autoIn.nextLine());
						String answ = autoIn.nextLine();
						//System.out.println(answ);
						if(answ.equals("ні")) {
							//System.out.println("40");
							break;
							}
						}
						appl.setEducation(autoIn.nextLine());
						//System.out.println("442");
						int[] tmp = new int[3];
						//System.out.println("45");
						for(int i = 0; i<3;i++) {
							//System.out.println("46");
							tmp[i] = autoIn.nextInt();
						}
						autoIn.nextLine();
						appl.setDismissalDate(tmp);
						//System.out.println("53");
						String[] reqs = new String[3];
						//System.out.println("55");
						for(int i = 0; i<3;i++) {
							//System.out.println("57");
							reqs[i] = autoIn.nextLine();
						}
						//System.out.println("58");
						appl.setJobReqs(reqs);
						//System.out.println("62");
						apps.add(appl);
					//	System.out.println("64");
				}
				autoIn.close();
				//System.out.println("71");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			//System.out.println("75");
			//showAll();
			
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
		
		int[] askDissmisDate(Applicant appl) {
			int[] date = new int[3];
			for(int i = 0; i<3; i++) {
				date[i] = in.nextInt();
			}
			return date;
		}
		void showDissmisDate(Applicant appl) {
			for(int i = 0; i<3; i++) {
				System.out.print(appl.getDismissalDate()[i] + "/");
			}
		}
		
		void showAll() {
			for(Applicant i : apps) {
				menu.showInfo(i);
			}
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
				System.out.println("Змінити даректорію? (так/ні)");
				if(in.nextLine().equals("так")) {
					System.out.println("вверх / вниз ? (вв/вн)");
					if(in.nextLine().equals("вн")) {
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
								System.out.println("151 line");
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
						System.out.println("Deserialized ");
						showAll();
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

	
