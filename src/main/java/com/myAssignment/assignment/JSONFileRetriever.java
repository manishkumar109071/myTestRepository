package com.myAssignment.assignment;

import java.io.File;
import java.util.Scanner;

public class JSONFileRetriever {

    private static final String JSON_FILE_PATH = "src/sourcefile/log.json";
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

    public static String getTheJsonPath() {

        boolean isCorrectInput = false;
        String userInput = "";
        System.out.print("Do you want to specify the .json file? Select -> (Y/N) ");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.nextLine();

        while (isCorrectInput == false) {
            switch (userAnswer.toLowerCase()) {
                case "y": {
                    System.out.print("Please provide the Json file file path: ");
                    userInput = scanner.nextLine();
                    isCorrectInput = true;
                    break;
                }
                case "n": {
                    System.out.print("Default file path has been applied\n" );
                    userInput = JSON_FILE_PATH;
                    isCorrectInput = true;
                    break;
                }
                default:
                    System.out.println("Please try again:");
                    userAnswer = scanner.nextLine();
                    break;
            }
        }
        return userInput;
    }
}
