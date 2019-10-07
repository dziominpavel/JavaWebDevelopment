package by.dziomin.trade.command;

import by.dziomin.trade.command.auth.LoginCommand;
import by.dziomin.trade.command.auth.LogoutCommand;
import by.dziomin.trade.command.auth.RegisterUserCommand;
import by.dziomin.trade.command.cashier.ProductInfoCommand;
import by.dziomin.trade.command.cashier.ProductsCommand;
import by.dziomin.trade.command.cashier.ReceiptCancelCommand;
import by.dziomin.trade.command.cashier.ReceiptCreateCommand;
import by.dziomin.trade.command.cashier.SalesItemAddCommand;
import by.dziomin.trade.command.cashier.UserInfoCommand;
import by.dziomin.trade.command.cashier.UserUpdateCommand;
import by.dziomin.trade.command.manager.ProductCreateCommand;
import by.dziomin.trade.command.manager.ProductDeleteCommand;
import by.dziomin.trade.command.manager.ProductUpdateCommand;

public enum CommandType {
    REGISTER(new RegisterUserCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    USERINFO(new UserInfoCommand()),
    USERUPDATE(new UserUpdateCommand()),
    PRODUCTS(new ProductsCommand()),
    PRODUCTINFO(new ProductInfoCommand()),
    UPDATEPRODUCT(new ProductUpdateCommand()),
    CREATEPRODUCT(new ProductCreateCommand()),
    DELETEPRODUCT(new ProductDeleteCommand()),
    ADDSALESITEM(new SalesItemAddCommand()),
    CREATERECEIPT(new ReceiptCreateCommand()),
    CANCELRECEIPT(new ReceiptCancelCommand());

    private Command command;

    CommandType(final Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
