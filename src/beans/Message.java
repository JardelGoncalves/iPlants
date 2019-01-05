package beans;

public class Message {
	private boolean status;
	private String context;
	
	public Message(boolean status, String context) {
		this.status = status;
		this.context = context;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}

}
