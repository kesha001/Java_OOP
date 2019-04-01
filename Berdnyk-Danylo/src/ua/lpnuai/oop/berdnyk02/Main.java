package ua.lpnuai.oop.berdnyk02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
		static ArrayList<StringIterator> stringIters = new ArrayList<>(); 
	public static void main(String[] args) {
		controlMainPanel();
	}
	public static void controlMainPanel() {
			boolean flag = true;
			Scanner in = new Scanner(System.in);
			Menu m = new Menu();
			while(flag) {
				char c = m.showMainPanel();
				switch(c) {
				case ('a'):
					stringIters.add(new StringIterator());
					System.out.println("created");
					break;
				case('b'):
					System.out.println("enter index of container: ");
					controlOperatingPanel(in.nextInt() - 1);
					break;
				case('c'):
					System.out.println("Enter the index of container: ");
				    stringIters.get((in.nextInt() -1)).display();
					break;
				case('d'):
					for(int i = 0; i<stringIters.size(); i++) {
						stringIters.get(i).display();
					}
					break;
				case('e'):
					flag = false;
					break;
				}
			}
		}
	public static void controlOperatingPanel(int indx) {
		boolean flag = true;
	    StringIterator sI = stringIters.get(indx);
		Scanner in = new Scanner(System.in);
		Menu m = new Menu();
		while(flag) {
			char c = m.showOperatingMenu();
			switch(c) {
			case('a'):
				System.out.println(sI.toString());
				break;
			case('b'):
				System.out.println("enter string to add: ");
				sI.add(in.nextLine());
				System.out.println("added");
				break;
			case('c'):
				sI.clear();
				System.out.println("cleared");
				break;
			case('d'):
				System.out.println("enter the string to remove: ");
				sI.remove(in.nextLine());
				System.out.println("removed");
				break;
			case('e'):
				for(Object i : sI.toArray())
					System.out.println(i);
				break;
			case('f'):
				System.out.println(sI.size());
				break;
			case('g'):
				System.out.println("enter the element: ");
				System.out.println(sI.contains(in.nextLine()));
				break;
			case('h'):
				System.out.println("enter index of the container to compare: ");
			    System.out.println(sI.containsAll(stringIters.get(in.nextInt() - 1)));
			    break;
			case('i'):
				sI.sort();
				System.out.println("sorted");
				break;
			case('k'):
				Iterator<String> i = sI.iterator();
            while (i.hasNext()) {
                System.out.println(i.next());
            	}
            	break;
			case('l'):
				sI.calcuations();
			case('s'):
				sI.serialize();
				break;
			case('p'):
				sI.deserialize();
				break;
			case('m'):
				return;
			}
			
		}
	}

}


