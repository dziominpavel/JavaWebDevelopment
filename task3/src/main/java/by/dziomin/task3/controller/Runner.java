package by.dziomin.task3.controller;

import by.dziomin.task3.exception.ServiceException;
import by.dziomin.task3.service.LocalizationService;
import by.dziomin.task3.service.impl.LocalizationServiceImpl;
import org.apache.log4j.Logger;


/**
 * Main class.
 */
public class Runner {

    /**
     * main method.
     *
     * @param args args.
     * @throws ServiceException ServiceException
     */
    public static void main(String[] args) throws ServiceException {
        Logger loger = Logger.getLogger(Runner.class);

        TaskController controller = TaskController.getInstance();
        LocalizationService localizationService =
                LocalizationServiceImpl.getInstance();
        try {
            Object text = controller.handleRequest(RequestType.READ_TEXT_FROM_FILE);
            text = controller.handleRequest(RequestType.SORT,
                    "PARAGRAPHS_BY_SENTENCES_COUNT", text);
            text = controller.handleRequest(RequestType.SORT,
                    "WORDS_BY_WORD_LENGTH", text);
            text = controller.handleRequest(RequestType.SORT,
                    "SENTENCES_BY_WORD_COUNT", text);
            text = controller.handleRequest(RequestType.SORT,
                    "LEKSEMS_BY_SYMBOL_COUNT_DESC", text, "a");

            text = controller.handleRequest(RequestType.CONCATENATE_TO_STRING,
                    text);

            System.out.println(text);
        } catch (ServiceException e) {
            System.out.println(localizationService.getLocalizedMessage(e.getMessage()));
        } catch (Exception e) {
            System.out.println(localizationService.getLocalizedMessage("INTERNAL_ERROR"));
        }
    }
}

