package bank.ocr;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountParser {

    private String multipleAccountsSymbols  ;

    public AccountParser(String multipleAccountsSymbols) {
        this.multipleAccountsSymbols = multipleAccountsSymbols;
    }

    public List<String> parseAccounts() {
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile(Account.SYMBOLS_PATTERN).matcher(multipleAccountsSymbols);
        while (m.find()) {
            Account account = new Account(m.group());
            allMatches.add(account.getAccountNumber());
        }
        return allMatches;
    }
}
