package com.creditsuisse.assignment;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ServerLogTest {

    private ServerLog testLog;
    private static int counter = 1;

    @org.junit.Before
    public void setup() {
        testLog = new ServerLog("scsmbstgrxyz", "STARTED",
                1491377495212L, "123", "APPLICATION_LOG");
        System.out.println("Running a test nr: " + counter + " from a: " + this.getClass().getSimpleName());
        counter++;
    }

    @Test
    public void convertMillisecondsIntoDate_timeZero() {
        ServerLog testZero = new ServerLog("scsmbstgrxyz", "STARTED",
                0, "123", "APPLICATION_LOG");
        assertEquals("1970-01-01T01:00",
                testZero.convertMillisecondsIntoDate(testZero.getTimestamp()).toString());
    }

    @Test
    public void convertMillisecondsIntoDate_timeMinus() {
        ServerLog testZero = new ServerLog("scsmbstgrxyz", "STARTED",
                -51351252, "123", "APPLICATION_LOG");
        assertEquals("1969-12-31T10:44:08.748",
                testZero.convertMillisecondsIntoDate(testZero.getTimestamp()).toString());
    }

    @Test
    public void getLogInputDate() {
        LocalDateTime time = testLog.getLogInputDate();
        assertEquals(time, testLog.convertMillisecondsIntoDate(testLog.getTimestamp()));
    }

    @Test
    public void getLogInputDate_ForDefault() {
        ServerLog testLog = new ServerLog(null, null,
                0, null, null);
        LocalDateTime time = testLog.getLogInputDate();
        assertEquals(time, testLog.convertMillisecondsIntoDate(testLog.getTimestamp()));
    }

    @Test
    public void isAlertFlag() {
        assertFalse("The ending eventLog still has not been executed", testLog.isAlertFlag());
    }
}