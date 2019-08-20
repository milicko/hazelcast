import base.BaseTest;
import hazelcast.views.HomeView;
import hazelcast.Login;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test suite is created for maps tab. Test suite contains @Before test where you open browser and login with specific user
 * and @After test where you logout and close browser, test needs to log out at the end because same user cannot be logged in if he
 * was already logged on other browser, suite also contains one test for verifying value from Entries column in Maps tab
 *
 * @author Milic Bogicevic
 */
public class MapsTabTests {

    public HomeView login() {
        Login login = new Login();
        login.openBrowser(Constants.BASE_URL);
        return login.setUsername(Constants.USERNAME).setPassword(Constants.PASSWORD).login();
    }

    @Test
    public void verifyValueFromEntries() {
        String mapName = "default";

        HomeView homeView = login();
        homeView.selectMapsTab().verifyEntityValue(mapName, 100);

    }

    @After
    public void logoutAndCloseBrowser() {

        HomeView homeView = new HomeView();
        homeView.logOut().closeBrowser();
    }


}
