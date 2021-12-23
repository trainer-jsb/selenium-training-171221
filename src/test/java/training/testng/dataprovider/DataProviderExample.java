package training.testng.dataprovider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	
	@DataProvider(name = "data-provider-1")
	public Object[][] firstDataProvider(){
		return new Object[][] {
			{"Aditya"},
			{"Alisha"},
			{"Ashish"},
			{"lalit"},
			{"Lavina"}
		};
	}
	
	@Test(dataProvider = "data-provider-1")
	public void firstDataProviderTest(String strInput) {
		System.out.println("Members in training are " +strInput);
	}
	
	@DataProvider(name = "data-provider-2")
	public Object[][] secondDataProvider(){
		return new Object[][] {
			{1,2,3},
			{3,4,6},
			{5,6,11},
			{7,8,15}
		};
	}
	
	@Test(dataProvider = "data-provider-2")
	public void secondDataProvderTest(int num1, int num2, int num3) {
		int sum = num1 + num2;
		Assert.assertEquals(sum, num3);
	}

}
