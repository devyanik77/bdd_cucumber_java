//package runners;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//import org.testng.annotations.DataProvider;
//
//@CucumberOptions(
//    features = "src/test/resources/features",
//    glue = {"stepDefinitions"},
//    plugin = {"pretty", "html:target/cucumber-report.html"},
//    monochrome = true
//)
//public class CucumberTest_maven extends AbstractTestNGCucumberTests {
//    @Override
//    @DataProvider(parallel = false)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
//}
