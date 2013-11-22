package bank.ocr;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AccountParserTest {

    private String accountsSymbols =
    " _  _  _  _  _  _  _  _  _ \n" +
    "| || || || || || || || || |\n" +
    "|_||_||_||_||_||_||_||_||_|\n" +
    "                           \n" +
    "                           \n" +
    "  |  |  |  |  |  |  |  |  |\n" +
    "  |  |  |  |  |  |  |  |  |\n" +
    "                           \n";

    @Test
    public void parsesMultipleAccounts() {
        AccountParser accountParser = new AccountParser(accountsSymbols);
        assertEquals(Arrays.asList("000000000", "111111111"), accountParser.parseAccounts());
    }

    @Test
    public void ignoresSymbolsThatDoNotMatchAccountPattern() {
        String validAndInvalidSymbols = "invalid " + accountsSymbols + "more bad stuff";
        AccountParser accountParser = new AccountParser(validAndInvalidSymbols);
        assertEquals(Arrays.asList("000000000", "111111111"), accountParser.parseAccounts());
    }

}
