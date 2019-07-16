package by.dziomin.task1.service;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class DataReaderTest {

    @DataProvider(name = "fileInformation")
    public Object[] fileInformation() {
        File fileOne = new File("src\\test\\java\\by\\dziomin" +
                       "\\task1\\service\\testDataReaderFileOne.txt");
        File fileTwo = new File("src\\test\\java\\by\\dziomin" +
                "\\task1\\service\\testDataReaderFileTwo.txt");
        List<String> list = new ArrayList<>();
        list.add("RELAX/Belarus/Russia/100/CAR/14/ALLINCLUSIVE" +
                "/EXCURSION");
        list.add("SHOPPING/Belarus/Poland/45/BUS/4/BREAKFAST/BelastokShop");

        return new Object[][]{
                {fileOne, list},
                {fileTwo, new ArrayList<>()}
        };
    }

    @Test(description = "reading information from file",
            dataProvider = "fileInformation")
    public void testDataReader(File a, List<String> c) {

        List<String> info = DataReader.dataReader(a);
        assertEquals(info, c);

    }
}