package by.dziomin.trade.entity;

/**
 * User entity
 *
 * @author - Pavel Dziomin
 */
public class UserEntity extends BaseEntity {
    private String name;
    private String login;
    private String password;
    private Role role;

    /**
     * Get user full name
     *
     * @return user full name
     */
    public String getName() {
        return name;
    }

    /**
     * Set user full name
     *
     * @param name name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Get user login
     *
     * @return user login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Set user login
     *
     * @param login login to set
     */
    public void setLogin(final String login) {
        this.login = login;
    }

    /**
     * Get user password
     *
     * @return user password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set user password
     *
     * @param password password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Get user role
     *
     * @return user role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Set user role
     *
     * @param role role to set
     */
    public void setRole(final Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UserEntity user = (UserEntity) o;

        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null)
            return false;
        if (getLogin() != null ? !getLogin().equals(user.getLogin()) : user.getLogin() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
            return false;
        return getRole() == user.getRole();
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getLogin() != null ? getLogin().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getRole() != null ? getRole().hashCode() : 0);
        return result;
    }
}
