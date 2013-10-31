package SampleThread;

public class ThreadClass implements Runnable{

	int i=0;
	
	public void run(){
		printName();
	}
	
	public static synchronized void print(){
		System.out.println("Hello World!");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printName(){
		System.out.println(Thread.currentThread().getName());
		i++;
		
		// example if synchronized keyword when synchronized on different class!
		if(i%2 == 0){
			synchronized (this){
				try {
					this.wait();
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(i);
			}
		}else{
			synchronized(this){
				try {
					Thread.sleep(1000);
					this.notify();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(this.getClass().getName());
			}
		}
		
	}
	
}
