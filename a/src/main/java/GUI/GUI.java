package GUI;

import java.awt.BorderLayout;

import Main.Main;
import dataStorage.DataStorage;

public class GUI {
	private Window window;
	private DataPanel datapanel = null;
	private MenuPanel menupanel = null;
	private Messenger messenger = null;
	private InfoPanel infopanel = null;
	
	public GUI(DataStorage dataStorage){
		window = new Window();
		messenger = new Messenger();
		datapanel = new DataPanel(window.DEFAULT_WIDTH, 9 * window.DEFAULT_HEIGHT / 10, messenger, dataStorage);
		menupanel = new MenuPanel(window.DEFAULT_WIDTH, window.DEFAULT_HEIGHT / 20, datapanel, messenger);
		infopanel = new InfoPanel(window.DEFAULT_WIDTH, window.DEFAULT_HEIGHT / 20, messenger);
	}
	
	public void addGUI(){
		window.add(menupanel, BorderLayout.NORTH);
		window.add(infopanel, BorderLayout.CENTER);
		window.add(datapanel, BorderLayout.SOUTH);
		window.pack();
	}
}
