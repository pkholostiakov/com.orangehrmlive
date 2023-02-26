package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import pages.BasePage;
import utils.Driver;

public class BasePageSteps {

	protected WebDriver driver = Driver.getDriver();
	protected BasePage basePage;
	
	@Then ("all the button works at the home page")
	public void all_the_button_works_at_the_home_page() {
		basePage = new BasePage(driver);
		basePage.checkBasePageElements();
	}
	
	@Then ("user is logout")
	public void user_is_logout() {
		basePage.logout();
	}
}
