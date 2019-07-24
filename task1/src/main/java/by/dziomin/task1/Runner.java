package by.dziomin.task1;

import by.dziomin.task1.entity.Voucher;
import by.dziomin.task1.entity.VoucherType;
import by.dziomin.task1.repository.VoucherRepository;
import by.dziomin.task1.service.DataReader;
import by.dziomin.task1.service.DataVoucherParcer;
import by.dziomin.task1.service.VoucherInformer;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        VoucherRepository voucherReposiroty = VoucherRepository.getInstance();
        VoucherInformer voucherInformer = VoucherInformer.getInstance();
        List<Voucher> voucherList;


        List<String> fileInfo = DataReader.dataReader(voucherInformation);

        for (String s : fileInfo) {
            Voucher voucher = null;
            try {
                voucher = voucherCreator(DataVoucherParcer.voucherInfo(s));
            } catch (Exception E) {
                logger.error("Error of reading voucher data...", E);
            }
            if (voucher != null) {
                voucherReposiroty.add(voucher);
            }
        }


        HashMap<String, Object> parametrs = new HashMap<>();
        parametrs.put("voucherType", VoucherType.RELAX);
        List<String> orderBy = new ArrayList<>();
        orderBy.add("price");
        /*
             this code for example of viewinf data.

             parametrs.put("destinationCountry", "Russia");
             orderBy.add("countDays"); */

        voucherList = voucherReposiroty.get(parametrs, orderBy);
        logger.info(voucherList);
        voucherInformer.calcTotalPrice(voucherList);
        logger.info(voucherInformer);


        //this code for demonstrating change price and total price.
        final double newPrice = 26;
        voucherList.get(0).setPrice(newPrice);
        logger.info("Price changed manually and total price changed "
                + "automatically");
        logger.info("New_" + voucherInformer);


    }
}
