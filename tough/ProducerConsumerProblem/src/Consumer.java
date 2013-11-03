public class Consumer implements Runnable {

	DropMessage dm;

	public Consumer(DropMessage m) {
		this.dm = m;
	}

	public void run() {
		consumeMessage(dm);
	}

	public void consumeMessage(DropMessage m) {
		String msg;
		do {
			try {
				Thread.sleep((int) Math.random() * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			msg = m.getMessage();
			System.out.println("consumer: " + msg);
		} while (!msg.equals("hello9"));
		
		System.out.println("end consumer");
	}
}
