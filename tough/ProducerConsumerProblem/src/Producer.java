
public class Producer implements Runnable{
	
	DropMessage dm;
	
	public Producer(DropMessage m){
		this.dm = m;
	}
	
	public void run(){
		produceMessage(dm);
	}
	
	public void produceMessage(DropMessage m){
		String msg = "hello";
		
		for(int i=0;i<10;i++){
			try {
				Thread.sleep((int)Math.random()*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			m.putMessage(msg+i);
			System.out.println("producer: "+msg+i);
		}
		System.out.println("end producer");
	}
}
