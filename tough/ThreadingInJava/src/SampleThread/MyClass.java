package SampleThread;

import java.lang.Thread;

public class MyClass implements Runnable{

	public void run(){
		System.out.println("Run this thread");
	}
	
	public static void main(String args[]){
	
		// you can put certain condition on thread
		Thread thread = new Thread(new MyClass(),"MyThread");
		thread.start();
		System.out.println(thread.getName());
		System.out.println(thread.getId());
		System.out.println(Thread.currentThread().getName());
	
		ThreadClass tc = new ThreadClass();
		
		for (int i=0;i<10;i++){
			Thread th = new Thread(tc);
			th.start();
			//ThreadClass.print();
		}
		
		System.out.println(tc.getClass().getName());
	}
	
}
