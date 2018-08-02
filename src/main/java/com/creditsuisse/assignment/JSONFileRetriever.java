package com.creditsuisse.assignment;

import java.io.File;
import java.util.Scanner;

public class JSONFileRetriever {

    private String jsonFilePath;
    private File file;

    public JSONFileRetriever(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;

        if (file == null) {
            this.file = new File(getJsonFilePath());
        } else {
            return;
        }
    }
    @Override
    public String toString() {
        return "JSON File name:  " + file.getName() +
                ". Path: " + file.getAbsolutePath();
    }

    public File getFile() {
        return file;
    }

    public String getJsonFilePath() {
        return jsonFilePath;
    }

    public void setJsonFilePath(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }

    public boolean isJSONFile() {
        String jsonFile = this.file.getName();
        String extension = jsonFile.substring(jsonFile.lastIndexOf("."));
        if (extension.equals(".json")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isJSONFileExists() {
        if (this.file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public static String inputTheFilePath() {

        System.out.println("Please input the file path: ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input the file path: ");
        String userInput = scanner.nextLine();
        scanner.close();
        return userInput;
    }
}
