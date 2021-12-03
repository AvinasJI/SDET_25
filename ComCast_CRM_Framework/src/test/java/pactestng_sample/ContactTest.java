package pactestng_sample;

import org.testng.annotations.Test;

public class ContactTest {

 @Test(invocationCount = 10)
  public void createContactTest() {
	  System.out.println("execute   create hdfc ContactTest");
  }

 
}
