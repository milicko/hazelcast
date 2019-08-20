package driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

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

        String driverPath = System.getProperty(DRIVER_PROPERTY);

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