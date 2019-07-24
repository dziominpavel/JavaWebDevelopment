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
        logger.info("trying to create voucher...");

        try {
            if (!VoucherValidator
                    .voucherTypeValidator(voucherInfo[POSITION_VOUCHERTYPE]
                            .toUpperCase())) {
                logger.info("ERROR of reading data from file...");
                throw new IllegalVoucherArgumentException("Error creating "
                        + "voucher");
            }

            Voucher voucher =
                    new VoucherFactory().createVoucher(
                            VoucherType.valueOf(
                                    voucherInfo[POSITION_VOUCHERTYPE]
                                            .toUpperCase()));
            voucher.setVoucherType(VoucherType.valueOf(
                    voucherInfo[POSITION_VOUCHERTYPE].toUpperCase()));
            voucher.setDepartureCountry(voucherInfo[POSITION_DEPARTURE]);
            voucher.setDestinationCountry(voucherInfo[POSITION_DESTINATION]);
            voucher.setPrice(Double.valueOf(voucherInfo[POSITION_PRICE]));
            voucher.setTransportType(TransportType.valueOf(
                    voucherInfo[POSITION_TRANSPORTTYPE].toUpperCase()));
            voucher.setCountDays(Integer.valueOf(
                    voucherInfo[POSITION_COUNTDAYS]));
            voucher.setEatingType(EatingType.valueOf(
                    voucherInfo[POSITION_EATINGTYPE].toUpperCase()));
            if (voucher instanceof RelaxVoucher) {
                ((RelaxVoucher) voucher).setRelaxType(RelaxType.valueOf(
                        voucherInfo[POSITION_RELAXTYPE].toUpperCase()));
            } else if (voucher instanceof WorkingVoucher) {
                ((WorkingVoucher) voucher).setWorkName(
                        voucherInfo[POSITION_WORKNAME].toUpperCase());
            } else if (voucher instanceof ShoppingVoucher) {
                ((ShoppingVoucher) voucher).setShopName(
                        voucherInfo[POSITION_SHOPNAME].toUpperCase());
            } else if (voucher instanceof MedicationVoucher) {
                ((MedicationVoucher) voucher).setHospitalName(
                        voucherInfo[POSITION_HOSPITALNAME].toUpperCase());
            }
            logger.info("creating voucher [" + voucher.getVoucherType()
                    + "] success");
            return voucher;

        } catch (IllegalVoucherArgumentException e) {
            logger.error("error of creating voucher...");
        }
        return null;
    }

}
