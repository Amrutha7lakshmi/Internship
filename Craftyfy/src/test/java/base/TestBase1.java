package base;

import java.io.FileReader; 
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

//import utilities.Screenshot;


public class TestBase1 {
    
    protected WebDriver driver;
    Properties prop;
    
    public void setUp() throws IOException {
        FileReader Obj = new FileReader("E:\\internship\\Craftyfy\\src\\test\\resources\\config.properties");
        prop = new Properties();
        prop.load(Obj);
    }

    @BeforeTest
    public void firstMet() throws IOException {
        setUp();
        
        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

////   @AfterMethod
//    public void tearDown(ITestResult result) {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            Screenshot.captureScreenshot(driver, result.getName());
//        }
//      
//    }
    
    @AfterTest
    public void driverQuit() {
        driver.quit();
    }

}
