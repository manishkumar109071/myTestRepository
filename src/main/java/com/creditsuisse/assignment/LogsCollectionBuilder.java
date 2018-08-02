package com.creditsuisse.assignment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class LogsCollectionBuilder implements Parsable <File> {

    private File file;
    private static List <ServerLog> logList;

    @Override
    public List <ServerLog> parseFile(File f) {

        this.file = f;
        Pattern pattern = Pattern.compile("}");
        String hostName = "";
        String typeOfMessage = "";
        logList = new ArrayList <>();
        try (Scanner input = new Scanner(file).useDelimiter(pattern)) {
            while (input.hasNext()) {
                String line = input.next().trim();
                if (line != "") {
                    JSONObject obj = new JSONObject(line + "}");
                    String checkLog = obj.toString();
                    if (!checkLog.contains("host")) {
                        hostName = "N/A";
                    } else {
                        hostName = obj.getString("host");
                    }
                    if (!checkLog.contains("type")) {
                        typeOfMessage = "N/A";
                    } else {
                        typeOfMessage = obj.getString("type");
                    }
                    logList.add(new ServerLog(obj.getString("id"), obj.getString("state"),
                            obj.getLong("timestamp"), hostName, typeOfMessage));
                } else {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The .json file in the path: (")
                .append(this.file)
                .append(") has been successfully scanned.\n")
                .append("All of the logs (")
                .append(logList.size())
                .append(") are collected in a list.");
        System.out.println(sb);
        return logList;
    }

    public void setTheAlertFlagsForDelayedEvents(List <ServerLog> list) {

        long timeDifference = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 1; j < list.size(); j++) {
                if (list.get(i).getId().equals(list.get(j).getId())) {
                    if (!list.get(i).getState().equals(list.get(j).getState())) {
                        if (list.get(i).getState().toUpperCase().equals("STARTED")) {
                            timeDifference = list.get(j).getTimestamp() - list.get(i).getTimestamp();
                        } else {
                            timeDifference = list.get(i).getTimestamp() - list.get(j).getTimestamp();
                        }
                    }
                }
                if (timeDifference > 4) {
                    list.get(i).setAlertFlag(true);
                    list.get(i).setProcessedTime((int) timeDifference);
                    list.get(j - 1).setAlertFlag(true);
                    list.get(j - 1).setProcessedTime((int) timeDifference);

                    timeDifference = 0;
                    break;
                } else if (timeDifference <= 4) {
                    if (list.get(j).getId().equals(list.get(0).getId())) {
                        list.get(j).setProcessedTime(list.get(0).getProcessedTime());
                    }
                    if (list.get(i).getId().equals(list.get(j).getId())) {
                        list.get(i).setAlertFlag(false);
                        list.get(i).setProcessedTime((int) timeDifference);
                        list.get(j).setAlertFlag(false);
                        list.get(j).setProcessedTime((int) timeDifference);
                    }
                }
            }
        }
    }

    public static boolean isHostNameAvailable(JSONObject log) {
        try {
            if (log.getString("host") == null) {
                return false;
            } else {
                return true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isTypeOfMessageAvailable(JSONObject log) {
        try {
            if (log.getString("type") == null) {
                return false;
            } else {
                return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Optional <String> WrapHostLog(JSONObject log) throws JSONException {
        if (log.getString("host").isEmpty()) {
            return Optional.of("");
        } else {
            return Optional.of(log.getString("host"));
        }
    }
    public static Optional <String> WrapTypeOfMessageLog(JSONObject log) throws JSONException {
        if (log.getString("type").isEmpty()) {
            return Optional.of("");
        } else {
            return Optional.of(log.getString("type"));
        }
    }
}

