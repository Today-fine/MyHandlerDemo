package demo;

import java.util.UUID;

public class HandlerLaunch {
	public static void main(String[] args) {
		Looper.prepare();
		Handler handler = new Handler() {
			public void handleMessage(Message msg) {
				System.out.println("Thread Id:"+ Thread.currentThread().getName() + "received msg: " + msg.toString());
			};
		};
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					Message msg = new Message();
					msg.obj = UUID.randomUUID().toString();
					System.out.println("Thread Id:"+ Thread.currentThread().getName() +"send message: " + msg.obj);
					handler.sendMessage(msg);
				}
			}
		}).start();
		
		Looper.loop();
		
	}
}
