package by.dziomin.task1;

import org.apache.log4j.Logger;

final class Main {

    private Main() {
        //
    }

    /**
     * main method.
     *
     * @param args String args
     */


    public static void main(final String[] args) {
        Logger logger = Logger.getLogger(Main.class);
        logger.debug("Hello World!");
        logger.trace("Hello World!");
    }
}
