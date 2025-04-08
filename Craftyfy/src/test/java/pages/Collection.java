package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Collection {
	
	WebDriver driver;
	
	public Collection(WebDriver drv)
	{
		this.driver=drv;
	}
	
	//Method to check the search bar is working properly
	public void searchBar()
	{
		WebElement search=driver.findElement(By.xpath("//img[contains(@class, 'cursor-pointer')]"));
		search.isDisplayed();
		search.click();
		WebElement search_bar=driver.findElement(By.xpath("//input[@placeholder='Search']"));
		search_bar.click();
		search_bar.sendKeys("Art Book");
		WebElement image = driver.findElement(By.xpath("//img[contains(@src,'qpyxjb4hptlr1idzitap.webp')]"));
		image.isDisplayed();
		search_bar.clear();

	}
	
	//Method to check the filter options are working properly or not
	public void filterCategories()
	{
		WebElement search1=driver.findElement(By.xpath("//img[contains(@class,'w-5')]"));
		search1.click();
		WebElement cross = driver.findElement(By.xpath("//img[contains(@class,'inline w-3 cursor-pointer')]"));
		cross.click();
		WebElement jewel=driver.findElement(By.xpath("//input[@value='Jewellery']"));
		jewel.click();
		WebElement image1 = driver.findElement(By.xpath("//p[text()='Long Chain']"));
		image1.isDisplayed();

	}

	//Method to add products to the cart
	public void addtoCart()
	{
		WebElement collectionText = driver.findElement(By.xpath("//p[text()='COLLECTION']"));
		collectionText.click();
		WebElement imageElement = driver.findElement(By.xpath("//p[text()='Long Chain']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", imageElement);
		WebElement button = driver.findElement(By.xpath("//button[text()='Red']"));
		button.click();
		WebElement addToCartButton = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
		addToCartButton.click();

	}
	
	

}
