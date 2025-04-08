package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddProduct {
	
	WebDriver driver;
	WebDriverWait wait;
    // Constructor to initialize the WebDriver.

        // Constructor to initialize the WebDriver.
        public AddProduct(WebDriver drv) {
            this.driver = drv;
        }

        // Method to perform admin login operation.
        public void login_Bttn1(String email, String password) {
            driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email); // enter Email
            driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password); // Enter password
            driver.findElement(By.xpath("//button[@type='submit']")).click(); // click submit

           
        }
     // Method to perform add item  operation.
        public void addItem1(String path,String product, String productDetails) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Click on "Add Items"
            WebElement addItemsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Add Items']")));
            addItemsButton.click();

            // Locate the hidden file input and make it visible
            WebElement fileInput = driver.findElement(By.xpath("//input[@id='image1']"));
            js.executeScript("arguments[0].removeAttribute('hidden');", fileInput);
            
            // Upload the file
            fileInput.sendKeys(path);

            // Enter Product Name
            WebElement productNameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Type here']")));
            productNameField.sendKeys(product);

            // Enter Product Description
            WebElement productDescriptionField = driver.findElement(By.xpath("//textarea[@placeholder='Write content here']"));
            productDescriptionField.sendKeys(productDetails);

            // Get the dropdowns (since both have the same class, we use indexing)
            List<WebElement> dropdowns = driver.findElements(By.xpath("//select[@class='w-full px-3 py-2']"));

            // Select Product Category
            Select productCategory = new Select(dropdowns.get(0));
            productCategory.selectByVisibleText("Jewellery");

            // Select Subcategory
            Select subCategory = new Select(dropdowns.get(1));
            subCategory.selectByVisibleText("WallHangings");

            // Select Product Color
            WebElement colorOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Yellow']")));
            colorOption.click();

            // Click "Add to Bestseller"
            WebElement bestsellerCheckbox = driver.findElement(By.xpath("//input[@id='bestseller']"));
            js.executeScript("arguments[0].scrollIntoView(true);", bestsellerCheckbox);
            wait.until(ExpectedConditions.elementToBeClickable(bestsellerCheckbox)).click();

            // Click Add Button
            WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            addButton.click();
            
            WebElement signupButton = driver.findElement(By.xpath("//div[@class=\"Toastify__toast Toastify__toast-theme--light Toastify__toast--success\"]"));
            Assert.assertTrue(signupButton.isDisplayed(), "Signup button is not visible!");
        }
        public void listItem1() {
        	driver.findElement(By.xpath("//p[text()='List Items']")).click();
        	boolean isPdtNamePresent = driver.findElements(By.xpath("//p[text()='Jewellery']")).size() > 0;
            
            if (isPdtNamePresent) {
                Assert.assertTrue(isPdtNamePresent, "product is not visible!");
            } else {
                System.out.println("product  is NOT present on the page.");
                Assert.fail("product is missing!");
            }
            
        }
    
    

    // Method to perform admin login operation.
    public void login_Bttn(String email, String password) {
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email); // enter Email
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password); // Enter password
        driver.findElement(By.xpath("//button[@type='submit']")).click(); // click submit

       
    }
 // Method to perform add item  operation.
   
    public void addItem(String path,String product, String productDetails) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Click on "Add Items"
        WebElement addItemsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Add Items']")));
        addItemsButton.click();

        // Locate the hidden file input and make it visible
        WebElement fileInput = driver.findElement(By.xpath("//input[@id='image1']"));
        js.executeScript("arguments[0].removeAttribute('hidden');", fileInput);
        
        // Upload the file
        fileInput.sendKeys(path);

        // Enter Product Name
        WebElement productNameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Type here']")));
        productNameField.sendKeys(product);

        // Enter Product Description
        WebElement productDescriptionField = driver.findElement(By.xpath("//textarea[@placeholder='Write content here']"));
        productDescriptionField.sendKeys(productDetails);

        // Get the dropdowns (since both have the same class, we use indexing)
        List<WebElement> dropdowns = driver.findElements(By.xpath("//select[@class='w-full px-3 py-2']"));

        // Select Product Category
        Select productCategory = new Select(dropdowns.get(0));
        productCategory.selectByVisibleText("Jewellery");

        // Select Subcategory
        Select subCategory = new Select(dropdowns.get(1));
        subCategory.selectByVisibleText("WallHangings");
        //product price
        WebElement price=driver.findElement(By.xpath("//input[@type='Number']"));
        price.sendKeys("125");

        // Select Product Color
        WebElement colorOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Yellow']")));
        colorOption.click();

        // Click "Add to Bestseller"
        WebElement bestsellerCheckbox = driver.findElement(By.xpath("//input[@id='bestseller']"));
        js.executeScript("arguments[0].scrollIntoView(true);", bestsellerCheckbox);
        wait.until(ExpectedConditions.elementToBeClickable(bestsellerCheckbox)).click();

        // Click Add Button
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        addButton.click();
        
        WebElement signupButton = driver.findElement(By.xpath("//div[@class=\"Toastify__toast Toastify__toast-theme--light Toastify__toast--success\"]"));
        Assert.assertTrue(signupButton.isDisplayed(), "Signup button is not visible!");
    }
    public void listItem() {
    	driver.findElement(By.xpath("//p[text()='List Items']")).click();
    	boolean isPdtNamePresent = driver.findElements(By.xpath("//p[text()='Jewellery']")).size() > 0;
        
        if (isPdtNamePresent) {
            Assert.assertTrue(isPdtNamePresent, "product is not visible!");
        } else {
            System.out.println("product  is NOT present on the page.");
            Assert.fail("product is missing!");
        }
        
    }
}