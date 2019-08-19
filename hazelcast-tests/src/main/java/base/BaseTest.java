package base;

import driver.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

/**
 * @author Milic Bogiceivc
 */
public class BaseTest {
    private static final String BROWSER_TYPE_PROPERTY = "browser";
    private static final String DRIVER_PROPERTY = "driver.path";

    public WebDriver getDriver() {
        return _driver;
    }

    public void setDriver(WebDriver driver) {
        this._driver = driver;
    }

    public static WebDriver _driver;


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


        String driverPath = System.getProperty(DRIVER_PROPERTY);

        switch (type) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", driverPath);
                setDriver(_driver = new ChromeDriver());
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", driverPath);
                setDriver(_driver = new FirefoxDriver());
                break;
        }


        return driver;

    }


    /**
     * This method calls createDriver method to create driver for browser that you want to use and it opens url in opened browser window
     *
     * @param url - url that you want to open
     */
    public void openBrowser(String url) {
        createDriver(determineDriverType());
        getDriver().get(url);
    }

    /**
     * This method closes browser
     */
    public void closeBrowser() {
        getDriver().quit();
    }


}
