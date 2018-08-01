package com.creditsuisse.assignment;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LogsCollectionBuilder implements Parsable <File> {

        private File file;
        private static List<ServerLog> logList;

        @Override
        public List <ServerLog> parseFile(File f) {

            this.file = f;
            Pattern pattern = Pattern.compile("}");
            String hostName = "";
            String typeOfMessage = "";
            logList = new ArrayList<>();

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
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return logList;
        }

        public List<ServerLog> sortTheCollection (List<ServerLog> list) {

            //MyCompararator comparator = new MyCompararator();
            return null;
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

        public static Optional<String> WrapHostLog(JSONObject log) throws JSONException {
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

