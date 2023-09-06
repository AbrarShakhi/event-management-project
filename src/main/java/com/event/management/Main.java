package com.event.management;

public final class Main {
    private Main() {
    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.setVisible(true);
    }

}
