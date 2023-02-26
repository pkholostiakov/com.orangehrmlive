package stepDefinitions;

import static utils.ConfigReader.*;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pages.ResetPasswordPage;
import utils.Driver;

public class ResetPasswordSteps {

	private WebDriver driver = Driver.getDriver();
	private ResetPasswordPage reset;

	@Then("user is navigated to the reset password page")
	public void user_is_navigated_to_the_reset_password_page() {
		reset = new ResetPasswordPage(driver);
		driver.getCurrentUrl().contains("requestPassword");
		driver.getPageSource().contains("Reset Password");
	}
	
	@When("user enters username")
	public void user_enters_username() {
		reset.enterUsername(getProperty("username"));
	}

	@And("user press reset password button")
	public void user_press_reset_password_button() {
		reset.clickResetBtn();
	}

	@Then("it appears sent a new password to the e-mail message")
	public void it_appears_sent_a_new_password_to_the_e_mail_message() {
		reset.verifyNoteMsg();
	}
}
