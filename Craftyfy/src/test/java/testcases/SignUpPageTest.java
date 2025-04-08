package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.SignUpPage;
import utilities.AutomationConstants;

public class SignUpPageTest extends TestBase{
	
	SignUpPage obj;
	
	@BeforeClass
	public void bfTest()
	{
		obj=new SignUpPage(driver);
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

}
