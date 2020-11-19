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

public class LandingPageFunctions extends base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialSetUp() throws IOException {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
		log.info("url triggered");
	}

	@Test()
	public void featuredCourseTitle() throws IOException {
		LandingPage lp = new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED123 COURSES");
		log.info("Featured Course Got");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("driver closed");
	}
	
	
}
