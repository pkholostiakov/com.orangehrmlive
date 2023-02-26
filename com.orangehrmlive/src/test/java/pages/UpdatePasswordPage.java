package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Utils;

public class UpdatePasswordPage extends AdminManagementPage {
	
	@FindBy (xpath="//p[contains(@class,'orangehrm-user-name')]")
	private WebElement username;
	
	public UpdatePasswordPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void checkUsernameIsMatch() {
		Assert.assertEquals(ConfigReader.getProperty("username"), username.getText().trim());
	}
	
	public void enterPassword() {
		currentPasswordInput.sendKeys(ConfigReader.getProperty("password"));
	}
	
	public void enterInvalidPassword() {
		currentPasswordInput.sendKeys(Utils.randomStr(10));
	}
	
	public void enterAndConfirmPassword() {
		String password = Utils.randomValidPassword();
		passwordInput.sendKeys(password);
		confirmPasswordInput.sendKeys(password);
	}
	
	public void checkSuccessMsg() {
		Assert.assertTrue(successMsg.isDisplayed());
	}
	
	public void checkErrorMsg() {
		Assert.assertTrue(errorMsg.isDisplayed());
	}
	
	public void clickSaveBtn() {
		saveBtn.click();
	}
}
