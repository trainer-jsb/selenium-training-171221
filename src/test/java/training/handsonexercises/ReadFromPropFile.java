package training.handsonexercises;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import utilities.Helper;

public class ReadFromPropFile {
	
	@Test (priority = 1)
	public void readFromPropFileTest() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src/test/resources/base.prop");
		prop.load(fis);
		System.out.println(prop.getProperty("timeout"));
	}
	
	@Test (priority =  2)
	public void readrFromPropFileInHelperClass() {
		Helper helper = new Helper();
		String timeout = helper.readFromPropFileTest("src/test/resources/baase.prop", "timeout");
		System.out.println(timeout);
	}
}