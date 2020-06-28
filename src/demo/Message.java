package demo;

public class Message {
	Handler target;
	Object obj;
	
	public Message() {
		
	}
	
	@Override
	public String toString() {
		return obj.toString();
	}

}
