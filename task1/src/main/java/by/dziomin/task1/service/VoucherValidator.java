package by.dziomin.task1.service;

import by.dziomin.task1.entity.EatingType;
import by.dziomin.task1.entity.RelaxType;
import by.dziomin.task1.entity.TransportType;
import by.dziomin.task1.entity.VoucherType;
import org.apache.log4j.Logger;

public final class VoucherValidator {
    /**
     * logger.
     */
    private static Logger logger = Logger.getLogger(VoucherValidator.class);

    private VoucherValidator() {
    }

    /**
     * voucherTypeValidator.
     *
     * @param voucherType voucherType.
     * @return boolean value.
     */
    public static boolean voucherTypeValidator(final String voucherType) {
        for (VoucherType type : VoucherType.values()) {
            try {
                if (VoucherType.valueOf(voucherType) == type) {
                    return true;
                }
            } catch (Exception e) {
                logger.error("unknown type of voucher");
                return false;
            }
        }
        logger.error("unknown type of voucher");
        return false;
    }

    /**
     * departureCountry.
     *
     * @param departureCountry departureCountry
     * @return boolean value.
     */
    public static boolean departureCountryValidator(
            final String departureCountry) {
        if (departureCountry.length() != 0) {
            return true;
        } else {
            logger.error("unknown departure country of voucher");
            return false;
        }
    }

    /**
     * destinationCountry.
     *
     * @param destinationCountry destinationCountry
     * @return boolean value.
     */
    public static boolean destinationCountryValidator(
            final String destinationCountry) {
        if (destinationCountry.length() != 0) {
            return true;
        } else {
            logger.error("unknown destination country of voucher");
            return false;
        }
    }

    /**
     * price.
     *
     * @param price price
     * @return boolean value.
     */
    public static boolean priceValidator(
            final String price) {
        try {
            if (Double.parseDouble(price) > 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            logger.error("unknown price of voucher");
            return false;
        }
        return false;
    }

    /**
     * transportType.
     *
     * @param transportType transportType.
     * @return boolean value.
     */
    public static boolean transportTypeValidator(final String transportType) {
        for (TransportType type : TransportType.values()) {
            try {
                if (TransportType.valueOf(transportType) == type) {
                    return true;
                }
            } catch (Exception e) {
                logger.error("unknown type of transport");
                return false;
            }
        }
        logger.error("unknown type of transport");
        return false;
    }

    /**
     * countDays.
     *
     * @param countDays countDays
     * @return boolean value.
     */
    public static boolean countDaysValidator(
            final String countDays) {
        try {
            if (Integer.parseInt(countDays) > 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            logger.error("unknown count of days");
            return false;
        }
        return false;
    }

    /**
     * eatingType.
     *
     * @param eatingType eatingType.
     * @return boolean value.
     */
    public static boolean eatingTypeValidator(final String eatingType) {
        for (EatingType type : EatingType.values()) {
            try {
                if (EatingType.valueOf(eatingType) == type) {
                    return true;
                }
            } catch (Exception e) {
                logger.error("unknown type of eating");
                return false;
            }
        }
        logger.error("unknown type of eating");
        return false;
    }

    /**
     * relaxType.
     *
     * @param relaxType relaxType.
     * @return boolean value.
     */
    public static boolean relaxTypeValidator(final String relaxType) {
        for (RelaxType type : RelaxType.values()) {
            try {
                if (RelaxType.valueOf(relaxType) == type) {
                    return true;
                }
            } catch (Exception e) {
                logger.error("unknown type of relax");
                return false;
            }
        }
        logger.error("unknown type of relax");
        return false;
    }

    /**
     * shopName.
     *
     * @param shopName shopName
     * @return boolean value.
     */
    public static boolean shopNameValidator(
            final String shopName) {
        if (shopName.length() != 0) {
            return true;
        } else {
            logger.error("unknown shop name");
            return false;
        }
    }

    /**
     * workName.
     *
     * @param workName workName
     * @return boolean value.
     */
    public static boolean workNameValidator(
            final String workName) {
        if (workName.length() != 0) {
            return true;
        } else {
            logger.error("unknown work name");
            return false;
        }
    }

    /**
     * hospitalName.
     *
     * @param hospitalName hospitalName
     * @return boolean value.
     */
    public static boolean hospitalNameValidator(
            final String hospitalName) {
        if (hospitalName.length() != 0) {
            return true;
        } else {
            logger.error("unknown hospital name");
            return false;
        }
    }
}
