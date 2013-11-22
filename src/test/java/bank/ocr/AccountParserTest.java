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
        AccountParser accountParser = new AccountParser();
        assertEquals(Arrays.asList("000000000", "111111111"), accountParser.parseAccounts(accountsSymbols));
    }

    @Test
    public void ignoresSymbolsThatDoNotMatchAccountPattern() {
        AccountParser accountParser = new AccountParser();
        String validAndInvalidSymbols = "invalid " + accountsSymbols + "more bad stuff";
        assertEquals(Arrays.asList("000000000", "111111111"), accountParser.parseAccounts(validAndInvalidSymbols));
    }

}
