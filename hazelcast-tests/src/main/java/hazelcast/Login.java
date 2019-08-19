package hazelcast;

import base.Base;
import base.BaseTest;
import hazelcast.views.HomeView;

public class Login extends Base {
    public Login(BaseTest _driver) {
        super(_driver);

    }

    private String LOCATOR_PASSWORD = "//input[@name='password']";
    private String LOCATOR_USERNAME = "//input[@name='username']";
    private String LOCATOR_LOGIN = "//button[@type='submit']";

    /**
     * This method sets username in username input
     *
     * @param username - username that you want to enter
     * @return - Login
     */
    public Login setUsername(String username) {
        typeKeys(LOCATOR_USERNAME, username);
        return this;
    }

    /**
     * This method sets password in password field
     *
     * @param password - password that you want to enter
     * @return Login
     */
    public Login setPassword(String password) {
        typeKeys(LOCATOR_PASSWORD, password);
        return this;
    }

    /**
     * This method clicks on Login button
     *
     * @return Home View
     */
    public HomeView login() {
        click(LOCATOR_LOGIN);
        return new HomeView(this);
    }
}
