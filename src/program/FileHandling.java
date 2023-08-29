package program;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileHandling {
    private final static String DIR = ".data";
    private final static String FILE_LOGEDIN = ".loged_in.txt";
    private final static String FILE_REGISTERED_USER = ".registered_user.txt";

    public static String[] findRegisteredUserInfo() {



        File logFile = null;
        Scanner scanner = null;

        boolean userFound = false;
        boolean run = true;

        while (run) {

            try {
                logFile = new File(DIR + "/" + FILE_REGISTERED_USER);
                scanner = new Scanner(logFile);
                scanner.next();
                if (scanner.hasNextLine())
                    userFound = true;
                run = false;

            } catch (FileNotFoundException e) {
                try {
                    run = FileHandling.createLogenIn();
                } catch (IOException e1) {
                    throw new IOException();
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
                throw new Exception();

            } finally {
                if (scanner != null)
                    scanner.close();
            }
        }


















        try {
            createADir(DIR);
        } catch (Exception e) {
        } finally {

        }

        return new String[] {};
    }

    public static boolean findLogedInUser() throws Exception {
        File logFile = null;
        Scanner scanner = null;

        boolean userFound = false;
        boolean run = true;

        do {

            try {
                logFile = new File(DIR + "/" + FILE_LOGEDIN);
                scanner = new Scanner(logFile);
                scanner.next();
                if (scanner.hasNextLine())
                    userFound = true;
                run = false;

            } catch (FileNotFoundException e) {
                try {
                    run = FileHandling.createLogenIn();
                } catch (IOException e1) {
                    throw new IOException();
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
                throw new Exception();

            } finally {
                if (scanner != null)
                    scanner.close();
            }
        } while (run);
        return userFound;
    }

    public static boolean createLogenIn() throws IOException {
        FileWriter fw = null;

        try {
            createADir(DIR);
            File file = new File(DIR + "/" + FILE_LOGEDIN);
            fw = new FileWriter(file.getAbsoluteFile());
            fw.write("username");

        } catch (IOException e) {
            throw new IOException();
        } finally {
            if (fw != null)
                fw.close();
        }
        return true;
    }

    public static boolean createADir(String dir) {
        File dataDir = new File(dir);
        return dataDir.mkdir();
    }
}
