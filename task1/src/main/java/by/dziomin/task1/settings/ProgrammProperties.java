package by.dziomin.task1.settings;

import java.io.File;

/**
 * Program settings.
 */
public final class ProgrammProperties {

    /**
     * separator.
     */
    public static final String SEPARATOR = "/";
    /**
     * count of voucher fields.
     */
    public static final int COUNT_VOUCHER_FIELDS = 8;
    /**
     * Position of voucher type.
     */
    public static final int POSITION_VOUCHERTYPE = 0;
    /**
     * Position of voucher departure country in the file.
     */
    public static final int POSITION_DEPARTURE = 1;
    /**
     * Position of voucher destination country in the file.
     */
    public static final int POSITION_DESTINATION = 2;
    /**
     * Position of voucher price.
     */
    public static final int POSITION_PRICE = 3;
    /**
     * Position of transport type in the file.
     */
    public static final int POSITION_TRANSPORTTYPE = 4;
    /**
     * Position of count days in the file.
     */
    public static final int POSITION_COUNTDAYS = 5;
    /**
     * Position of eating type in the file.
     */
    public static final int POSITION_EATINGTYPE = 6;
    /**
     * Position of hospital name in the file.
     */
    public static final int POSITION_HOSPITALNAME = 7;
    /**
     * Position of work name in the file.
     */
    public static final int POSITION_WORKNAME = 7;
    /**
     * Position of shop name in the file.
     */
    public static final int POSITION_SHOPNAME = 7;
    /**
     * Position of relax type in the file.
     */
    public static final int POSITION_RELAXTYPE = 7;
    /**
     * path to file with voucher information.
     */
    public static final File voucherInformation = new File("src\\main"
            + "\\resources\\voucherInformation.txt");


    private ProgrammProperties() {
    }
}
