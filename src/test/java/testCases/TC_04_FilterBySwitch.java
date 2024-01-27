package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchResultPage;
import testBase.BaseClass;

public class TC_04_FilterBySwitch extends BaseClass{
	
	@Test
	public void verify_filterby() throws InterruptedException
	{
		String filtervalue=fileobj.getProperty("filterby");  //taking filter value from config.properties
		
		SearchResultPage sresult= new SearchResultPage(driver);
		getProduct();
		
		switch(filtervalue) {
		
			case "in stock":
				
				sresult.clickInStock();
				Thread.sleep(500);
				driver.navigate().refresh();
				//verified by  no of card present vs no of result displayed
				Assert.assertEquals(sresult.cardCount(),sresult.ResultCount());
				Thread.sleep(500);
				break;
				
			case "out of stock":
				
				sresult.clickOutInStock();
				Thread.sleep(500);
				driver.navigate().refresh();
				//verified by  no of card present vs no of result displayed
				Assert.assertEquals(sresult.cardCount(),sresult.ResultCount());
				Thread.sleep(500);
				break;
		}		
	}
}
