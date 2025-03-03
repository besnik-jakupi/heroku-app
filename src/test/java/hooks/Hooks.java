package hooks;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverManager;


public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
        String baseUrl = ConfigReader.getProperty("base.url");
        driver.get(baseUrl);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            DriverManager.quitDriver();
        }
    }
}