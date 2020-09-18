package resources;

import java.util.List;


import org.openqa.selenium.WebElement;

public class utils {
	
	
	public static int TotalStateCountSum(List<WebElement>StateList) {
		
		int TotalCount=StateList.size();
		System.out.println(TotalCount);
		int sum= 0;
		for (WebElement element : StateList) 
		{
			String text= element.getText();
			System.out.println(text);
			String TotalStateCase=text.split("\\r?\\n")[0];
			System.out.println(TotalStateCase);
			String TC=TotalStateCase.replace(",","");
			int TotalStateCaseCount=Integer.parseInt(TC);
			sum=sum+TotalStateCaseCount;
		}
		return sum;
		
		
	}
	public static int TotalIndiaCount(WebElement IndiaCount) {
		
			
		String text=IndiaCount.getText();
		System.out.println(text);
		String TotalIndCase=text.split("\\r?\\n")[0];
		System.out.println(TotalIndCase);
		String TC=TotalIndCase.replace(",","");
		System.out.println(TC);
		int TotalIndiaCaseCount=Integer.parseInt(TC);
		return TotalIndiaCaseCount;
		
		
	}


}
