package pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage{
	
	public WebDriver driver;
	
	public SearchResultPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@class=\"card__inner  ratio\"]") 
	List <WebElement> searchresult;
	
	@FindBy(xpath="//span[@id='ProductCountDesktop']")
	WebElement resultcount;
	
	@FindBy(xpath="//p[@role='status']")
	WebElement resultstatus;
	
	@FindBy(xpath="//span[@class='facets__summary-label']")
	WebElement availability;
	
	@FindBy(xpath="//input[@id='Filter-filter.v.availability-1']")
	WebElement instock;
	
	@FindBy(xpath="//input[@id='Filter-filter.v.availability-2']")
	WebElement outofstock;
	
	@FindBy(xpath="//div[2]/facet-remove[2]")
	WebElement removefilter;
	
	public int cardCount() {
		System.out.println("Card Count "+searchresult.size());
		return searchresult.size(); 	//getting the number of cards displayed on page
		
	}
	public int ResultCount() {
		String result= resultcount.getText();  //getting the count of label "<num> results"
		String results[]=result.split("\\s+");
		int num = Integer.parseInt(results[0]);	
		System.out.println("Result count "+num);
		return num;
	}
	
	public String resultString() {
		return resultstatus.getText(); 	//getting result for invalid search
		
	}
	
	public void clickAvailability() {
		availability.click();
	}
	
	public void clickInStock() {
		js.executeScript("arguments[0].click();",instock);
		//instock.click();
		instock.sendKeys(Keys.ENTER);
	}
	
	public void clickOutInStock() {
		js.executeScript("arguments[0].scrollIntoView(true);", outofstock);
		js.executeScript("arguments[0].click();",outofstock);
		//outofstock.click();
		outofstock.sendKeys(Keys.ENTER);
	}
	
	public void removeAllfilter() {
		removefilter.click();
	}

}
