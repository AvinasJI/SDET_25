package practice;

import static org.testng.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericutility.BaseAnnotationClass;
import com.crm.comcast.objectrepositoryUtility.HomePage;

@Listeners(com.crm.comcast.genericutility.ListImpClass.class)
public class ValidationSmmpleCode2  extends BaseAnnotationClass{
	@Test
	public void createCoantctTest() {
		
       HomePage hp = new HomePage(driver);
       hp.getContactLink().click();
       
       Assert.assertEquals(false, true);
      
      
	}	

}




