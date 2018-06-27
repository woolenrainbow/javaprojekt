package a.a;

import java.nio.file.Path;
import java.nio.file.Paths;

import FileReader.FileReader;
import dataStorage.DataStorage;
import junit.framework.TestCase;

public class TestFileReader extends TestCase {
	private DataStorage dataS = null;
	private FileReader fileR = null;
	private Path path = null;
	
	protected void setUp() {
		dataS = new DataStorage();
		path = Paths.get("przykladowe dane.txt");
		fileR = new FileReader(path, dataS);
		fileR.get();
	}
	
	public void test_FileReader() {
		assertFalse(dataS.getData().size() == 0);
	}
}
