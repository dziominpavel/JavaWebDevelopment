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
     * @throws Exception exeption
     */
    public static String[] voucherInfo(final String stringVoucherData)
            throws Exception {
        Logger logger = Logger.getLogger(DataVoucherParcer.class);
        logger.info("parcing voucher data...");
        try {
            if (stringVoucherData != null) {
                String[] voucherInfo = new String[COUNT_VOUCHER_FIELDS];
                System.arraycopy(stringVoucherData.split(SEPARATOR), 0,
                        voucherInfo, 0, COUNT_VOUCHER_FIELDS);
                return voucherInfo;
            }
        } catch (Exception e) {
            logger.error("Error of parcing file");
            throw new Exception();
        }
        return null;
    }
}
