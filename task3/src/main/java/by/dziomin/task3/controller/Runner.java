package by.dziomin.task3.controller;

import by.dziomin.task3.controller.exception.ControllerException;
import by.dziomin.task3.service.LocalizationService;
import by.dziomin.task3.service.impl.LocalizationServiceImpl;
import org.apache.log4j.Logger;

import java.util.Scanner;


/**
 * Main class.
 */
public final class Runner {
    /**
     * default constructor.
     */
    private Runner() {
    }

    /**
     * main method.
     *
     * @param args args.
     */
    public static void main(final String[] args) {
        Logger logger = Logger.getLogger(Runner.class);
        TaskController controller = TaskController.getInstance();
        LocalizationService localizationService =
                LocalizationServiceImpl.getInstance();
        String[] localeParam = userDialog();
        try {
            controller.handleRequest(RequestType.CHANGE_LOCALE, localeParam[0],
                    localeParam[1]);

            //read from file
            Object text = controller.handleRequest(RequestType
                    .READ_TEXT_FROM_FILE);
            String logStr = localizationService
                    .getLocalizedMessage("READING.SOURCE_TEXT");
            logger.info(logStr);
            Object resultText =
                    controller.handleRequest(RequestType.CONCATENATE_TO_STRING,
                            text);
            logger.debug(resultText);

            //sort by sentence count
            text = controller.handleRequest(
                    RequestType.SORT,
                    "PARAGRAPHS_BY_SENTENCES_COUNT", text);
            logStr = localizationService
                    .getLocalizedMessage("SORT.BY_SENTENCES_COUNT");
            logger.info(logStr);
            resultText =
                    controller.handleRequest(
                            RequestType.CONCATENATE_TO_STRING, text);
            logger.debug(resultText);

            //sort by word length
            logStr = localizationService
                    .getLocalizedMessage("SORT.BY_WORDS_LENGTH");
            logger.info(logStr);
            text = controller.handleRequest(RequestType.SORT,
                    "WORDS_BY_WORD_LENGTH", text);
            resultText = controller.handleRequest(
                    RequestType.CONCATENATE_TO_STRING, text);
            logger.debug(resultText);

            //sort by word count
            text = controller.handleRequest(RequestType.SORT,
                    "SENTENCES_BY_WORD_COUNT", text);
            logStr = localizationService
                    .getLocalizedMessage("SORT.BY_WORDS_COUNT");
            logger.info(logStr);
            resultText = controller.handleRequest(
                    RequestType.CONCATENATE_TO_STRING, text);
            logger.debug(resultText);

            //sort by symbol count desc
            text = controller.handleRequest(RequestType.SORT,
                    "LEKSEMS_BY_SYMBOL_COUNT_DESC", text, "a");
            logStr = localizationService
                    .getLocalizedMessage("SORT.BY_SYMBOL_COUNT");
            logger.info(logStr);
            resultText = controller.handleRequest(
                    RequestType.CONCATENATE_TO_STRING, text);
            logger.debug(resultText);

        } catch (ControllerException e) {
            logger.error(e.getLocalizedMessage(), e.getCause());
        } catch (Exception e) {
            logger.error(localizationService.getLocalizedMessage(
                    "INTERNAL_ERROR"), e);
        }
    }

    /**
     * dialog with user for choose locale.
     *
     * @return String[] parametrs (language,country)
     */
    private static String[] userDialog() {
        System.out.println("choose Locale:");
        System.out.println("1 -> English");
        System.out.println("2 -> Russian");
        System.out.println("3 -> Belorussian");
        System.out.println("other -> default");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String language;
        String country;
        switch (str) {
            case "1":
                language = "en";
                country = "US";
                break;
            case "2":
                language = "ru";
                country = "RU";
                break;
            case "3":
                language = "be";
                country = "BY";
                break;
            default:
                language = "";
                country = "";
                break;
        }
        return new String[]{language, country};

    }
}


