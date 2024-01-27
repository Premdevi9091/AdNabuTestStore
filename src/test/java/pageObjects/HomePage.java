package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[@class='h2']") 
	WebElement title;
	
	@FindBy(xpath="//header/details-modal/details/summary")
	WebElement searchbar;
	
	@FindBy(xpath="//input[@id=\"Search-In-Modal-1\"]")
	WebElement innersearchbar;
	
	public String getTitleText() {
		return title.getText();
	}
	
	public void searchClick() {
		searchbar.click();
	}
	
	public void innersearchClick(String prodname) {
		innersearchbar.click();
		innersearchbar.sendKeys(prodname);
		innersearchbar.sendKeys(Keys.ENTER);
		
	}
	
	
	
}
