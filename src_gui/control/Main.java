package control;

import account.StartPage;

public class Main {

    public static void main(String[] args) {
        try {
            var startPage = new StartPage(1000, 700);
            startPage.initComponent();
            startPage.btnEvent();
            if (startPage.getValidUser()){
                // do next part
            }

        } catch (Exception e) {
        } finally {
        }
    }
}