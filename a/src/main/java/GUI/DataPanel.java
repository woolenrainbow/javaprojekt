package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dataStorage.DataStorage;
import FileReader.FileReader;

public class DataPanel extends JPanel implements Callable<Void> {
	//ArrayList<ArrayList<BigDecimal>> data = null;
	private JPanel panel = null;
	private Messenger messenger = null;
	private DataStorage dataStorage = null;
	private ArrayList<JLabel> labels = null;
	public DataPanel(int width, int height, Messenger messenger, DataStorage data) {	
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
		Path path = Paths.get(messenger.getMessage());
		FileReader reader = new FileReader(path, dataStorage);
		reader.get();
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
			label.setPreferredSize(new Dimension(40,20));
			panel.add(label);
			labels.add(label);
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
		return null;
	}
	
}
