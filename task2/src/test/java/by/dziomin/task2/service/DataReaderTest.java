package by.dziomin.task2.service;

import by.dziomin.task2.exception.MatrixException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * test of data reader class.
 */
public class DataReaderTest {
    /**
     * Positive file information dataProvider.
     * @return Object[]
     */
    @DataProvider(name = "fileInformationPositive")
    public Object[] fileInformationPositive() {
        Path fileMatrix = Paths.get("datatest/matrix.txt");
        Path fileThread = Paths.get("datatest/thread.txt");
        List<String> listMatrixInfo = new ArrayList<>();
        listMatrixInfo.add("1 1 1 1 1 1 1 1");
        listMatrixInfo.add("2 2 2 2 2 2 2 2");
        List<String> listThreadInfo = new ArrayList<>();
        listThreadInfo.add("99 98 97 96 95");

        return new Object[][]{
                {fileMatrix, listMatrixInfo},
                {fileThread, listThreadInfo}
        };
    }

    /**
     * Negative file information dataProvider.
     * @return Object[]
     */
    @DataProvider(name = "fileInformationNegative")
    public Object[] fileInformationNegative() {
        Path fileMatrix = Paths.get("datatest/matri.txt");
        Path fileThread = Paths.get("datatest/tread.txt");
        List<String> listMatrixInfo = new ArrayList<>();
        listMatrixInfo.add("1 1 1 1 1 1 1 1");
        listMatrixInfo.add("2 2 2 2 2 2 2 2");
        List<String> listThreadInfo = new ArrayList<>();
        listThreadInfo.add("99 98 97 96 95");

        return new Object[][]{
                {fileMatrix, listMatrixInfo},
                {fileThread, listThreadInfo}
        };
    }

    /**
     * Positive read file test.
     * @param file file.
     * @param listInfo listInfo.
     * @throws MatrixException MatrixException.
     */
    @Test(description = "reading information from file",
            dataProvider = "fileInformationPositive")
    public void testReadFilePositive(final Path file,
                                     final List<String> listInfo)
            throws MatrixException {

        List<String> result = DataReader.getInstance().readFile(file);
        assertEquals(result, listInfo);

    }

    /**
     * Negative read file test.
     * @param file file
     * @param listInfo listInfo
     */
    @Test(description = "reading information from file",
            dataProvider = "fileInformationNegative")
    public void testReadFileNegative(final Path file,
                                     final List<String> listInfo) {

        List<String> result = null;
        try {
            result = DataReader.getInstance().readFile(file);
        } catch (MatrixException newE) {
            assertNull(result);
        }

    }
}
