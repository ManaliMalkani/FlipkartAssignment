package TestCases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CoronavirusTrackerPage;
import resources.base;
import resources.utils;

public class CoronavirusTotalCases extends base {

	

	public  static WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName()); ;
	CoronavirusTrackerPage ct;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();	 
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
					
	}
    @Test
    public void TC01CalclateTheSumofTotalCasesOfAllStates() throws IOException, InterruptedException
    {
    	ct=new CoronavirusTrackerPage(driver);
		ct.NDTVAlert().click();
		ct.IndiaCasesFrame();
		int sumOfTotalCasesofAllStates = utils.TotalStateCountSum(ct.TotalCasesforStates());
		int TotalIndiaCases=utils.TotalIndiaCount(ct.TotalCasesInIndia());
		Assert.assertEquals(sumOfTotalCasesofAllStates, TotalIndiaCases);

     }
    @Test
    public void TC02CalclateTheSumofActiveCasesOfAllStates() throws IOException, InterruptedException
    {
    	ct=new CoronavirusTrackerPage(driver);
    	int sumOfTotalActiveCasesofAllStates = utils.TotalStateCountSum(ct.TotalActiveCasesforStates());
    	int TotalActiveIndiaCases=utils.TotalIndiaCount(ct.TotalActiveCasesInIndia());
		Assert.assertEquals(sumOfTotalActiveCasesofAllStates, TotalActiveIndiaCases);
     }
    @Test
    public void TC03CalclateTheSumofRecoveredCasesOfAllStates() throws IOException, InterruptedException
    {
    	ct=new CoronavirusTrackerPage(driver);
    	int sumOfTotalRecoveredCasesofAllStates = utils.TotalStateCountSum(ct.TotalRecoverdCasesforStates());
    	int TotalRecoveredIndiaCases=utils.TotalIndiaCount(ct.TotalRecoverdCasesInIndia());
		Assert.assertEquals(sumOfTotalRecoveredCasesofAllStates, TotalRecoveredIndiaCases);
	}
    
    @Test
    public void TC04CalclateTheSumofDeathsOfAllStates() throws IOException, InterruptedException
    {
    	ct=new CoronavirusTrackerPage(driver);
    	int sumOfTotalDeathCasesofAllStates = utils.TotalStateCountSum(ct.TotalDeathInStates());
    	int TotalDeathIndiaCases=utils.TotalIndiaCount(ct.TotalDeathInInIndia());
		Assert.assertEquals(sumOfTotalDeathCasesofAllStates, TotalDeathIndiaCases);
    }
    
    @Test
    public void TC05CalclateTheSumofTotalTodayCasesOfAllStates() throws IOException, InterruptedException
    {
    	ct=new CoronavirusTrackerPage(driver);
    	int sumOfTotalTodayCasesofAllStates = utils.TotalStateCountSum(ct.TotalTodayCasesforStates());
    	int TotalTodayIndiaCases=utils.TotalIndiaCount(ct.TotalTodayCasesInIndia());
		Assert.assertEquals(sumOfTotalTodayCasesofAllStates, TotalTodayIndiaCases);    	
    }  
    @Test(retryAnalyzer=Analyzer.RetryAnalyzer.class)
    public void TC06CalclateTheSumofTotalActiveTodayCasesOfAllStates() throws IOException, InterruptedException
    {
    	ct=new CoronavirusTrackerPage(driver);
    	int sumOfActiveTodayCasesofAllStatesUp = utils.TotalStateCountSum(ct.TotalTodayActiveCasesforStatesUp());
    	int sumOfActiveTodayCasesofAllStatesDown = utils.TotalStateCountSum(ct.TotalTodayActiveCasesforStatesDown());
    	int finalcount=sumOfActiveTodayCasesofAllStatesUp-sumOfActiveTodayCasesofAllStatesDown;
    	int TotalActiveTodayIndiaCases=utils.TotalIndiaCount(ct.TotalTodayActiveCasesInIndia());
		Assert.assertEquals(finalcount, TotalActiveTodayIndiaCases);   
    }
    @Test
    public void TC07CalclateTheSumofTotalRecoveredTodayCasesOfAllStates() throws IOException, InterruptedException
    {
    	ct=new CoronavirusTrackerPage(driver);
    	int sumOfRecoveredTodayCasesofAllStates = utils.TotalStateCountSum(ct.TotalTodayRecoveredCasesforStates());
    	int TotalRecoveredTodayIndiaCases=utils.TotalIndiaCount(ct.TotalTodayRecoveredCasesInIndia());
		Assert.assertEquals(sumOfRecoveredTodayCasesofAllStates, TotalRecoveredTodayIndiaCases);   
	}
    
    @Test
    public void TC08CalclateTheSumofTotalDeathTodayCasesOfAllStates() throws IOException, InterruptedException
    {
    	ct=new CoronavirusTrackerPage(driver);
    	int sumOfTodayDeathCasesofAllStates = utils.TotalStateCountSum(ct.TotalTodayDeathCasesforStates());
    	int TotalDeathTodayIndiaCases=utils.TotalIndiaCount(ct.TotalTodayDeathCasesInIndia());
		Assert.assertEquals(sumOfTodayDeathCasesofAllStates, TotalDeathTodayIndiaCases);   
	}


    @AfterTest
    public void closethebrowser() {
    	driver.close();
    	log.info("All Test run successfully");  	
    	
    }
    }
