package by.dziomin.task1;

import org.apache.log4j.Logger;

final class Runner {
    /**
     * default constructor.
     */
    private Runner() {
    }

    /**
     * main method.
     *
     * @param args String args
     */
    public static void main(final String[] args) {
        Logger logger = Logger.getLogger(Runner.class);
        logger.info("Hello World!");
        logger.trace("Hello World!");
    }
}
