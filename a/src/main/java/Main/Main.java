package Main;

import java.awt.*;
import javax.swing.*;

import GUI.*;
import dataStorage.DataStorage;

public class Main{
	public Main() {
		DataStorage dataStorage = new DataStorage();
		GUI my_GUI = new GUI(dataStorage);
		my_GUI.addGUI();
	}
	
	public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            new Main();
        });
	}
}
