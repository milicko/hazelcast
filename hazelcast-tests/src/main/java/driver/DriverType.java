package driver;

public enum DriverType {
    CHROME("chrome"), FIREFOX("firefox"), REMOTE("remote");

    /**
     * Returns driver type by name of the system property "browser"
     *
     * @param propertyName - system property "browser", name of the browser where you want to run your automated tests
     * @return enum DriverType, type of browser where you want to run your tests
     */
    public static DriverType getDriverTypeByPropertyName(String propertyName) {
        DriverType driver = null;
        for (DriverType driverType : DriverType.values()) {
            if (driverType.propertyName().equals(propertyName)) {
                driver = driverType;
                break;
            }
        }
        return driver;
    }

    private String _propertyName;

    private DriverType(String propertyName) {
        _propertyName = propertyName;
    }

    public String propertyName() {
        return _propertyName;
    }

}
