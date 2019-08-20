package hazelcast.views;

import base.BaseTest;
import base.BaseTable;

public class MapsView extends HomeView {
    public static final String COLUMN_ENTRIES = "Entries";


    /**
     * This method verifies value form column Entries by name of the map in table
     *
     * @param mapName       - name of the map from witch you want to verify Entries
     * @param expectedValue - value that you expect in Entries column for specific map
     * @return MapsView
     */
    public MapsView verifyEntityValue(String mapName, int expectedValue) {
        getTable().verifyValueForRowAndColumn(mapName, COLUMN_ENTRIES, expectedValue);
        return this;
    }

    private BaseTable getTable() {
        return new BaseTable();
    }

}
