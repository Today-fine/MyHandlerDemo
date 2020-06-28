package demo;

public class Looper {
	static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();
	final MessageQueue mQueue;
	final Thread mThread;

	private Looper() {
		mQueue = new MessageQueue();
		mThread = Thread.currentThread();
	}

	public static void prepare() {
		if (sThreadLocal.get() != null) {
			throw new RuntimeException("Only one Looper may be created per thread");
		}
		sThreadLocal.set(new Looper());
	}

	public static Looper myLooper() {
		return sThreadLocal.get();
	}

	public static void loop() {
		final Looper me = myLooper();
		final MessageQueue queue = me.mQueue;
		for (;;) {
			Message msg = queue.next();
			msg.target.dispatchMessage(msg);
		}
		
	}
}
