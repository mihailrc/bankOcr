package bank.ocr;

import bank.ocr.exceptions.InvalidAccountPatternException;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

public class AccountTest {

    static Map<String, String> accountsMap = new HashMap<String, String>();
    static Map<String, String> accountsWithStatusMap = new HashMap<String, String>();
    static Map<String, String> accountsInfoMap = new HashMap<String, String>();

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
        accountsWithStatusMap.put(
        " _  _  _  _  _  _  _  _    \n" +
        "| || || || || || || ||_   |\n" +
        "|_||_||_||_||_||_||_| _|  |\n" +
        "                           \n", "000000051");
        accountsWithStatusMap.put(
        "    _  _  _  _  _  _     _ \n" +
        "|_||_|| || ||_   |  |  | _ \n" +
        "  | _||_||_||_|  |  |  | _|\n" +
        "                           \n", "49006771? ILL");
        accountsWithStatusMap.put(
        "    _  _     _  _  _  _  _ \n" +
        "  | _| _||_| _ |_   ||_||_|\n" +
        "  ||_  _|  | _||_|  ||_| _ \n" +
        "                           \n", "1234?678? ILL");
        accountsInfoMap.put(
        "                           \n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "                           \n", "711111111");
        accountsInfoMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "                           \n", "777777177");
        accountsInfoMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        " _|| || || || || || || || |\n" +
        "|_ |_||_||_||_||_||_||_||_|\n" +
        "                           \n", "200800000");
        accountsInfoMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        "                           \n", "333393333");
        accountsInfoMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "                           \n", "888888888 AMB ['888886888', '888888880', '888888988']");
        accountsInfoMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        "                           \n", "555555555 AMB ['555655555', '559555555']");
        accountsInfoMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "                           \n", "666666666 AMB ['666566666', '686666666']");
        accountsInfoMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        "                           \n", "999999999 AMB ['899999999', '993999999', '999959999']");
        accountsInfoMap.put(
        "    _  _  _  _  _  _     _ \n" +
        "|_||_|| || ||_   |  |  ||_ \n" +
        "  | _||_||_||_|  |  |  | _|\n" +
        "                           \n", "490067715 AMB ['490067115', '490067719', '490867715']");
        accountsInfoMap.put(
        "    _  _     _  _  _  _  _ \n" +
        " _| _| _||_||_ |_   ||_||_|\n" +
        "  ||_  _|  | _||_|  ||_| _|\n" +
        "                           \n", "123456789");
        accountsInfoMap.put(
        " _     _  _  _  _  _  _    \n" +
        "| || || || || || || ||_   |\n" +
        "|_||_||_||_||_||_||_| _|  |\n" +
        "                           \n", "000000051");
        accountsInfoMap.put(
        "    _  _  _  _  _  _     _ \n" +
        "|_||_|| ||_||_   |  |  | _ \n" +
        "  | _||_||_||_|  |  |  | _|\n" +
        "                           \n", "490867715");
        accountsInfoMap.put(
        "    _  _  _  _  _  _     _ \n" +
        "|_||_|| ||_||_   |  |  | _ \n" +
        "  | _||_||_||_|  |  |    _|\n" +
        "                           \n", "4908677?? ILL");
    }

    @Test
    public void extractsAccountNumberFromSymbols() {
        for (String symbols : accountsMap.keySet()) {
            Account account = new Account(symbols);
            assertEquals(accountsMap.get(symbols), account.getAccountNumber());
        }
    }

    @Test
    public void extractsAccountWithStatusFromSymbols() {
        for (String symbols : accountsWithStatusMap.keySet()) {
            Account account = new Account(symbols);
            assertEquals(accountsWithStatusMap.get(symbols), account.getAccountWithStatus());
        }
    }

    @Test
    public void extractsAccountInfoFromSymbols() {
        for (String symbols : accountsInfoMap.keySet()) {
            Account account = new Account(symbols);
            assertEquals(accountsInfoMap.get(symbols), account.getAccountInfo());
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
