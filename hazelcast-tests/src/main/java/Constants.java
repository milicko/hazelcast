public class Constants {


    public static String getBaseUrl() {
        String baseUrl = null;
        if (System.getProperty("remote.driver").equals("true")) {
            baseUrl = "http://" + System.getenv("APP_IP") + ":8081/mancenter";
        } else {
            baseUrl = BASE_URL;
        }
        return baseUrl;
    }

    public static final String BASE_URL = "http://localhost:8081/mancenter";


    public static final String USERNAME = "mbogicevic";
    public static final String PASSWORD = "password1!";


}
