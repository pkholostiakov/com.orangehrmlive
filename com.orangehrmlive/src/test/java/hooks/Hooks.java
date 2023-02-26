package hooks;

import static utils.ConfigReader.getProperty;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.*;
import utils.Driver;

public class Hooks {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = Driver.getDriver();
		driver.get(getProperty("url"));
	}
	
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			String screenshotPath = "target/screenshots" + screenshotName + ".png";
			try {
				byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "Screenshot");
				FileUtils.copyFile(((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE),
						new File(screenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Driver.quitDriver();
	}
}
