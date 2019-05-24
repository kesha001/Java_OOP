package ua.lpnuai.oop.berdnyk06;


import java.util.Random;
import java.util.Scanner;

class Task1 extends Thread{
	private static final double DIVIDER = 1_000_000;
	int[] arr;
	
	Task1(){
		
	}
	
	Task1(int[] arr){
		this.arr = arr;
	}
	
	public void run() {
		long start = System.nanoTime();
		int count = 0;
		for(int i = 0; i<arr.length;i++) {
			if(arr[i]%2 == 0)count++;
		}
//		System.out.println("Task1 - "+(System.nanoTime() - start)/DIVIDER);
		System.out.println("Result task 1 :" + count);
		return;
	}
}

class Task2 extends Thread{
	int[] arr;
	private static final double DIVIDER = 1_000_000;
	Task2(){
		
	}
	
	Task2(int[] arr){
		this.arr = arr;
	}
	
	public void run() {
		long start = System.nanoTime();
		int count = 0;
		for(int i = 0; i<arr.length;i++) {
			if(arr[i]%2 == 1)count++;
		}
//		System.out.println("Task2 - "+(System.nanoTime() - start)/DIVIDER);
		System.out.println("Result task 2 :" + count);
		return;
	}
}

class Task3 extends Thread{
	int[] arr;
	private static final double DIVIDER = 1_000_000;
	Task3(){
		
	}
	
	Task3(int[] arr){
		this.arr = arr;
	}
	
	public void run() {
		long start = System.nanoTime();
		int count = 0;
		for(int i = 0; i<arr.length;i++) {
			if(arr[i] <=50)count++;
		}
//		System.out.println("Task3 - "+(System.nanoTime() - start)/DIVIDER);
		System.out.println("Result task 3 :" + count);
		return;
	}
}

class TimeLimitChecker extends Thread{
	private static final double DIVIDER = 1_000_000;
	private float time_limit;
	
	TimeLimitChecker(float limit){
		this.time_limit = limit;
	}
	
	public void run() {
		float start = System.nanoTime();
		while(((System.nanoTime() - start)/DIVIDER) < time_limit) {
		}
		System.exit(-1);
	}
}

public class Main{

	private static final double DIVIDER = 1_000_000;

	public static void main(String[] args) throws InterruptedException{
		Scanner in = new Scanner(System.in);
		Random rgen = new Random();
		int[] arr = new int[5000000];
		for(int i = 0; i<arr.length;i++) {
			int random = rgen.nextInt(100);
			arr[i] = random;
		}
		//count num of even numbers
		Task1 t1 = new Task1(arr);
		//count num of odd numbers
		Task2 t2 = new Task2(arr);
		//count num of numbers <= 50
		Task3 t3 = new Task3(arr);
		System.out.println("m - multithading \ng - gradualy");
		char ch = in.next().charAt(0);
		System.out.println("Type limit time in ms: ");
		float limit = in.nextFloat();
		//runs timer(is not used)
		TimeLimitChecker checker = new TimeLimitChecker(limit);
		in.close();
		long start;
		double end = 0;
		switch(ch) {
		case ('m'):
			start = System.nanoTime();
			t1.start();
			if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
			t2.start();
			if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
			t3.start();
			if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
			t1.join();
			if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
			t2.join();
			if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
			t3.join();
			if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
			end = (System.nanoTime() - start)/DIVIDER;

			System.out.println("Multithread - "+end);
			break;
		case('g'):
			start = System.nanoTime();
			t1.start();
			if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
			t1.join();
			if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
			t2.start();
			if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
			t2.join();
			if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
			t3.start();
			if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
			t3.join();
			if((System.nanoTime() - start)/DIVIDER > limit) { System.err.println("limit");System.exit(0);}
			end = (System.nanoTime() - start)/DIVIDER;
			System.out.println("Gradually - "+end);
			break;
		}
		
		
		
	}

}
