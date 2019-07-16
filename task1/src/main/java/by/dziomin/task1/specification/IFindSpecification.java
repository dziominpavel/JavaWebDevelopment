package by.dziomin.task1.specification;


import by.dziomin.task1.entity.BaseEntity;

import java.util.function.Predicate;

public interface IFindSpecification<T extends BaseEntity>
        extends ISpecification {
    /**
     * Predicate.
     * @param object object.
     * @return Predicate.
     */
    Predicate<T> getPredicate(Object object);
}
