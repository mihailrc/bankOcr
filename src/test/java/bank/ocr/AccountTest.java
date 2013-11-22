package bank.ocr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    @Test
    public void extractsAccountNumberFromZeroSymbols() {
        String zeros =
        " _  _  _  _  _  _  _  _  _ \n" +
        "| || || || || || || || || |\n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "                           ";
        Account account = new Account(zeros);
        assertEquals("000000000", account.getAccountNumber());
    }

    @Test
    public void extractsAccountNumberFromOneSymbols() {
        String ones =
        "                           \n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "                           ";
        Account account = new Account(ones);
        assertEquals("111111111", account.getAccountNumber());
    }
}
