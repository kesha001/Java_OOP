package ua.lpnuai.oop.berdnyk05;

import java.io.Serializable;
import java.util.Iterator;

public class MyLinkedList<T> implements Serializable, Iterable<T>{
	
	private int size;
	private Node<T> home, crawler;
	
	public MyLinkedList() {
		this.size = 0;
	}
	
	void add(T d) {
		Node<T> node = new Node<T>(d);
		if(home == null) {
			home = node;
		}
		else {
			crawler = home;
			while(crawler.getNext() != null) {
				crawler = crawler.getNext();
			}
			crawler.setNext(node);
			crawler.getNext().setNext(null);
		}
		size++;
	}
	
	boolean remove(int indx) {
		if(indx < 0 || indx > size) {
			return false;
		}
		else if(indx == 0) {
			home = home.getNext();
		}
		Node<T> crawler = home;
		Node<T> tempor = new Node<T>();
		
		for(int i = 0; i<indx; i++) {
			if(i == indx-1) {
				tempor = crawler.getNext().getNext();
				crawler.getNext().setNext(null);
				crawler.setNext(tempor);
				break;
			}
			crawler = crawler.getNext();
		}
		size--;
		return true;
	}
	
	T get(int indx){
		if (indx < 0 || home == null) {
			System.out.println("returned null (57)");
            return null;
            
        }
		Node<T> crawler = home;
		for(int i = 0; i<size();i++) {
			if(i == indx) {
				return crawler.getData();
			}
			crawler = crawler.getNext();
		}
		System.out.println("returned null (65)");
		return null;
	}
	
	T[] toArray(){
		T arr[] = (T[]) new Object[size];
		Node<T> crawler = home;
		for(int i = 0; i<size;i++) {
			arr[i] = crawler.getData();
			crawler = crawler.getNext();
		}
		return arr;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		Node<T> crawler = home;
		for(int i = 0; i<size(); i++) {
			Applicant apl = (Applicant) crawler.getData();
			str.append(apl.toString());
			crawler = crawler.getNext();
		}
		return str.toString();
	}
	
	boolean isEmpty() {
		if(home == null) {
			return true;
		}
		return false;
	}
	
	int size() {
		return size;
	}
	@Override
	public Iterator<T> iterator() {
		return new InnerIterator();
	}
	
	private class InnerIterator implements Iterator<T>{
		
		private int count;
		
		{
			count = 0;
		}
		
		@Override
		public boolean hasNext() {
			return count < size();
		}

		@Override
		public T next() {
			
			return get(count++);
		}
		
	}

	


}
