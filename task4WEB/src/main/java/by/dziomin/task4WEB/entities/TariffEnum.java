package by.dziomin.task4WEB.entities;

public enum TariffEnum {
//    TARIFFS("tariffs"),
    TARIFF("tariff"),
    ID("id"),
    NAME("name"),
    STARTDATE("startdate"),
    PAYROLL("payroll"),
    OPERATORNAME("operatorname"),
//    CALLPRICES("callprices"),
    INCALLPRICE("incallprice"),
    OUTCALLPRICE("outcallprice"),
    CITYCALLPRICE("citycallprice"),
    SMSPRICE("smsprice"),
//    PARAMETERS("parameters"),
    FAVOURITENUMBER("favouriteNumber"),
    TARIFICATION("tarification"),
    STARTPRICE("startprice");


    private String value;

    private TariffEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
