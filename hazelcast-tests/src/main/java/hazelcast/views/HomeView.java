package hazelcast.views;


import base.Views;
import hazelcast.Login;

public class HomeView extends Views {

    public static final String LOGOUT_LOCATOR = "//a[@data-test='logout']";


    /**
     * This method clicks on Maps tab in Side menu
     *
     * @return MapsView
     */
    public MapsView selectMapsTab() {
        selectTab("menu-maps");
        return new MapsView();
    }

    /**
     * This method clicks on Log out button in Home View
     *
     * @return Login
     */
    public Login logOut() {
        click(LOGOUT_LOCATOR);
        return new Login();
    }


}
