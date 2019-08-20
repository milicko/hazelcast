package base;

public class Views extends BaseTest {

    public static final String MAPS_TAB_LOCATOR_TEMPLATE = "//div[@id='sidebar-menu']//a[@data-test='%s']";


    /**
     * This method clicks on a tab, it finds element by data-test parm and clicks on that element
     *
     * @param dataTest - data-test parm
     */
    protected void selectTab(String dataTest) {
        click(String.format(MAPS_TAB_LOCATOR_TEMPLATE, dataTest));
    }


}
