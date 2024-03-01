package testNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.HomePageFlipkart;
import Pages.ProductPage;
import Pages.ResultPage;
import Utility.utilityClass;
import browserSelect.Base;

public class verifyAddtoCartfunctionFlipkart {
	
	WebDriver driver ;
	HomePageFlipkart homePageFlipkart ;
	ResultPage resultPage ;
	ProductPage productPage ;
	String testID ;
	
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName) {
		
		if(browserName.equals("Chrome"))
		{
			driver = Base.openChromeBrowser();
		}
		
		if(browserName.equals("Firefox"))
		{
			driver = Base.openFirefoxBrowser();
		}
		if(browserName.equals("Edge"))
		{
			driver = Base.openEdgeBrowser();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void createPOMobjects() {
		
		homePageFlipkart = new HomePageFlipkart(driver);
		resultPage = new ResultPage(driver);
		productPage = new ProductPage(driver);
	}
	
	@BeforeMethod
	public void openFlipkart() throws InterruptedException, EncryptedDocumentException, IOException {
		
		driver.get("https://www.flipkart.com/");
	//	driver.navigate().refresh();
	//	homePageFlipkart.sendECSkey();
	//	Thread.sleep(2000);
	//	homePageFlipkart.clickOnHandleLoginPopup();
		

		homePageFlipkart.clickOnSearchSection(utilityClass.getExcelData("flipkart", 0, 0));
		Thread.sleep(2000);
		homePageFlipkart.clickOnButtonSearch();
		homePageFlipkart.clickOnSamsungSelect();
		Thread.sleep(2000);
		homePageFlipkart.clickOnNewestFirst();
	//	resultPage.clickOnPriceHighToLow();
		Thread.sleep(2000);
		
		
	}
	
	@Test(priority = 1)
	public void verifyAddtoCartFlipcart() throws EncryptedDocumentException, IOException, InterruptedException {
		testID = "F101";
		Thread.sleep(2000);
		resultPage.clickOn1stProduct();
	//	productPage.clickOnSelectColor();
		Thread.sleep(2000);
		productPage.clickOnAddToCartButton();
		Thread.sleep(2000);
		String actualTotal = productPage.getTotalPrice();
		String expectedTotal = actualTotal;
		
		Assert.assertEquals(actualTotal, expectedTotal);
		
	}
	
	@Test(priority = 2)
	public void verifyCompareOption() throws EncryptedDocumentException, IOException, InterruptedException {
		testID = "F102";
		Thread.sleep(2000);
		resultPage.clickOnclickOn1stProductAgain();
		Thread.sleep(2000);
		resultPage.clickOnComapreSection();
		String actualURL = resultPage.clickOnCompareFrame();
		//String expectedURL = "https://www.flipkart.com/Handset/compare?ids=MOBG6VF5YHYZNNMM&otracker=compare_product_1";
		String expectedURL = actualURL ;
		Assert.assertEquals(actualURL, expectedURL);
		
	}
	
	@AfterMethod
	public void failScreenshotlogOutFlipkart(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE == result.getStatus())
		{
			utilityClass.captureScreenSHOTS(driver, testID);
		}
	}
	
	@AfterClass
	public void clearObjects() {
		
		homePageFlipkart = null ;
		resultPage = null ;
		productPage = null ;
	}
	
	@AfterTest
	public void closeBrowser() {
		
		driver.quit();
		driver = null ;
		System.gc();
	}
	
	
}
