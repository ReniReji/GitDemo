package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;

By signin = By.cssSelector("a[href*='sign_in']");
By featuredCourse = By.xpath("//h2[contains(text(),'Featured Courses')]");
By navBar = By.xpath("//header/div[2]/div[1]/nav[1]/ul[1]/li/a");
By header = By.cssSelector("div[class*=\"video-banner\"] h3");
By popup = By.xpath("//button[text()='NO THANKS']");
public LandingPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver =driver;
}

public LoginPage login() {
	driver.findElement(signin).click();
	LoginPage login =new LoginPage(driver);
	return login;
}

public WebElement getTitle() {
	return driver.findElement(featuredCourse);
}

public WebElement getNavBar() {
	return driver.findElement(navBar);
}

public List<WebElement> getPopUpSize() {
	return driver.findElements(popup);
}
public WebElement getPopUp() {
	return driver.findElement(popup);
}
public WebElement getHeader() {
	return driver.findElement(header);
}
}
