//package runners;
//
//import io.cucumber.core.cli.Main;
//
//public class CucumberTestRunner_java {
//    public static void main(String[] args) {
//        String[] cucumberArgs = {
//            "--glue", "stepDefinitions",
//            "--glue", "hooks", 
//            "--plugin", "pretty",
//            "--plugin", "html:target/cucumber-reports-java.html",
//            "--plugin", "json:target/cucumber-reports-java.json",
//            "--monochrome",
//            "src/test/resources/features"  // Feature files path
//        };
//        
//        System.out.println("Starting Cucumber execution...");
//        Main.main(cucumberArgs);
//        System.out.println("Cucumber execution completed!");
//    }
//}