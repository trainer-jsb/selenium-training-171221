package training.testng.dataprovider;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderLayerInheritence {

	@Test(dataProvider = "data-provider-1", dataProviderClass = DataProviderLayer.class)
	public void firstDataProviderTest(String strInput) {
		System.out.println("Members in training are " +strInput);
	}
	
	
	@Test(dataProvider = "data-provider-2", dataProviderClass = DataProviderLayer.class)
	public void secondDataProvderTest(int num1, int num2, int num3) {
		int sum = num1 + num2;
		Assert.assertEquals(sum, num3);
	}

}
