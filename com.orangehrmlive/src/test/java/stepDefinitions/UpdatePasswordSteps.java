package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pages.BasePage;
import pages.UpdatePasswordPage;
import utils.Driver;

public class UpdatePasswordSteps {

	private WebDriver driver = Driver.getDriver();
	private BasePage basePage;
	private UpdatePasswordPage updatePasswordPage;

	@When("user clicks change password button")
	public void user_clicks_change_password_button() {
		basePage = new BasePage(driver);
		basePage.clickUserMenu("Change Password");
	}
	@Then("user is navigated to the update password page")
	public void user_is_navigated_to_the_update_password_page() {
		updatePasswordPage = new UpdatePasswordPage(driver);
		updatePasswordPage.checkUsernameIsMatch();
	}
	
	@When("user enters valid password")
	public void user_enters_valid_password() {
		updatePasswordPage.enterPassword();
	}

	@And("user enters password and confirms password")
	public void user_enters_password_and_confirms_password() {
		updatePasswordPage = new UpdatePasswordPage(driver);
		updatePasswordPage.enterAndConfirmPassword();
	}

	@And("user clicks save button")
	public void user_clicks_save_button() {
		updatePasswordPage.clickSaveBtn();
	}

	@Then("success message is apears")
	public void success_message_is_apears() {
		updatePasswordPage.checkSuccessMsg();
	}

	@When("user enters invalid password")
	public void user_enters_invalid_password() {
		updatePasswordPage.enterInvalidPassword();
	}

	@Then("invalid parameter message is apears")
	public void invalid_parameter_message_is_apears() {
		updatePasswordPage.checkErrorMsg();
	}
}
