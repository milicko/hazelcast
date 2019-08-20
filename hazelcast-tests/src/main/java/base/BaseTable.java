package base;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

import java.util.List;

public class BaseTable extends BaseTest {


    private int getRow(String name) {

        List<WebElement> elements = getDriver().findElements(By.xpath("//div[@class='rt-thead -header']//div[@class='rt-tr']"));

        if (elements.size() == 0) {
            throw new RuntimeException(String.format("Element isn't found for row %s!", name));
        }

        int i = 1;
        for (WebElement el : elements) {
            if (el.getText().equals(name)) {
                return i;
            } else {
                i++;
            }

        }
        return i;
    }

    /**
     * Method verifies value from specific row (map) for specific column
     *
     * @param mapName       - name of map for witch you want to verify value
     * @param columnName    - name of column
     * @param expectedValue - int value that you expect
     */
    public void verifyValueForRowAndColumn(String mapName, String columnName, int expectedValue) {

        String text = getDriver().findElement(By.xpath("//a[text()='" + mapName + "']/ancestor::div[@class='rt-tr -odd']/div[" + getRow(columnName) + "]")).getText();

        assertEquals(String.format("Value for map '%s;, from column: %s, isn't as expected!", mapName, columnName), Integer.toString(expectedValue), text);
    }


}
