package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.*;
import testBase.BaseClass;

public class TC_02_ValidSearchProduct extends BaseClass{
	@Test
	public void verify_validsearch() throws InterruptedException
	
	{
		HomePage hp= new HomePage(driver);
		SearchResultPage sresult= new SearchResultPage(driver);
		Thread.sleep(500);
		hp.searchClick();
		Thread.sleep(500);
		hp.innersearchClick(fileobj.getProperty("productname"));
		Thread.sleep(500);
		
		//verified by  no of card present vs no of result displayed
		Assert.assertEquals(sresult.cardCount(),sresult.ResultCount());
	}
}
