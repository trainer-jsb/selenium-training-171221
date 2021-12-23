package utilities;

import java.io.FileInputStream;
import java.util.Properties;
import org.testng.Assert;

public class DataProvider {

	public static String readTestData(String propFile, String propNane) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail("FAIL | Check prop file for location, filename and key correctness.");
		}
		return prop.getProperty(propNane);
	}
}