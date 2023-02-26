package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features"},
glue = {"stepDefinitions", "hooks"},
monochrome=true,
plugin={"pretty", "junit:target/JUNITReport/report.xml",
		"json:target/JSONReport/report.json",
		"html:target/HtmlReport/report.html"}
)
public class Runner {
}
