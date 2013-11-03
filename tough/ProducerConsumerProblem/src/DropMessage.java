
public class DropMessage {

	// buffer
	private String message;
	
	// if message is read
	private boolean empty = true;
	
	public synchronized String getMessage(){
		while(empty){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		empty = true;
		notifyAll();
		return message;
	}
	
	public synchronized void putMessage(String m){
		while(!empty){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		message = m;
		empty = false;
		notifyAll();
	}
	
}
