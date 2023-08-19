package control;

public class Initialization {
    public boolean welcome() {
        System.out.println("***************************************************");
        System.out.println("***   Welcome to Event Management Application   ***");
        System.out.println("***************************************************");
        System.out.println();

        System.out.print("Enter 'yes' to start 'no' to cancel: ");
        return new java.util.Scanner(System.in).nextBoolean();
    }
}