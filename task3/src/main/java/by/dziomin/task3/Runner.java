package by.dziomin.task3;

import by.dziomin.task3.exception.ServiceException;
import by.dziomin.task3.service.DataReader;
import by.dziomin.task3.service.TextCreator;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import static by.dziomin.task3.settings.ProgramSettings.TEXT_FILE_PATH;

/**
 * Main class.
 */
public class Runner {
    /**
     * main method.
     * @param args
     * @throws ServiceException
     */
    public static void main(String[] args) throws ServiceException {
        List<String> textLines =
                DataReader.getInstance().readFile(TEXT_FILE_PATH);

        Logger loger = Logger.getLogger(Runner.class);

        loger.info(textLines);
        String text = new TextCreator().concatLines(textLines);
        loger.info(text);
    }

    private static void Localize() {
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

