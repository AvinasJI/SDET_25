package practice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnotationClass;

public class ValidationSmmpleCode extends BaseAnnotationClass{
	@Test
	public void verifyHomePageTest() {
		String expectedTitle = "Administrator - Home".trim();
		String actPageTitle = driver.getTitle().trim();
		
		Assert.assertEquals(actPageTitle, expectedTitle,"home page is not verified==FAIL");
		System.out.println("Home page is verified ==PASS");
	}	
	@Test
	public void verifyLogoTest() {
		 boolean actImgStatus =  driver.findElement(By.xpath("//img[@alt='vtiger-crm-logo.gif']")).isDisplayed();
		Assert.assertEquals(actImgStatus, true);
	}
}




