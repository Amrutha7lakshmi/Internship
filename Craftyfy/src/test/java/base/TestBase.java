package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class TestBase {
	
	protected WebDriver driver;
	
	@BeforeTest
	public void bfClass()
	{
		driver=new ChromeDriver();
		driver.get("https://craftyfy-frontend.vercel.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}	
	@AfterTest
	public void driverQuit() {
		driver.quit();
	}	
}
