package control;

import account.StartPage;

public class Main {

    public static void main(String[] args) {
        try {
            var startPage = new StartPage(1000, 700);
            startPage.initComponent();
            startPage.setBtnEvent();

        } catch (Exception e) {
        } finally {
        }
    }
}