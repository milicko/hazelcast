package driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DriverFactory {


    private static final String BROWSER_TYPE_PROPERTY = "browser";
    private static final String DRIVER_PROPERTY = "driver.path";

    public WebDriver getDriver() {
        if (_driver == null) {
            createDriver(determineDriverType());
        }
        return _driver;
    }

    public void setDriver(WebDriver driver) {
        this._driver = driver;
    }

    private static WebDriver _driver;


    /**
     * Returning DriverType based on "browser" system propertie
     *
     * @return - DriverType
     */
    public DriverType determineDriverType() {
        String typeProperty = System.getProperty(BROWSER_TYPE_PROPERTY);

        DriverType driverType = DriverType.getDriverTypeByPropertyName(typeProperty);

        return driverType;
    }

    /**
     * Creating web driver for specific browser based on system property "browser"
     *
     * @return WebDriver
     */
    public WebDriver createDriver(DriverType type) {
        WebDriver driver = null;


        switch (type) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", getClass().getClassLoader().getResource("drivers/chromedriver").getPath());
                setDriver(_driver = new ChromeDriver());
                _driver.manage().window().maximize();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", getClass().getClassLoader().getResource("drivers/geckodriver").getPath());
                setDriver(_driver = new FirefoxDriver());
                _driver.manage().window().maximize();
                break;
        }


        return driver;

    }


}