package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFlipkart {
	
	@FindBy (xpath = "//input[@title='Search for Products, Brands and More']")
	private WebElement searchSection ;
	
	@FindBy (xpath = "//button[@title='Search for Products, Brands and More']")
	private WebElement buttonSearch ;
	
	@FindBy (xpath = "//div[@title='SAMSUNG']")
	private WebElement samsungSelect ;
	
	@FindBy(xpath = "//div[text()='Newest First']")
	private WebElement newestFirst ;
	
	@FindBy(xpath = "//span[@role='button']")
	private WebElement handleLoginPopup ;
	
	private WebDriver driver ;
	
	public HomePageFlipkart(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	public void clickOnHandleLoginPopup() {
		
		handleLoginPopup.click();
		
	}
	
	public void sendECSkey() {
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ESCAPE);
	}
	
	public void clickOnSearchSection(String data) {
		
		try{
			
			handleLoginPopup.click();
			Actions act = new Actions(driver);
			act.moveToElement(searchSection).perform();
			searchSection.sendKeys(data);
		}
		catch(NoSuchElementException e) {
			
			searchSection.sendKeys(data);
		}
	}
	
	public void clickOnButtonSearch() {
		
		buttonSearch.click();
		
	}
	
	public void clickOnSamsungSelect() {
		
		samsungSelect.click();
	}
	
	public void clickOnNewestFirst() {
		
		newestFirst.click();
	}
	
	
}
