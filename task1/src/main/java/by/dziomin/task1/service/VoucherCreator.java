package by.dziomin.task1.service;

import by.dziomin.task1.entity.EatingType;
import by.dziomin.task1.entity.MedicationVoucher;
import by.dziomin.task1.entity.RelaxType;
import by.dziomin.task1.entity.RelaxVoucher;
import by.dziomin.task1.entity.ShoppingVoucher;
import by.dziomin.task1.entity.TransportType;
import by.dziomin.task1.entity.Voucher;
import by.dziomin.task1.entity.VoucherType;
import by.dziomin.task1.entity.WorkingVoucher;
import by.dziomin.task1.errors.IllegalVoucherArgumentException;
import by.dziomin.task1.factory.VoucherFactory;
import org.apache.log4j.Logger;

import static by.dziomin.task1.settings.ProgrammProperties.POSITION_COUNTDAYS;
import static by.dziomin.task1.settings.ProgrammProperties.POSITION_DEPARTURE;
import static by.dziomin.task1.settings.ProgrammProperties.POSITION_DESTINATION;
import static by.dziomin.task1.settings.ProgrammProperties.POSITION_EATINGTYPE;
import static by.dziomin.task1.settings.ProgrammProperties.POSITION_HOSPITALNAME;
import static by.dziomin.task1.settings.ProgrammProperties.POSITION_PRICE;
import static by.dziomin.task1.settings.ProgrammProperties.POSITION_RELAXTYPE;
import static by.dziomin.task1.settings.ProgrammProperties.POSITION_SHOPNAME;
import static by.dziomin.task1.settings.ProgrammProperties.POSITION_TRANSPORTTYPE;
import static by.dziomin.task1.settings.ProgrammProperties.POSITION_VOUCHERTYPE;
import static by.dziomin.task1.settings.ProgrammProperties.POSITION_WORKNAME;

public final class VoucherCreator {
    /**
     * private constructor for utility class.
     */
    private VoucherCreator() {
    }

    /**
     * voucher creator.
     *
     * @param voucherInfo voucherInfo.
     * @return voucher
     */
    public static Voucher voucherCreator(final String[] voucherInfo) {

        Logger logger = Logger.getLogger(VoucherCreator.class);
        logger.info("reading data from file...");

        try {
            Voucher voucher =
                    new VoucherFactory().createVoucher(
                            VoucherType.valueOf(
                                    voucherInfo[POSITION_VOUCHERTYPE]));
            voucher.setVoucherType(VoucherType.valueOf(
                    voucherInfo[POSITION_VOUCHERTYPE]));
            voucher.setDepartureCountry(voucherInfo[POSITION_DEPARTURE]);
            voucher.setDestinationCountry(voucherInfo[POSITION_DESTINATION]);
            voucher.setPrice(Double.valueOf(voucherInfo[POSITION_PRICE]));
            voucher.setTransportType(TransportType.valueOf(
                    voucherInfo[POSITION_TRANSPORTTYPE]));
            voucher.setCountDays(Integer.valueOf(
                    voucherInfo[POSITION_COUNTDAYS]));
            voucher.setEatingType(EatingType.valueOf(
                    voucherInfo[POSITION_EATINGTYPE]));
            if (voucher instanceof RelaxVoucher) {
                ((RelaxVoucher) voucher).setRelaxType(RelaxType.valueOf(
                        voucherInfo[POSITION_RELAXTYPE]));
            } else if (voucher instanceof WorkingVoucher) {
                ((WorkingVoucher) voucher).setWorkName(
                        voucherInfo[POSITION_WORKNAME]);
            } else if (voucher instanceof ShoppingVoucher) {
                ((ShoppingVoucher) voucher).setShopName(
                        voucherInfo[POSITION_SHOPNAME]);
            } else if (voucher instanceof MedicationVoucher) {
                ((MedicationVoucher) voucher).setHospitalName(
                        voucherInfo[POSITION_HOSPITALNAME]);
            }
            logger.info("creating voucher [" + voucher.getVoucherType()
                    + "] success");
            return voucher;

        } catch (IllegalVoucherArgumentException e) {
            logger.error("error of creating track...");
            return null;
        }
    }
}
