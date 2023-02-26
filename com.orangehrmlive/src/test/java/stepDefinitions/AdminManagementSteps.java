package stepDefinitions;

import java.util.LinkedHashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pages.AdminManagementPage;
import pages.BasePage;
import pages.HomePage;
import utils.Driver;

public class AdminManagementSteps {
	
	private WebDriver driver = Driver.getDriver();
	private BasePage basePage;
	private HomePage homePage;
	private AdminManagementPage adminPage;
	private String recordsBefore;
	private LinkedHashMap<String, String> deletedUserData;
	private List<LinkedHashMap<String, String>> allRecordsData;

	@When("user clicks admin button in main menu")
	public void user_clicks_admin_button_in_main_menu() {
		basePage = new BasePage(driver);
		basePage.clickUserMenu("Admin");
	}

	@Then("user is navigated to the admin management page")
	public void user_is_navigated_to_the_admin_management_page() {
		homePage = new HomePage(driver);
		homePage.checkHeader("Admin");
	}

	@When("user press delete button near some user")
	public void user_press_delete_button_near_some_user() {
		adminPage = new AdminManagementPage(driver);
		recordsBefore = adminPage.pressDeleteBtnRandomRecord();
	}
	
	@When("user press delete button near particular user")
	public void user_press_delete_button_near_particular_user() {
		adminPage = new AdminManagementPage(driver);
		deletedUserData = adminPage.pressDeleteBtnParticularRecord();
	}

	@When("user confirm to delete the record in the allert message")
	public void user_confirm_to_delete_the_record_in_the_allert_message() {
		adminPage.confirmDeleteRecord();
	}
	
	@Then("the counter of user records becomes less by one")
	public void the_counter_of_user_records_becomes_less_by_one() {
		adminPage.checkCounterBecomesLessByOne(recordsBefore);
	}

	@Then("the particular user record is deleted")
	public void the_particular_user_record_is_deleted() {
		allRecordsData = adminPage.getUserRecordsData();
		adminPage.checkRecordsDataIsntContainDeletedRow(allRecordsData, deletedUserData);
	}
}
