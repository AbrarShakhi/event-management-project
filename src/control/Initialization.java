package control;

import java.util.Scanner;

public class Initialization {
    public boolean welcome() {
        var in = new Scanner(System.in);

        System.out.println("***************************************************");
        System.out.println("***   Welcome to Event Management Application   ***");
        System.out.println("***************************************************");
        System.out.println();

        boolean done;
        String ans = "";

        do {
            System.out.print("Enter 'GO' to start 'exit' to cancel: ");
            done = false;
            ans = in.next().toLowerCase();
            if (ans.equals("go")) {
                return true;
            } else if (ans.equals("exit")) {
                return false;
            } else
                done = true;
        } while (done);

        return false;
    }
}