package dataStorage;
import java.math.BigDecimal;
import java.util.ArrayList;

public class DataStorage {
	private ArrayList<BigDecimal> data = new ArrayList<BigDecimal>();
	public DataStorage()
	{
		
	}
	public void setData(String data) {
		//pociąć string tam gdzie są spacje tabulatory entery oraz aby nie było błedow powrot karetki czyli \r,
		// czyli tniesz string dla " ", "\t", "\n", "\r", i bierzesz fragmenty
		//do cięcia split() np. dla spacji nazwa_stringu.split(" ")
		//pozniej ladujesz dane do data jako this.data.add(new BigDecimal(string__zliczba));
		//teraz je sortujesz
		//aktualnie program nic nie moze wyswietlic bo przerabiamy rzeczy i wyswietlanie jeszcze nie dziala :)
		//POWODZENIA!!!
	}
	public ArrayList<BigDecimal> getData()
	{
		return data;
	}
}
