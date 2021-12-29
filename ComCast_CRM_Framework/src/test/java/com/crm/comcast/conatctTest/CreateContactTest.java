package com.crm.comcast.conatctTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnotationClass;
import com.crm.comcast.objectrepositoryUtility.Contacts;
import com.crm.comcast.objectrepositoryUtility.ContactsInfoPage;
import com.crm.comcast.objectrepositoryUtility.CreateNewConatctPage;
import com.crm.comcast.objectrepositoryUtility.CreateOrganizationPage;
import com.crm.comcast.objectrepositoryUtility.HomePage;
import com.crm.comcast.objectrepositoryUtility.OrganizationInfoPage;
import com.crm.comcast.objectrepositoryUtility.OrganizationPage;



/**
 * 
 * @author Deepak
 *
 */
public class CreateContactTest extends BaseAnnotationClass{

	@Test(groups = {"smokeTest"})
	public void  createContactWithLastNameTest() throws Throwable {
		/* get ramDomData */
		int randomNum = jLib.getRandomNumber();
		 /* read test data from Excel File*/
		    String lastName = eLib.getDataFromExcel("contact", 1, 2) + randomNum;
         /* step 1 : navigate to Contacts Page */ 
         HomePage hp = new HomePage(driver);
         hp.getContactLink().click(); 
         /* step 2 :  navigate to CREATE  Contact Page*/ 
         Contacts cp = new Contacts(driver);
         cp.getCreateNewConatctIMG().click();
         
         /* step 3 : create a new Contact Page */
         CreateNewConatctPage cncp = new CreateNewConatctPage(driver);
         cncp.createNewConatct(lastName);

         /* step 4 : verify */ 
         ContactsInfoPage cip = new ContactsInfoPage(driver);
         String  actContactinfo = cip.getContactSucMsg().getText();
         boolean status =  actContactinfo.contains(lastName);
       	 Assert.assertTrue(status ,"Contact name is not verified==FAIL");
        
	}
	
	
	@Test(groups = {"regressionTest"})
	public void createContact_Support_DateTest() throws Throwable {
		/* get ramDomData */
		int randomNum = jLib.getRandomNumber();
		 
		 /* read test data from Excel File*/
		    String lastName = eLib.getDataFromExcel("contact", 7, 2) + randomNum;
		    String mobileNumber = eLib.getDataFromExcel("contact", 7, 3); 
         /* step 1 : navigate to Contacts Page */ 
         HomePage hp = new HomePage(driver);
         hp.getContactLink().click(); 
         /* step 2 :  navigate to CREATE  Contact Page*/ 
         Contacts cp = new Contacts(driver);
         cp.getCreateNewConatctIMG().click();         
         /* step 3 : create a new Contact Page */
         CreateNewConatctPage cncp = new CreateNewConatctPage(driver);
         cncp.createNewConatct(lastName, mobileNumber, jLib.getDateFormate());

         /* step 4 : verify */ 
         ContactsInfoPage cip = new ContactsInfoPage(driver);
         String  actContactinfo = cip.getContactSucMsg().getText();
         boolean status =  actContactinfo.contains(lastName);
       	 Assert.assertTrue(status ,"Contact name is not verified==FAIL");
        
	}
	
	@Test(groups = {"regressionTest"})
	public void createConatctWithOrgTest() throws Throwable {	
		/* get ramDomData */
		int randomNum = jLib.getRandomNumber();
		 /* read test data from Excel File*/
		    String orgName = eLib.getDataFromExcel("contact", 4, 2) + randomNum;
		    String conactName = eLib.getDataFromExcel("contact", 4, 3) + randomNum;
  
   /* step 2 :  navigate to Org Page*/ 
        HomePage hp = new HomePage(driver);
        hp.getOrganizationLink().click();     
                
   /* step 3 : navigate to create Org page */  
        OrganizationPage op = new OrganizationPage(driver);
        op.getCreateOrganizationIMG();
               
   /* step 3 : create a new Org */   
        CreateOrganizationPage cop = new CreateOrganizationPage(driver);
        cop.createOrganization(orgName);       
   /* step 4 : verify */ 
        OrganizationInfoPage oip = new OrganizationInfoPage(driver);
        wLib.waitForElemnetToBeClickAble(driver, oip.getOrganizationInfo());  
        
         /* step 5 :  navigate to CREATE  Coantct Page*/ 
        hp.getContactLink().click();
  
        /* step 6 :  navigate to CREATE  Contact Page*/ 
        Contacts cp = new Contacts(driver);
        cp.getCreateNewConatctIMG().click();
        
        /* step 7 : create a new Contact Page */
        CreateNewConatctPage cncp = new CreateNewConatctPage(driver);
        cncp.createNewConatct(conactName, orgName);
        
        /* step 8 : verify */ 
        ContactsInfoPage cip = new ContactsInfoPage(driver);
        String  actContactinfo = cip.getContactSucMsg().getText();
       boolean status =  actContactinfo.contains(conactName);
       	 Assert.assertTrue(status ,"Contact name is not verified==FAIL");
        
	}

	

}
