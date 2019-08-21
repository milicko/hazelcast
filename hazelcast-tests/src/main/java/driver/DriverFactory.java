package driver;


import org.apache.commons.exec.util.StringUtils;
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

        if (typeProperty == null | typeProperty.equals("")) {

            throw new RuntimeException(String.format("System property for browser %s wasn't set! Set system property -D%s", BROWSER_TYPE_PROPERTY, BROWSER_TYPE_PROPERTY));
        }

        DriverType driverType = DriverType.getDriverTypeByPropertyName(typeProperty);


        return driverType;
    }

    public String getDriverPath(DriverType type) {

        String driverPath = System.getProperty(DRIVER_PROPERTY);

        switch (type) {
            case CHROME: {
                String chromePath = System.getProperty("webdriver.chrome.driver");
                if (chromePath == null || chromePath.isEmpty()) {
                } else {
                    driverPath = chromePath;
                }
                break;
            }
            case FIREFOX:
                String firefoxPath = System.getProperty("webdriver.gecko.driver");
                if (firefoxPath == null || firefoxPath.isEmpty()) {
                } else {
                    driverPath = firefoxPath;
                }
                break;


        }
        if (driverPath == null || driverPath.equals("")) {
            throw new RuntimeException("Path to driver isn't set!");
        }
        return driverPath;


    }

    /**
     * Creating web driver for specific browser based on system property "browser"
     *
     * @return WebDriver
     */
    public WebDriver createDriver(DriverType type) {
        WebDriver driver = null;

        String driverPath = getDriverPath(type);

        if (driverPath.equals("")) {
            throw new RuntimeException(String.format("System property for driver %s wasn't set! Set system property -D%s", DRIVER_PROPERTY, DRIVER_PROPERTY));
        }

        switch (type) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", driverPath);
                setDriver(_driver = new ChromeDriver());
                _driver.manage().window().maximize();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", driverPath);
                setDriver(_driver = new FirefoxDriver());
                _driver.manage().window().maximize();
                break;
        }


        return driver;

    }


}