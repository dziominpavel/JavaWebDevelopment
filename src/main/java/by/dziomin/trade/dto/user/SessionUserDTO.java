package by.dziomin.trade.dto.user;

import by.dziomin.trade.dto.BaseDTO;

import java.io.Serializable;

/**
 * DTO to store user in session
 *
 * @author - Pavel Dziomin
 */
public final class SessionUserDTO extends BaseDTO implements Serializable {
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
