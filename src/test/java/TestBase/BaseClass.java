package TestBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public Logger logger;
    public Properties properties;

    @Parameters({"os", "browser"})
    @BeforeClass(groups = {"sanity", "regression", "master"})
    public void setup(String os, String br) throws IOException {

        FileReader file = new FileReader(".//src/main/config.properties");
        properties = new Properties();
        properties.load(file);

        if (properties.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            }
            else if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN11);
            }
            else if (os.equalsIgnoreCase("Linux")) {
                capabilities.setPlatform(Platform.LINUX);}
            else {
                System.out.println("Invalid OS");
                return;
            }
            switch (br.toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;
                case "firefox":
                    capabilities.setBrowserName("firefox");
                    break;
                default:
                    System.out.println("Invalid Browser");
                    return;
            }
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        }

        // If remote

        if (properties.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch (br.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    System.out.println("Invalid Browser");
                    return;
            }
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("appUrl"));
        driver.manage().window().maximize();
    }

    @AfterClass(groups = {"sanity", "regression", "master"})
    public void tearDown() {
        driver.quit();
    }

    public String randomString() {
        String random = RandomStringUtils.randomAlphabetic(5);
        return random;
    }

    public String randomAlphanumeric() {
        String randomAlpha = RandomStringUtils.randomAlphabetic(5);
        String randomNum = RandomStringUtils.randomNumeric(5);
        return (randomAlpha + "@" + randomNum);
    }
}
