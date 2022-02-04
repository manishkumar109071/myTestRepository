package com.myAssignment.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        String filePath = JSONFileRetriever.getTheJsonPath();
        JSONFileRetriever myJsonFile = new JSONFileRetriever(filePath);
        if (!myJsonFile.isJSONFileExists() || !myJsonFile.isJSONFile()) {
            throw new FileNotFoundException("Requested file not available on path: "
                    + filePath);
        }
        
        File myFile = myJsonFile.getFile();
        LogsCollectionBuilder listBuilder = new LogsCollectionBuilder();
        List <ServerLog> arr = listBuilder.parseFile(myFile);
        listBuilder.setTheAlertFlagsForDelayedEvents(arr);
        
        
        HSQLDatabase.exportToDatabase(arr);
        if (LogsCollectionBuilder.isPreviewLogApproved()) {
            listBuilder.getTheEventList(arr, 3);
        }
        System.out.println("Total Records Processed : "+arr.stream().count());
        System.out.println("Process has been successfully finished!");
    }
}