package by.dziomin.task1.specification;

import by.dziomin.task1.entity.Voucher;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QueryExecutor {
    /**
     * instance.
     */
    private static QueryExecutor instance;

    /**
     * getInstance.
     *
     * @return QueryExecutor
     */
    public static QueryExecutor getInstance() {
        if (instance == null) {
            instance = new QueryExecutor();
        }
        return instance;
    }

    /**
     * query.
     *
     * @param specificationObjectMap specificationObjectMap.
     * @param list                   list.
     * @return List
     */
    public List<Voucher> query(
            final Map<ISpecification, Object> specificationObjectMap,
            final List<Voucher> list) {

        Stream<Voucher> stream = list.stream();
        Comparator<Voucher> comparator = null;
        for (ISpecification specification : specificationObjectMap.keySet()) {
            if (specification instanceof IFindSpecification) {
                Object parametr = specificationObjectMap.get(specification);
                Predicate<Voucher> predicate =
                        ((IFindSpecification) specification)
                                .getPredicate(parametr);
                stream = stream.filter(predicate);
            }

            if (specification instanceof ISortSpecification) {
                if (comparator == null) {
                    comparator =
                            ((ISortSpecification) specification)
                                    .getComparator();
                } else {
                    comparator
                            .thenComparing(((ISortSpecification) specification)
                                    .getComparator());
                }

            }

        }

        if (comparator != null) {
            stream = stream.sorted(comparator);
        }

        return stream.collect(Collectors.toList());
    }
}



