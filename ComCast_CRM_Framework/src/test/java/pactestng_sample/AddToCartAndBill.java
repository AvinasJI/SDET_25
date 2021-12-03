package pactestng_sample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddToCartAndBill {

	
	@Test(dataProvider = "")
	public void addToCartAndBillTest(String pName , int qty) {
		
		   System.out.println("execute addTo addToCartAndBill==>"+pName + ",=>"+qty);
		}
		
	
	@DataProvider
	public Object[][] dp_addToCartAndBill() {
		
		Object[][] objArr = new Object[5][2];
		objArr[0][0] = "iphone-10";
		objArr[0][1] = 10;
		
		objArr[1][0] = "nokia";
		objArr[1][1] = 10;
		
		objArr[2][0] = "fasttrack";
		objArr[2][1] = 10;
		
		objArr[3][0] = "books";
		objArr[3][1] = 10;
		
		objArr[4][0] = "iwatch";
		objArr[4][1] = 20;
		return objArr;
		
	}
	
	
	
	
}
