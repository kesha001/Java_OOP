package ua.lpnuai.oop.berdnyk02;

import java.util.Iterator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class StringIterator implements Iterable<String>, Serializable{
	 
	
	private static final int INITIAL_CAPACITY = 10;
	private int size = 0;
	private String[] stringsIter = {};
	
	public StringIterator(){
		stringsIter = new String[INITIAL_CAPACITY];
	}
	
	public String toString() {
		if(stringsIter.length == 0)
			return null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stringsIter.length; i++) {
			if(stringsIter[i] != null)
            	sb.append(stringsIter[i]);
        }
		
		return new String(sb);
	}
	public void add(String string) {
		if(size == stringsIter.length)
			increaseCapacity();
		stringsIter[size++] = string;
	}
	
	public void clear() {
		for(int i = 0; i<stringsIter.length;i++) {
			stringsIter[i] = null;
		}
		size = 0;
	}
	
	public boolean remove(String string) {
		boolean removed = false;
		for(int i = 0; i<size;i++) {
			if(stringsIter[i].equals(string)) {
				removed = true;
				for(int j = i; j<size-1;j++) {
					stringsIter[j] = stringsIter[j+1];
				}
				stringsIter[size-1] = null;
				size--;
				break;
			}
			
		}
		return removed;
	}
	
	public Object[] toArray() {
		Object[] temp = new String[size];
		for(int i = 0; i<size; i++) {
			temp[i] = stringsIter[i];
		}
		return temp;
			
	}
	
	public int size() {
		return size;
	}
	
	public boolean contains(String string) {
		for(String i : stringsIter) {
			if(i.equals(string)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsAll(StringIterator container) {
		boolean contains = false;
		for(String i : container) {
			for(int j = 0; j<size;j++) {
				if(i.equals(stringsIter[j])) {
					contains = true;
					break;
				}
			}
			if(!contains) {
				return false;
			}
			contains = false;
			
		}
		return true;
	}
	private void increaseCapacity() {
		int doubledCap = stringsIter.length *2;
		stringsIter = Arrays.copyOf(stringsIter, doubledCap);
	}
	public void display() {
		for(String i : stringsIter){
			if(i == null) {
				System.out.println("there is no elements in container");
				break;
			}
			System.out.println(i);
		}
	}
	public void compareLength(int indx1, int indx2) {
		if(stringsIter[indx1].length() > stringsIter[indx2].length()) {
			System.out.println(stringsIter[indx1] + " longer than "+ stringsIter[indx2]);
		}
		else if(stringsIter[indx1].length() < stringsIter[indx2].length()){
			System.out.println(stringsIter[indx2] + " longer than "+ stringsIter[indx1]);
		}
		else {
			System.out.println("These strings have the same length");
		}
	}
	
	public void sort() {
		int b = 0;
		for(int i = 0; i<stringsIter.length; i++) {
			if(stringsIter[i] != null) {
				b++;
			}
		}
		Arrays.sort(stringsIter,0,b);
		
	}
	
	public boolean search(String s) {
		for(String i : stringsIter) {
			if(i.equals(s)) {
				return true;
			}
		}
		return false;
	}
	public boolean serialize() {
		try {
			FileOutputStream fileOut =
			         new FileOutputStream("serialized.ser");
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(this);
			         out.close();
			         fileOut.close();
			         System.out.println("Serialized");
			         return true;
		}catch (IOException i){
	         i.printStackTrace();
	         return false;
	      }
	}
	public boolean deserialize() {
		StringIterator e = null;
		try {
			FileInputStream fileIn =
					new FileInputStream("serialized.ser");
					ObjectInputStream in = new ObjectInputStream(fileIn);
					e = (StringIterator) in.readObject();
					in.close();
					fileIn.close();
					stringsIter = (String[]) e.toArray();
					System.out.println("Deserialized: ");
					size = e.size;
					for(int i = 0; i<size; i++) {
						System.out.println(stringsIter[i]);
					}
					return true;
		}catch (IOException i) {
	         i.printStackTrace();
	         return false;
		}catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return false;
	      }
		
	}
	public void calcuations() {
//		Menu m = new Menu();
//		m.divideStrings(stringsIter);
		String[] shortests = new String[3];
//		shortests = m.shortInGroups(m.getVow(), m.getCons(), m.getNonLetr());
//		for(int i = 0; i<3;i++) {
//			System.out.println(shortests[i]);
//		}
		int cVow = StringFunct.countVow(stringsIter, stringsIter.length);
		String[] startsVow = new String[cVow];
		
		int cCons = StringFunct.countCons(stringsIter, stringsIter.length);
		String[] startsCons = new String[cCons];
		
		int cNonL = StringFunct.countNon(stringsIter, stringsIter.length); 
		String[] startsNonLetr = new String[cNonL];
		
		startsVow = StringFunct.findVow(stringsIter, cVow,stringsIter.length);
		startsCons = StringFunct.findCons(stringsIter, cCons,stringsIter.length);
		startsNonLetr = StringFunct.findNon(stringsIter,cNonL,stringsIter.length);
		
		shortests[0] = StringFunct.findShortest(startsVow, startsVow.length);
		shortests[1] = StringFunct.findShortest(startsCons, startsCons.length);
		shortests[2] = StringFunct.findShortest(startsNonLetr, startsNonLetr.length);
		
		for(int i = 0; i<shortests.length;i++) {
			System.out.println("Group " + (i+1));
			System.out.println(shortests[i] + " Length - " + shortests[i].length());
		}
	}
	@Override
	public Iterator<String> iterator() {
		
		return new InnerIterator();
	}
	
	private class InnerIterator implements Iterator<String>{
		int cursor = -1;
		@Override
		public boolean hasNext() {
			if(stringsIter[cursor+1] != null)
			return cursor < stringsIter.length -1;
			else
				return false;
		}

		@Override
		public String next() {
			return stringsIter[++cursor];
		}
		public void remove() {
			for(String i : stringsIter) {
				if(stringsIter[cursor].equals(i)) {					
					for(int j = cursor; j<size-1;j++) {
						stringsIter[j] = stringsIter[j+1];
					}
					size--;
					break;
				}
			}
		}
	}
	
	
	

}
