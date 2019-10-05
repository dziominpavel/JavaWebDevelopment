package by.dziomin.trade.command;

public class CommandException extends Exception {

    public CommandException() {
    }

    public CommandException(final String message) {
        super(message);
    }

    public CommandException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CommandException(final Throwable cause) {
        super(cause);
    }

    public CommandException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
