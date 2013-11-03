
public class ProducerConsumerDriver{
	
	public static void main(String args[]){
		DropMessage dm = new DropMessage();
		Producer p = new Producer(dm);
		Consumer c = new Consumer(dm);
	
		Thread pd = new Thread(p);
		pd.start();
		
		Thread cm = new Thread(c);
		cm.start();
		
		try {
			pd.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cm.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Problem Solved!");
	}
	
}
