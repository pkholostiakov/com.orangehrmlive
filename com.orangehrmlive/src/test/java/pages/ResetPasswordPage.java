package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends BasePage{
	
	@FindBy (xpath = "//input[@name='username']")
	private WebElement usernameInp;
	
	@FindBy (xpath = "//button[contains(@class,'cancel')]")
	private WebElement cancelBtn;
	
	@FindBy (xpath = "//button[contains(@class,'reset')]")
	private WebElement resetBtn;
	
	@FindBy (xpath = "//p[contains(.,'Note')]")
	private WebElement NoteMsg;

	public ResetPasswordPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		usernameInp.sendKeys(username);
	}

	public void clickResetBtn() {
		resetBtn.click();
	}
	
	public void clickCancelBtn() {
		cancelBtn.click();
	}
	
	public void verifyNoteMsg() {
		Assert.assertTrue(NoteMsg.isDisplayed());
	}
}
