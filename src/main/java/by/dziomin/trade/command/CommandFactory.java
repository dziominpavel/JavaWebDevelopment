package by.dziomin.trade.command;

/**
 * Command factory
 *
 * @author - Pavel Dziomin
 */
public final class CommandFactory {
    private static CommandFactory instance;

    private CommandFactory() {
    }

    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    public Command defineCommand(String commandName) throws CommandException {
        try {
            CommandType type = CommandType.valueOf(commandName.toUpperCase());
            return type.getCommand();
        } catch (IllegalArgumentException e) {
            throw new CommandException(commandName);
        }
    }
}
