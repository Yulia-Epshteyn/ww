package ww.q1;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DictionaryFileTest {

    private static final String DICTIONARY_FILE_PATH = "tst/ww/q1/file.txt";

    @Test
    public void pathDoesntExist() {
        final boolean expectedResult = DictionaryFile.doesFileExist("tst/ws/q1/file");
        Assert.assertFalse(expectedResult);
    }

    @Test
    public void pathExists() {
        final boolean expectedResult = DictionaryFile.doesFileExist(DICTIONARY_FILE_PATH);
        Assert.assertTrue(expectedResult);
    }

    @Test
    public void printDictionary() {
        DictionaryFile.printDictionary(DICTIONARY_FILE_PATH);
    }

    @Test
    public void verifyPrintout() {
        final PrintStream originalOut = System.out;
        final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));

        DictionaryFile.printDictionary(DICTIONARY_FILE_PATH);

        final String result = outStream.toString();
        Assert.assertTrue(result.contains("Apple"));
        Assert.assertTrue(result.contains("Table"));
        Assert.assertTrue(result.contains("Orange"));
        Assert.assertFalse(result.contains("orange"));

        final String[] lines = result.split("\n");
        Assert.assertEquals(7, lines.length);

        System.setOut(originalOut);
    }
}
