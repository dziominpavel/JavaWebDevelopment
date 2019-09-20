package by.dziomin.task4WEB.service;

import by.dziomin.task4WEB.entities.OperatorName;
import by.dziomin.task4WEB.entities.Tarif;
import by.dziomin.task4WEB.entities.TariffEnum;
//import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class TariffsHandler extends DefaultHandler {
//    Logger logger = Logger.getLogger(TariffsHandler.class);

    private Set<Tarif> tariffs;
    private Tarif current = null;
    private TariffEnum currentEnum = null;

    public TariffsHandler() {
        tariffs = new HashSet<>();
//        logger.debug(parameters);


    }

    public Set<Tarif> getTariffs() {
        return tariffs;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("tariff".equals(localName)) {
            current = new Tarif();
            current.setId(attrs.getValue(0));
        } else {
            TariffEnum temp = null;
            for (TariffEnum tariffEnum : TariffEnum.values()) {
                try {
                    if (TariffEnum.valueOf(localName.toUpperCase()).equals(tariffEnum)) {
                        temp = TariffEnum.valueOf(localName.toUpperCase());
                    }
                } catch (Exception e) {

                }


            }
            currentEnum = temp;
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if ("tariff".equals(localName)) {
//            logger.debug(current);
            tariffs.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    current.setName(s);
                    break;
                case STARTDATE:
                    XMLGregorianCalendar xmlGregorianCalendar = null;
                    try {
                        xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-05-22T16:28:40.317-04:00");
                    } catch (DatatypeConfigurationException e) {
                        e.printStackTrace();
                    }
                    current.setStartDate(xmlGregorianCalendar);
                    break;
                case PAYROLL:
                    current.setPayRoll(Double.parseDouble(s));
                    break;
                case OPERATORNAME:
                    current.setOperatorName(OperatorName.valueOf(s.toUpperCase()));
                    break;
                case INCALLPRICE:
                    current.getCallPrices().setInCallPrice(Double.parseDouble(s));
                    break;
                case OUTCALLPRICE:
                    current.getCallPrices().setOutCallPrice(Double.parseDouble(s));
                    break;
                case CITYCALLPRICE:
                    current.getCallPrices().setCityCallPrice(Double.parseDouble(s));
                    break;
                case SMSPRICE:
                    current.setSmsPrice(Double.parseDouble(s));
                    break;
                case FAVOURITENUMBER:
                    current.getParameters().setFavouriteNumber(Integer.parseInt(s));
                    break;
                case TARIFICATION:
                    current.getParameters().setTarification(Integer.parseInt(s));
                    break;
                case STARTPRICE:
                    current.getParameters().setStartPrice(Double.parseDouble(s));
                    break;

                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
