package com.creditsuisse.assignment;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class LogsCollectionBuilderTest {

    private File file;
    private LogsCollectionBuilder logObj;
    private static int counter = 1;
    private static List <ServerLog> testList;
    private LogsCollectionBuilder lcb;

    @org.junit.Before
    public void setup() {
        lcb = new LogsCollectionBuilder();
        file = new File("src/sourcefile/log.json");
        System.out.println("Running a test nr: " + counter + " from a " + this.getClass().getSimpleName());
        counter++;
    }
    @Test
    public void setTheAlertFlagsForDelayedEvents_checkFlags() {
        ServerLog firstTestLog = new ServerLog("scsmbstgra", "STARTED", 1491377495212L,
                "12345", "APPLICATION_LOG");
        ServerLog secondTestLog = new ServerLog("scsmbstgra", "FINISHED", 1491377495218L,
                "12345", "APPLICATION_LOG");
        testList = new ArrayList <>();
        testList.add(firstTestLog);
        testList.add(secondTestLog);
        logObj.setTheAlertFlagsForDelayedEvents(testList);
        assertEquals(true, firstTestLog.isAlertFlag());
    }

    @Before
    public void parseFile() {
        logObj = new LogsCollectionBuilder();
        testList = new ArrayList <>();
        testList = logObj.parseFile(file);
    }

    @Test
    public void isTypeOfMessageAvailable() {
        JSONObject obj = new JSONObject(testList.get(0));
        boolean result = logObj.isTypeOfMessageAvailable(obj);
        assertTrue("The 'TYPE' key has not been found in .json file.", result);
    }

    @Test
    public void isHostNameAvailable() {
        JSONObject obj = new JSONObject(testList.get(0));
        boolean result = logObj.isHostNameAvailable(obj);
        assertTrue("The 'HOST' key has not been found in .json file.", result);
    }
}