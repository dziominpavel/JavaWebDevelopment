package by.dziomin.task4WEB.service;

import by.dziomin.task4WEB.entities.Tarif;
//import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

public class TariffsSaxBuilder {
//    Logger logger = Logger.getLogger(TariffsSaxBuilder.class);

    private Set<Tarif> tarifSet;
    private TariffsHandler th;
    private XMLReader reader;

    public TariffsSaxBuilder() {
        th = new TariffsHandler();
        try {
            // создание объекта-обработчика
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(th);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        }
    }

    public Set<Tarif> getTarifSet() {
        return tarifSet;
    }

    public void buildSetTariffs(String fileName) {
        try {
            // разбор XML-документа
            reader.parse(fileName);

        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        }
        tarifSet = th.getTariffs();
//        logger.debug(tarifSet);
    }
}
