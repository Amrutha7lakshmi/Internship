package pages;
 
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
	
	WebDriver driver;
	
	public SignUpPage(WebDriver drv)
	{
		this.driver=drv;
	}
	//Method to check valid signup of the user
	public void signUp()
	{
		WebElement symbol=driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/img"));
		symbol.isDisplayed();
		symbol.click();
		driver.findElement(By.xpath("//div[@id='root']/div/form/div[2]/p[2]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Jamesss");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("jameess1@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("jameeess@1234");
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CONTACT'])[2]/following::button[1]")).click();
		
	}
	
	public String UserDashboard() {
		WebElement dashboard=driver.findElement(By.xpath("//p[text()='HOME']"));
		String dash=dashboard.getText();
		return dash;
		
	}
	
	public void logout()
	{
		WebElement collectionText = driver.findElement(By.xpath("//div[@id='root']/div/div/ul/a[2]/p"));
		collectionText.click();
		driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/img")).click();
//		driver.findElement(By.xpath("//p[(text() = 'Logout' or . = 'Logout')]")).click();
	}
	
	
	
	//Method to check invalid signup
	public String invalidSignup()
	{
		WebElement symbol=driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/img"));
		symbol.isDisplayed();
		symbol.click();
		driver.findElement(By.xpath("//div[@id='root']/div/form/div[2]/p[2]")).click();
		WebElement name=driver.findElement(By.xpath("//input[@placeholder='Name']"));
		name.sendKeys("");
		WebElement email=driver.findElement(By.xpath("//input[@placeholder='Email']"));
		email.sendKeys("lakshmi@gmail.com");
		WebElement psswd=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		psswd.sendKeys("lakshmi@123");
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CONTACT'])[2]/following::button[1]")).click();
		
		 // Capture the validation message
        @SuppressWarnings("deprecation")
		String validationMessage = name.getAttribute("validationMessage");
        //System.out.println("Validation Message: " + validationMessage);
        return validationMessage;
        
	}
	//Method to check email without @ symbol
	public String emailValidation()
	{
		//driver.findElement(By.xpath("//p[normalize-space()='Create account']")).click();
		WebElement name_field=driver.findElement(By.xpath("//input[@placeholder='Name']"));
		name_field.clear();
		name_field.sendKeys("Lakshmi");
		WebElement email_field=driver.findElement(By.xpath("//input[@placeholder='Email']"));
		email_field.clear();
		email_field.sendKeys("lakshmigmail.com");
		WebElement pswd_field=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		pswd_field.clear();
		pswd_field.sendKeys("lakshmi@123");
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CONTACT'])[2]/following::button[1]")).click();
		
		 // Use JavaScript to get the validation message
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", email_field);
        return validationMessage;     
	}
	
	//Method to check valid login with credentials
	public void login(String email, String password)
	{
//		WebElement log=driver.findElement(By.xpath("//p[text()='Login Here']"));
//        log.click(); 
		WebElement em= driver.findElement(By.xpath("//input[@placeholder='Email']"));
		em.clear();
		em.sendKeys(email);
		WebElement ps= driver.findElement(By.xpath("//input[@placeholder='Password']"));
		ps.clear();
		ps.sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	}
	
	//Method to check the login with invalid email
	public void invalidLoginEmail()
	{
//		WebElement symbol=driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/img"));
//		symbol.isDisplayed();
//		symbol.click();
		WebElement log=driver.findElement(By.xpath("//p[text()='Login Here']"));
        log.click(); 
		WebElement mail=driver.findElement(By.xpath("//input[@placeholder='Email']"));
		mail.clear();
		mail.sendKeys("sunitha@gmail");
		WebElement pass=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		pass.clear();
		pass.sendKeys("sunitha@123");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		WebElement toastMessage = driver.findElement(By.xpath("//div[contains(@class, 'Toastify__toast') and contains(text(), \"User doesn't exists\")]"));
		System.out.println("Toast Message: " + toastMessage.getText());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("Toastify__toast-container")));

	}
}
