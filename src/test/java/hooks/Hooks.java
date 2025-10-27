package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverFactory;
import utilities.ConfigReader;

import java.io.IOException;

public class Hooks {
    @Before
    public void setUp() throws IOException {
        ConfigReader.loadConfig();
        DriverFactory.initDriver();
    }

    @After
    public void tearDown() {
        try {
            DriverFactory.quitDriver();
            Thread.sleep(1000); // 🕒 Give ChromeDriver time to release sockets
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
