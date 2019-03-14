package ua.lpnuai.oop.berdnyk01;

public class Main {

	public static void main(String[] args) {
	
		if(args.length>0) {	
			if(args[0].equals("-h") || args[0].equals("-help"))	{
				Menu.help();
				return;
			}
			if(args[0].equals("-d") || args[0].equals("-debug")) {
				Menu.debug = true;
			}
		}
		controlPanel();
		// доробити з викрористанням еррей лістів
		

	}
	public static void controlPanel() {
		boolean flag = true;
		while(flag) {
			char c = Menu.showPanel();
			switch(c) {
			case ('a'):
				Menu.askStrings();
				break;
			case('b'):
				Menu.showAskedStrings();
				break;
			case('c'):
				Menu.divideStrings();
				break;
			case('d'):
				Menu.showDidvidedStrings();
				break;
			case('e'):
				Menu.shortInGroups();
				break;
			case('f'):
				Menu.showShortests();
				break;
			case('g'):
				flag = false;
			}
			
			
				
		}
	}

}
