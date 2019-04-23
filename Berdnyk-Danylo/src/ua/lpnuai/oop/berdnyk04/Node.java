package ua.lpnuai.oop.berdnyk04;

import java.io.Serializable;

public class Node<T> implements Serializable {

	private Node<T> next;
	private T data;
	public Node() {
		
	}
	
	public Node(T data){
		this.data = data;
	}
	
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
	
	
}
