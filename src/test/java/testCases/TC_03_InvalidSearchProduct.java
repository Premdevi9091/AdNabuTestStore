package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultPage;
import testBase.BaseClass;

public class TC_03_InvalidSearchProduct extends BaseClass{
	
	
	@Test
	public void verify_invalidsearch() throws InterruptedException
	{
		HomePage hp= new HomePage(driver);
		SearchResultPage sresult= new SearchResultPage(driver);
		Thread.sleep(500);
		hp.searchClick();
		Thread.sleep(500);
		hp.innersearchClick(fileobj.getProperty("invalidproductname"));
		Thread.sleep(500);
		String result="No results found for “"+fileobj.getProperty("invalidproductname")+"”. Check the spelling or use a different word or phrase.";
		//validated by error message
		Assert.assertEquals(result,sresult.resultString());
	}

}
