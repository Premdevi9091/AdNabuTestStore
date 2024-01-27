package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.*;
import testBase.BaseClass;

public class TC_07_RemovefromCart extends BaseClass{

	@Test
	public void verify_removefromcart() throws InterruptedException
	
	{
		HomePage hp= new HomePage(driver);
		CartPage cart=new CartPage(driver);
		hp.searchClick();
		Thread.sleep(500);
		hp.innersearchClick(fileobj.getProperty("productname"));
		Thread.sleep(500);
		cart.prodselect();
		Thread.sleep(500);
		cart.prodadd();
		Thread.sleep(1000);
		cart.cartclick();
		Thread.sleep(500);
		cart.deletebutton();
		Thread.sleep(1500);
	
		//verified by text "Your cart is empty"
		Assert.assertEquals(cart.emptycart(),"Your cart is empty");
	}

}
