package demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MessageQueue {
	
	private static final int MAXCOUNT = 10;
	BlockingQueue<Message> queue;
	
	public MessageQueue() {
		queue = new ArrayBlockingQueue<Message>(MAXCOUNT);
	}
	
	Message next() {
		Message msg = null;
		try {
			msg = queue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

	public void enqueueMessage(Message msg) {
		try {
			queue.put(msg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}