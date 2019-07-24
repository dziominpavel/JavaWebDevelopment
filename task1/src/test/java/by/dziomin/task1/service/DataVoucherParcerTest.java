package by.dziomin.task1.service;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class DataVoucherParcerTest {

    @DataProvider(name = "parcerInformation")
    public Object[] fileInformation() {
        String strOne = "RELAX/Belarus/Russia/100/CAR/14/ALLINCLUSIVE" +
                "/EXCURSION";
        String strTwo = "RELAX/Belarus/German/95/CAR/2/ALLINCLUSIVE/EXCURSION";
        String strThree = "relax/Belarus/Russia/20/CAR/14/ALLINCLUSIVE" +
                "/EXCURSION";
        String strFour = "SHOPPING/Belarus/Poland/45/BUS/43/BREAKFAST" +
                "/BelastokShop";
        String strFive = "RELAX";

        String[] arrayOne = {"RELAX", "Belarus", "Russia", "100", "CAR", "14",
                "ALLINCLUSIVE", "EXCURSION"};
        String[] arrayTwo = {"RELAX", "Belarus", "German", "95", "CAR", "2",
                "ALLINCLUSIVE", "EXCURSION"};
        String[] arrayThree = {"relax", "Belarus", "Russia", "20", "CAR", "14",
                "ALLINCLUSIVE", "EXCURSION"};
        String[] arrayFour = {"SHOPPING", "Belarus", "Poland", "45", "BUS",
                "43", "BREAKFAST", "BelastokShop"};
        String[] arrayFive = {};

        return new Object[][]{
                {strOne, arrayOne},
                {strTwo, arrayTwo},
                {strThree, arrayThree},
                {strFour, arrayFour},
                {strFive, arrayFive},
        };
    }

    @Test(description = "Parcer information from file",
            dataProvider = "parcerInformation")
    public void testVoucherInfo(String str, String[] arrayString) {

        String[] result = new String[0];
        try {
            result = DataVoucherParcer.voucherInfo(str);
        } catch (Exception newE) {
            newE.printStackTrace();
        }
        assertEquals(result, arrayString);

    }
}
