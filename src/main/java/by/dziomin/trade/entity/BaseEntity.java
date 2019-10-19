package by.dziomin.trade.entity;

/**
 * Base entity
 *
 * @author - Pavel Dziomin
 */
public class BaseEntity {
    private Long id;

    /**
     * Get entity id
     *
     * @return entity id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set entity id
     *
     * @param id id to set
     */
    public void setId(final Long id) {
        this.id = id;
    }
}
