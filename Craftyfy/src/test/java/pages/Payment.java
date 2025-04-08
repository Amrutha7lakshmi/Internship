package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Payment {
	
WebDriver driver;
	
	public Payment(WebDriver drv)
	{
		this.driver=drv;
	}
	
	public void viewAddtoCart()
	{
		WebElement cartsymb = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='HOME'])[2]/preceding::p[2]"));
		cartsymb.click();
		WebElement image2 = driver.findElement(By.xpath("//p[text()='Long Chain']"));
		image2.isDisplayed();
	}
	
	    public void testQuantityUpdate() throws InterruptedException {
	        // Locate quantity input box
	        WebElement quantityBox = driver.findElement(By.xpath("//input[@type='number']"));
	        int initialQuantity = Integer.parseInt(quantityBox.getAttribute("value"));

	        // Increase quantity
	        quantityBox.clear();
	        quantityBox.sendKeys(String.valueOf(initialQuantity + 1));
	        Thread.sleep(2000);  // Wait for subtotal update

	        // Verify subtotal update
	        WebElement subtotalElement = driver.findElement(By.xpath("//p[contains(text(),'Subtotal')]/following-sibling::p"));
	        double expectedSubtotal = (initialQuantity + 1) * 34; // Since price is $34
	        Assert.assertEquals(Double.parseDouble(subtotalElement.getText().replace("$", "")), expectedSubtotal, "Subtotal did not update correctly!");

	        System.out.println("Quantity update test passed ✅");
	    }
	    
	    public String payment(String fname, String lname, String email, String street, String city, String state, String zipcode, String country, String phone)
	    {
	    	WebElement pay=driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));
	    	pay.click();
	    	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fname);
	    	driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lname);
	    	driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
	    	driver.findElement(By.xpath("//input[@name='street']")).sendKeys(street);
	    	driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
	    	driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
	    	driver.findElement(By.xpath("//input[@name='zipcode']")).sendKeys(zipcode);
	    	driver.findElement(By.xpath("//input[@name='country']")).sendKeys(country);
	    	driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);
	    	driver.findElement(By.xpath("//p[text()='CASH ON DELIVERY']")).click();
	    	driver.findElement(By.xpath("//button[@type='submit']")).click();
	    	WebElement order=driver.findElement(By.xpath("//p[text()='Order Placed']"));
	    	String ord=order.getText();
	    	return ord;
	    }

}
