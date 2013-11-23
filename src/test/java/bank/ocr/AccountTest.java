package bank.ocr;

import bank.ocr.exceptions.InvalidAccountPatternException;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void extractsAccountNumberFromSymbols() {
        Map<String,String> testData = AccountTestData.accountsMap;
        for (String symbols : testData.keySet()) {
            Account account = new Account(symbols);
            assertEquals(testData.get(symbols), account.getAccountNumber());
        }
    }

    @Test
    public void extractsAccountWithStatusFromSymbols() {
        Map<String,String> testData = AccountTestData.accountsWithStatusMap;
        for (String symbols : testData.keySet()) {
            Account account = new Account(symbols);
            assertEquals(testData.get(symbols), account.getAccountWithStatus());
        }
    }

    @Test
    public void extractsAccountInfoFromSymbols() {
        Map<String,String> testData = AccountTestData.accountsInfoMap;
        for (String symbols : testData.keySet()) {
            Account account = new Account(symbols);
            assertEquals(testData.get(symbols), account.getAccountInfo());
        }
    }

    @Test(expected = InvalidAccountPatternException.class)
    public void throwsExceptionForInvalidAccountPattern() {
        String invalid = "invalid";
        new Account(invalid);
        fail();
    }

    @Test
    public void identifiesValidAccount() {
        String accountSymbols =
        " _  _  _  _  _  _  _  _  _ \n" +
        "| || || || || || || || || |\n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "                           \n";
        Account account = new Account(accountSymbols);
        assertTrue(account.isValid());
    }

    @Test
    public void identifiesInvalidAccount() {
        String accountSymbols =
        "                           \n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "                           \n";
        Account account = new Account(accountSymbols);
        assertFalse(account.isValid());
    }

    @Test
    public void findsValidAlternatives() {
        String accountSymbols =
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "                           \n";
        Account account = new Account(accountSymbols);
        assertEquals(Arrays.asList("888886888", "888888880", "888888988"), account.findValidAlternatives());
    }
}
