package training.handsonexercises;

import org.testng.annotations.Test;

import utilities.Helper;

public class ReadFromExcel {
	
	@Test
	public void readFromExcelTest() {
		Helper helper = new Helper();
		String fPath = "src/test/resources/TestExcel.xls";
		String cellValue = helper.readFromExcel(fPath, "Sheet1", 2, 3);
		System.out.println(cellValue);
	}
}