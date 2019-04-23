
package ua.lpnuai.oop.berdnyk04;

import java.util.Scanner;

public class Main {
	//
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		if(args.length > 0 && (args[0].equals("-a") ||args[0].equals("-auto"))) {
			ApplicantFunct apf = new ApplicantFunct();
			System.out.println("automode");
			
			apf.automode();
			System.out.println("utomode end");
			return;
		}
		controlPanel();		
	}
	static void controlPanel() {
		ApplicantFunct apf = new ApplicantFunct();
		Menu menu = new Menu();
		while(true) {
			char c = menu.showMenu();
			switch(c) {
			case('а') :
				apf.add();
				break;
			case('б'):
				apf.showAll();
					break;
			case('с'):
				System.out.println("index of element to delete ");
				int indx = in.nextInt()-1;
				apf.remove(indx);
				break;
			case('д'):
				apf.saveXml();
				System.out.println("Saved");
				break;
			case('ї'):
				apf.loadXml();
				break;
			
			case('ж'):
				apf.serialize();
				break;
			case('з'):
				apf.deserialize();
				break;
			case('е'):
				System.exit(0);
			}	
			
			
		}
	}

}
