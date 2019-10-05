package by.dziomin.trade.dto;

import java.io.Serializable;

public class UserDTO extends BaseDTO implements Serializable {
    private String login;
    private String name;
    private String role;

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(final String role) {
        this.role = role;
    }
}
