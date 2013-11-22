package bank.ocr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    private String symbols =
    " _  _  _  _  _  _  _  _  _ \n" +
    "| || || || || || || || || |\n" +
    "|_||_||_||_||_||_||_||_||_|\n" +
    "                           ";

    @Test
    public void extractsAccountNumberFromSymbols() {
        Account account = new Account(symbols);
        assertEquals("000000000", account.getAccountNumber());
    }
}
