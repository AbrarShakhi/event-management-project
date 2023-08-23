package control;

/*
* :
* First It will take username, password, and make an as silmple as an user
* account.
* then it will show that user to choose a template.
* once that choosing is done then User will have that information
* 
* ///////////// Then (Thinking) ///////////////
* 
*/

import people.*;
import event_type.*;

public class Main {
    public static java.util.Scanner input = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        try {
            if (!welcome())
                return;

            // To make it more simple we have not created sign in, up, out yet. We will
            // create it leter.
            // we will only ask user to enter their name and info.

            var acc = new AccountLogic();
            acc.takeInfo(input);
            var user = new User(acc.getfName(), acc.getlName(), acc.getuName(), acc.getpWord());
            user.setEvent(showTemplate());

            var price = new Price();
            price.calculate(user);
            System.out.print("Total price is " + price.getTotalPrice());

        } finally {
            input.close();
        }
    }

    public static Event showTemplate() {
        System.out.println();
        System.out.println("What kind of event are you planning for?");
        System.out.println("1. Birthday");
        System.out.println("2. Conference");
        System.out.println("3. Wedding");
        System.out.println("4. no selection");

        boolean done;
        int ans;
        Event event = new Event();

        do {
            System.out.print("Enter your choice: ");
            done = false;
            try {
                ans = input.nextInt();

                switch (ans) {
                    case 1 -> {
                        setEvent(event);
                    }
                    case 2 -> {
                        setEvent(event);
                    }
                    case 3 -> {
                        setEvent(event);
                    }
                    case 4 -> {
                        setEvent(event);
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

        return event;
    }

    public static void setEvent(Event event) {
        System.out.print("What is you theme color: ");
        event.setThemeColor(input.nextLine());

        System.out.print("How many food idtem do you want: ");
        String[] fitem = new String[input.nextInt()];

        for (int i = 0; i < fitem.length; i++) {
            System.out.printf("%d: ", i + 1);
            fitem[i] = input.nextLine();
        }
        event.setFood(fitem);

        System.out.println("Enter the date of the event: ");
        event.setDateOfEvent(input.nextLine());
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
            ans = input.nextLine().toLowerCase();
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
