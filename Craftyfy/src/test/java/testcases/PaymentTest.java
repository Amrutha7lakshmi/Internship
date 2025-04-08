package testcases;

import org.testng.Assert; 
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Collection;
import pages.Payment;
import pages.SignUpPage;
import utilities.AutomationConstants;

public class PaymentTest extends TestBase{
	
	SignUpPage obj;
	Collection aObj;
	Payment pObj;
		
		@BeforeClass
		public void bfTest()
		{
			obj=new SignUpPage(driver);
	
			aObj=new Collection(driver);
			pObj=new Payment(driver);
		}
		
		@Test(priority=1)
		public void validSignUp()
		{
			obj.signUp();
			String actResult1=obj.UserDashboard();
			Assert.assertEquals(actResult1, AutomationConstants.usdash);
			obj.logout();
			
		}
		@Test(priority=2)
		public void invalidSignUp()
		{
			String actResult2=obj.invalidSignup();
			Assert.assertEquals(actResult2, AutomationConstants.errMssg1);
			String actResult3=obj.emailValidation();
			Assert.assertEquals(actResult3, AutomationConstants.errMssg2);
		}
		
		@Test(priority=3)
		public void logTest()
		{
			obj.invalidLoginEmail();
			obj.login("anna@gmail.com","Anna@123");
		}

		
		@Test(priority=4)
		public void payTest() throws InterruptedException
		{
			//aObj.login("anna@gmail.com", "Anna@123");
			aObj.filterCategories();
			aObj.addtoCart();
			pObj.viewAddtoCart();
			pObj.testQuantityUpdate();
			String actResult5=pObj.payment("Anna","Thomas","anna@gmail.com","pala","Kottayam","Kerala","633447","India","9944264948");
			Assert.assertEquals(actResult5, AutomationConstants.ordermssg);
			obj.logout();
		}
		

}
