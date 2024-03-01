package Pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {
	
	@FindBy (xpath = "//div[text()='Price -- High to Low']")
	private WebElement priceHighToLow ;
	
	@FindBy (xpath = "//div[@id='container']/div/div[3]/div[1]/div[2]/div[2]//a")
	private WebElement product1stSelect ;
	
	@FindBy (xpath = "(//div[@id='container']/div/div[3]/div[1]/div[2]/div[1]/div[2]//div)[2]")
	private WebElement comapreSection ;
	
	@FindBy (xpath = "//span[text()='COMPARE']")
	private WebElement compareFrame ;
	
	private WebDriver driver ;
	
	public ResultPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	public void clickOnComapreSection() {
		
		comapreSection.click();
	}
	public String clickOnCompareFrame() {
		
		compareFrame.click();
		return driver.getCurrentUrl();
	}
	
	public void clickOnPriceHighToLow() throws InterruptedException {
		
		priceHighToLow.click();
		Thread.sleep(2000);
	}
	
	public void clickOn1stProduct() throws InterruptedException {
		
		Thread.sleep(1000);
		product1stSelect.click();
		
		ArrayList<String> chieldPage = new ArrayList<String>( driver.getWindowHandles() );
		driver.switchTo().window(chieldPage.get(1));
	}
	public void clickOnclickOn1stProductAgain() {
		
		product1stSelect.click();
		ArrayList<String> chieldPage = new ArrayList<String>( driver.getWindowHandles() );
		driver.switchTo().window(chieldPage.get(2));
	}
	
	
}
