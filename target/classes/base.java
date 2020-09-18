package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {

	public static  WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
	prop=new Properties();
	FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	//mvn test -Dbrowser=chrome
	//String browserName=System.getProperty("browser");  // Uncomment this line if you are sending parameter from Maven
	String browserName=prop.getProperty("browser");
	System.out.println(browserName);

	if(browserName.contains("chrome")){
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");
	 ChromeOptions options =new ChromeOptions();
	 if(browserName.contains("headless"))
	 {
	  options.addArguments("headless");
	 }
driver= new ChromeDriver(options);
		//execute in chrome driver
	
}
else if (browserName.equals("firefox"))
{
	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Owner\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
	 driver= new FirefoxDriver();
	//firefox code
}
else if (browserName.equals("IE"))
{
//	IE code
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;

}


public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;

}
	public String[] getExcelData() throws IOException
	{
		ArrayList<String> a = new ArrayList();
		String filepath=System.getProperty("user.dir")+"\\TestData.xlsx";
		FileInputStream fis= new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets= workbook.getNumberOfSheets();
		for (int i =0; i<sheets; i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("TestData"))
			{
				XSSFSheet sheet= workbook.getSheetAt(i);
				Iterator<Row> rows= sheet.iterator();//sheet is collection of rows
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();//row is collection of cells
				int k=0;
				int column = 0;
				while(ce.hasNext())
				{
					Cell value = ce.next();
					//System.out.println(value);
					//System.out.println(value.getStringCellValue());
					
					if(value.getStringCellValue().equalsIgnoreCase("Vegetables Required"))
					{
						
						column=k;
						while(rows.hasNext())
						{
							Row r = rows.next();
							Iterator<Cell> cv= r.cellIterator();
							cv.next();
							Cell c=cv.next();
							if(c.getCellTypeEnum()==CellType.STRING)
							{
								a.add(c.getStringCellValue());
							}
							else
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							
							
				}
					}
					
					k++;
						
					
					
					
					
				////once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
					//System.out.println(a);
				}
				
			}	
		}
		System.out.println(a);
			String[] stringArray = a.toArray(new String[0]);
			
			
		
		
		return stringArray;
	}
	public String getExcelDataQuantity(String vegetable) throws IOException
	{
		ArrayList<String> a = new ArrayList();
		String filepath=System.getProperty("user.dir")+"\\TestData.xlsx";
		FileInputStream fis= new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets= workbook.getNumberOfSheets();
		for (int i =0; i<sheets; i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("TestData"))
			{
				XSSFSheet sheet= workbook.getSheetAt(i);
				Iterator<Row> rows= sheet.iterator();//sheet is collection of rows
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();//row is collection of cells
				int k=0;
				int column = 0;
				while(ce.hasNext())
				{
					Cell value = ce.next();
					//System.out.println(value);
					//System.out.println(value.getStringCellValue());
					
					if(value.getStringCellValue().equalsIgnoreCase("Quantity Required"))
					{
						
						column=k;
						while(rows.hasNext())
						{
							Row r = rows.next();
							Iterator<Cell> cv= r.cellIterator();
							cv.next();
							Cell v=cv.next();
							if(v.getStringCellValue().contains(vegetable))
							{
							Cell c=cv.next();
							if(c.getCellTypeEnum()==CellType.STRING)
							{
								a.add(c.getStringCellValue());
							}
							else
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							
							
				}
					}
					}
					
					k++;
						
					
					
					
					
				////once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
					
				}
				
				System.out.println(a);
				
			}	
		}
			String[] stringArray = a.toArray(new String[0]);
			System.out.println(stringArray[0]);
			//System.out.println(stringArray[1]);
			//System.out.println(stringArray[2]);
			//System.out.println(stringArray[3]);
			
		
		
		return stringArray[0];
	}
	
	}
