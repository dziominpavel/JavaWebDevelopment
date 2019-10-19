package by.dziomin.trade.command;

import by.dziomin.trade.command.auth.LoginCommand;
import by.dziomin.trade.command.auth.LogoutCommand;
import by.dziomin.trade.command.auth.RegisterUserCommand;
import by.dziomin.trade.command.cashier.ProductInfoCommand;
import by.dziomin.trade.command.cashier.ProductsCommand;
import by.dziomin.trade.command.cashier.ReceiptCancelCommand;
import by.dziomin.trade.command.cashier.ReceiptCreateCommand;
import by.dziomin.trade.command.cashier.ReceiptsCommand;
import by.dziomin.trade.command.cashier.SalesItemAddCommand;
import by.dziomin.trade.command.cashier.UserInfoCommand;
import by.dziomin.trade.command.cashier.UserUpdateCommand;
import by.dziomin.trade.command.cashier.UsersCommand;
import by.dziomin.trade.command.manager.ProductCreateCommand;
import by.dziomin.trade.command.manager.ProductDeleteCommand;
import by.dziomin.trade.command.manager.ProductUpdateCommand;

public enum CommandType {
    ADDSALESITEM(new SalesItemAddCommand()),
    CANCELRECEIPT(new ReceiptCancelCommand()),
    CREATEPRODUCT(new ProductCreateCommand()),
    CREATERECEIPT(new ReceiptCreateCommand()),
    DELETEPRODUCT(new ProductDeleteCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    PRODUCTS(new ProductsCommand()),
    PRODUCTINFO(new ProductInfoCommand()),
    RECEIPTS(new ReceiptsCommand()),
    REGISTER(new RegisterUserCommand()),
    UPDATEPRODUCT(new ProductUpdateCommand()),
    USERS(new UsersCommand()),
    USERINFO(new UserInfoCommand()),
    USERUPDATE(new UserUpdateCommand());



    private Command command;

    CommandType(final Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
