package by.dziomin.task2.service;

import by.dziomin.task2.exception.MatrixException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertSame;

public class DataParcerTest {

    @DataProvider(name = "parcerMatrixInfoPositive")
    public Object[] fileMatrixInformationPositive() {

        List<String> stringListMatrix = new ArrayList<>();
        stringListMatrix.add("1 1 1 1 1 1 1 1");
        stringListMatrix.add("2 2 2 2 2 2 2 2");

        List<String[]> resultMatrix = new ArrayList<>();
        resultMatrix.add(stringListMatrix.get(0).split(" "));
        resultMatrix.add(stringListMatrix.get(1).split(" "));

        return new Object[][]{
                {stringListMatrix, resultMatrix},
        };
    }

    @DataProvider(name = "parcerThreadInfoPositive")
    public Object[] fileThreadInformationPositive() {

        List<String> stringListTread = new ArrayList<>();
        stringListTread.add("99 98 97 96 95");
        String[] resultThread = stringListTread.get(0).split(" ");

        return new Object[][]{
                {stringListTread, resultThread},
        };
    }

    @Test(description = "Parcer matrix information from file",
            dataProvider = "parcerMatrixInfoPositive")
    public void testMatrixInfoPositive(ArrayList<String> listRows,
                               ArrayList<String[]> listElements)
            throws MatrixException {
        List<String[]> result = DataParcer.getInstance().matrixInfo(listRows);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i), listElements.get(i));
        }

    }

    @Test(description = "Parcer thread information from file",
            dataProvider = "parcerThreadInfoPositive")
    public void testThreadInfoPositive(ArrayList<String> listRows,
                               String[] arrayElements)
            throws MatrixException {
        String[] result = DataParcer.getInstance().threadInfo(listRows);
        assertEquals(result, arrayElements);

    }


    @DataProvider(name = "parcerInfoNegative")
    public Object[] fileMatrixInformationNegative() {

        ArrayList illegalArgument = new ArrayList();
        illegalArgument.add(1d);
        return new Object[][]{
                {illegalArgument, null},
        };
    }

    @Test(description = "Parcer matrix information from file",
            dataProvider = "parcerInfoNegative")
    public void testMatrixInfoNegative(ArrayList<String> listRows,
                               ArrayList<String[]> listElements)
            throws MatrixException {
        List<String[]> result = null;
        try {
            result = DataParcer.getInstance().matrixInfo(listRows);
        } catch (ClassCastException newE) {
            assertNull(result);
        }

    }

    @Test(description = "Parcer thread information from file",
            dataProvider = "parcerInfoNegative")
    public void testThreadInfoNegative(ArrayList<String> listRows,
                               String[] arrayElements)
            throws MatrixException {
        List<String[]> result = null;
        try {
            result = DataParcer.getInstance().matrixInfo(listRows);
        } catch (ClassCastException newE) {
            assertNull(result);
        }

    }







}