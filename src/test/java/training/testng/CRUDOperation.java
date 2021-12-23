package training.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CRUDOperation {
	
	@BeforeClass
	public void setup() {
		System.out.println("This is before class");
	}
	
	@Test (priority = 4, timeOut = 5000)
	public void searchTest() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("This is the search test method");
	}
	
	@Test (priority = 1)
	public void createEntity() {
		System.out.println("This is the create method");
	}
	
	@Test (priority = 2, dependsOnMethods = "createEntity")
	public void updateEntity() {
		System.out.println("This is the update method");
	}
	
	@Test (priority = 3, dependsOnMethods = "createEntity")
	public void deleteEntity() {
		System.out.println("This is the delete method");
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("This is after class");
	}

}
