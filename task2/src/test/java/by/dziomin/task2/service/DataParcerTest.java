package by.dziomin.task2.service;

import by.dziomin.task2.exception.MatrixException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * class of set dataparcer class.
 */
public class DataParcerTest {
    /**
     * @return Object[]
     */
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

    /**
     * Positive thread information test.
     *
     * @return Object[]
     */
    @DataProvider(name = "parcerThreadInfoPositive")
    public Object[] fileThreadInformationPositive() {

        List<String> stringListTread = new ArrayList<>();
        stringListTread.add("99 98 97 96 95");
        String[] resultThread = stringListTread.get(0).split(" ");

        return new Object[][]{
                {stringListTread, resultThread},
        };
    }

    /**
     * Positive matrix parcer test.
     *
     * @param listRows     listRows
     * @param listElements listElements
     * @throws MatrixException MatrixException
     */
    @Test(description = "Parcer matrix information from file",
            dataProvider = "parcerMatrixInfoPositive")
    public void testMatrixInfoPositive(final ArrayList<String> listRows,
                                       final ArrayList<String[]> listElements)
            throws MatrixException {
        List<String[]> result = DataParcer.getInstance().matrixInfo(listRows);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i), listElements.get(i));
        }

    }

    /**
     * Positive test of thread info.
     *
     * @param listRows      listRows
     * @param arrayElements arrayElements
     * @throws MatrixException MatrixException
     */
    @Test(description = "Parcer thread information from file",
            dataProvider = "parcerThreadInfoPositive")
    public void testThreadInfoPositive(final ArrayList<String> listRows,
                                       final String[] arrayElements)
            throws MatrixException {
        String[] result = DataParcer.getInstance().threadInfo(listRows);
        assertEquals(result, arrayElements);

    }

    /**
     * Negative matrix information dataProvider.
     *
     * @return Object[]
     */
    @DataProvider(name = "parcerInfoNegative")
    public Object[] fileMatrixInformationNegative() {

        ArrayList illegalArgument = new ArrayList();
        illegalArgument.add(1d);
        return new Object[][]{
                {null},
        };
    }

    /**
     * Negative matrix info test.
     *
     * @param listRows listRows
     * @throws MatrixException MatrixException
     */
    @Test(description = "Parcer matrix information from file",
            dataProvider = "parcerInfoNegative",
            expectedExceptions = MatrixException.class)
    public void testMatrixInfoNegative(final ArrayList<String> listRows)
            throws MatrixException {
        DataParcer.getInstance().matrixInfo(listRows);

    }

    /**
     * Negative thread info test.
     *
     * @param listRows listRows
     * @throws MatrixException MatrixException
     */
    @Test(description = "Parcer thread information from file",
            dataProvider = "parcerInfoNegative",
            expectedExceptions = MatrixException.class)
    public void testThreadInfoNegative(final ArrayList<String> listRows)
            throws MatrixException {
        DataParcer.getInstance().matrixInfo(listRows);

    }


}
