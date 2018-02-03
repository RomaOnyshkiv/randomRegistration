package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private Properties properties = new Properties();
    private String PATH_TO_DRIVER;
    protected String BASE_URL;

    protected static WebDriver driver;

    @BeforeTest
    public void startDriver() {
        try {
            loadProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", PATH_TO_DRIVER);
            driver = new ChromeDriver();
            driver.manage().timeouts()
                    .implicitlyWait(30, TimeUnit.SECONDS)
                    .setScriptTimeout(30, TimeUnit.SECONDS)
                    .pageLoadTimeout(30, TimeUnit.SECONDS);
        }
        driver.manage().deleteAllCookies();
    }

    private void loadProperties() throws IOException {
        File prop = new File("src/main/resources/test.properties");
        properties.load(new FileInputStream(prop));
        PATH_TO_DRIVER = properties.getProperty("driver");
        BASE_URL = properties.getProperty("url");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
