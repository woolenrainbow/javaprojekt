package a.a;

import java.math.BigDecimal;

import dataStorage.DataStorage;
import junit.framework.TestCase;

public class TestDataStorage  extends TestCase {
	private DataStorage datas = new DataStorage();
	private String s = " 1 \n3";
	private BigDecimal ans1 = new BigDecimal("1");
	private BigDecimal ans2 = new BigDecimal("3");
	
	protected void setUp() {
		datas.setData(s);
	}
	
	public void test_DS() {
		assertTrue(datas.getData().get(0).equals(ans1) && datas.getData().get(1).equals(ans2));
	}
}