package control;

import people.*;
import event_type.*;

public class Main {
    public static java.util.Scanner input = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        try {
            if (!welcome())
                return;

            /*
             * First It will take username, password, and make an as silmple as an user
             * account.
             * then it will show that user to choose a template.
             * once that choosing is done then User will have that information
             * 
             * ///////////// Then (Thinking) ///////////////
             * 
             */

        } finally {
            input.close();
        }
    }

    public static void showTemplate() {
        System.out.println("What kind of event are you planning for?");
        System.out.println();
        System.out.println("1. Birthday");
        System.out.println("2. Conference");
        System.out.println("3. Wedding");
        System.out.println("4. no selection");

        boolean done;
        int ans;

        do {
            System.out.print("Enter your choice: ");
            done = false;
            try {
                ans = input.nextInt();
                switch (ans) {
                    case 1 -> {
                        // his/her choice is Birthday
                    }
                    case 2 -> {
                        // choice is Conference
                    }
                    case 3 -> {
                        // choice is Wedding
                    }
                    case 4 -> {
                        // choice is no selection
                    }
                    default -> {
                        System.out.println("Invalid Input");
                        done = true;
                    }
                }
            } catch (Exception e) {
                System.out.println("Something went wrong");
                done = false;
            }

        } while (done);

    }

    public static boolean welcome() {
        System.out.println("***************************************************");
        System.out.println("***   Welcome to Event Management Application   ***");
        System.out.println("***************************************************");
        System.out.println();

        boolean done;
        String ans;

        do {
            System.out.print("Enter 'GO' to start 'exit' to cancel: ");
            done = false;
            ans = input.next().toLowerCase();
            if (ans.equals("go"))
                return true;
            else if (ans.equals("exit"))
                return false;
            else {
                System.out.println("Invalid input");
                done = true;
            }
        } while (done);

        return false;
    }
}
