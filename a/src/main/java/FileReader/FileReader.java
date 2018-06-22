package FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.ArrayList;

import dataStorage.DataStorage;

public class FileReader {
	private static int len = 512;
	private ArrayList<ArrayList<BigDecimal>> data = null;
	private ByteBuffer buffer = null;
	private FileChannel fc = null;
	private DataStorage dataStorage = null;
	public FileReader(Path path, DataStorage dataStorage) {
		this.dataStorage = dataStorage;
		data = new ArrayList<ArrayList<BigDecimal>>();
		data.add(new ArrayList<BigDecimal>());		
		try {
			fc = FileChannel.open(path);
		} catch (IOException e1) {
			System.out.println("Błąd przy otwieraniu pliku!");
		}
		buffer = ByteBuffer.allocate(len);
	}
	public void get() {
		StringBuilder sbuilder = new StringBuilder();
		while(true) {
			buffer.clear();
			int i = 0;
			try {
				i = fc.read(buffer);
			} catch (IOException e) {
				System.out.println("Błąd odczytu z pliku!");
			}
			if(i == -1)
				break;
			byte[] byteArray = buffer.array();
			if(i == len) {
				sbuilder.append(new String(byteArray));
			} else {
				sbuilder.append((new String(byteArray)).substring(0, i));
			}
		}
		try {
			fc.close();
		} catch (IOException e) {
			System.out.println("Błąd zamykania pliku!");
		}
		dataStorage.setData(sbuilder.toString());
		/*String [] rows = sbuilder.toString().split("\\s");
		int currentNumber = 0;
		for(String r : rows) {
			r = r.split("\r")[0];
			String [] numbers = r.split(" ");
			for(String n: numbers) {
				data.get(currentNumber).add(new BigDecimal(n));
			}
			data.add(new ArrayList<BigDecimal>());
			currentNumber++;
		}*/
		/*for(ArrayList<BigDecimal> i: data) {
			for(BigDecimal j : i) {
				System.out.print(j.toString() + " ");
			}
			System.out.print("\n");
		}*/
		//return data;
	}
	
}
