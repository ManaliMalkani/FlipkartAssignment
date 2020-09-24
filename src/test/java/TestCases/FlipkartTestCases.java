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
import org.openqa.selenium.support.ui.WebDriverWait;
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

	
	 @BeforeTest 
	 public void initialize() throws IOException {
	 driver=initializeDriver(); log.info("Driver is initialized");
	 driver.get(prop.getProperty("url"));
	 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	 driver.manage().window().maximize();
	 
	  }
	 
	@Test
	public void TC01CalclateTheSumofTotalCasesOfAllStates() throws IOException, InterruptedException {
	
		
		fk = new FlipkartHomePage(driver);
		fk.CancelLink().click();
		fk.Searchbox().sendKeys("apple iphone");
		fk.SearchButton().click();
		fk.PriceLowtoHigh().click();
		fk.AvailabilityDropdown().click();
		fk.ExcludeOutOfStock().click();
		Thread.sleep(5000);
		List<WebElement> list_of_products = fk.ListOfProducts();
		List<WebElement> list_of_products_price = fk.list_of_products_price();
		List<WebElement> list_of_products_ratings =fk.list_of_products_ratings();

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
		        //String[] data = null;
		        for (int i = 0; i < list_of_products.size(); i++) {
					
					String prouctprice=list_of_products_price.get(i).getText();
					String product_pp = prouctprice.replaceAll("[^0-9]", "");
					int product_price =Integer.parseInt(product_pp);//Convert to Integer
		        
			if(product_price<40000)
			{
				
				String [] data = new String [] {list_of_products.get(i).getText(),product_pp, list_of_products_ratings.get(i).getText()  };
				//data[0]=list_of_products.get(i).getText();
				//data[1]=product_pp;
				//data[2]=list_of_products_ratings.get(i).getText();
				writer.writeNext(data); 
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

	 @AfterTest
	 public void closethebrowser() {
	 driver.close();
	log.info("All Test run successfully");
}
}
