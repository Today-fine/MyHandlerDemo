package demo;

public class Handler {
	final Looper mLooper;
    final MessageQueue mQueue;
    
    public Handler() {
    	mLooper = Looper.myLooper();
        mQueue = mLooper.mQueue;
    }

	public void dispatchMessage(Message msg) {
         handleMessage(msg);
	}

    /**
     * Subclasses must implement this to receive messages.
     */
	public void handleMessage(Message msg) {
		
	}
	
	public void sendMessage(Message message) {
		enqueueMessage(message);
	}
	
	public void enqueueMessage(Message msg) {
		msg.target = this;
		mQueue.enqueueMessage(msg);
	}

}
