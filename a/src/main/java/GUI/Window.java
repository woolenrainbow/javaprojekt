package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Window extends JFrame{
	protected static final int DEFAULT_WIDTH = 1200;
	protected static final int DEFAULT_HEIGHT = 700;
	public Window() {
		super("Prezentacja Danych");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		setVisible(true);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLocation(0,0);
	}
}
