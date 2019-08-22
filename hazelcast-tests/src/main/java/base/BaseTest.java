package base;

import driver.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * @author Milic Bogiceivc
 */
public class BaseTest {


    DriverFactory driverFactory = new DriverFactory();

    WebDriver getDriver() {
        return driverFactory.getDriver();
    }


    /**
     * This method calls createDriver method to create driver for browser that you want to use and it opens url in opened browser window
     *
     * @param url - url that you want to open
     */
    public void openBrowser(String url) {
        getDriver().get(url);
    }

    /**
     * This method closes browser
     */
    public void closeBrowser() {
        getDriver().quit();
    }


    /**
     * This method verifies that element is visible, method waits for 5 seconds for element to appear if element doesn't appear in 5 seconds method will fail
     *
     * @param locator - xpath locator to the element
     */
    public void waitForVisible(final String locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

    }

    /**
     * This method clicks on specific element
     *
     * @param locator - xpath locator to the element
     */
    public void click(String locator) {
        getDriver().findElement(By.xpath(locator)).click();
    }

    /**
     * This method types specific text to desired input field
     *
     * @param locator     - xpath locator to the element
     * @param text4typing - text that you want to type in input field
     */
    public void typeKeys(String locator, String text4typing) {
        getDriver().findElement(By.xpath(locator)).sendKeys(text4typing);
    }

    /**
     * This method verifies value from specific input field, it gets value from input field and it asserts that expected value matches with actual value in input field
     *
     * @param locator       - xpath locator to the element
     * @param expectedValue - value that you expect to be in input field
     */
    public void verifyValue(String locator, String expectedValue) {
        String actualValue = getDriver().findElement(By.xpath(locator)).getAttribute("value");
        assertEquals("Value isn't as expected!", expectedValue, actualValue);
    }


    /**
     * This method clears value from input field
     *
     * @param locator - xpath locator to the element
     */
    public void clear(String locator) {
        getDriver().findElement(By.xpath(locator)).clear();
    }


}
