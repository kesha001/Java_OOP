package ua.lpnuai.oop.berdnyk02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class Menu {
	static boolean debug = false;
	static String[] strings;
	public static void debugActive() {
		debug = true;
	}
	public static String[] askStrings(){	
		Scanner in = new Scanner(System.in);
		
		List<String> strings2 = new ArrayList<String>();
		boolean next = true;
		do {
			strings2.add(in.nextLine());
			System.out.println("Next?(y/n)");
			if(in.nextLine().equals("n"))
				next = false;
		}while(next);
		strings = new String[strings2.size()]; 
		strings = strings2.toArray(strings);
		return strings;
	}
	public static void showAskedStrings() {
		for(int i = 0; i<strings.length;i++) {
			System.out.println(strings[i]);
		}
	}
	public static void help() {
		System.out.println("Author : first name - Danylo, last name - Berdnyk ");
		System.out.println("student of the Lviv Politechnik University");
		System.out.println("Group - KN-108");
		System.out.println("Command line arguments : \"-h\"/\"-help\" - shows information about author of the program \n"
				+ "\"-d\"/\"-debug\" - activates debug mode where addictional information avaiable \n"
				+ "a - input the strings \nb - viewing the strings from the input \nc - dividing strings into 3 groups \n"
				+ "d - show the result of the dividing \ne - calculate the shortest string in each group\n f - show show shortest strings in each group\n g - end the program");
	}
	static String[] startsVow;
	static String[] startsCons;
	static String[] startsNonLetr;
	public static char showPanel() {
		System.out.println("a - input the strings \nb - viewing the strings from the input \nc - dividing strings into 3 groups \n"
				+ "d - show the result of the dividing \ne - calculate the shortest string in each group\nf - show shortest strings in each group\n"
				+ "g - end the program");
		Scanner in = new Scanner(System.in);
		return in.next().charAt(0);
	}
	public static char showMainPanel() {
		System.out.println("a - create new container \nb - container operating menu \nc - display the container by index \nd - show list of your containers"
				+ "\ne - end the program");
		Scanner in = new Scanner(System.in);
		return in.next().charAt(0);
	}
	public static char showOperatingMenu() {
		System.out.println("a - convert continer into string \nb - adds new string to the end of the container \nc - clears the container data \n"
				+ "d - removes element by name \ne - returns array that contains all elements in container \nf - returns number of elements in "
				+ "container \ng - returns true if container contains given element \nh - compares 2 containers"
				+ "\ni - sort elements \nk - iterates through container \nl - calculations from the previos lab \n"
				+ "m - close menu \ns - serialise container \np - desirialise container");
		Scanner in = new Scanner(System.in);
		return in.next().charAt(0);
	}
	public static void divideStrings(String[] strings) {
		
		int cVow = StringFunct.countVow(strings, strings.length);
		startsVow = new String[cVow];
		
		int cCons = StringFunct.countCons(strings, strings.length);
		startsCons = new String[cCons];
		
		int cNonL = StringFunct.countNon(strings, strings.length); 
		startsNonLetr = new String[cNonL];
		
		startsVow = StringFunct.findVow(strings, cVow,strings.length);
		startsCons = StringFunct.findCons(strings, cCons,strings.length);
		startsNonLetr = StringFunct.findNon(strings,cNonL,strings.length);
	}
	public String[] getVow() {
		return startsVow;
	}
	public String[] getCons() {
		return startsCons;
	}
	public String[] getNonLetr() {
		return startsNonLetr;
	}
	static String[] shortests = new String[3];
	public static String[] shortInGroups(String[] startsVow, String[] startsCons, String[] startsNonLetr) {
		shortests[0] = StringFunct.findShortest(startsVow, startsVow.length);
		shortests[1] = StringFunct.findShortest(startsCons, startsCons.length);
		shortests[2] = StringFunct.findShortest(startsNonLetr, startsNonLetr.length);
		return shortests;
	}
	public static void showShortests() {
		System.out.println("Shortests: ");
		for(int i = 0; i<shortests.length;i++) {
			System.out.println("Group " + (i+1));
			System.out.println(shortests[i] + " Length - " + shortests[i].length());
		}
	}
	
	public static void showDidvidedStrings() {
		StringFunct.printStrings(startsVow, startsCons, startsNonLetr);
	}
	

}
