package bank.ocr;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountParser {

    private String accountsSymbols;

    public AccountParser(String accountsSymbols) {
        this.accountsSymbols = accountsSymbols;
    }

    public List<String> parseAccounts() {
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile(Account.SYMBOLS_PATTERN).matcher(accountsSymbols);
        while (m.find()) {
            Account account = new Account(m.group());
            allMatches.add(account.getAccountNumber());
        }
        return allMatches;
    }
}
