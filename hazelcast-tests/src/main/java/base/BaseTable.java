package base;

import base.Base;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

import java.util.List;

public class BaseTable extends Base {
    public BaseTable(BaseTest _driver) {
        super(_driver);

    }


    private int getRow(String name) {

        List<WebElement> elements = getDriver().findElements(By.xpath("//div[@class='rt-thead -header']//div[@class='rt-tr']"));

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

    public void verifyValueForRowAndColumn(String mapName, String columnName, int expectedValue) {

        String text = getDriver().findElement(By.xpath("//a[text()='" + mapName + "']/ancestor::div[@class='rt-tr -odd']/div[" + getRow(columnName) + "]")).getText();

        assertEquals(String.format("Value for map '%s;, from column: %s, isn't as expected!", mapName, columnName), Integer.toString(expectedValue), text);
    }


}
