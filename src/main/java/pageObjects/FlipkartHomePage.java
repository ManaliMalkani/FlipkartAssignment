package pageObjects;

import java.io.IOException;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoronavirusTrackerPage {
	
	public WebDriver driver;
	
	private By NDTVAlert=By.xpath("//a[text()='No Thanks']");
	private String IndiaCasesFrame="t5";
	private By TotalCasesforStates=By.xpath("//tr//td[2]//p");
	private By TotalCasesInIndia =By.cssSelector("li[class='ind-mp_total_iteam confirmed'] span[class='ind-mp_num']");
	private By TotalActiveCasesforStates=By.xpath("//tr//td[3]//p");
	private By TotalActiveCasesInIndia= By.cssSelector ("li[class='ind-mp_total_iteam activecase'] span[class='ind-mp_num']");
	private By TotalRecoverdCasesforStates=By.xpath("//tr//td[4]//p");
	private By TotalRecoverdCasesInIndia= By.cssSelector ("li[class='ind-mp_total_iteam recovered'] span[class='ind-mp_num']");
	private By TotalDeathInStates=By.xpath("//tr//td[5]//p");
	private By TotalDeathInInIndia= By.cssSelector ("li[class='ind-mp_total_iteam deaths'] span[class='ind-mp_num']");
	private By TotalTodayCasesforStates=By.xpath("//tr//td[2]//p//span");
	private By TotalTodayCasesInIndia =By.cssSelector("li[class='ind-mp_total_iteam confirmed'] span[class='ind-mp_num'] span");
	private By TotalTodayActiveCasesforStatesDown=By.xpath("//tr//td[3]//p//span[@class='data-down']");
	private By TotalTodayActiveCasesforStatesUp=By.xpath("//tr//td[3]//p//span[@class='data-up']");
	private By TotalTodayActiveCasesInIndia =By.cssSelector("li[class='ind-mp_total_iteam activecase'] span[class='ind-mp_num'] span");
	private By TotalTodayRecoveredCasesforStates=By.xpath("//tr//td[4]//p//span");
	private By TotalTodayRecoveredCasesInIndia =By.cssSelector("li[class='ind-mp_total_iteam recovered'] span[class='ind-mp_num'] span");
	private By TotalTodayDeathCasesforStates=By.xpath("//tr//td[5]//p//span");
	private By TotalTodayDeathCasesInIndia =By.cssSelector("li[class='ind-mp_total_iteam deaths'] span[class='ind-mp_num'] span");


public CoronavirusTrackerPage(WebDriver driver)
{
	this.driver=driver;
}

public WebElement NDTVAlert()
{
	return driver.findElement(NDTVAlert);
	
}
public WebDriver IndiaCasesFrame()
{
	return driver.switchTo().frame(IndiaCasesFrame);
	
}

public List TotalCasesforStates()
{
	return driver.findElements(TotalCasesforStates);
	
}
public WebElement TotalCasesInIndia()
{
	return driver.findElement(TotalCasesInIndia);
	
}

public List TotalActiveCasesforStates()
{
	return driver.findElements(TotalActiveCasesforStates);
	
}
public WebElement TotalActiveCasesInIndia()
{
	return driver.findElement(TotalActiveCasesInIndia);
	
}
public List TotalRecoverdCasesforStates()
{
	return driver.findElements(TotalRecoverdCasesforStates);
	
}
public WebElement TotalRecoverdCasesInIndia()
{
	return driver.findElement(TotalRecoverdCasesInIndia);
	
}
public List TotalDeathInStates()
{
	return driver.findElements(TotalDeathInStates);
	
}
public WebElement TotalDeathInInIndia()
{
	return driver.findElement(TotalDeathInInIndia);
	
}
public List<WebElement> TotalTodayCasesforStates()
{
	return driver.findElements(TotalTodayCasesforStates);
	
}
public WebElement TotalTodayCasesInIndia()
{
	return driver.findElement(TotalTodayCasesInIndia);
	
}
public List<WebElement> TotalTodayActiveCasesforStatesUp()
{
	return driver.findElements(TotalTodayActiveCasesforStatesUp);
	
}
public List<WebElement> TotalTodayActiveCasesforStatesDown()
{
	return driver.findElements(TotalTodayActiveCasesforStatesDown);
	
}
public WebElement TotalTodayActiveCasesInIndia()
{
	return driver.findElement(TotalTodayActiveCasesInIndia);
	
}
public List<WebElement> TotalTodayRecoveredCasesforStates()
{
	return driver.findElements(TotalTodayRecoveredCasesforStates);
	
}
public WebElement TotalTodayRecoveredCasesInIndia()
{
	return driver.findElement(TotalTodayRecoveredCasesInIndia);
	
}
public List<WebElement> TotalTodayDeathCasesforStates()
{
	return driver.findElements(TotalTodayDeathCasesforStates);
	
}
public WebElement TotalTodayDeathCasesInIndia()
{
	return driver.findElement(TotalTodayDeathCasesInIndia);
	
}
}


