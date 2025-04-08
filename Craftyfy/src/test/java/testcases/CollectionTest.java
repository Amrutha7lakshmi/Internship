package testcases;

import org.testng.annotations.BeforeClass; 
import org.testng.annotations.Test;

import base.TestBase;
import pages.Collection;
//import pages.LoginPage;
import pages.SignUpPage;

public class CollectionTest extends TestBase{

	SignUpPage obj;
//LoginPage lObj;
Collection aObj;
	
	@BeforeClass
	public void bfTest()
	{
		obj=new SignUpPage(driver);
		aObj=new Collection(driver);
	}
	
	@Test(priority=1)
	public void cartTest()
	{
		obj.login("sunitha@gmail.com", "sunitha@123");
	}
	
	@Test(priority=2)
	public void cartTest1()
	{
		aObj.searchBar();
		aObj.filterCategories();
		aObj.addtoCart();
		
	}
	
}
