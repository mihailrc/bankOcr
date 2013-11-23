package bank.ocr;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileAccountParserTest {

    private String symbols = AccountTestData.getAccountSymbols(AccountTestData.accountsInfoMap);
    private String accountsInfo = AccountTestData.getAccountInfoAsString(AccountTestData.accountsInfoMap);

    private File dir, symbolsFile, numbersFile;

    @Before
    public void setUp() throws IOException {
        dir = new File("target", "testData");
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
        assertEquals(accountsInfo, FileUtil.readToString(numbersFile));
    }

    private File createFile(String fileName) throws IOException {
        File file = new File(dir, fileName);
        file.createNewFile();
        return file;
    }

}
