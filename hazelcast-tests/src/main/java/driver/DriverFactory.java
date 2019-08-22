package driver;


import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DriverFactory {


    private static final String BROWSER_TYPE_PROPERTY = "browser";
    private static final String DRIVER_PROPERTY = "driver.path";
    private static final String REMOTE_DRIVER = "remote.driver";

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


    /**
     * Creating web driver for specific browser based on system property "browser"
     *
     * @return WebDriver
     */
    public WebDriver createDriver(DriverType type) {
        WebDriver driver = null;
        String driverPath = System.getProperty(DRIVER_PROPERTY);
        String remoteDriver = System.getProperty(REMOTE_DRIVER);
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (remoteDriver.contains("true")) {
            capabilities.setVersion("latest");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);
        }


        switch (type) {
            case CHROME:
                if (remoteDriver.equals("true")) {
                    capabilities.setBrowserName("chrome");
                    try {
                        setDriver(_driver = new RemoteWebDriver(new URI("http://selenoid:4444/wd/hub").toURL(), capabilities));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.setProperty("webdriver.chrome.driver", driverPath);
                    setDriver(_driver = new ChromeDriver());
                }
                _driver.manage().window().maximize();
                break;
            case FIREFOX:
                if (remoteDriver.equals("true")) {
                    capabilities.setBrowserName("firefox");

                    try {
                        setDriver(_driver = new RemoteWebDriver(new URI("http://selenoid:4444/wd/hub").toURL(), capabilities));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {

                    System.setProperty("webdriver.gecko.driver", driverPath);
                    setDriver(_driver = new FirefoxDriver());
                }
                _driver.manage().window().maximize();
                break;

        }

        return driver;

    }


}