package hazelcast.views;


import base.BaseTest;
import base.Views;
import hazelcast.Login;
import hazelcast.views.MapsView;

public class HomeView extends Views {
    public HomeView(BaseTest _driver) {
        super(_driver);

    }

    private String LOGOUT_LOCATOR = "//a[@data-test='logout']";


    /**
     * This method clicks on Maps tab in Side menu
     *
     * @return MapsView
     */
    public MapsView selectMapsTab() {
        selectTab("menu-maps");
        return new MapsView(this);
    }

    /**
     * This method clicks on Log out button in Home View
     *
     * @return Login
     */
    public Login logOut() {
        click(LOGOUT_LOCATOR);
        return new Login(this);
    }


}
