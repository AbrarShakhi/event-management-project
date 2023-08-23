package control;

import java.util.Scanner;

public class AccountLogic {
    private String fName;
    private String lName;
    private String uName;
    private String pWord;

    public void takeInfo(Scanner in) {
        System.out.print("Enter your first name: ");
        fName = in.nextLine();
        System.out.print("Enter your last name: ");
        lName = in.nextLine();
        System.out.print("Enter your username: ");
        uName = in.nextLine();
        System.out.print("Enter your password: ");
        pWord = in.nextLine();
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getuName() {
        return uName;
    }

    public String getpWord() {
        return pWord;
    }

}
