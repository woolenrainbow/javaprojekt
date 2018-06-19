package GUI;

public class Messenger {
	private String message = null;
	public Messenger() {}
	public Messenger(String message) {
		this.message = message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
