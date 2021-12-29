package com.crm.comcast.organaizationtest;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.annotations.BaseAnnotation;

import com.crm.comcast.genericutility.BaseAnnotationClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.JavaUtlity;
import com.crm.comcast.genericutility.WebDriverUtility;
import com.crm.comcast.objectrepositoryUtility.CreateOrganizationPage;
import com.crm.comcast.objectrepositoryUtility.HomePage;
import com.crm.comcast.objectrepositoryUtility.Login;
import com.crm.comcast.objectrepositoryUtility.OrganizationInfoPage;
import com.crm.comcast.objectrepositoryUtility.OrganizationPage;



/**
 * 
 * @author Deepak
 *
 */
public class CreateOrganizationTest extends BaseAnnotationClass{
	@Test(groups = {"smokeTest"})
	public void createOrganizationTest() throws Throwable {

		/* get ramDomData */
		int randomNum = jLib.getRandomNumber();
		 /* read test data from Excel File*/
		    String orgName = eLib.getDataFromExcel("org", 1, 2) + randomNum;
         /* step 2 :  navigate to Org Page*/ 
              HomePage hp = new HomePage(driver);
              hp.getOrganizationLink().click();             
         /* step 3 : navigate to create Org page */  
              OrganizationPage op = new OrganizationPage(driver);
              op.getCreateOrganizationIMG().click();
         /* step 3 : create a new Org */   
              CreateOrganizationPage cop = new CreateOrganizationPage(driver);
              cop.createOrganization(orgName);
         /* step 4 : verify */ 
              OrganizationInfoPage oip = new OrganizationInfoPage(driver);
              String orgNameInfoMsg =  oip.getOrganizationInfo().getText();
              boolean status = orgNameInfoMsg.contains(orgName);
              Assert.assertTrue(status);
	}
	@Test(groups = {"regressionTest"})
	public void  createOrganization_With_Industries_And_Type_Test() throws Throwable {
		/* get ramDomData */
		int randomNum = jLib.getRandomNumber();
		 /* read test data from Excel File*/
		    String orgName = eLib.getDataFromExcel("org", 4, 2) + randomNum;
		    String industries = eLib.getDataFromExcel("org", 4, 3);
		    String type = eLib.getDataFromExcel("org", 4, 4);
    /* step 2 :  navigate to Org Page*/ 
         HomePage hp = new HomePage(driver);
         hp.getOrganizationLink().click();             
    /* step 3 : navigate to create Org page */  
         OrganizationPage op = new OrganizationPage(driver);
         op.getCreateOrganizationIMG().click();
    /* step 3 : create a new Org  with indutries & type*/   
         CreateOrganizationPage cop = new CreateOrganizationPage(driver);
         cop.createOrganization(orgName, industries, type);
         
    /* step 4 : verify */ 
         OrganizationInfoPage oip = new OrganizationInfoPage(driver);
         String orgNameInfoMsg =  oip.getOrganizationInfo().getText();
         boolean status = orgNameInfoMsg.contains(orgName);
         Assert.assertTrue(status);
         
      SoftAssert soft = new SoftAssert();
        String actIndustriesinfo =  oip.getIndustriesInfo().getText();
        soft.assertEquals(actIndustriesinfo, industries, "indusries is not verified==FAIL");
        
        String actTypeinfo =  oip.getTypeInfo().getText();
        soft.assertEquals(actTypeinfo, type , " org type  is not verified==FAIL");
       soft.assertAll();
	}

}
