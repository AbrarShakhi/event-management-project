package control;

import people.*;
import event_type.*;

public class Main {
    public static void main(String[] args) {
        // var init = new Initialization();
        // if (!init.welcome()) return;

        // it will give a choice to select an event either a birthday, Confrence, Wedding or costiom.

        var birthday = new Birthday("Red", "cake", "23 august");
        System.out.println( birthday.getThemeColor() +
        birthday.getFood() +
        birthday.getDateOfEvent());
      
    }
}

