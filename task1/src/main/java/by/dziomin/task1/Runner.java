package by.dziomin.task1;

import by.dziomin.task1.entity.Voucher;
import by.dziomin.task1.entity.VoucherType;
import by.dziomin.task1.repository.VoucherReposiroty;
import by.dziomin.task1.service.DataReader;
import by.dziomin.task1.service.DataVoucherParcer;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static by.dziomin.task1.service.VoucherCreator.voucherCreator;
import static by.dziomin.task1.settings.ProgrammProperties.voucherInformation;

final class Runner {
    /**
     * default constructor.
     */
    private Runner() {
    }

    /**
     * main method.
     *
     * @param args String args
     */
    public static void main(final String[] args) {

        Logger logger = Logger.getLogger(Runner.class);
        VoucherReposiroty voucherReposiroty = VoucherReposiroty.getInstance();

        List<String> fileInfo = DataReader.dataReader(voucherInformation);

        for (String s : fileInfo) {
            Voucher voucher =
                    voucherCreator(Objects.requireNonNull(
                            DataVoucherParcer.voucherInfo(s)));
            voucherReposiroty.add(voucher);
        }

        HashMap<String, Object> parametrs = new HashMap<>();
        parametrs.put("voucherType", VoucherType.RELAX);
        parametrs.put("destinationCountry", "Russia");
        List<String> orderBy = Collections.singletonList("price");
        logger.info(voucherReposiroty.get(parametrs, orderBy));


    }
}
