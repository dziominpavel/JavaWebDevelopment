package by.dziomin.trade.dto.user;

import by.dziomin.trade.dto.BaseDTO;

public class UserCreateDTO extends BaseDTO {
    private String name;
    private String login;
    private String password;
    private String confirmPassword;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(final String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
