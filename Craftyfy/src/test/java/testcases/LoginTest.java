package testcases;

import org.openqa.selenium.WebDriver; 
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import base.TestBase1;
import pages.AddProduct;
import pages.AdminLoginPage;


public class LoginTest extends TestBase1 {
	AdminLoginPage obj;
	AddProduct login;
	
	@BeforeClass
	public void objInt()
	{
		
		obj=new AdminLoginPage(driver);
		login=new AddProduct(driver);
	}
	
	//Add item
	
	@Test(priority=1)
    public void tc01_login() 
    {
    login.login_Bttn("admin@example.com", "greatstack123");//method for call login

    }
    @Test(priority=2)
    public void tc02_addItem() 
    {
    login.addItem("C:\\Users\\HP\\Pictures\\pics\\download.jpg","Jewellery", "malabar gold and diamonds visvasam atalle ellam!!!");
    }
    @Test(priority=3)
    public void tc03_addpdfexceptImage() 
    {
    login.addItem("C:\\Users\\HP\\Pictures\\pics\\RedCustomisedwomenswalletwalletwithnameGiftingStudio.webp","Jewellery2", "Shawai kazhikku labham needu");
    }
    @Test(priority=4)
    public void tc04_additemWithoutImage() 
    {
    login.addItem("","Jewellery3", "malabar gold and diamonds visvasam atalle ellam!!!");
    }
    @Test(priority=5)
    public void tc05_addWithoutPdtname() 
    {
    login.addItem("C:\\Users\\HP\\Pictures\\pics\\download.jpg","Jewellery3", "malabar gold and diamonds visvasam atalle ellam!!!");
    }
    @Test(priority=6)
    //List item testCases
    public void tc06_listItem() 
    {
    login.listItem();
    }
	
	@Test(priority = 7)
	public void tc07_list()
	{

		obj.list();
		String actresult3=obj.productName();
		String expresult3="Jewellery2Jewellery3";
		System.out.println("1st entry");
		Assert.assertEquals(actresult3, expresult3);
		System.out.println(actresult3);
		
		//new added
		obj.removal();
		
		obj.Alert();
		
	}
	
	@Test(priority = 8)
	public void tc09_orderstatus()
	{
		obj.orderStatus();
		String actresult1=obj.title();
		String expresult1="Order Page";
		Assert.assertEquals(expresult1, actresult1);
		System.out.println(actresult1);
		obj.updateDelivery();
//		obj.logout();
		
	}
	@Test(priority = 9)
	public void tc10_logout()
	{
		obj.logout();
	}
}