package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TrayIcon.MessageType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import dataStorage.DataStorage;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.CustomBalloonTip;
import net.java.balloontip.styles.EdgedBalloonStyle;
import FileReader.FileReader;

public class DataPanel extends JPanel implements Callable<Void> {
	//ArrayList<ArrayList<BigDecimal>> data = null;
	private JPanel panel = null;
	private Messenger messenger = null;
	private DataStorage dataStorage = null;
	private LabelsCon labels = new LabelsCon();
	private int WIDTH = 0;
	private int HEIGHT = 0;
	public DataPanel(int width, int height, Messenger messenger, DataStorage data) {
		WIDTH = width / 5;
		HEIGHT = height / 30;
		dataStorage = data;
		this.messenger = messenger;
		panel = new JPanel();
		//panel.add(new JLabel("asd"));
		//panel.setBackground(new Color(1));
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(width, height));
		add(scrollPane);
		//panel.add(new JLabel("asd"));
	}
	@Override
	public Void call() throws Exception {
		// TODO Auto-generated method stub
		if(messenger.getCode() == Messenger.READ) {
			Path path = Paths.get(messenger.getMessage());
			FileReader reader = new FileReader(path, dataStorage);
			panel.removeAll();
			panel.revalidate();	
			labels.removeLabels();
			try {
				reader.get();
			}
			catch(Exception e) {
				dataStorage.clear();
				panel.revalidate();	
				JOptionPane.showMessageDialog(this.getParent(), "Błędny format danych w pliku!", "Błąd!", JOptionPane.ERROR_MESSAGE);
				return null;
			}
			ArrayList<BigDecimal> my_Array = dataStorage.getData();
			//ArrayList my_Array = new ArrayList();
			//for(int i = 0; i<1203; i++)
			//	 my_Array.add(i);
			//int w = this.panel.getWidth();	
			int asize = my_Array.size();
			panel.setLayout(new GridLayout(Math.floorDiv(asize, 5) + 1, 5, 50, 0));		
			for (int i = 0; i < asize; i++)
			{
				JLabel label = new JLabel(my_Array.get(i).toString());
				label.setPreferredSize(new Dimension(WIDTH, HEIGHT));
				label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				label.setHorizontalAlignment(SwingConstants.RIGHT);
				BalloonTip balloon = new BalloonTip(label,my_Array.get(i).toString(), new EdgedBalloonStyle(Color.WHITE, Color.BLUE), false);
				balloon.setVisible(false);
				label.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
					       balloon.setVisible(true);
					    }
				});
				label.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseExited(MouseEvent e) {
					       balloon.setVisible(false);
					    }
				});
				label.setPreferredSize(new Dimension(40,20));
				panel.add(label);
				labels.addLabel(label);
			}
			/*System.out.println(panel.toString());
			if(data.size() > 0 &&  data.get(0).size() > 0) {
				panel.setLayout(new GridLayout(data.size(), data.get(0).size()));
				for(ArrayList<BigDecimal> i : data) {
					for(BigDecimal j : i) {
						JLabel label = new JLabel(j.toString());
						label.setPreferredSize(new Dimension(40,20));
						panel.add(label);
					}
				}
			} else {
				;
			}*/
			panel.revalidate();	
		} else if(messenger.getCode() == Messenger.FIND) {
			try {
				searchdata(new BigDecimal(messenger.getMessage().split(" ")[0]), new BigDecimal(messenger.getMessage().split(" ")[1]));
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(this.getParent(), "Błędny format danych!", "Błąd!", JOptionPane.ERROR_MESSAGE);
			}
		
		}
		return null;
	}
	public void searchdata(BigDecimal a, BigDecimal b) {
		for(LabelsIterator iter = this.labels.getLabel(); iter.hasnext();) {
			JLabel curr_label = iter.next();
			BigDecimal value = new BigDecimal(curr_label.getText());
			curr_label.setOpaque(false);
			//curr_label.setBackground(Color.lightGray);
			if (value.compareTo(a) != -1 && value.compareTo(b) != 1) {
				curr_label.setOpaque(true);
				curr_label.setBackground(Color.PINK);
			}
			curr_label.repaint();
		}
	}
}
