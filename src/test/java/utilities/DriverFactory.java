package utilities;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // Read CHROME_ARGS env var (set in GitHub Actions)
        String chromeArgs = System.getenv("CHROME_ARGS");

        if (chromeArgs != null && !chromeArgs.isBlank()) {
            // Split the string into arguments
            List<String> args = Arrays.asList(chromeArgs.split(" "));
            options.addArguments(args);
            System.out.println("Running in CI with CHROME_ARGS: " + chromeArgs);
        } else {
            // Local fallback (normal Chrome)
            options.addArguments("--start-maximized");
            System.out.println("Running locally (normal Chrome mode)");
        }

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
