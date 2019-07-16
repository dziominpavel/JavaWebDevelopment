package by.dziomin.task1.specification;

import by.dziomin.task1.entity.BaseEntity;

import java.util.Comparator;

public interface ISortSpecification<T extends BaseEntity>
        extends ISpecification {
    /**
     * @return getComparator.
     */
    Comparator<T> getComparator();
}
