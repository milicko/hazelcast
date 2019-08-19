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
public class MapsTabTests extends BaseTest {
    HomeView homeView = new HomeView(this);

    @Before
    public void login() {
        openBrowser(Constants.BASE_URL);
        Login login = new Login(this);

        login.setUsername(Constants.USERNAME).setPassword(Constants.PASSWORD).login();
    }

    @Test
    public void verifyValueFromEntries() {

        String mapName = "default";


        homeView.selectMapsTab().verifyEntityValue(mapName, 110);

    }

    @After
    public void logoutAndCloseBrowser() {

        homeView.logOut();
        closeBrowser();
    }


}
