package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


/**
 * @author Milic Bogiceivc
 */
public class Base extends BaseTest {

    public Base(BaseTest driver) {
    }

    public WebDriver getDriver() {
        return _driver;
    }


    /**
     * This method verifies that element is visible, method waits for 5 seconds for element to appear if element doesn't appear in 5 seconds method will fail
     *
     * @param locator - xpath locator to the element
     */
    public void waitForVisible(final String locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

    }

    /**
     * This method clicks on specific element
     *
     * @param locator - xpath locator to the element
     */
    public void click(String locator) {
        _driver.findElement(By.xpath(locator)).click();
    }

    /**
     * This method types specific text to desired input field
     *
     * @param locator     - xpath locator to the element
     * @param text4typing - text that you want to type in input field
     */
    public void typeKeys(String locator, String text4typing) {
        _driver.findElement(By.xpath(locator)).sendKeys(text4typing);
    }

    /**
     * This method verifies value from specific input field, it gets value from input field and it asserts that expected value matches with actual value in input field
     *
     * @param locator       - xpath locator to the element
     * @param expectedValue - value that you expect to be in input field
     */
    public void verifyValue(String locator, String expectedValue) {
        String actualValue = _driver.findElement(By.xpath(locator)).getAttribute("value");
        assertEquals("Value isn't as expected!", expectedValue, actualValue);
    }

    /**
     * This method verifies that specific field has focus by finding desiered field by locator and it checks is that element active by activeElement() webDriver method
     *
     * @param locator - xpath locator to the element
     * @param focused - boolean, if boolean is true then you expect that input is focused, if boolean is false then you don't expect field to be focused
     */
    public void verifyInputIsFocused(String locator, boolean focused) {

        WebElement element = _driver.findElement(By.xpath(locator));

        boolean isFocused = element.equals(_driver.switchTo().activeElement());

        if (focused) {
            assertEquals(String.format("Input for locator %s, isn't focused, you expected it to be focused!", locator), true, isFocused);
        } else {
            assertEquals(String.format("Input for locator %s, is focused, you expected it not to be focused!", locator), false, isFocused);
        }


    }

    public void clear(String locator) {
        _driver.findElement(By.xpath(locator)).clear();
    }

}
