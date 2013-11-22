package bank.ocr;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class AccountTest {

    static Map<String, String> accountsMap = new HashMap<String, String>();

    {
        accountsMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "| || || || || || || || || |\n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "                           \n", "000000000");
        accountsMap.put(
        "                           \n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "                           \n", "111111111");
        accountsMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
        "                           \n", "222222222");
        accountsMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        "                           \n", "333333333");
        accountsMap.put(
        "                           \n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "                           \n", "444444444");
        accountsMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        "                           \n", "555555555");
        accountsMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "                           \n", "666666666");
        accountsMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "                           \n", "777777777");
        accountsMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "                           \n", "888888888");
        accountsMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        "                           \n", "999999999");
        accountsMap.put(
        "    _  _     _  _  _  _  _ \n" +
        "  | _| _||_||_ |_   ||_||_|\n" +
        "  ||_  _|  | _||_|  ||_| _|\n" +
        "                           \n", "123456789");
    }

    @Test
    public void extractsAccountNumberFromSymbols() {
        for (String symbols : accountsMap.keySet()) {
            Account account = new Account(symbols);
            assertEquals(accountsMap.get(symbols), account.getAccountNumber());
        }
    }
}
