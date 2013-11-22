package bank.ocr;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileAccountParserTest {

    private String symbols =
    " _  _  _  _  _  _  _  _  _ \n" +
    "| || || || || || || || || |\n" +
    "|_||_||_||_||_||_||_||_||_|\n" +
    "                           \n" +
    "                           \n" +
    "  |  |  |  |  |  |  |  |  |\n" +
    "  |  |  |  |  |  |  |  |  |\n" +
    "                           \n" +
    " _  _  _  _  _  _  _  _    \n" +
    "| || || || || || || ||_   |\n" +
    "|_||_||_||_||_||_||_| _|  |\n" +
    "                           \n" +
    "    _  _  _  _  _  _     _ \n" +
    "|_||_|| || ||_   |  |  | _ \n" +
    "  | _||_||_||_|  |  |  | _|\n" +
    "                           \n" +
    "    _  _     _  _  _  _  _ \n" +
    "  | _| _||_| _ |_   ||_||_|\n" +
    "  ||_  _|  | _||_|  ||_| _ \n" +
    "                           \n";

    private String numbers =
    "000000000\n" +
    "111111111 ERR\n" +
    "000000051\n" +
    "49006771? ILL\n" +
    "1234?678? ILL\n";

    private File dir, symbolsFile, numbersFile;

    @Before
    public void setUp() throws IOException {
        dir = new File("target","testData");
        dir.mkdir();
        symbolsFile = createFile("symbols.txt");
        symbolsFile.createNewFile();
        FileUtil.writeToFile(symbols, symbolsFile);
        numbersFile = createFile("accountNumbers.txt");
    }

    @Test
    public void readsAccountSymbolsFromFileAndWritesAccountNumbersToFile() throws IOException {
        FileAccountParser fileAccountParser = new FileAccountParser(symbolsFile);
        fileAccountParser.writeAccountNumbers(numbersFile);
        assertEquals(numbers, FileUtil.readToString(numbersFile));
    }

    private File createFile(String fileName) throws IOException {
        File file = new File(dir, fileName);
        file.createNewFile();
        return file;
    }

}
