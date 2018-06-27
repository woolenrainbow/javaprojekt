package dataStorage;
import java.math.BigDecimal;
import java.util.*;

import javax.swing.JOptionPane;

public class DataStorage {
	private ArrayList<BigDecimal> data = new ArrayList<BigDecimal>();
	public DataStorage()
	{
		
	}
	public void setData(String data) {
		this.data.clear();
		String[] tokens = data.trim().split("\\s+");
		
		for (String i: tokens)
		{
			this.data.add(new BigDecimal(i));
		}
		
		Collections.sort(this.data);
	}
	
	public ArrayList<BigDecimal> getData()
	{
		return data;
	}
	
	public void clear() {
		data.clear();
	}
}
