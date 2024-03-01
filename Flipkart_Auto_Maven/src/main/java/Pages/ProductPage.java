package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	
	@FindBy (xpath = "(//div[@id='container']/div/div[3]/div[1]/div[2]/div[5]//div//a)[3]")
	private WebElement selectColor ;
	
	@FindBy (xpath = "(//div[@id='container']//button)[2]")
	private WebElement addToCartButton ;
	
	@FindBy (xpath = "//div[@id='container']/div/div[2]/div/div/div[2]/div[1]//div//div/div/div/div/div//div[2]//span")
	private WebElement totalPrice ;
	
	private WebDriver driver ;
	
	public ProductPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	public void clickOnSelectColor() {
		
		selectColor.click();
	}
	
	public void clickOnAddToCartButton() throws InterruptedException {
		
		Thread.sleep(2000);
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(addToCartButton));
		
		addToCartButton.click();
	}
	
	public String getTotalPrice() throws InterruptedException {
		
		Thread.sleep(2000);
		return totalPrice.getText();
	}
	
	
}
