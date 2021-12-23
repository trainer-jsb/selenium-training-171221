package training.testng;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {
	
	@Parameters({"browser"})
	@Test
	public void firstTest( @Optional("chrome") String browser) {
		System.out.println("Parameter passed is " +browser);
	}

}
