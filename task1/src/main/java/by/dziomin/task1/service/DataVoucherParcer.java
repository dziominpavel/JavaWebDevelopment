package by.dziomin.task1.service;


import org.apache.log4j.Logger;

import static by.dziomin.task1.settings.ProgrammProperties.COUNT_VOUCHER_FIELDS;
import static by.dziomin.task1.settings.ProgrammProperties.SEPARATOR;

public final class DataVoucherParcer {

    private DataVoucherParcer() {
    }

    /**
     * voucherInfo.
     * @param stringVoucherData stringVoucherData
     * @return String[]
     */
    public static String[] voucherInfo(final String stringVoucherData) {
        Logger logger = Logger.getLogger(DataReader.class);
        logger.info("parcing voucher data...");
        try {
            if (stringVoucherData != null) {
                String[] voucherInfo = new String[COUNT_VOUCHER_FIELDS];
                System.arraycopy(stringVoucherData.split(SEPARATOR), 0,
                        voucherInfo, 0, COUNT_VOUCHER_FIELDS);
                return voucherInfo;
            }
        } catch (Exception e) {
            logger.error("Error of reading voucher data...");
        }
        return null;
    }
}
