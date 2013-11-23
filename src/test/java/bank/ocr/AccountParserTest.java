package bank.ocr;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AccountParserTest {

    private String accountsSymbols = AccountTestData.getAccountSymbols(AccountTestData.accountsInfoMap);
    private List<String> accountInfoList = AccountTestData.getAccountInfo(AccountTestData.accountsInfoMap);

    @Test
    public void parsesMultipleAccounts() {
        AccountParser accountParser = new AccountParser(accountsSymbols);
        assertEquals(accountInfoList, accountParser.parseAccounts());
    }

    @Test
    public void ignoresSymbolsThatDoNotMatchAccountPattern() {
        String validAndInvalidSymbols = "invalid " + accountsSymbols + "more bad stuff";
        AccountParser accountParser = new AccountParser(validAndInvalidSymbols);
        assertEquals(accountInfoList, accountParser.parseAccounts());
    }

}
