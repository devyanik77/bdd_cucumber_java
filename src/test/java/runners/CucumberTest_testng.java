package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features", glue = { "stepDefinitions", "hooks" }, plugin = { "pretty",
		"json:target/cucumber.json", "html:target/cucumber-reports/index.html",
		"junit:target/cucumber-junit.xml" }, monochrome = true, dryRun = false)
public class CucumberTest_testng extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}