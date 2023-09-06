package com.event.management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * FileHandle
 */
public class FileHandle {
    protected static final String DATA_FOLDER = ".database";
    protected static final String LOGGED_IN_USERNAME = ".loggedin_username.txt";
    protected static final String REGISTERED_USER = ".registered_users.txt";

    protected static boolean isAlreadyLoggedIn() {
        if (!isExists(DATA_FOLDER + "/" + LOGGED_IN_USERNAME) &&
                !isExists(DATA_FOLDER + "/" + REGISTERED_USER))
            return false;

        boolean userFound = false;

        File logFile = null;
        Scanner scanner = null;

        try {
            logFile = new File(DATA_FOLDER + "/" + LOGGED_IN_USERNAME);
            scanner = new Scanner(logFile);

            scanner.next();
            if (scanner.hasNextLine())
                userFound = true;

        } catch (FileNotFoundException e) {
            return false;
        } catch (Exception e) {
            resetFile(LOGGED_IN_USERNAME, "username");
        } finally {
            if (scanner != null)
                scanner.close();
        }

        return userFound;
    }

    protected static boolean isExists(String path) {
        return new File(path).exists();
    }

    protected static void createDir(String dir) {
        File path = new File(dir);

        if (!path.exists())
            path.mkdir();
    }

    protected static void resetFile(String filePath, String outpuString) {

        createDir(DATA_FOLDER);

        FileWriter fr = null;

        try {
            fr = new FileWriter(DATA_FOLDER + "/" + filePath);
            fr.write(outpuString);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (Exception e) {
            }
        }

    }
}
