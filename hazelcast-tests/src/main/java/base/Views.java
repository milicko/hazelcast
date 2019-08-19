package base;

public class Views extends Base {

    public Views(BaseTest _driver) {
        super(_driver);

    }

    private String MAPS_TAB(String dataTest) {
        return String.format("//div[@id='sidebar-menu']//a[@data-test='" + dataTest + "']");
    }


    /**
     * This method clicks on a tab, it finds element by data-test parm and clicks on that element
     *
     * @param dataTest - data-test parm
     */
    protected void selectTab(String dataTest) {
        click(MAPS_TAB(dataTest));
    }


}
