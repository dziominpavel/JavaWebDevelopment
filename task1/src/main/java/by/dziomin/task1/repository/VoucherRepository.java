package by.dziomin.task1.repository;

import by.dziomin.task1.entity.Voucher;
import by.dziomin.task1.specification.IFindSpecification;
import by.dziomin.task1.specification.ISortSpecification;
import by.dziomin.task1.specification.ISpecification;
import by.dziomin.task1.specification.QueryExecutor;
import by.dziomin.task1.specification.VoucherFindByDeparture;
import by.dziomin.task1.specification.VoucherFindByDestination;
import by.dziomin.task1.specification.VoucherFindByGreaterThanPrice;
import by.dziomin.task1.specification.VoucherFindByLowerThanPrice;
import by.dziomin.task1.specification.VoucherFindByType;
import by.dziomin.task1.specification.VoucherSortByCountDaysSpecification;
import by.dziomin.task1.specification.VoucherSortByPriceSpecification;
import by.dziomin.task1.specification.VoucherSortByTypeSpecification;
import by.dziomin.task1.werehouse.VoucherWereHouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class VoucherRepository implements Repository<Voucher> {
    /**
     * ORDERBY.
     */
    private static final HashMap<String, ISortSpecification> ORDERBY;
    /**
     * FINDBY.
     */
    private static final HashMap<String, IFindSpecification> FINDBY;

    /**
     * voucherList.
     */
    private static VoucherRepository instance;

    static {
        ORDERBY = new HashMap<>();
        ORDERBY.put("price", new VoucherSortByPriceSpecification());
        ORDERBY.put("voucherType", new VoucherSortByTypeSpecification());
        ORDERBY.put("countDays", new VoucherSortByCountDaysSpecification());
        FINDBY = new HashMap<>();
        FINDBY.put("voucherType", new VoucherFindByType());
        FINDBY.put("departureCountry", new VoucherFindByDeparture());
        FINDBY.put("destinationCountry", new VoucherFindByDestination());
        FINDBY.put("greaterThanPrice", new VoucherFindByGreaterThanPrice());
        FINDBY.put("lowerThanPrice", new VoucherFindByLowerThanPrice());

    }

    /**
     * queryExecutor.
     */
    private QueryExecutor queryExecutor;
    /**
     * voucherWereHouse.
     */
    private VoucherWereHouse voucherWereHouse;


    private VoucherRepository() {
        voucherWereHouse = VoucherWereHouse.getInstance();
        queryExecutor = QueryExecutor.getInstance();
    }

    /**
     * singleton voucherRepository.
     *
     * @return instance.
     */
    public static VoucherRepository getInstance() {
        if (instance == null) {
            instance = new VoucherRepository();
        }
        return instance;
    }

    @Override
    public void add(final Voucher voucher) {
        if (voucher != null) {
            voucherWereHouse.getVoucherList().add(voucher);
        }
    }

    @Override
    public void delete(final Voucher voucher) {
        voucherWereHouse.getVoucherList().remove(voucher);
    }

    @Override
    public List<Voucher> get(final Map<String, Object> parametrs,
                             final List<String> orderBy) {

        Map<ISpecification, Object> specificationObjectMap = new HashMap<>();
        for (String s : parametrs.keySet()) {
            ISpecification specification = FINDBY.get(s);
            if (specification != null) {
                Object parametr = parametrs.get(s);
                specificationObjectMap.put(specification, parametr);
            }
        }

        for (String s : orderBy) {
            ISpecification specification = ORDERBY.get(s);
            if (specification != null) {
                specificationObjectMap.put(specification, null);
            }
        }
        return queryExecutor.query(specificationObjectMap,
                new ArrayList(voucherWereHouse.getVoucherList()));
    }
}
