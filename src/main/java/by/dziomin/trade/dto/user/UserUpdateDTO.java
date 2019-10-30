package by.dziomin.trade.dto.user;

import by.dziomin.trade.dto.BaseDTO;
import by.dziomin.trade.entity.Role;

/**
 * DTO to update user
 *
 * @author - Pavel Dziomin
 */
public class UserUpdateDTO extends BaseDTO {

    private String name;
    private String password;
    private String confirmPassword;
    private Role role;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
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

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }
}
