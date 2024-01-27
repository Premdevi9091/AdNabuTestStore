package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.*;
import testBase.BaseClass;

public class TC_06_AddtoCard extends BaseClass{
	
	@Test
	public void verify_addtocard() throws InterruptedException
	
	{
		HomePage hp= new HomePage(driver);
		CartPage cart=new CartPage(driver);
		hp.searchClick();
		Thread.sleep(500);
		hp.innersearchClick(fileobj.getProperty("productname"));
		Thread.sleep(500);
		cart.prodselect();
		Thread.sleep(500);
		String prodtitle=cart.prodtitle();
		cart.prodadd();
		Thread.sleep(1000);
		cart.cartclick();
		Thread.sleep(500);
		//verified by product name of product details page and cart page
		Assert.assertEquals(prodtitle,cart.cartprodtitle());
		
	}
	@Test
	public void verify_addtocard2() throws InterruptedException
	
	{
		HomePage hp= new HomePage(driver);
		CartPage cart=new CartPage(driver);
		hp.searchClick();
		Thread.sleep(500);
		hp.innersearchClick(fileobj.getProperty("productname"));
		Thread.sleep(500);
		cart.prodselect();
		Thread.sleep(500);
		String prodtitle=cart.prodtitle();
		cart.prodadd();
		Thread.sleep(1000);
		cart.cartclick();
		Thread.sleep(500);
		//verified by product name of product details page and cart page
		Assert.assertEquals(prodtitle,cart.cartprodtitle());
		
	}

}
