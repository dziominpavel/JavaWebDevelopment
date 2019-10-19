package by.dziomin.trade.entity;

/**
 * Measure entity
 *
 * @author - Pavel Dziomin
 */
public class MeasureEntity extends BaseEntity {
    private String name;

    /**
     * Get measure name
     *
     * @return measure name
     */
    public String getName() {
        return name;
    }

    /**
     * Set measure name
     *
     * @param name name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        MeasureEntity measure = (MeasureEntity) o;

        return getName() != null ? getName().equals(measure.getName()) : measure.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
