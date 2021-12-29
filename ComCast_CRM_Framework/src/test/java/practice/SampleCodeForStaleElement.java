package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.objectrepositoryUtility.Login;


public class SampleCodeForStaleElement {

	public static void main(String[] args) throws Throwable {

		String username = "admin";
		String password  = "manager";
		
		WebDriver driver = new FirefoxDriver();
		         driver.get("http://localhost:8888");
		         
		         driver.findElement(By.name("user_name")).sendKeys(username);
		         driver.findElement(By.name("user_password")).sendKeys(password);
		         driver.findElement(By.id("submitButton")).click();
	
	       

	}

}
