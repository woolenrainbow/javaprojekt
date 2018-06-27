package GUI;

public class Messenger {
	public static int NO_ACTION = 0;
	public static int READ = 1;
	public static int FIND = 2;
	public static int SET_RANGE = 3;
	private String message = null;
	private int code;
	public Messenger() {
		code = NO_ACTION;
	}
	public Messenger(String message, int code) {
		this.message = message;
		this.code = code;
	}
	public void setMessage(String message, int code) {
		this.message = message;
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public int getCode() {
		return code;
	}
}
