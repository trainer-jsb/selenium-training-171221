package training.testng.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderLayer {
	
	@DataProvider(name = "data-provider-1")
	public static Object[][] firstDataProvider(){
		return new Object[][] {
			{"Aditya"},
			{"Alisha"},
			{"Ashish"},
			{"lalit"},
			{"Lavina"}
		};
	}
	
	@DataProvider(name = "data-provider-2")
	public static Object[][] secondDataProvider(){
		return new Object[][] {
			{1,2,3},
			{3,4,7},
			{5,6,11},
			{7,8,15}
		};
	}

}
