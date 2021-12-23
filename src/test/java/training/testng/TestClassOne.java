package training.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestClassOne {
  @Test (priority =  1, groups = {"Regression"})
  public void testOne() {
	  System.out.println("This is testOne of TestClassOne");
  }
  
  @Test (priority =  2, groups = {"Regression", "Smoke"})
  public void testTwo() {
	  System.out.println("This is testTwo of TestClassOne");
  }
  
  @Test (priority = 3, groups = {"Smoke"})
  public void testThird() {
	  System.out.println("This is testThird of TestClassOne");
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is beforeClass of TestClassOne");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is afterClass of TestClassOne");
  }
}
