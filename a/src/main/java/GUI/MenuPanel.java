package GUI;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class MenuPanel extends JPanel{
	private Callable<DataPanel> fun;
	public MenuPanel(int width, int height, Callable<DataPanel> fun, Messenger messenger) {
		this.fun = fun;
		setPreferredSize(new Dimension(width, height));
		FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);
		setLayout(layout);
		JButton getFileBtn = new JButton("Wybierz plik");
		getFileBtn.setPreferredSize(new Dimension(width / 7, height / 3));
		getFileBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int returnValue = chooser.showOpenDialog(null);
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					messenger.setMessage(chooser.getSelectedFile().getPath());
					try {
						
						fun.call();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				// TODO Auto-generated method stub
				
			}
		});
		add(getFileBtn);
		
		//chooser.setCurrentDirectory(new java.io.File("."));
	}
}
