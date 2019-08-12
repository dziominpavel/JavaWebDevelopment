package by.dziomin.task3;

import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {
    public static void main(String[] args) {

        int number = 2;
        String country = "";
        String language = "";

        switch (number) {
            case 1:
                language = "en";
                country = "US";
                break;
            case 2:
                language = "ru";
                country = "RU";
                break;
        }


        Locale current = new Locale(language, country);
        ResourceBundle rb = ResourceBundle.getBundle("text",
                current);
        String s1 = rb.getString("str1");
        System.out.println(s1);
        String s2 = rb.getString("str2");
        System.out.println(s2);
    }
}

