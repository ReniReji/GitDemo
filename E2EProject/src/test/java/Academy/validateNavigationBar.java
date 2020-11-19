package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateNavigationBar extends base{
	public WebDriver driver;
	LandingPage lp;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialSetUp() throws IOException {
		driver = initializeBrowser();
		log.info("driver initialized");
		driver.get(prop.getProperty("url"));
		log.info("url is hit");
	}

	@Test()
	public void navigationBar() throws IOException {

		lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNavBar().isDisplayed());
		log.info("navigation bar is displayed");
		
	}
	
	@Test()
	public void header() throws IOException {

		Assert.assertEquals(lp.getHeader().getText(),"An Academy to learn Everything about Testing");
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("driver closed");
	}
	
}
