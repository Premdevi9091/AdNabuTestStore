package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.*;
import testBase.BaseClass;

public class TC_01_WebSite_Launch extends BaseClass{
	
	@Test
	public void verify_homepage() throws InterruptedException
	{
		HomePage log= new HomePage(driver);
		Thread.sleep(500);
		
		//verified by header title adnabu-submit
		Assert.assertEquals("adnabu-Sumit", log.getTitleText());
	}

}
