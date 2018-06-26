package a.a;

import GUI.Messenger;

import junit.framework.TestCase;


public class TestMessenger extends TestCase{
	private Messenger messenger = new Messenger();
	String message = "asdf";
	
	public void test_set_message() {
		messenger.setMessage(message, 1);
	    assertNotNull(messenger.getMessage());
	}
}
