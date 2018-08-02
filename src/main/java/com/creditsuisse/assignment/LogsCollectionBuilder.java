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
                            obj.getLong("timestamp"), hostName, typeOfMessage, false));

                } else {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return logList;
    }

    public void setTheAlertFlagsForDelayedEvents(List <ServerLog> list) {

        long timeDifference = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(i).getId().equals(list.get(j).getId())) {
                    if (!list.get(i).getState().equals(list.get(j).getState())) {
                         if (list.get(i).getState().toUpperCase().equals("STARTED")) {
                             timeDifference = list.get(j).getTimestamp() - list.get(i).getTimestamp();
                         } else {
                             timeDifference = list.get(i).getTimestamp() - list.get(j).getTimestamp();
                         }
                    }
                }
                if (timeDifference > 4)  {
                    list.get(i).setAlertFlag(true);
                    list.get(j - 1).setAlertFlag(true);
                    timeDifference = 0;

                    System.out.println(list.get(i).getId() + " " + list.get(i).isAlertFlag());
                    System.out.println(list.get(j-1).getId() + " " + list.get(j-1).isAlertFlag());
                    break;
                } else if (timeDifference <= 4) {
                    list.get(i).setAlertFlag(false);
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

    public void sortList(List <ServerLog> list) {

        List <ServerLog> sortedList = new ArrayList <>();

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getId().compareTo(list.get(j).getId()) > 0) {
//                    //... Exchange elements in first array
//                    String temp = list.get(i).getId();
//                    list.set(i, list.get(j));
//                    list.set(j, temp);
                    ServerLog temp = list.get(i);
                    //... Exchange elements in second array
                    // temp = sortedList.get(i).getId();
                    sortedList.set(i, list.get(j));
                    sortedList.set(j, temp);
                }

            }
        }

        for (int i = 0; i < sortedList.size() - 1; i++) {

            System.out.println(sortedList.get(i));

        }
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
            return Optional.of("null");
        } else {
            return Optional.of(log.getString("host"));
        }
    }

    public static Optional <String> WrapTypeOfMessageLog(JSONObject log) throws JSONException {
        if (log.getString("type").isEmpty()) {
            return Optional.of("null");
        } else {
            return Optional.of(log.getString("type"));
        }
    }
}

