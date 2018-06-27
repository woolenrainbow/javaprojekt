package a.a;

import GUI.Window;
import junit.framework.TestCase;

public class TestWindow extends TestCase{
	private Window window = null;
	private int width, height;
	
	protected void setUp() {
		window = new Window();
		width = 1200;
		height = 700;
	}

	public void test_windows_size() {
		assertTrue(window.getWidth() == 1200 && window.getHeight() == 700);
	}
}
