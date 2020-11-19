package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initialSetUp() throws IOException {
		driver = initializeBrowser();
		log.info("url triggered again");
	}
	
@Test(dataProvider="getData")
public void baseHomePageNavigation(String email,String password) throws IOException {
	driver.get(prop.getProperty("url"));
	LandingPage lp = new LandingPage(driver);
	LoginPage login=lp.login();
	log.info("login page clicked");
	//LoginPage login =new LoginPage(driver);
	login.getEmail().sendKeys(email);
	
	login.getPassword().sendKeys(password);
	login.getLoginBtn().click();
	log.info("user login");
	ForgotPassword fp = login.getForgotPassword();
	fp.getEmail().sendKeys("abc");
	fp.sendMeInstruction().click();
}	

@AfterTest
public void tearDown() {
	driver.close();
	log.info("driver closed");
}
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[2][2];
		data[0][0] = "nonrestricteduser@gmail.com";
		data[0][1] = "Welcome";
		
		data[1][0] = "restricteduser@gmail.com";
		data[1][1] = "WelcomeHome";
		
		return data;
	}
}

