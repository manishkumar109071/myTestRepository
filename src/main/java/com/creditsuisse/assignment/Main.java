package com.creditsuisse.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    //for testing purposes assigned fixed file path
    public static final String FILE_PATH = "C:\\Users\\Hubert\\Desktop\\log.json";

    public static void main(String[] args) throws FileNotFoundException {

        //String filePath = JsonFileLog.inputTheFilePath();
        JSONFileRetriever myJsonFile = new JSONFileRetriever(FILE_PATH);
        if (!myJsonFile.isJSONFileExists() || !myJsonFile.isJSONFile()) {
            throw new FileNotFoundException("The JSON file has not been found in the following path: "
                    + FILE_PATH);
        }
        File myFile = myJsonFile.getFile();
        LogsCollectionBuilder listBuilder = new LogsCollectionBuilder();
        List <ServerLog> arr = listBuilder.parseFile(myFile);
        listBuilder.setTheAlertFlagsForDelayedEvents(arr);

        for (int i = 0; i < arr.size() ; i++) {

            System.out.println(arr.get(i).toString() + "\n");

        }


    }
}
