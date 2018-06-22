package Main;

import java.awt.*;
import javax.swing.*;

import GUI.*;
import dataStorage.DataStorage;

public class Main extends JFrame {
	private static final int DEFAULT_WIDTH = 1200;
	private static final int DEFAULT_HEIGHT = 700;
	public Main() {
		super("Prezentacja Danych");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		Messenger messenger = new Messenger();
		DataStorage dataStorage = new DataStorage();
		DataPanel dataGrid = new DataPanel(DEFAULT_WIDTH, 9 * DEFAULT_HEIGHT / 10, messenger, dataStorage);
        add(new MenuPanel(DEFAULT_WIDTH, DEFAULT_HEIGHT / 10, dataGrid, messenger), BorderLayout.NORTH);
        add(dataGrid, BorderLayout.SOUTH);
        setVisible(true);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocation(0,0);
        pack();
	}
	
	public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            new Main();
        });
	}
}
