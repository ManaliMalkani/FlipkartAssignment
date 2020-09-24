package pageObjects;

import java.io.IOException;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartHomePage {
	
	public WebDriver driver;
	
	
	private By cancel= By.xpath("//button[@class='_2AkmmA _29YdH8']");
	private By Searchbox=By.xpath("//input[@title='Search for products, brands and more']");
	private By SearchButton=By.xpath("//*[@type='submit']");
	private By PriceLowtoHigh =By.xpath("//*[text()='Price -- Low to High']");
	private By AvailabilityDropdown=By.xpath("//*[text()='Availability']");
	private By ExcludeOutOfStock=By.xpath("//*[text()='Exclude Out of Stock']/..//*[@class='_1p7h2j']");
	private By ListOfProducts=By.xpath("//div[@class='_3wU53n']"); 
	private By list_of_products_price=By.xpath("//div[@class='_1vC4OE _2rQ-NK']");
	private By list_of_products_ratings=By.xpath("//span[contains(text() ,'Ratings')]");


public FlipkartHomePage(WebDriver driver)
{
	this.driver=driver;
}
public WebElement CancelLink()
{
	return driver.findElement(cancel);
	
}

public WebElement Searchbox()
{
	return driver.findElement(Searchbox);
	
}
public WebElement SearchButton()
{
	return driver.findElement(SearchButton);
	
}


public WebElement PriceLowtoHigh()
{
	return driver.findElement(PriceLowtoHigh);
	
}
public WebElement AvailabilityDropdown()
{
	return driver.findElement(AvailabilityDropdown);
	
}
public WebElement ExcludeOutOfStock()
{
	return driver.findElement(ExcludeOutOfStock);
	
}
public List<WebElement> ListOfProducts()
{
	WebDriverWait wait = new WebDriverWait(driver,30);
	List<WebElement> listProducts=driver.findElements(ListOfProducts);
	listProducts= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ListOfProducts));
	return listProducts;
	
}
public List<WebElement> list_of_products_price()
{
	WebDriverWait wait = new WebDriverWait(driver,30);
	List<WebElement> listProductsprice=driver.findElements(list_of_products_price);
	listProductsprice= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(list_of_products_price));
	return listProductsprice;
	
}
public List<WebElement> list_of_products_ratings()
{
	return driver.findElements(list_of_products_ratings);
	
}

}


