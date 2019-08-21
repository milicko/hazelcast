package hazelcast;

import base.BaseTest;
import hazelcast.views.HomeView;
import hazelcast.views.StatusView;

public class Login extends BaseTest {

    public static final String INPUT_LOCATOR_TEMPLATE = "//input[@name='%s']";
    private String LOCATOR_LOGIN = "//button[@type='submit']";

    /**
     * This method sets username in username input
     *
     * @param username - username that you want to enter
     * @return - Login
     */
    public Login setUsername(String username) {
        waitForVisible(String.format(INPUT_LOCATOR_TEMPLATE, "username"));
        typeKeys(String.format(INPUT_LOCATOR_TEMPLATE, "username"), username);
        return this;
    }

    /**
     * This method sets password in password field
     *
     * @param password - password that you want to enter
     * @return Login
     */
    public Login setPassword(String password) {
        typeKeys(String.format(INPUT_LOCATOR_TEMPLATE, "password"), password);
        return this;
    }

    /**
     * This method clicks on Login button
     *
     * @return Home View
     */
    public StatusView login() {
        click(LOCATOR_LOGIN);
        return new StatusView();
    }
}
