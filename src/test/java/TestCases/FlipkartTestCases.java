package TestCases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.CSVWriter;

import pageObjects.FlipkartHomePage;
import resources.base;
import resources.utils;

public class FlipkartTestCases extends base {

	public static WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());;
	FlipkartHomePage fk;

	/*
	 * @BeforeTest public void initialize() throws IOException {
	 * driver=initializeDriver(); log.info("Driver is initialized");
	 * driver.get(prop.getProperty("url"));
	 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	 * driver.manage().window().maximize();
	 * 
	 * }
	 */
	@Test
	public void TC01CalclateTheSumofTotalCasesOfAllStates() throws IOException, InterruptedException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		fk = new FlipkartHomePage(driver);
		fk.CancelLink().click();
		fk.Searchbox().sendKeys("apple iphone");
		fk.SearchButton().click();
		Thread.sleep(5000);
		fk.PriceLowtoHigh().click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Availability']")).click();
		driver.findElement(By.xpath("//*[text()='Exclude Out of Stock']/..//*[@class='_1p7h2j']")).click();
		Thread.sleep(5000);
		List<WebElement> list_of_products = driver.findElements(By.xpath("//div[@class='_3wU53n']"));
		List<WebElement> list_of_products_price = driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
		List<WebElement> list_of_products_ratings = driver
				.findElements(By.xpath("//span[contains(text() ,'Ratings')]"));

		String filePath=System.getProperty("user.dir")+"\\AppleIphone.csv";
		File file = new File(filePath);
		
			
			
			try { 
		        // create FileWriter object with file as parameter 
		        FileWriter outputfile = new FileWriter(file); 
		  
		        // create CSVWriter object filewriter object as parameter 
		        CSVWriter writer = new CSVWriter(outputfile); 
		  
		        // adding header to csv 
		        String[] header = { "DeviceDetails", "Price", "Ratings" }; 
		        writer.writeNext(header); 
		        String[] data = null;
		        for (int i = 0; i < list_of_products.size(); i++) {
					
					String prouctprice=list_of_products_price.get(i).getText();
					String product_pp = prouctprice.replaceAll("[^0-9]", "");
					int product_price =Integer.parseInt(product_pp);//Convert to Integer
		        
			if(product_price<40000)
			{
				//data[0]=list_of_products.get(i).getText();
				//data[1]=product_pp;
				//data[2]=list_of_products_ratings.get(i).getText();
				//writer.writeNext(data); 
		}
		        }
		
			 // closing writer connection 
	        writer.close(); 
		}
	        catch (IOException e) { 
		        // TODO Auto-generated catch block 
		        e.printStackTrace(); 
		    } 
		
	   
	  
	
	    } 
	   
	
	

	/*
	 * @Test public void TestFlipkartSearch() {
	 * 
	 * Reporter.log("TC to test Flipkart Search functioanlity started", true);
	 * String s_search_string = "AppleIphone"; String url =
	 * "https://www.flipkart.com"; System.setProperty("webdriver.chrome.driver",
	 * System.getProperty("user.dir")+"/chromedriver.exe"); WebDriver driver = new
	 * ChromeDriver(); driver.manage().timeouts().implicitlyWait(20,
	 * TimeUnit.SECONDS);
	 * 
	 * driver.get(url); Reporter.log("Chrome Invoked and navigated to URL: " + url +
	 * "<br>", true);
	 * 
	 * //Checking page is navigated with the expected title String actual =
	 * driver.getTitle(); String expected =
	 * "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"
	 * ; Assert.assertEquals(actual, expected); Reporter.log("Page Navigated." +
	 * "<br>", true);
	 * 
	 * //Clicking on Cross button WebElement sign_in_cross =
	 * driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
	 * sign_in_cross.click(); Reporter.log("Sign In Window Closed." + "<br>", true);
	 * 
	 * //Check Search Box is Displayed WebElement searchbx =
	 * driver.findElement(By.xpath("//input[@name ='q' and @type='text']"));
	 * Assert.assertEquals(searchbx.isDisplayed(), true);
	 * Reporter.log("Search Box is displayed." + "<br>", true);
	 * 
	 * //Enter TV in Search text box searchbx.sendKeys(s_search_string);
	 * 
	 * //Clicked on Search button
	 * driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
	 * 
	 * //Check if search Results is displayed-VALIDATION 1 //WebElement
	 * txtbx_search_result_text = driver.findElement(By.
	 * xpath("//span[contains(text(),'Showing 1 – 24 of 1,600 results for ')]"));
	 * //Assert.assertEquals(txtbx_search_result_text.isDisplayed(), true);
	 * 
	 * //Check if search Results is displayed-VALIDATION 2
	 * 
	 * String exp_search_title = s_search_string; String actual_search_title =
	 * driver.getTitle();
	 * if(actual_search_title.toLowerCase().contains(exp_search_title.toLowerCase())
	 * ) { Assert.assertTrue(true); }else { Assert.assertTrue(false); }
	 * Reporter.log("Search Box set with value :" + s_search_string +
	 * " and search results displayed" + "<br>", true);
	 * 
	 * 
	 * //Fetch All the Products Text List<WebElement> list_of_products =
	 * driver.findElements(By.xpath("//div[@class='_3wU53n']")); List<WebElement>
	 * list_of_products_price =
	 * driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
	 * 
	 * //Use of HashMaop to store Products and Their prices(after conversion to
	 * Integer) String product_name; String product_price; int int_product_price;
	 * HashMap<Integer, String> map_final_products = new HashMap<Integer,String>();
	 * for(int i=0;i<list_of_products.size();i++) { product_name =
	 * list_of_products.get(i).getText();//Iterate and fetch product name
	 * product_price = list_of_products_price.get(i).getText();//Iterate and fetch
	 * product price product_price = product_price.replaceAll("[^0-9]",
	 * "");//Replace anything wil space other than numbers int_product_price =
	 * Integer.parseInt(product_price);//Convert to Integer
	 * map_final_products.put(int_product_price,product_name);//Add product and
	 * price in HashMap } System.out.println(list_of_products.size());
	 * System.out.println(map_final_products.size()); Reporter.
	 * log("Product Name and price fetched from UI and saved in HashMap as:" +
	 * map_final_products.toString() + "<br>",true);
	 * 
	 * //Find the Highest and Lowest prices //One way is to fetch all values of the
	 * hashMap and then save it in the ArrayList //Then using Collections class in
	 * java, sort it. this we can easily get highest and lowest
	 * 
	 * //Get all the keys from Hash Map Set<Integer> allkeys =
	 * map_final_products.keySet(); ArrayList<Integer>
	 * array_list_values_product_prices = new ArrayList<Integer>(allkeys);
	 * 
	 * //Sort the Prices in Array List using Collections class //this will sort in
	 * ascending order lowest at the top and highest at the bottom
	 * Collections.sort(array_list_values_product_prices);
	 * 
	 * //Highest Product is int high_price =
	 * array_list_values_product_prices.get(array_list_values_product_prices.size()-
	 * 1);
	 * 
	 * //Low price is int low_price = array_list_values_product_prices.get(0);
	 * 
	 * Reporter.log("High Product Price is: " + high_price + " Product name is: " +
	 * map_final_products.get(high_price),true);
	 * Reporter.log("Low Product Price is: " + low_price + " Product name is: " +
	 * map_final_products.get(low_price),true);
	 * 
	 * //Get List of All values from Hash Map. Right now we do not need it so
	 * commenting //Collection<String> allValues = map_final_products.values();
	 * //ArrayList<String> array_list_values_product_names = new
	 * ArrayList<String>(allValues);
	 * 
	 * }
	 */

	// Use of HashMaop to store Products and Their prices(after conversion to
	// Integer)

	// @AfterTest
	// public void closethebrowser() {
	// driver.close();
	// log.info("All Test run successfully");
}

