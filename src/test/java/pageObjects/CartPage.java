package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//li[@class='grid__item scroll-trigger animate--slide-in'][3]") 
	WebElement productselect;
	
	@FindBy(xpath="//div[@class='product__title']")
	WebElement prodtitle;
	
	@FindBy(name="add")
	WebElement add;
	
	@FindBy(xpath="///div[@class='cart-notification__header']")
	WebElement itemadd_msg;
	
	@FindBy(id="cart-icon-bubble")
	WebElement carticon;
	
	@FindBy(xpath="//a[@class=\"cart-item__name h4 break\"]")
	WebElement cartprodname;
	
	@FindBy(xpath="//*[@id=\"Remove-1\"]/a")
	WebElement delbtn;
	
	@FindBy(xpath="//h1[@class='cart__empty-text']")
	WebElement cartinfo;
	
	public void prodselect() {
		productselect.click();
	}
	
	public String prodtitle() {
		return prodtitle.getText();
	}
	
	public void prodadd() {
		add.click();
	}
	
	public String addprodmsg() {
		return itemadd_msg.getText();
	}
	
	public void cartclick() {
		carticon.click();
	}
	
	public String cartprodtitle() {
		return cartprodname.getText();
	}
	
	public void deletebutton() {
		delbtn.click();
	}
	
	public String emptycart() {
		return cartinfo.getText();
	}

}
