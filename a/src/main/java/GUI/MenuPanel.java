package GUI;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuPanel extends JPanel{
	private JTextField fromTextField = null;
	private JTextField toTextField = null;
	private int WIDTH = 0;
	private int HEIGHT = 0;
	public MenuPanel(int width, int height, Callable<Void> dataPanel, Callable<Void> infoPanel, Messenger messenger, Messenger infoMessenger) {
		this.WIDTH = width / 8;
		this.HEIGHT = (int) (height / 1.5);
		setPreferredSize(new Dimension(width, height));
		FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);
		setLayout(layout);
		fromTextField = new JTextField();
		toTextField = new JTextField();
		fromTextField.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
		toTextField.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
		add(new JLabel("Od: "));
		add(fromTextField);
		add(new JLabel("Do: "));
		add(toTextField);		
		JButton searchBtn = new JButton("Szukaj");
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				messenger.setMessage(fromTextField.getText() + " " + toTextField.getText(), Messenger.FIND);
				infoMessenger.setMessage(fromTextField.getText() + "/" + toTextField.getText(), Messenger.SET_RANGE);
				try {
					dataPanel.call();
					infoPanel.call();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		searchBtn.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
		add(searchBtn);
		JButton clearBtn = new JButton("Wyczyść");
		clearBtn.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
		clearBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				messenger.setMessage("", Messenger.CLEAR);
				infoMessenger.setMessage("brak wartości" + "/" + "brak wartości", Messenger.CLEAR);
				try {
					infoPanel.call();
					dataPanel.call();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		add(clearBtn);
		JButton getFileBtn = new JButton("Wybierz plik");
		getFileBtn.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
		getFileBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int returnValue = chooser.showOpenDialog(null);
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					messenger.setMessage(chooser.getSelectedFile().getPath(), Messenger.READ);
					try {
						
						dataPanel.call();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		add(getFileBtn);
		
	}
}