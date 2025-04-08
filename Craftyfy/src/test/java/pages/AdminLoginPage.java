package pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AdminLoginPage {
	WebDriver driver;
	 
	public AdminLoginPage(WebDriver drv)
	{
		this.driver=drv;
	}
	public void setEmail()//for user name
	{
		WebElement email=driver.findElement(By.xpath("//input[@placeholder='your@email.com']"));
		email.sendKeys("admin@example.com");
	}
	public void setPassword()// for password
	{
		WebElement pass=driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys("greatstack123");
	}
	public void setLogin()// click login
	{
		WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
	}
	
	public void list()//to get list of items
	{
		
		WebElement List=driver.findElement(By.xpath("//p[text()='List Items']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		List.click();

	
	}
	public String productName()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement name=driver.findElement(By.xpath("//p[text()='Jewellery2Jewellery3']"));
		String actresult=name.getText();
		return actresult;

	}
	public void removal()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement delt=driver.findElement(By.xpath("//p[text()='X']"));
		WebElement delt=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='X']")));
		delt.click();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	public void Alert()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

//		// Step 1: Perform the action that removes the product (e.g., clicking the remove button)
//		WebElement removeButton = driver.findElement(By.xpath("//button[text()='Product Removed']"));
//		removeButton.click();

		// Step 2: Wait for the "Product Removed" toast message to appear
		WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//div[text()='Product Removed']")
		));

		// Step 3: Get the text of the toast message
		String actresult = alert.getText();

		// Optional: Verify the result if needed
		String expresult = "Product Removed";
		Assert.assertEquals(actresult, expresult);

		// Print the result to the console
		System.out.println(actresult);
	}
	public void orderStatus()//to change the order status
	{
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		   WebElement order=driver.findElement(By.xpath("//p[text()='Orders']"));
		   order.click();
	}
	public String title()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement heading=driver.findElement(By.xpath("//h3[text()='Order Page']"));
		String actresult=heading.getText();
	    return actresult;
    }
	public void updateDelivery()
	{
		List<WebElement> dropdowns = driver.findElements(By.xpath("//select[@class='p-2 font-semibold']"));

	     // Select Product Category
	      Select productCategory = new Select(dropdowns.get(1));
	     productCategory.selectByVisibleText("Delivered");

	}
	public void logout()
	{
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the logout button to be clickable
		WebElement logoutButton = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Logout']")));

		// Use JavaScript to click the button
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", logoutButton);

		//driver.findElement(By.xpath("//button[text()='Logout']")).click();
		
	}
	   
}
