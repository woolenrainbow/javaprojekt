package GUI;

import java.awt.BorderLayout;

import Main.Main;
import dataStorage.DataStorage;

public class GUI {
	private Window window;
	private DataPanel datapanel;
	private MenuPanel menupanel;
	private Messenger messenger;
	
	public GUI(DataStorage dataStorage){
		window = new Window();
		messenger = new Messenger();
		datapanel = new DataPanel(window.DEFAULT_WIDTH, 9 * window.DEFAULT_HEIGHT / 10, messenger, dataStorage);
		menupanel = new MenuPanel(window.DEFAULT_WIDTH, window.DEFAULT_HEIGHT / 10, datapanel, messenger);
	}
	
	public void addGUI(){
		window.add(menupanel, BorderLayout.NORTH);
		window.add(datapanel, BorderLayout.SOUTH);
		window.pack();
	}
}
