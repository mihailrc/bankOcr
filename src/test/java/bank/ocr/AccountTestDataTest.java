package bank.ocr;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

//don't laugh I actually had a bug in this
public class AccountTestDataTest {

    @Test
    public void findsAccountInfoAsString() {
        assertFalse(AccountTestData.getAccountInfoAsString(AccountTestData.accountsInfoMap).isEmpty());
    }

    @Test
    public void findsAccountInfo() {
        assertFalse(AccountTestData.getAccountInfo(AccountTestData.accountsInfoMap).isEmpty());
    }

    @Test
    public void findsAccountSymbols() {
        assertFalse(AccountTestData.getAccountSymbols(AccountTestData.accountsInfoMap).isEmpty());
    }

}
