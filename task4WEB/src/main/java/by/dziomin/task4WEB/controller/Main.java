package by.dziomin.task4WEB.controller;

import by.dziomin.task4WEB.service.TariffsSaxBuilder;
//import org.apache.log4j.Logger;

public class Main {


    public static void main(String[] args) {
//        Logger logger = Logger.getLogger(Main.class);

//        try {
//            JAXBContext jc = JAXBContext.newInstance(Tariffs.class);
//            Unmarshaller u = jc.createUnmarshaller();
//            FileReader reader = new FileReader("data/tariffs.xml");
//            Tariffs tariffs = (Tariffs) u.unmarshal(reader);
//            System.out.println(tariffs);
//
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        TariffsSaxBuilder saxBuilder = new TariffsSaxBuilder();
        saxBuilder.buildSetTariffs("data/tariffs.xml");
//        logger.info(saxBuilder.getTarifSet());



//        try {
//            // создание SAX-анализатора
//            XMLReader reader = XMLReaderFactory.createXMLReader();
////            TariffsHandlerOld handler = new TariffsHandlerOld();
//            TariffsHandler handler = new TariffsHandler();
//            reader.setContentHandler(handler);
//            reader.parse("data/tariffs.xml");
//            System.out.println(handler.getTariffs());
//        } catch (SAXException e) {
//            System.err.print("ошибка SAX парсера " + e);
//        } catch (IOException e) {
//            System.err.print("ошибка I/О потока " + e);
//        }
    }
}
