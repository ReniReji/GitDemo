package stepdefinitions;



import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class StepDefinition extends base{
	LoginPage login;
	@Given("Initialize the browser with chrome")
	public void initialize_the_browser_with_chrome() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	  System.out.println("Browser Initialization");
	  driver = initializeBrowser();
	 
	}

	@Given("Navigate to {string} site")
	public void navigate_to_site(String string) {
	    // Write code here that turns the phrase above into concrete actions
		 driver.get(string);
	}
	@Given("click on Login link in home page to land on Secure Sign In Page")
	public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage lp = new LandingPage(driver);
		if(lp.getPopUpSize().size()>0) {
			lp.getPopUp().click();
		}
		login=lp.login();
	}



	@When("User enters {string} and {string} and log in")
	public void user_enters_and_log_in(String string, String string1) {
	    // Write code here that turns the phrase above into concrete actions
		login.getEmail().sendKeys(string);	
		login.getPassword().sendKeys(string1);
		login.getLoginBtn().click();
	}
	@Then("Verify that user is successfully logged in")
	public void verify_that_user_is_successfully_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.quit();
	}


}
