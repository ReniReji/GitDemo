package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;

	private By email = By.cssSelector("input[id='user_email']");
	private By password = By.xpath("//input[@id='user_password']");
	private By login = By.cssSelector("input[value='Log In']");
	private By forgotPassword = By.cssSelector("[href*=\'password/new\']");
	

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public ForgotPassword getForgotPassword() {
		driver.findElement(forgotPassword).click();
		return new ForgotPassword(driver);
	
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLoginBtn() {
		return driver.findElement(login);
	}
}
