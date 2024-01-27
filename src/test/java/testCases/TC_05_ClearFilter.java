package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchResultPage;
import testBase.BaseClass;

public class TC_05_ClearFilter extends BaseClass{
	
	
	@Test
	public void verify_clearfilterby() throws InterruptedException
	{
		String filtervalue=fileobj.getProperty("filterby");  //taking filter value from config.properties
		SearchResultPage sresult= new SearchResultPage(driver);
		getProduct();
		
		switch(filtervalue) {
		
			case "in stock":
				
				sresult.clickInStock();
				Thread.sleep(500);
				driver.navigate().refresh();
				sresult.removeAllfilter();
				driver.navigate().refresh();
				Assert.assertEquals(sresult.cardCount(),sresult.ResultCount());
				Thread.sleep(500);
				break;
				
			case "out of stock":
				
				sresult.clickOutInStock();
				Thread.sleep(500);
				driver.navigate().refresh();
				sresult.removeAllfilter();
				driver.navigate().refresh();
				Assert.assertEquals(sresult.cardCount(),sresult.ResultCount());
				Thread.sleep(500);
				break;
		}
		
	}
}
