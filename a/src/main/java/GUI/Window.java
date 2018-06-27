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
		//Messenger messenger = new Messenger();
		//DataStorage dataStorage = new DataStorage();
		//DataPanel dataGrid = new DataPanel(DEFAULT_WIDTH, 9 * DEFAULT_HEIGHT / 10, messenger, dataStorage);
        //add(new MenuPanel(DEFAULT_WIDTH, DEFAULT_HEIGHT / 10, dataGrid, messenger), BorderLayout.NORTH);
        //add(dataGrid, BorderLayout.SOUTH);
		//GUI my_GUI = new GUI(dataStorage, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		//my_GUI.addGUI(this);
		setVisible(true);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLocation(0,0);
		//pack();
	}
}
